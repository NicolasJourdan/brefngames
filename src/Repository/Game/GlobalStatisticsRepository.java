package Repository.Game;

import Game.Games.ConnectFour.ConnectFourStatsEnum;
import Game.Games.CookieClicker.CookieClickerStatsEnum;
import Game.Games.FifteenVainc.FifteenVaincStatsEnum;
import Game.Games.GlobalStatisticsEnum;
import Game.Games.Hangman.HangmanStatsEnum;
import Game.Games.Runner.RunnerStatsEnum;
import Game.Games.TicTacToe.TicTacToeStatsEnum;
import Game.Model.GameEnum;
import Player.Player;
import Repository.Player.PlayerRepository;
import Repository.Player.PlayerStatsEnum;
import Repository.Player.PlayerStatsRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GlobalStatisticsRepository {

    public static Map<GlobalStatisticsEnum, String> getAll() {
        Map<GlobalStatisticsEnum, String> globalStatsMap = new HashMap<>();

        globalStatsMap.put(GlobalStatisticsEnum.BEST_PLAYER, GlobalStatisticsRepository.getBestPlayer());
        globalStatsMap.put(GlobalStatisticsEnum.MOST_PLAYED_GAME, GlobalStatisticsRepository.getMostPlayedGame());
        globalStatsMap.put(GlobalStatisticsEnum.MOST_ADDICT_PLAYER, GlobalStatisticsRepository.getMostAddictPlayer());
        globalStatsMap.put(GlobalStatisticsEnum.NB_TOTAL_GAMES, GlobalStatisticsRepository.getTotalPlayedGames());

        return globalStatsMap;
    }

    /**
     * Get the player with the most victories
     *
     * @return The name of the player
     */
    public static String getBestPlayer() {
        return GlobalStatisticsRepository.getBestPlayerByStat(PlayerStatsEnum.TOTAL_NB_WIN);
    }

    /**
     * Get the player with the most games
     *
     * @return The name of the player
     */
    public static String getMostAddictPlayer() {
        return GlobalStatisticsRepository.getBestPlayerByStat(PlayerStatsEnum.TOTAL_NB_GAME);
    }

    /**
     * Get the most played game
     *
     * @return The name of the most played game
     */
    public static String getMostPlayedGame() {
        Map<GameEnum, Integer> nbGamesMap = GlobalStatisticsRepository.getNbGamesMap();

        GameEnum mostPlayedGame = GameEnum.TIC_TAC_TOE;
        for (Map.Entry<GameEnum, Integer> entry : nbGamesMap.entrySet()) {
            mostPlayedGame = (nbGamesMap.get(mostPlayedGame) < entry.getValue()) ? entry.getKey() : mostPlayedGame;
        }

        return mostPlayedGame.toString();
    }

    /**
     * Get the total played games
     */
    public static String getTotalPlayedGames() {
        Map<GameEnum, Integer> nbGamesMap = GlobalStatisticsRepository.getNbGamesMap();
        int totalPlayedGames = 0;

        for (Map.Entry<GameEnum, Integer> entry : nbGamesMap.entrySet()) {
            totalPlayedGames += entry.getValue();
        }

        return String.valueOf(totalPlayedGames);
    }

    /**
     * Get the best player on the game passed in parameter
     */
    public static String getBestPlayerByGame(GameEnum gameEnum) {
        switch (gameEnum) {
            case TIC_TAC_TOE:
                return GlobalStatisticsRepository.getBestPlayerByStat(PlayerStatsEnum.TIC_TAC_TOE_NB_WIN);
            case RUNNER:
                return GlobalStatisticsRepository.getBestPlayerByStat(PlayerStatsEnum.RUNNER_NB_WIN);
            case COOKIE_CLICKER:
                return GlobalStatisticsRepository.getBestPlayerByStat(PlayerStatsEnum.COOKIE_CLICKER_NB_WIN);
            case CONNECT_FOUR:
                return GlobalStatisticsRepository.getBestPlayerByStat(PlayerStatsEnum.CONNECT_FOUR_NB_WIN);
            case FIFTEEN_VAINC:
                return GlobalStatisticsRepository.getBestPlayerByStat(PlayerStatsEnum.FIFTEEN_VAINC_NB_WIN);
            case HANGMAN:
                return GlobalStatisticsRepository.getBestPlayerByStat(PlayerStatsEnum.HANGMAN_NB_WIN);
            default:
                throw new RuntimeException("GameEnum : " + gameEnum + " is unknown");
        }
    }

    /**
     * Get the best player on a statistic
     *
     * @return The name of the best player
     */
    private static String getBestPlayerByStat(PlayerStatsEnum stats) {
        List<Player> players = PlayerRepository.getAll();

        Player bestPlayer = players.get(0);

        for (Player player : players) {
            // Get Total of this stat from JSON
            String nbStatPlayerString = PlayerStatsRepository.getByStat(player.getName(), stats);
            if (null == nbStatPlayerString) {
                // The player don't have this stat
                continue;
            }

            // Get Total of this stat from JSON
            String nbStatBestPlayerString = PlayerStatsRepository.getByStat(bestPlayer.getName(), stats);
            if (null == nbStatBestPlayerString) {
                // The bestPlayer don't have this stat so the best player is the current player
                bestPlayer = player;
                continue;
            }

            int nbStatPlayer = Integer.parseInt(nbStatPlayerString);
            int nbStatBestPlayer = Integer.parseInt(nbStatBestPlayerString);

            bestPlayer = (nbStatBestPlayer < nbStatPlayer) ? player : bestPlayer;
        }

        return bestPlayer.getName();
    }

    /**
     * Get a map with the total of games matches per game
     */
    private static Map<GameEnum, Integer> getNbGamesMap() {
        Map<GameEnum, Integer> nbGamesMap = new HashMap<>();

        String ticTacToeNbGameString = TicTacToeRepository.getById(TicTacToeStatsEnum.TIC_TAC_TOE_NB_GAMES);
        int ticTacToeNbGame = Integer.parseInt(ticTacToeNbGameString);
        nbGamesMap.put(GameEnum.TIC_TAC_TOE, ticTacToeNbGame);

        String runnerNbGameString = RunnerRepository.getById(RunnerStatsEnum.RUNNER_NB_GAMES);
        int runnerNbGame = Integer.parseInt(runnerNbGameString);
        nbGamesMap.put(GameEnum.RUNNER, runnerNbGame);

        String connectFourNbGameString = ConnectFourRepository.getById(ConnectFourStatsEnum.CONNECT_FOUR_NB_GAMES);
        int connectFourNbGame = Integer.parseInt(connectFourNbGameString);
        nbGamesMap.put(GameEnum.CONNECT_FOUR, connectFourNbGame);

        String cookieClickerNbGameString = CookieClickerRepository.getById(CookieClickerStatsEnum.COOKIE_CLICKER_NB_GAMES);
        int cookieClickerNbGame = Integer.parseInt(cookieClickerNbGameString);
        nbGamesMap.put(GameEnum.COOKIE_CLICKER, cookieClickerNbGame);

        String fifteenVaincNbGameString = FifteenVaincRepository.getById(FifteenVaincStatsEnum.FIFTEEN_VAINC_NB_GAMES);
        int fifteenVaincNbGame = Integer.parseInt(fifteenVaincNbGameString);
        nbGamesMap.put(GameEnum.FIFTEEN_VAINC, fifteenVaincNbGame);

        String hangmanNbGameString = HangmanRepository.getById(HangmanStatsEnum.HANGMAN_NB_GAMES);
        int hangmanNbGame = Integer.parseInt(hangmanNbGameString);
        nbGamesMap.put(GameEnum.HANGMAN, hangmanNbGame);
        return nbGamesMap;
    }
}
