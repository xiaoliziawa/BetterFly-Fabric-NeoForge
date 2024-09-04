package com.tyxcnjiu.main.betterfly;

import com.tyxcnjiu.main.untitled2.BetterFly;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(BetterFly.MOD_ID)
public class NeoForge {
    public NeoForge(IEventBus modEventBus) {
        BetterFly.init();
        net.neoforged.neoforge.common.NeoForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        net.neoforged.neoforge.common.NeoForge.EVENT_BUS.register(NeoForgeEvents.class);
    }
}
