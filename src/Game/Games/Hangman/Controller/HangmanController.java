package Game.Games.Hangman.Controller;

import Game.Controller.AbstractGameController;
import Game.Games.Hangman.Model.HangmanModel;
import Game.Games.Hangman.View.HangmanView;
import Scene.Model.ActionEnum;

import java.util.Observable;

/**
 * controller in MVC architecture for a HangmanGame
 *
 * @author josephmalandruccolo
 */
public class HangmanController extends AbstractGameController {
    //===============================================================================================
    //											CONSTANTS
    //===============================================================================================
    private final String INITIAL_STATUS = "click a letter to make a guess!";    //status displayed in the view before any guess has been made

    //===============================================================================================
    //											CONSTRUCTOR
    //===============================================================================================

    public HangmanController(HangmanModel model, HangmanView view, boolean isTraining) {
        super(model, view, isTraining);

        //set the view's properties and turn it visible
        updateCurrentWord(model, view);
        updateNumGuesses(model, view);
        updateResultDisplay(INITIAL_STATUS, view);
        updateHangmanImage(model, view);
        ((HangmanView) this.view).updateCurrentPlayer(((HangmanModel) this.model).getCurrentPlayer());

        view.setVisible(true);
    }


    //===============================================================================================
    //											VIEW UPDATE METHODS
    //===============================================================================================

    //implement the make guess method
    //the method will necessarily update both the view and the model
    private static void updateCurrentWord(HangmanModel model, HangmanView view) {

        String strWord = model.getCurrentWord();

        char[] cWordChars = strWord.toCharArray();
        char[] cDisplayChars = new char[cWordChars.length * 2 - 1];    //number of characters plus padding

        int nLetterCounter = 0;
        for (int nC = 0; nC < cDisplayChars.length; nC++) {

            if (nC % 2 != 0) cDisplayChars[nC] = ' ';
            else {
                cDisplayChars[nC] = cWordChars[nLetterCounter];
                nLetterCounter++;
            }//end else
        }//end for

        view.setCurrentWord(new String(cDisplayChars));

    }//updateCurrentWord


    /**
     * call the setter method
     *
     * @param strMessage - the string to display to the user
     * @param view       - the view
     */
    private static void updateResultDisplay(String strMessage, HangmanView view) {
        view.setStatusUpdate(strMessage);
    }


    /**
     * get the number of guesses from the model and update the view
     *
     * @param model - hangman game model
     * @param view  - hangman game view
     */
    private static void updateNumGuesses(HangmanModel model, HangmanView view) {

        String strNumAsString = "";

        strNumAsString += model.getNumGuessesLeft();
        strNumAsString += " guesses left";

        view.setNumGuesses(strNumAsString);

    }//end updateNumGuesses


    /**
     * switch on the number of guesses left to determine the image icon
     *
     * @param model - hangman model
     * @param view  - hangman view
     */
    private static void updateHangmanImage(HangmanModel model, HangmanView view) {

        if (model.getNumGuessesLeft() > 7) {

            view.setImageIcon("/hw3/hang7.gif");

        } else {

            switch (model.getNumGuessesLeft()) {

                case 7:
                    view.setImageIcon("/data/Images/hang7.gif");
                    break;
                case 6:
                    view.setImageIcon("/data/Images/hang6.gif");
                    break;
                case 5:
                    view.setImageIcon("/data/Images/hang5.gif");
                    break;
                case 4:
                    view.setImageIcon("/data/Images/hang4.gif");
                    break;
                case 3:
                    view.setImageIcon("/data/Images/hang3.gif");
                    break;
                case 2:
                    view.setImageIcon("/data/Images/hang2.gif");
                    break;
                case 1:
                    view.setImageIcon("/data/Images/hang1.gif");
                    break;
                case 0:
                    view.setImageIcon("/data/Images/hang0.gif");
                    break;
                default:
                    break;

            }//end switch
        }//end else

    }//end updateHangmanImg


    //===============================================================================================
    //											HANGMAN METHODS
    //===============================================================================================

    /**
     * given a letter, make a guess
     * pass the guess to the model
     * update the view based on results from the model
     *
     * @param cLetter
     */
    public void makeGuess(char cLetter) {

        //if the game is not a win or loss
        if (!((HangmanModel) this.model).isWin() && !((HangmanModel) this.model).isLoss()) {
            String strResult = ((HangmanModel) this.model).makeGuess(cLetter);

            updateResultDisplay(strResult, ((HangmanView) this.view));
            updateCurrentWord(((HangmanModel) this.model), ((HangmanView) this.view));
            updateNumGuesses(((HangmanModel) this.model), ((HangmanView) this.view));
            updateHangmanImage(((HangmanModel) this.model), ((HangmanView) this.view));
        }//end if


        //alert if game is win
        if (((HangmanModel) this.model).isWin()) {
            this.setChanged();
            this.sendStats();
            if (((HangmanModel) this.model).getCurrentPlayer().getName().equals(((HangmanModel) this.model).getPlayers()[0].getName())) {
                this.notifyObservers(ActionEnum.FIRST_PLAYER_WON);
                System.out.println("First Player Won");
                return;
            } else {
                this.notifyObservers(ActionEnum.SECOND_PLAYER_WON);
                System.out.println("Second Player Won");
                return;
            }
        }//end if

        else if (((HangmanModel) this.model).isLoss()) {
            this.setChanged();
            this.sendStats();
            if (((HangmanModel) this.model).getCurrentPlayer().getName().equals(((HangmanModel) this.model).getPlayers()[0].getName())) {
                this.notifyObservers(ActionEnum.SECOND_PLAYER_WON);
                System.out.println("Second Player Won");
                return;
            } else {
                this.notifyObservers(ActionEnum.FIRST_PLAYER_WON);
                System.out.println("First Player Won");
                return;
            }
        }


        //repaint
        ((HangmanModel) this.model).changePlayer();
        ((HangmanView) this.view).updateCurrentPlayer(((HangmanModel) this.model).getCurrentPlayer());
        this.view.repaint();


    }//end makeGuess

    @Override
    public void update(Observable o, Object arg) {
        this.makeGuess((Character) arg);
    }

    private void sendStats() {
        if (!this.isTraining) {
            ((HangmanModel) this.model).sendStats();
        }
    }
}//end HangmanController
