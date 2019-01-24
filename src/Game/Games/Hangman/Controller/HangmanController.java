package Game.Games.Hangman.Controller;

import Game.Controller.AbstractGameController;
import Game.Games.DataObject.HangmanDataObject;
import Game.Games.Hangman.Model.HangmanModel;
import Game.Games.Hangman.View.HangmanView;

import java.util.Observable;

/**
 * controller in MVC architecture for a HangmanGame
 *
 * @author josephmalandruccolo
 */
public class HangmanController extends AbstractGameController {

    private final String INITIAL_STATUS = "click a letter to make a guess!";    //status displayed in the view before any guess has been made
    private final String ROOT_PICTURE = "/data/Images/hang";
    private final String EXTENSION_PICTURE = ".gif";
    private final int MAX_GUESSES = 7;

    public HangmanController(HangmanModel model, HangmanView view, boolean isTraining) {
        super(model, view, isTraining);
        HangmanDataObject hangmanDataObject = new HangmanDataObject(
                INITIAL_STATUS,
                ((HangmanModel) this.model).updateCurrentWord(),
                ((HangmanModel) this.model).updateNumGuesses(),
                ((HangmanModel) this.model).getNumGuessesLeft()
        );
        this.updateGame(hangmanDataObject);
        ((HangmanView) this.view).updateCurrentPlayer(((HangmanModel) this.model).getCurrentPlayer());
        this.view.setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (!((HangmanModel) this.model).isFinished()) {
            String result = ((HangmanModel) this.model).makeGuess((Character) arg);
            ((HangmanView) this.view).setDisabled((Character) arg);
            HangmanDataObject hangmanDataObject = new HangmanDataObject(
                    result,
                    ((HangmanModel) this.model).updateCurrentWord(),
                    ((HangmanModel) this.model).updateNumGuesses(),
                    ((HangmanModel) this.model).getNumGuessesLeft()
            );
            this.updateGame(hangmanDataObject);
        }
        if (((HangmanModel) this.model).isFinished()) {
            if (!this.isTraining) {
                ((HangmanModel) this.model).updatePlayerStats();
                ((HangmanModel) this.model).updateGlobalStats();
                ((HangmanModel) this.model).sendGlobalStats();
                ((HangmanModel) this.model).sendFirstPlayerStats();
                ((HangmanModel) this.model).sendSecondPlayerStats();
            }
            this.setChanged();
            this.notifyObservers(((HangmanModel) this.model).getWinner());
        } else {
            ((HangmanModel) this.model).changePlayer();
            ((HangmanView) this.view).updateCurrentPlayer(
                    ((HangmanModel) this.model).getCurrentPlayer()
            );
        }
    }

    protected void updateGame(HangmanDataObject hangmanDataObject) {
        ((HangmanView) this.view).setNumGuesses(hangmanDataObject.getResult());
        ((HangmanView) this.view).setCurrentWord(hangmanDataObject.getWord());
        ((HangmanView) this.view).setNumGuesses(hangmanDataObject.getNbGuess());
        this.updateHangmanImage(hangmanDataObject.getGuessLeft());
    }

    /**
     * switch on the number of guesses left to determine the image icon
     */
    protected void updateHangmanImage(int guessLeft) {
        if (guessLeft > MAX_GUESSES) {
            ((HangmanView) this.view).setImageIcon(ROOT_PICTURE + MAX_GUESSES + EXTENSION_PICTURE);
        } else {
            ((HangmanView) this.view).setImageIcon(ROOT_PICTURE + guessLeft + EXTENSION_PICTURE);
        }
    }
}
