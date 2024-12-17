package net.prizowo.betterfly.forge.events;

import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.prizowo.betterfly.Betterfly;
import net.minecraft.world.entity.player.Player;
import net.prizowo.betterfly.config.BetterFlyConfig;

@Mod.EventBusSubscriber(modid = Betterfly.MOD_ID)
public class ForgeEventHandler {
    
    @SubscribeEvent
    public static void onBreakSpeed(PlayerEvent.BreakSpeed event) {
        Player player = event.getEntity();
        if (!player.onGround() && player.getAbilities().flying && BetterFlyConfig.isNoMiningPenalty()) {
            event.setNewSpeed(event.getOriginalSpeed() * 5.0f);
        }
    }
} 