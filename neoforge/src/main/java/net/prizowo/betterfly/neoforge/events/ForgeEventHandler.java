package net.prizowo.betterfly.neoforge.events;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.prizowo.betterfly.Betterfly;
import net.minecraft.world.entity.player.Player;
import net.prizowo.betterfly.config.BetterFlyConfig;

@EventBusSubscriber(modid = Betterfly.MOD_ID)
public class ForgeEventHandler {
    
    @SubscribeEvent
    public static void onBreakSpeed(PlayerEvent.BreakSpeed event) {
        Player player = event.getEntity();
        if (!player.onGround() && player.getAbilities().flying && BetterFlyConfig.isNoMiningPenalty()) {
            event.setNewSpeed(event.getOriginalSpeed() * 5.0f);
        }
    }
} 