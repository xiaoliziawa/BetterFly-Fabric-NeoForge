package com.tyxcnjiu.main.untitled2.mixin;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public class PlayerMixin {

    @Inject(method = "getDestroySpeed", at = @At("RETURN"), cancellable = true)
    private void onGetDestroySpeed(BlockState state, CallbackInfoReturnable<Float> cir) {
        Player player = (Player)(Object)this;
        if (player.getAbilities().flying && !player.onGround()) {
            float speed = cir.getReturnValue();
            if (player.getAbilities().flying) {
                speed *= 5.0F;
            }
            cir.setReturnValue(speed);
        }
    }
}
