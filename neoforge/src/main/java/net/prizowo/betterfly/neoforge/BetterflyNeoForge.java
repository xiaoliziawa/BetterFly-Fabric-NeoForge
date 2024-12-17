package net.prizowo.betterfly.neoforge;

import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.prizowo.betterfly.command.FlyingCommand;
import net.prizowo.betterfly.neoforge.client.ModMenuIntegration;

@Mod("betterfly")
public class BetterflyNeoForge {
    public BetterflyNeoForge() {
        NeoForge.EVENT_BUS.register(this);
        
        if (FMLEnvironment.dist.isClient()) {
            ModMenuIntegration.register();
        }
    }

    @SubscribeEvent
    public void onRegisterCommands(RegisterCommandsEvent event) {
        FlyingCommand.register(event.getDispatcher());
    }
}
