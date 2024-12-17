package net.prizowo.betterfly.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

public class FlyingCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("flying")
            .requires(source -> source.hasPermission(2))
            .executes(FlyingCommand::execute));
    }

    private static int execute(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        ServerPlayer player = context.getSource().getPlayerOrException();
        player.getAbilities().mayfly = !player.getAbilities().mayfly;
        player.getAbilities().flying = player.getAbilities().mayfly;
        player.onUpdateAbilities();
        
        String translationKey = player.getAbilities().mayfly ? 
            "command.betterfly.flying.enabled" : "command.betterfly.flying.disabled";
        context.getSource().sendSuccess(() -> Component.translatable(translationKey), false);
        return 1;
    }
} 