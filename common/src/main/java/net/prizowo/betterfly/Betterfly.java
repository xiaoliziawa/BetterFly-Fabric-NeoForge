package net.prizowo.betterfly;

import dev.architectury.event.events.common.CommandRegistrationEvent;
import net.prizowo.betterfly.command.FlyingCommand;

public final class Betterfly {
    public static final String MOD_ID = "betterfly";

    public static void init() {
        CommandRegistrationEvent.EVENT.register((dispatcher, registry, selection) -> {
            FlyingCommand.register(dispatcher);
        });
    }
}
