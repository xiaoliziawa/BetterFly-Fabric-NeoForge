package net.prizowo.betterfly.mixin;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import net.prizowo.betterfly.config.BetterFlyConfig;

@Mixin(Player.class)
public class PlayerMixin {

    @Inject(method = "travel", at = @At("HEAD"))
    private void onTravel(Vec3 vec3, CallbackInfo ci) {
        Player player = (Player)(Object)this;
        if (player.getAbilities().flying && BetterFlyConfig.isInstantStop()) {
            if (vec3.x == 0 && vec3.z == 0) {
                player.setDeltaMovement(0, player.getDeltaMovement().y, 0);
            }
        }
    }

    @Inject(method = "getDestroySpeed", at = @At("RETURN"), cancellable = true)
    private void onGetDestroySpeed(BlockState blockState, CallbackInfoReturnable<Float> cir) {
        Player player = (Player)(Object)this;
        if (!player.onGround() && player.getAbilities().flying && BetterFlyConfig.isNoMiningPenalty()) {
            cir.setReturnValue(cir.getReturnValue() * 5.0f);
        }
    }

    @Inject(method = "getFlyingSpeed", at = @At("HEAD"), cancellable = true)
    private void onGetFlyingSpeed(CallbackInfoReturnable<Float> cir) {
        Player player = (Player)(Object)this;
        if (player.getAbilities().flying) {
            // 设置更精确的飞行速度控制
            cir.setReturnValue(0.05f);
        }
    }
} 