package Game.Games.DataObject;

import Game.Games.Coord;

import java.awt.*;
import java.io.Serializable;

public class HangmanDataObject implements Serializable {

    private String result;
    private String word;
    private String nbGuess;
    private int guessLeft;

    public HangmanDataObject(String result, String word, String nbGuess, int guessLeft) {
        this.result = result;
        this.word = word;
        this.nbGuess = nbGuess;
        this.guessLeft = guessLeft;
    }

    public String getResult() {
        return this.result;
    }

    public String getWord() {
        return this.word;
    }

    public String getNbGuess() {
        return this.nbGuess;
    }

    public int getGuessLeft() {
        return this.guessLeft;
    }
}
