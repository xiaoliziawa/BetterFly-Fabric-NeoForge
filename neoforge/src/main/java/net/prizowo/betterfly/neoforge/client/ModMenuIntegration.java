package net.prizowo.betterfly.neoforge.client;

import net.minecraft.client.gui.screens.Screen;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.prizowo.betterfly.client.gui.ConfigScreen;
import org.jetbrains.annotations.NotNull;

public class ModMenuIntegration {
    public static void register() {
        ModLoadingContext.get().registerExtensionPoint(
            IConfigScreenFactory.class,
            () -> new IConfigScreenFactory() {
                @Override
                public @NotNull Screen createScreen(@NotNull ModContainer container, @NotNull Screen modListScreen) {
                    return new ConfigScreen(modListScreen);
                }
            }
        );
    }
}