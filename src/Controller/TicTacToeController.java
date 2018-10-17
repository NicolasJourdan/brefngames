package Controller;

import Model.*;
import View.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;


public class TicTacToeController extends Controller {

    public TicTacToeController(TicTacToeModel model, TicTacToeView view) {
        super(model, view);
        addActionListeners();
    }
    private void addActionListeners(){
        for (JButton knob : view.knobs) {
            knob.addActionListener(this);
            view.newGame.addActionListener(this);
        }
    }
    private boolean addChoice(Integer field, Value value) {
        model.setChoice(field, value);
        if(model.movesCounter >= 5) {
            if(model.checkBoard()) {
                view.winGame();
                view.endGame();
                return true;
            }
            if(model.movesCounter == 9) {
                view.endGame();
                view.setNoWinner();
            }
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Value currentPlayer = view.getCurrentPlayerValue();

        if (Arrays.asList(view.knobs).contains(e.getSource()) && currentPlayer != null) {
            Integer knobIndex = Arrays.asList(view.knobs).indexOf((JButton)e.getSource());
            ((JButton) e.getSource()).setText(view.getCurrentPlayerString());
            view.pack();
            ((JButton) e.getSource()).setEnabled(false);
            if(!addChoice(knobIndex, currentPlayer)) view.changePlayer();
        } else if(e.getSource().equals(view.newGame)) {
            this.view.dispose();
            this.view = new TicTacToeView();
            addActionListeners();
            this.model = new TicTacToeModel();
        }
    }
}

