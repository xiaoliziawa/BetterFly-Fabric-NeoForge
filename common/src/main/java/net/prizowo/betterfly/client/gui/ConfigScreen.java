package net.prizowo.betterfly.client.gui;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.prizowo.betterfly.config.BetterFlyConfig;

public class ConfigScreen extends Screen {
    private final Screen parent;
    private static final int BUTTON_WIDTH = 200;
    private static final int BUTTON_HEIGHT = 20;

    public ConfigScreen(Screen parent) {
        super(Component.translatable("config.betterfly.title"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        int centerX = this.width / 2;
        int centerY = this.height / 2;

        // 急停开关按钮
        this.addRenderableWidget(Button.builder(
                Component.translatable("config.betterfly.instant_stop", 
                    Component.translatable(BetterFlyConfig.isInstantStop() ? 
                        "config.betterfly.instant_stop.on" : 
                        "config.betterfly.instant_stop.off")),
                button -> {
                    BetterFlyConfig.setInstantStop(!BetterFlyConfig.isInstantStop());
                    button.setMessage(Component.translatable("config.betterfly.instant_stop",
                        Component.translatable(BetterFlyConfig.isInstantStop() ? 
                            "config.betterfly.instant_stop.on" : 
                            "config.betterfly.instant_stop.off")));
                })
                .pos(centerX - BUTTON_WIDTH/2, centerY - 30)
                .size(BUTTON_WIDTH, BUTTON_HEIGHT)
                .build());

        // 挖掘速度惩罚开关按钮
        this.addRenderableWidget(Button.builder(
                Component.translatable("config.betterfly.no_mining_penalty",
                    Component.translatable(BetterFlyConfig.isNoMiningPenalty() ? 
                        "config.betterfly.no_mining_penalty.on" : 
                        "config.betterfly.no_mining_penalty.off")),
                button -> {
                    BetterFlyConfig.setNoMiningPenalty(!BetterFlyConfig.isNoMiningPenalty());
                    button.setMessage(Component.translatable("config.betterfly.no_mining_penalty",
                        Component.translatable(BetterFlyConfig.isNoMiningPenalty() ? 
                            "config.betterfly.no_mining_penalty.on" : 
                            "config.betterfly.no_mining_penalty.off")));
                })
                .pos(centerX - BUTTON_WIDTH/2, centerY)
                .size(BUTTON_WIDTH, BUTTON_HEIGHT)
                .build());

        // 完成按钮
        this.addRenderableWidget(Button.builder(
                Component.translatable("config.betterfly.done"),
                button -> this.minecraft.setScreen(parent))
                .pos(centerX - BUTTON_WIDTH/2, centerY + 30)
                .size(BUTTON_WIDTH, BUTTON_HEIGHT)
                .build());
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(graphics, mouseX, mouseY, partialTick);
        graphics.drawCenteredString(this.font, this.title, this.width / 2, 20, 0xFFFFFF);
        super.render(graphics, mouseX, mouseY, partialTick);
    }
} 