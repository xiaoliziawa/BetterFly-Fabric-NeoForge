package com.tyxcnjiu.main.betterfly;

import com.tyxcnjiu.main.untitled2.BetterFly;
import net.fabricmc.api.ModInitializer;

public class Fabric implements ModInitializer {
    @Override
    public void onInitialize() {
        BetterFly.init();
    }
}
