package com.tyxcnjiu.main.untitled2;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public class BetterFlyCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("flying")
                .executes(BetterFlyCommand::toggleFlying));
    }

    private static int toggleFlying(CommandContext<CommandSourceStack> context) {
        CommandSourceStack source = context.getSource();
        if (source.getEntity() instanceof Player player) {
            boolean flying = !player.getAbilities().mayfly;
            player.getAbilities().mayfly = flying;
            player.getAbilities().flying = flying;
            player.onUpdateAbilities();
            player.sendSystemMessage(Component.literal("Flying mode " + (flying ? "enabled" : "disabled")));
            return 1;
        }
        return 0;
    }
}
