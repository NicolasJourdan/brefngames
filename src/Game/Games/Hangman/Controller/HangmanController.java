package Game.Games.Hangman.Controller;

import Game.Controller.AbstractGameController;
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

    public HangmanController(HangmanModel model, HangmanView view, boolean isTraining) {
        super(model, view, isTraining);

        this.updateGame(INITIAL_STATUS);
        ((HangmanView) this.view).updateCurrentPlayer(((HangmanModel) this.model).getCurrentPlayer());

        this.view.setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (!((HangmanModel) this.model).isFinished()) {
            String result = ((HangmanModel) this.model).makeGuess((Character) arg);
            ((HangmanView) this.view).setDisabled((Character) arg);
            this.updateGame(result);
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

    private void updateGame(String result) {
        ((HangmanView) this.view).setNumGuesses(result);
        ((HangmanView) this.view).setCurrentWord(
                ((HangmanModel) this.model).updateCurrentWord()
        );
        ((HangmanView) this.view).setNumGuesses(
                ((HangmanModel) this.model).updateNumGuesses()
        );

        this.updateHangmanImage();
    }

    /**
     * switch on the number of guesses left to determine the image icon
     */
    private void updateHangmanImage() {

        if (((HangmanModel) this.model).getNumGuessesLeft() > 7) {
            ((HangmanView) this.view).setImageIcon("/hw3/hang7.gif");
        } else {
            switch (((HangmanModel) this.model).getNumGuessesLeft()) {

                case 7:
                    ((HangmanView) this.view).setImageIcon("/data/Images/hang7.gif");
                    break;
                case 6:
                    ((HangmanView) this.view).setImageIcon("/data/Images/hang6.gif");
                    break;
                case 5:
                    ((HangmanView) this.view).setImageIcon("/data/Images/hang5.gif");
                    break;
                case 4:
                    ((HangmanView) this.view).setImageIcon("/data/Images/hang4.gif");
                    break;
                case 3:
                    ((HangmanView) this.view).setImageIcon("/data/Images/hang3.gif");
                    break;
                case 2:
                    ((HangmanView) this.view).setImageIcon("/data/Images/hang2.gif");
                    break;
                case 1:
                    ((HangmanView) this.view).setImageIcon("/data/Images/hang1.gif");
                    break;
                case 0:
                    ((HangmanView) this.view).setImageIcon("/data/Images/hang0.gif");
                    break;
                default:
                    break;

            }
        }
    }
}
