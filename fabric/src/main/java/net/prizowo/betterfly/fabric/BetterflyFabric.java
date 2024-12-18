package net.prizowo.betterfly.fabric;

import net.prizowo.betterfly.Betterfly;
import net.fabricmc.api.ModInitializer;

public final class BetterflyFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Betterfly.init();
    }
}
