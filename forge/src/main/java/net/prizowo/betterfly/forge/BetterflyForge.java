package net.prizowo.betterfly.forge;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.prizowo.betterfly.forge.client.ModMenuIntegration;
import net.prizowo.betterfly.Betterfly;
import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.prizowo.betterfly.forge.events.ForgeEventHandler;

@Mod(Betterfly.MOD_ID)
public final class BetterflyForge {
    public BetterflyForge() {
        EventBuses.registerModEventBus(Betterfly.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        MinecraftForge.EVENT_BUS.register(ForgeEventHandler.class);
        
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> ModMenuIntegration::register);
        
        Betterfly.init();
    }
}
