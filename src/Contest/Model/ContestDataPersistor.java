package Contest.Model;

import Game.Games.ConnectFour.ConnectFourStatsEnum;
import Game.Games.CookieClicker.CookieClickerStatsEnum;
import Game.Games.FifteenVainc.FifteenVaincStatsEnum;
import Game.Games.Hangman.HangmanStatsEnum;
import Game.Games.Runner.RunnerStatsEnum;
import Game.Games.TicTacToe.TicTacToeStatsEnum;
import Game.Model.GameEnum;
import Repository.Game.*;
import Repository.Game.ConnectFourRepository;
import Repository.Game.HangmanRepository;
import Repository.Game.CookieClickerRepository;
import Repository.Game.RunnerRepository;
import Repository.Game.TicTacToeRepository;
import Repository.Player.PlayerStatsEnum;
import Repository.Player.PlayerStatsRepository;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class ContestDataPersistor {

    public static void updateTicTacToe(Map<TicTacToeStatsEnum, String> gameMap) {
        Map<TicTacToeStatsEnum, String> dataEntries = TicTacToeRepository.getAll();
        updateIntValueTicTacToe(dataEntries, gameMap, TicTacToeStatsEnum.TIC_TAC_TOE_NB_GAMES);
        updateIntValueTicTacToe(dataEntries, gameMap, TicTacToeStatsEnum.TIC_TAC_TOE_NB_CIRCLE);
        updateIntValueTicTacToe(dataEntries, gameMap, TicTacToeStatsEnum.TIC_TAC_TOE_NB_CROSS);
        updateIntValueTicTacToe(dataEntries, gameMap, TicTacToeStatsEnum.TIC_TAC_TOE_NB_ALL_SIGNS);
        updateIntValueTicTacToe(dataEntries, gameMap, TicTacToeStatsEnum.TIC_TAC_TOE_NB_DRAW);
        updateIntValueTicTacToe(dataEntries, gameMap, TicTacToeStatsEnum.TIC_TAC_TOE_NB_PERFECT);
        updateIntValueTicTacToe(dataEntries, gameMap, TicTacToeStatsEnum.TIC_TAC_TOE_TOTAL_TIME);
        // Average time took per sign
        dataEntries.put(
                TicTacToeStatsEnum.TIC_TAC_TOE_AVERAGE_TIME,
                String.valueOf(
                        Integer.parseInt(dataEntries.get(TicTacToeStatsEnum.TIC_TAC_TOE_TOTAL_TIME))
                                / Integer.parseInt(dataEntries.get(TicTacToeStatsEnum.TIC_TAC_TOE_NB_ALL_SIGNS))
                )
        );

        // The best player on tic tac toe
        dataEntries.put(
                TicTacToeStatsEnum.TIC_TAC_TOE_BEST_PLAYER,
                GlobalStatisticsRepository.getBestPlayerByGame(GameEnum.TIC_TAC_TOE)
        );

        TicTacToeRepository.saveAll(dataEntries);
    }

    private static void updateIntValueTicTacToe(Map<TicTacToeStatsEnum, String> dataEntries, Map<TicTacToeStatsEnum, String> gamesEntries, TicTacToeStatsEnum stats) {
        dataEntries.put(
                stats,
                String.valueOf(
                        Integer.parseInt(gamesEntries.get(stats))
                                + Integer.parseInt(dataEntries.get(stats))
                )
        );
    }

    public static void updateRunner(Map<RunnerStatsEnum, String> gameMap) {
        Map<RunnerStatsEnum, String> dataEntries = RunnerRepository.getAll();
        updateIntValueRunner(dataEntries, gameMap, RunnerStatsEnum.RUNNER_NB_GAMES);
        updateIntValueRunner(dataEntries, gameMap, RunnerStatsEnum.RUNNER_NB_CLICKS);
        updateIntValueRunner(dataEntries, gameMap, RunnerStatsEnum.RUNNER_TOTAL_TIME);
        // Average time of each race
        dataEntries.put(
                RunnerStatsEnum.RUNNER_AVERAGE_TIME,
                String.valueOf(
                        Integer.parseInt(dataEntries.get(RunnerStatsEnum.RUNNER_TOTAL_TIME))
                                / Integer.parseInt(dataEntries.get(RunnerStatsEnum.RUNNER_NB_GAMES))
                )
        );

        // Average clicks per second
        dataEntries.put(
                RunnerStatsEnum.RUNNER_AVERAGE_SPEED,
                String.valueOf(
                        Integer.parseInt(dataEntries.get(RunnerStatsEnum.RUNNER_NB_CLICKS))
                                / Integer.parseInt(dataEntries.get(RunnerStatsEnum.RUNNER_TOTAL_TIME))
                )
        );

        // The best player on runner
        dataEntries.put(
                RunnerStatsEnum.RUNNER_BEST_PLAYER,
                GlobalStatisticsRepository.getBestPlayerByGame(GameEnum.RUNNER)
        );

        RunnerRepository.saveAll(dataEntries);
    }

    private static void updateIntValueRunner(Map<RunnerStatsEnum, String> dataEntries, Map<RunnerStatsEnum, String> gamesEntries, RunnerStatsEnum stats) {
        dataEntries.put(
                stats,
                String.valueOf(
                        Integer.parseInt(gamesEntries.get(stats))
                                + Integer.parseInt(dataEntries.get(stats))
                )
        );
    }

    public static void updateCookieClicker(Map<CookieClickerStatsEnum, String> gameMap) {
        Map<CookieClickerStatsEnum, String> dataEntries = CookieClickerRepository.getAll();
        updateIntValueCookieClicker(dataEntries, gameMap, CookieClickerStatsEnum.COOKIE_CLICKER_NB_GAMES);
        updateIntValueCookieClicker(dataEntries, gameMap, CookieClickerStatsEnum.COOKIE_CLICKER_NB_CLICKS);
        updateIntValueCookieClicker(dataEntries, gameMap, CookieClickerStatsEnum.COOKIE_CLICKER_NB_PERFECT);
        updateIntValueCookieClicker(dataEntries, gameMap, CookieClickerStatsEnum.COOKIE_CLICKER_TOTAL_FAULT);
        updateIntValueCookieClicker(dataEntries, gameMap, CookieClickerStatsEnum.COOKIE_CLICKER_TOTAL_TIME);
        updateIntValueCookieClicker(dataEntries, gameMap, CookieClickerStatsEnum.COOKIE_CLICKER_TOTAL_REQUIRED_CLICKS);
        // Average required clicks per game
        dataEntries.put(
                CookieClickerStatsEnum.COOKIE_CLICKER_AVERAGE_REQUIRED_CLICKS,
                String.valueOf(
                        Integer.parseInt(dataEntries.get(CookieClickerStatsEnum.COOKIE_CLICKER_TOTAL_REQUIRED_CLICKS))
                                / Integer.parseInt(dataEntries.get(CookieClickerStatsEnum.COOKIE_CLICKER_NB_GAMES))
                )
        );

        // Average faults per game
        dataEntries.put(
                CookieClickerStatsEnum.COOKIE_CLICKER_AVERAGE_FAULT,
                String.valueOf(
                        Integer.parseInt(dataEntries.get(CookieClickerStatsEnum.COOKIE_CLICKER_TOTAL_FAULT))
                                / Integer.parseInt(dataEntries.get(CookieClickerStatsEnum.COOKIE_CLICKER_NB_GAMES))
                )
        );

        // The best player on cookie clicker
        dataEntries.put(
                CookieClickerStatsEnum.COOKIE_CLICKER_BEST_PLAYER,
                GlobalStatisticsRepository.getBestPlayerByGame(GameEnum.COOKIE_CLICKER)
        );

        CookieClickerRepository.saveAll(dataEntries);
    }

    private static void updateIntValueCookieClicker(Map<CookieClickerStatsEnum, String> dataEntries, Map<CookieClickerStatsEnum, String> gamesEntries, CookieClickerStatsEnum stats) {
        dataEntries.put(
                stats,
                String.valueOf(
                        Integer.parseInt(gamesEntries.get(stats))
                                + Integer.parseInt(dataEntries.get(stats))
                )
        );
    }

    public static void updateConnectFour(Map<ConnectFourStatsEnum, String> gameMap) {
        Map<ConnectFourStatsEnum, String> dataEntries = ConnectFourRepository.getAll();
        updateIntValueConnectFour(dataEntries, gameMap, ConnectFourStatsEnum.CONNECT_FOUR_NB_GAMES);
        updateIntValueConnectFour(dataEntries, gameMap, ConnectFourStatsEnum.CONNECT_FOUR_NB_DRAW);
        updateIntValueConnectFour(dataEntries, gameMap, ConnectFourStatsEnum.CONNECT_FOUR_NB_YELLOW_PAWNS);
        updateIntValueConnectFour(dataEntries, gameMap, ConnectFourStatsEnum.CONNECT_FOUR_NB_RED_PAWNS);
        updateIntValueConnectFour(dataEntries, gameMap, ConnectFourStatsEnum.CONNECT_FOUR_NB_ALL_PAWNS);
        updateIntValueConnectFour(dataEntries, gameMap, ConnectFourStatsEnum.CONNECT_FOUR_NB_WIN_DIAG);
        updateIntValueConnectFour(dataEntries, gameMap, ConnectFourStatsEnum.CONNECT_FOUR_NB_WIN_LANDSCAPE);
        updateIntValueConnectFour(dataEntries, gameMap, ConnectFourStatsEnum.CONNECT_FOUR_NB_WIN_VERTICAL);
        updateIntValueConnectFour(dataEntries, gameMap, ConnectFourStatsEnum.CONNECT_FOUR_TOTAL_TIME);
        // Average time per game
        dataEntries.put(
                ConnectFourStatsEnum.CONNECT_FOUR_AVERAGE_TIME,
                String.valueOf(
                        Integer.parseInt(dataEntries.get(ConnectFourStatsEnum.CONNECT_FOUR_TOTAL_TIME))
                                / Integer.parseInt(dataEntries.get(ConnectFourStatsEnum.CONNECT_FOUR_NB_GAMES))
                )
        );

        // The best player on connect four
        dataEntries.put(
                ConnectFourStatsEnum.CONNECT_FOUR_BEST_PLAYER,
                GlobalStatisticsRepository.getBestPlayerByGame(GameEnum.CONNECT_FOUR)
        );

        ConnectFourRepository.saveAll(dataEntries);
    }

    private static void updateIntValueConnectFour(Map<ConnectFourStatsEnum, String> dataEntries, Map<ConnectFourStatsEnum, String> gamesEntries, ConnectFourStatsEnum stats) {
        dataEntries.put(
                stats,
                String.valueOf(
                        Integer.parseInt(gamesEntries.get(stats))
                                + Integer.parseInt(dataEntries.get(stats))
                )
        );
    }

    public static void updateFifteenVainc(Map<FifteenVaincStatsEnum, String> gameMap) {
        Map<FifteenVaincStatsEnum, String> dataEntries = FifteenVaincRepository.getAll();
        updateIntValueFifteenVainc(dataEntries, gameMap, FifteenVaincStatsEnum.FIFTEEN_VAINC_NB_GAMES);
        updateIntValueFifteenVainc(dataEntries, gameMap, FifteenVaincStatsEnum.FIFTEEN_VAINC_NB_DRAW);
        updateIntValueFifteenVainc(dataEntries, gameMap, FifteenVaincStatsEnum.FIFTEEN_VAINC_NB_PERFECT);
        updateIntValueFifteenVainc(dataEntries, gameMap, FifteenVaincStatsEnum.FIFTEEN_VAINC_TOTAL_TIME);

        // The best player on fifteen vainc
        dataEntries.put(
                FifteenVaincStatsEnum.FIFTEEN_VAINC_BEST_PLAYER,
                GlobalStatisticsRepository.getBestPlayerByGame(GameEnum.FIFTEEN_VAINC)
        );

        FifteenVaincRepository.saveAll(dataEntries);
    }

    private static void updateIntValueFifteenVainc(Map<FifteenVaincStatsEnum, String> dataEntries, Map<FifteenVaincStatsEnum, String> gamesEntries, FifteenVaincStatsEnum stats) {
        dataEntries.put(
                stats,
                String.valueOf(
                        Integer.parseInt(gamesEntries.get(stats))
                                + Integer.parseInt(dataEntries.get(stats))
                )
        );
    }

    public static void updateHangman(Map<HangmanStatsEnum, String> gameMap) {
        Map<HangmanStatsEnum, String> dataEntries = HangmanRepository.getAll();
        updateIntValueHangman(dataEntries, gameMap, HangmanStatsEnum.HANGMAN_NB_GAMES);
        updateIntValueHangman(dataEntries, gameMap, HangmanStatsEnum.HANGMAN_NB_CORRECT_LETTERS);
        updateIntValueHangman(dataEntries, gameMap, HangmanStatsEnum.HANGMAN_NB_WRONG_LETTERS);
        updateIntValueHangman(dataEntries, gameMap, HangmanStatsEnum.HANGMAN_NB_LETTERS);
        updateIntValueHangman(dataEntries, gameMap, HangmanStatsEnum.HANGMAN_NB_PERFECT);
        // Average time per game
        dataEntries.put(
                HangmanStatsEnum.HANGMAN_AVERAGE_TIME,
                String.valueOf(
                        Integer.parseInt(dataEntries.get(HangmanStatsEnum.HANGMAN_TOTAL_TIME))
                                / Integer.parseInt(dataEntries.get(HangmanStatsEnum.HANGMAN_NB_GAMES))
                )
        );

        // The best player on connect four
        dataEntries.put(
                HangmanStatsEnum.HANGMAN_BEST_PLAYER,
                GlobalStatisticsRepository.getBestPlayerByGame(GameEnum.HANGMAN)
        );

        HangmanRepository.saveAll(dataEntries);
    }

    private static void updateIntValueHangman(Map<HangmanStatsEnum, String> dataEntries, Map<HangmanStatsEnum, String> gamesEntries, HangmanStatsEnum stats) {
        dataEntries.put(
                stats,
                String.valueOf(
                        Integer.parseInt(gamesEntries.get(stats))
                                + Integer.parseInt(dataEntries.get(stats))
                )
        );
    }

    public static void updateDataPlayer(String playerId, Map<PlayerStatsEnum, String> gameMap) {

        if (!ContestDataPersistor.validatePlayerStatsMap(gameMap)) {
            throw new RuntimeException("Player statistics map not valid, data not saved");
        }

        Map<PlayerStatsEnum, String> dataEntries = PlayerStatsRepository.getByPlayerId(playerId);

        if (null == dataEntries) {
            return;
        }

        for (Map.Entry<PlayerStatsEnum, String> entry : gameMap.entrySet()) {
            ContestDataPersistor.updateIntValueDataPlayer(dataEntries, gameMap, entry.getKey());
        }

        ContestDataPersistor.updateRatePlayer(dataEntries);

        dataEntries.put(
                PlayerStatsEnum.MOST_PLAYED_GAME,
                ContestDataPersistor.getMostPlayedGame(dataEntries)
        );

        PlayerStatsRepository.saveAll(playerId, dataEntries);
    }

    private static void updateIntValueDataPlayer(Map<PlayerStatsEnum, String> dataEntries, Map<PlayerStatsEnum, String> gamesEntries, PlayerStatsEnum stats) {
        dataEntries.put(
                stats,
                String.valueOf(
                        Integer.parseInt(gamesEntries.get(stats))
                                + Integer.parseInt(dataEntries.get(stats))
                )
        );
    }

    private static void updateRatePlayer(Map<PlayerStatsEnum, String> dataEntries) {
        dataEntries.put(
                PlayerStatsEnum.TIC_TAC_TOE_WIN_RATE,
                ContestDataPersistor.getRate(
                        Integer.parseInt(dataEntries.get(PlayerStatsEnum.TIC_TAC_TOE_NB_WIN)),
                        Integer.parseInt(dataEntries.get(PlayerStatsEnum.TIC_TAC_TOE_NB_GAME))
                )
        );

        dataEntries.put(
                PlayerStatsEnum.RUNNER_WIN_RATE,
                ContestDataPersistor.getRate(
                        Integer.parseInt(dataEntries.get(PlayerStatsEnum.RUNNER_NB_WIN)),
                        Integer.parseInt(dataEntries.get(PlayerStatsEnum.RUNNER_NB_GAME))
                )
        );

        dataEntries.put(
                PlayerStatsEnum.COOKIE_CLICKER_WIN_RATE,
                ContestDataPersistor.getRate(
                        Integer.parseInt(dataEntries.get(PlayerStatsEnum.COOKIE_CLICKER_NB_WIN)),
                        Integer.parseInt(dataEntries.get(PlayerStatsEnum.COOKIE_CLICKER_NB_GAME))
                )
        );

        dataEntries.put(
                PlayerStatsEnum.CONNECT_FOUR_WIN_RATE,
                ContestDataPersistor.getRate(
                        Integer.parseInt(dataEntries.get(PlayerStatsEnum.CONNECT_FOUR_NB_WIN)),
                        Integer.parseInt(dataEntries.get(PlayerStatsEnum.CONNECT_FOUR_NB_GAME))
                )
        );

        dataEntries.put(
                PlayerStatsEnum.FIFTEEN_VAINC_WIN_RATE,
                ContestDataPersistor.getRate(
                        Integer.parseInt(dataEntries.get(PlayerStatsEnum.FIFTEEN_VAINC_NB_WIN)),
                        Integer.parseInt(dataEntries.get(PlayerStatsEnum.FIFTEEN_VAINC_NB_GAME))
                )
        );

        dataEntries.put(
                PlayerStatsEnum.WIN_RATE,
                ContestDataPersistor.getRate(
                        Integer.parseInt(dataEntries.get(PlayerStatsEnum.TOTAL_NB_WIN)),
                        Integer.parseInt(dataEntries.get(PlayerStatsEnum.TOTAL_NB_GAME))
                )
        );
    }

    private static String getRate(int nbWin, int nbGame) {
        DecimalFormat df = new DecimalFormat();
        df.setMinimumFractionDigits(2);
        df.setMaximumFractionDigits(2);
        df.setDecimalSeparatorAlwaysShown(true);
        return (nbGame > 0) ? String.valueOf(df.format(((float) nbWin / nbGame) * 100)) : "0";
    }

    private static boolean validatePlayerStatsMap(Map<PlayerStatsEnum, String> statsMap) {

        if (
                !statsMap.containsKey(PlayerStatsEnum.TOTAL_NB_GAME) ||
                !statsMap.containsKey(PlayerStatsEnum.TOTAL_NB_LOOSE) ||
                !statsMap.containsKey(PlayerStatsEnum.TOTAL_NB_WIN) ||
                !(
                        (
                                statsMap.containsKey(PlayerStatsEnum.TIC_TAC_TOE_NB_GAME) &&
                                statsMap.containsKey(PlayerStatsEnum.TIC_TAC_TOE_NB_WIN)
                        ) ||
                        (
                                statsMap.containsKey(PlayerStatsEnum.RUNNER_NB_GAME) &&
                                statsMap.containsKey(PlayerStatsEnum.RUNNER_NB_WIN)
                        ) ||
                        (
                                statsMap.containsKey(PlayerStatsEnum.CONNECT_FOUR_NB_GAME) &&
                                statsMap.containsKey(PlayerStatsEnum.CONNECT_FOUR_NB_WIN)
                        ) ||
                        (
                                statsMap.containsKey(PlayerStatsEnum.COOKIE_CLICKER_NB_GAME) &&
                                statsMap.containsKey(PlayerStatsEnum.COOKIE_CLICKER_NB_WIN)
                        )||
                        (
                                statsMap.containsKey(PlayerStatsEnum.FIFTEEN_VAINC_NB_GAME) &&
                                statsMap.containsKey(PlayerStatsEnum.FIFTEEN_VAINC_NB_WIN)
                        ) ||
                        (
                                statsMap.containsKey(PlayerStatsEnum.HANGMAN_NB_GAME) &&
                                statsMap.containsKey(PlayerStatsEnum.HANGMAN_NB_WIN)
                        )

                )
        ) {
            return false;
        }

        return true;
    }

    /**
     * Get the most played game
     *
     * @return The name of the most played game
     */
    public static String getMostPlayedGame(Map<PlayerStatsEnum, String> dataEntries) {
        Map<GameEnum, Integer> nbGamesMap = ContestDataPersistor.getNbGamesMap(dataEntries);

        GameEnum mostPlayedGame = GameEnum.TIC_TAC_TOE;
        for (Map.Entry<GameEnum, Integer> entry : nbGamesMap.entrySet()) {
            mostPlayedGame = (nbGamesMap.get(mostPlayedGame) < entry.getValue()) ? entry.getKey() : mostPlayedGame;
        }

        return mostPlayedGame.toString();
    }

    /**
     * Get a map with the total of games matches per game
     */
    private static Map<GameEnum, Integer> getNbGamesMap(Map<PlayerStatsEnum, String> dataEntries) {
        Map<GameEnum, Integer> nbGamesMap = new HashMap<>();

        String ticTacToeNbGameString = dataEntries.get(PlayerStatsEnum.TIC_TAC_TOE_NB_GAME);
        int ticTacToeNbGame = Integer.parseInt(ticTacToeNbGameString);
        nbGamesMap.put(GameEnum.TIC_TAC_TOE, ticTacToeNbGame);

        String runnerNbGameString = dataEntries.get(PlayerStatsEnum.RUNNER_NB_GAME);
        int runnerNbGame = Integer.parseInt(runnerNbGameString);
        nbGamesMap.put(GameEnum.RUNNER, runnerNbGame);

        String connectFourNbGameString = dataEntries.get(PlayerStatsEnum.CONNECT_FOUR_NB_GAME);
        int connectFourNbGame = Integer.parseInt(connectFourNbGameString);
        nbGamesMap.put(GameEnum.CONNECT_FOUR, connectFourNbGame);

        String cookieClickerNbGameString = dataEntries.get(PlayerStatsEnum.COOKIE_CLICKER_NB_GAME);
        int cookieClickerNbGame = Integer.parseInt(cookieClickerNbGameString);
        nbGamesMap.put(GameEnum.COOKIE_CLICKER, cookieClickerNbGame);

        String fifteenVaincNbGameString = dataEntries.get(PlayerStatsEnum.FIFTEEN_VAINC_NB_GAME);
        int fifteenVaincNbGame = Integer.parseInt(fifteenVaincNbGameString);
        nbGamesMap.put(GameEnum.FIFTEEN_VAINC, fifteenVaincNbGame);

        return nbGamesMap;
    }
}
