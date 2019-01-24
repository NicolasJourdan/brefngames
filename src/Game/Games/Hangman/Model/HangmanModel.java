package Game.Games.Hangman.Model;

import Contest.Model.ContestDataPersistor;
import Game.Games.Hangman.HangmanStatsEnum;
import Game.Model.AbstractGameModel;
import Player.Player;
import Repository.Game.HangmanWordsRepository;
import Repository.Player.PlayerStatsEnum;
import Scene.Model.ActionEnum;
import Utils.Chronometer.Chronometer;

import java.util.*;

/**
 * models a hangman game
 *
 * @author josephmalandruccolo
 */
public class HangmanModel extends AbstractGameModel {

    private static int DEFAULT_NB_PLAYERS = 2;
    private static final int NUM_LEGAL_CHARS = 27;    //26 letters, each converted to uppercase and a '-' (hyphen) character
    private static final int PADDING = 5;    //additional space in the array, for safety
    private static final int GUESSES_NUMBER = 7;
    private static final String ALREADY_GUESSED_ALERT = "You already tried that letter!";
    private static final String SUCCESSFUL_GUESS_ALERT = "YES!";
    private static final String FAILED_GUESS_ALERT = "nope";
    private Player currentPlayer;
    private String strSecretWord;                    //the word to be guessed
    private boolean wrongLetter;                    //the word to be guessed
    private int nRemainingGuesses;                    //number of guesses left
    private int nLettersRemaining;                    //number of letters the player needs to guess to solve the word
    private char[] cCurrentWordChars;                //holds the current word, as guessed by the user
    private List<Character> cLettersGuessed;    //linked list of characters
    private Map<HangmanStatsEnum, String> gameStats;
    private Map<PlayerStatsEnum, String> firstPlayerStats;
    private Map<PlayerStatsEnum, String> secondPlayerStats;
    private Chronometer chronometer;

