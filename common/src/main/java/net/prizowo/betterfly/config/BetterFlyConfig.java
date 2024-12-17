package net.prizowo.betterfly.config;

public class BetterFlyConfig {
    private static boolean instantStop = true;
    private static boolean noMiningPenalty = true;

    public static boolean isInstantStop() {
        return instantStop;
    }

    public static void setInstantStop(boolean value) {
        instantStop = value;
    }

    public static boolean isNoMiningPenalty() {
        return noMiningPenalty;
    }

    public static void setNoMiningPenalty(boolean value) {
        noMiningPenalty = value;
    }
} 