package com.tyxcnjiu.main.betterfly;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

@EventBusSubscriber(modid = "untitled2")
public class NeoForgeEvents {

    @SubscribeEvent
    public static void onBreakSpeed(PlayerEvent.BreakSpeed event) {
        Player player = event.getEntity();
        if (player.getAbilities().flying) {
            float baseSpeed = event.getOriginalSpeed();

            if (!player.onGround()) {
                baseSpeed *= 5.0F;
            }

            if (player.isInWater() && !player.hasEffect(MobEffects.WATER_BREATHING)) {
                baseSpeed *= 5.0F;
            }

            event.setNewSpeed(baseSpeed);
        }
    }
}