    public HangmanModel(Player[] players) {
        super(players);
        Random random = new Random();
        this.wrongLetter = false;
        this.currentPlayer = listPlayers[random.nextInt(HangmanModel.DEFAULT_NB_PLAYERS)];
        this.strSecretWord = this.genSecretWord();
        this.strSecretWord = this.strSecretWord.toUpperCase();
        this.nRemainingGuesses = GUESSES_NUMBER;
        this.nLettersRemaining = strSecretWord.length();
        this.cLettersGuessed = new ArrayList<Character>(HangmanModel.NUM_LEGAL_CHARS + HangmanModel.PADDING);
        this.cCurrentWordChars = new char[strSecretWord.length()];

        //set the current word to "_ _ _..."
        for (int nC = 0; nC < cCurrentWordChars.length; nC++) cCurrentWordChars[nC] = '_';
        this.initStats();
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void changePlayer() {
        if (this.wrongLetter) {
            int wrongNb = Integer.parseInt(this.gameStats.get(HangmanStatsEnum.HANGMAN_NB_WRONG_LETTERS)) + 1;
            gameStats.put(HangmanStatsEnum.HANGMAN_NB_WRONG_LETTERS, Integer.toString(wrongNb));
            gameStats.put(HangmanStatsEnum.HANGMAN_NB_PERFECT, "0");
            if (this.currentPlayer.equals(this.listPlayers[0])) {
                this.currentPlayer = this.listPlayers[1];
            } else {
                this.currentPlayer = this.listPlayers[0];
            }
        }
        else{
            int correctNb = Integer.parseInt(this.gameStats.get(HangmanStatsEnum.HANGMAN_NB_CORRECT_LETTERS)) + 1;
            gameStats.put(HangmanStatsEnum.HANGMAN_NB_CORRECT_LETTERS, Integer.toString(correctNb));
        }
        this.wrongLetter = false;
    }

    private String genSecretWord() {
        return HangmanWordsRepository.getWord();
    }

    /**
     * represents a player guessing a letter
     * updates the state of the game based on the player's guess:
     * number of guesses remaining
     * number of letters remaining
     * current word
     * letters guessed
     * <p>
     * GAME LOGIC:
     * if the letter guessed is not in the word AND has not already been guessed, decrement the number of guesses
     * if the letter guessed is in the word AND has not already been guessed, update the game state and do NOT decrement the number of guesses
     * no penalty for guessing the same letter multiple times
     *
     * @param cLetter - the character guessed by the user
     * @return true if (the game is not over AND guessed letter was in the word) false otherwise
     */
    public String makeGuess(char cLetter) {
        String strMessage;

        //have we guessed this letter before?
        if (isLetterInWord(cLetter, this.cLettersGuessed)) {
            //we have guessed the letter before
            strMessage = HangmanModel.ALREADY_GUESSED_ALERT;
        } else {
            //we have NOT guessed the letter before

            //the letter is in the secret word
            if (isLetterInWord(cLetter, this.strSecretWord)) {
                this.updateCurrentWord(cLetter);
                this.updateLettersGuessed(cLetter);
                strMessage = HangmanModel.SUCCESSFUL_GUESS_ALERT;
            } else {
                //the letter is NOT in the secret word
                this.nRemainingGuesses--;
                updateLettersGuessed(cLetter);
                strMessage = HangmanModel.FAILED_GUESS_ALERT;
                this.wrongLetter = true;
            }
        }

        return strMessage;
    }

    public String updateCurrentWord() {
        String strWord = this.getCurrentWord();

        char[] cWordChars = strWord.toCharArray();
        //number of characters plus padding
        char[] cDisplayChars = new char[cWordChars.length * 2 - 1];

        int nLetterCounter = 0;
        for (int nC = 0; nC < cDisplayChars.length; nC++) {

            if (nC % 2 != 0) cDisplayChars[nC] = ' ';
            else {
                cDisplayChars[nC] = cWordChars[nLetterCounter];
                nLetterCounter++;
            }
        }

        return new String(cDisplayChars);
    }

    public String updateNumGuesses() {
        String strNumAsString = "";

        strNumAsString += this.getNumGuessesLeft();
        strNumAsString += " guesses left";

        return strNumAsString;
    }

    public boolean isFinished() {
        return this.isWin() || this.isLoss();
    }

    public ActionEnum getWinner() {
        if (this.isWin()) {
            return this.getCurrentPlayer().getName().equals(this.getPlayers()[0].getName()) ?
                    ActionEnum.FIRST_PLAYER_WON : ActionEnum.SECOND_PLAYER_WON;
        }

        // isLoss
        return this.getCurrentPlayer().getName().equals(this.getPlayers()[0].getName()) ?
                ActionEnum.SECOND_PLAYER_WON : ActionEnum.FIRST_PLAYER_WON;
    }

    /**
     * identifies whether the player has won the game
     *
     * @return true if there are no more letters to be guessed and the player has a positive number of guesses remaining
     */
    private boolean isWin() {
        return this.nRemainingGuesses > 0 && this.nLettersRemaining <= 0;
    }

    /**
     * identifies whether the player has lost the game
     *
     * @return true if there are no remaining guesses and more letters to guess
     */
    private boolean isLoss() {
        return this.nRemainingGuesses <= 0 && this.nLettersRemaining > 0;
    }

    /**
     * if the letter guessed has not already been stored, store it
     *
     * @param cLetter - letter guessed
     */
    private void updateLettersGuessed(char cLetter) {
        if (!isLetterInWord(cLetter, this.cLettersGuessed)) this.cLettersGuessed.add(cLetter);
    }

    /**
     * update the current word to reflect the guess
     * method also responsible for updating the number of letters remaining
     *
     * @param cLetter
     */
    private void updateCurrentWord(char cLetter) {
        //loop through the secret word, if we encounter the guessed letter, update the current word array
        for (int nC = 0; nC < this.cCurrentWordChars.length; nC++) {
            if (this.strSecretWord.charAt(nC) == cLetter) {
                this.cCurrentWordChars[nC] = cLetter;
                this.nLettersRemaining--;
            }
        }
    }

    /**
     * linear search algorithm to identify if a char key is in a char array, inefficient algorithm is fine
     * as we expect the character array (word) to be short
     *
     * @param cLetter - the key
     * @param cWord   - the list
     * @return true if found, false otherwise
     */
    private boolean isLetterInWord(char cLetter, List<Character> cWord) {

        for (int nC = 0; nC < cWord.size(); nC++) if (cWord.get(nC) == cLetter) return true;

        return false;
    }


    /**
     * @param cLetter - the key
     * @param strWord - the word
     * @return true if found, false otherwise
     */
    private boolean isLetterInWord(char cLetter, String strWord) {
        return strWord.indexOf(cLetter) >= 0;
    }

    /**
     * @return the number of guesses remaining
     */
    public int getNumGuessesLeft() {
        return this.nRemainingGuesses;
    }

    /**
     * @return the current word, as a String
     */
    public String getCurrentWord() {
        StringBuilder sbCurrentWordPublic = new StringBuilder();

        for (int nC = 0; nC < this.cCurrentWordChars.length; nC++)
            sbCurrentWordPublic.append(this.cCurrentWordChars[nC]);

        return sbCurrentWordPublic.toString();
    }

    private void initStats() {
        this.chronometer = new Chronometer();

        //Game Stats
        this.gameStats = new HashMap<>();
        this.gameStats.put(HangmanStatsEnum.HANGMAN_NB_WRONG_LETTERS, "0");
        this.gameStats.put(HangmanStatsEnum.HANGMAN_NB_CORRECT_LETTERS, "0");
        this.gameStats.put(HangmanStatsEnum.HANGMAN_NB_LETTERS, "0");
        this.gameStats.put(HangmanStatsEnum.HANGMAN_NB_PERFECT, "1");
        this.gameStats.put(HangmanStatsEnum.HANGMAN_NB_GAMES, "1");

        //First Player Stats
        this.firstPlayerStats = new HashMap<>();
        this.firstPlayerStats.put(PlayerStatsEnum.HANGMAN_NB_GAME, "1");
        this.firstPlayerStats.put(PlayerStatsEnum.HANGMAN_NB_WIN, "0");
        this.firstPlayerStats.put(PlayerStatsEnum.TOTAL_NB_GAME, "1");
        this.firstPlayerStats.put(PlayerStatsEnum.TOTAL_NB_WIN, "0");
        this.firstPlayerStats.put(PlayerStatsEnum.TOTAL_NB_LOOSE, "0");

        //Second Player Stats
        this.secondPlayerStats = new HashMap<>();
        this.secondPlayerStats.put(PlayerStatsEnum.HANGMAN_NB_GAME, "1");
        this.secondPlayerStats.put(PlayerStatsEnum.HANGMAN_NB_WIN, "0");
        this.secondPlayerStats.put(PlayerStatsEnum.TOTAL_NB_GAME, "1");
        this.secondPlayerStats.put(PlayerStatsEnum.TOTAL_NB_WIN, "0");
        this.secondPlayerStats.put(PlayerStatsEnum.TOTAL_NB_LOOSE, "0");
    }

    public void updateGlobalStats() {
        int wrongNb = Integer.parseInt(this.gameStats.get(HangmanStatsEnum.HANGMAN_NB_WRONG_LETTERS));
        int correctNb = Integer.parseInt(this.gameStats.get(HangmanStatsEnum.HANGMAN_NB_CORRECT_LETTERS));
        this.gameStats.put(HangmanStatsEnum.HANGMAN_NB_LETTERS, Integer.toString(wrongNb + correctNb));
        this.gameStats.put(HangmanStatsEnum.HANGMAN_TOTAL_TIME, Integer.toString(this.chronometer.getDuration()));
    }

    public void updatePlayerStats() {
        if ((this.isWin() && this.currentPlayer.equals(this.listPlayers[0])) || (this.isLoss() && this.currentPlayer.equals(this.listPlayers[1]))) {
            this.firstPlayerStats.put(PlayerStatsEnum.HANGMAN_NB_WIN, "1");
            this.firstPlayerStats.put(PlayerStatsEnum.TOTAL_NB_WIN, "1");
            this.secondPlayerStats.put(PlayerStatsEnum.TOTAL_NB_LOOSE, "1");
        } else if ((this.isWin() && this.currentPlayer.equals(this.listPlayers[1])) || (this.isLoss() && this.currentPlayer.equals(this.listPlayers[0]))) {
            this.secondPlayerStats.put(PlayerStatsEnum.HANGMAN_NB_WIN, "1");
            this.secondPlayerStats.put(PlayerStatsEnum.TOTAL_NB_WIN, "1");
            this.firstPlayerStats.put(PlayerStatsEnum.TOTAL_NB_LOOSE, "1");
        }
    }

    public void sendGlobalStats() {
        ContestDataPersistor.updateHangman(this.getGameStats());
    }

    public void sendFirstPlayerStats() {
        ContestDataPersistor.updateDataPlayer(this.getPlayers()[0].getName(), this.getFirstPlayerStats());
    }

    public void sendSecondPlayerStats() {
        ContestDataPersistor.updateDataPlayer(this.getPlayers()[1].getName(), this.getSecondPlayerStats());
    }

    public Map<HangmanStatsEnum, String> getGameStats() {
        return this.gameStats;
    }

    public Map<PlayerStatsEnum, String> getFirstPlayerStats() {
        return this.firstPlayerStats;
    }

    public Map<PlayerStatsEnum, String> getSecondPlayerStats() {
        return this.secondPlayerStats;
    }
}
