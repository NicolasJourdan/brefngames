package Statistic.Factory;

import Game.Games.Runner.RunnerStatsEnum;

public class RunnerStatisticFactory {
    public static String getStringStat(RunnerStatsEnum stat) {
        switch (stat) {
            case RUNNER_NB_GAMES:
                return "Runner Number of games";
            case RUNNER_NB_CLICS:
                return "Runner Number of click";
            case RUNNER_AVERAGE_SPEED:
                return "Runner average speed";
            case RUNNER_AVERAGE_TIME:
                return "Runner average time";
            case RUNNER_TOTAL_TIME:
                return "Runner total time";
            case RUNNER_BEST_PLAYER:
                return "Runner best player";
            default:
                throw new RuntimeException("The statistic : " + stat.toString() + " is unknown");
        }
    }
}
