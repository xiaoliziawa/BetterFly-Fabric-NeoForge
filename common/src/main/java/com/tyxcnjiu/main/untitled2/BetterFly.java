package com.tyxcnjiu.main.untitled2;

import dev.architectury.event.events.common.CommandRegistrationEvent;

public class BetterFly {
    public static final String MOD_ID = "betterfly";

    public static void init() {
        BetterFlyHandler.init();
        CommandRegistrationEvent.EVENT.register((dispatcher, registry, selection) -> {
            BetterFlyCommand.register(dispatcher);
        });
    }

}
