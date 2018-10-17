package Controller;

import Model.*;
import View.*;

import java.awt.event.ActionListener;

public abstract class Controller implements ActionListener {

    protected TicTacToeModel model;

    protected TicTacToeView view;

    public Controller(TicTacToeModel model, TicTacToeView view) {
        this.model = model;
        this.view = view;
    }
}
