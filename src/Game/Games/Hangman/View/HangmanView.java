package Game.Games.Hangman.View;

import Game.Games.DisplayPanel;
import Player.Player;
import Utils.UI.CustomLabel;
import Utils.UI.CustomPanel.CustomGameBackgroundPanel;
import Utils.UI.FileGetter;
import Utils.UI.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * GUI for a Hangman Game
 *
 * @author josephmalandruccolo
 */
public class HangmanView extends CustomGameBackgroundPanel {


    //===============================================================================================
    //											PROPERTIES
    //===============================================================================================

    public static final int JFRAME_WIDTH = 800;
    public static final int JFRAME_HEIGHT = 500;
    private static CustomLabel lblToHoldCurrent;    //placeholder of the current word
    private static JLabel lblNumguesses;    //number of guesses remaining
    private static JLabel lblStatusUpdate;    //last status
    private static JLabel lblImage;            //image icon
    private DisplayPanel firstPlayerDisplay;
    private DisplayPanel secondPlayerDisplay;
    private DisplayPanel currentPlayerPanel;
    private DisplayPanel otherPlayerPanel;
    private Map<Character, HangmanBox> map;


    //===============================================================================================
    //											CONSTRUCTOR
    //===============================================================================================

    /**
     * default constructor
     */
    public HangmanView(Player[] players, int[] scores) {
        super(players, scores);
        initialize(players);
    }

    public void updateCurrentPlayer(Player currentPlayer) {
        if (!currentPlayer.getName().equals(this.currentPlayerPanel.getPlayer().getName())) {
            this.changePlayer();
        }
        this.revalidate();
        this.repaint();
    }

    public void changePlayer() {
        DisplayPanel tmp = this.currentPlayerPanel;
        this.currentPlayerPanel = this.otherPlayerPanel;
        this.otherPlayerPanel = tmp;
        this.currentPlayerPanel.setFocus(true);
        this.otherPlayerPanel.setFocus(false);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize(Player[] players) {

        //===============================================================================================
        //											NORTH JPANEL - HOLDS CURRENT WORD
        //===============================================================================================
        this.map = new HashMap<Character, HangmanBox>();
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraint = new GridBagConstraints();
        this.firstPlayerDisplay = new DisplayPanel(players[0], true);
        this.currentPlayerPanel = this.firstPlayerDisplay;
        this.secondPlayerDisplay = new DisplayPanel(players[1], false);
        this.otherPlayerPanel = this.secondPlayerDisplay;
        constraint.gridy = 0;
        constraint.gridx = 0;
        constraint.gridwidth = 4;
        constraint.gridheight = 1;


        lblToHoldCurrent = new CustomLabel("To hold current word");
        lblToHoldCurrent.setFont(FileGetter.getFont().deriveFont(Utils.DEFAULT_GOAL_SIZE_LABEL));
        this.add(lblToHoldCurrent, constraint);

        constraint.gridy = 2;
        constraint.gridwidth = 2;
        this.add(this.firstPlayerDisplay, constraint);


        //===============================================================================================
        //											CENTER JPANEL - HOLDS HANGMAN IMAGE
        //===============================================================================================

//		this.setLayout(new GridLayout(0, 1, 0, 0));

        lblImage = new JLabel();
        lblImage.setHorizontalAlignment(SwingConstants.CENTER);
        lblImage.setIcon(new ImageIcon(HangmanView.class.getResource("/data/Images/hang7.gif")));
        constraint.gridwidth = 4;
        constraint.anchor = GridBagConstraints.CENTER;
        this.add(lblImage, constraint);

        constraint.gridx = 3;
        constraint.gridwidth = 1;
        constraint.anchor = GridBagConstraints.LINE_END;
        this.add(this.secondPlayerDisplay, constraint);


        //===============================================================================================
        //											SOUTH JPANEL - HOLDS USER INPUTS
        //===============================================================================================

        JPanel panInputs = new JPanel();
        panInputs.setOpaque(false);
        constraint.gridy = 3;
        constraint.gridx = 0;
        constraint.gridwidth = 4;
        this.add(panInputs, constraint);
        Dimension panInputsDimension = new Dimension(HangmanView.JFRAME_WIDTH, HangmanView.JFRAME_HEIGHT / 3);
        panInputs.setPreferredSize(panInputsDimension);
        Dimension btnDimension = new Dimension(HangmanView.JFRAME_WIDTH / 11, HangmanView.JFRAME_HEIGHT / 11);
        panInputs.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        HangmanBox btnA = new HangmanBox("A", btnDimension);
        btnA.addActionListener(new HangmanBtnListener());
        this.map.put("A".charAt(0),btnA);
        panInputs.add(btnA);

        HangmanBox btnB = new HangmanBox("B", btnDimension);
        btnB.addActionListener(new HangmanBtnListener());
        this.map.put("B".charAt(0),btnB);
        panInputs.add(btnB);

        HangmanBox btnC = new HangmanBox("C", btnDimension);
        btnC.addActionListener(new HangmanBtnListener());
        this.map.put("C".charAt(0),btnC);
        panInputs.add(btnC);

        HangmanBox btnD = new HangmanBox("D", btnDimension);
        btnD.addActionListener(new HangmanBtnListener());
        this.map.put("D".charAt(0),btnD);
        panInputs.add(btnD);

        HangmanBox btnE = new HangmanBox("E", btnDimension);
        btnE.addActionListener(new HangmanBtnListener());
        this.map.put("E".charAt(0),btnE);
        panInputs.add(btnE);

        HangmanBox btnF = new HangmanBox("F", btnDimension);
        btnF.addActionListener(new HangmanBtnListener());
        this.map.put("F".charAt(0),btnF);
        panInputs.add(btnF);

        HangmanBox btnG = new HangmanBox("G", btnDimension);
        btnG.addActionListener(new HangmanBtnListener());
        this.map.put("G".charAt(0),btnG);
        panInputs.add(btnG);

        HangmanBox btnH = new HangmanBox("H", btnDimension);
        btnH.addActionListener(new HangmanBtnListener());
        this.map.put("H".charAt(0),btnH);
        panInputs.add(btnH);

        HangmanBox btnI = new HangmanBox("I", btnDimension);
        btnI.addActionListener(new HangmanBtnListener());
        this.map.put("I".charAt(0),btnI);
        panInputs.add(btnI);

        HangmanBox btnJ = new HangmanBox("J", btnDimension);
        btnJ.addActionListener(new HangmanBtnListener());
        this.map.put("J".charAt(0),btnJ);
        panInputs.add(btnJ);

        HangmanBox btnK = new HangmanBox("K", btnDimension);
        btnK.addActionListener(new HangmanBtnListener());
        this.map.put("K".charAt(0),btnK);
        panInputs.add(btnK);

        HangmanBox btnL = new HangmanBox("L", btnDimension);
        btnL.addActionListener(new HangmanBtnListener());
        this.map.put("L".charAt(0),btnL);
        panInputs.add(btnL);

        HangmanBox btnM = new HangmanBox("M", btnDimension);
        btnM.addActionListener(new HangmanBtnListener());
        this.map.put("M".charAt(0),btnM);
        panInputs.add(btnM);

        HangmanBox btnN = new HangmanBox("N", btnDimension);
        btnN.addActionListener(new HangmanBtnListener());
        this.map.put("N".charAt(0),btnN);
        panInputs.add(btnN);

        HangmanBox btnO = new HangmanBox("O", btnDimension);
        btnO.addActionListener(new HangmanBtnListener());
        this.map.put("O".charAt(0),btnO);
        panInputs.add(btnO);

        HangmanBox btnP = new HangmanBox("P", btnDimension);
        btnP.addActionListener(new HangmanBtnListener());
        this.map.put("P".charAt(0),btnP);
        panInputs.add(btnP);

        HangmanBox btnQ = new HangmanBox("Q", btnDimension);
        btnQ.addActionListener(new HangmanBtnListener());
        this.map.put("Q".charAt(0),btnQ);
        panInputs.add(btnQ);

        HangmanBox btnR = new HangmanBox("R", btnDimension);
        btnR.addActionListener(new HangmanBtnListener());
        this.map.put("R".charAt(0),btnR);
        panInputs.add(btnR);

        HangmanBox btnS = new HangmanBox("S", btnDimension);
        btnS.addActionListener(new HangmanBtnListener());
        this.map.put("S".charAt(0),btnS);
        panInputs.add(btnS);

        HangmanBox btnT = new HangmanBox("T", btnDimension);
        btnT.addActionListener(new HangmanBtnListener());
        this.map.put("T".charAt(0),btnT);
        panInputs.add(btnT);

        HangmanBox btnU = new HangmanBox("U", btnDimension);
        btnU.addActionListener(new HangmanBtnListener());
        this.map.put("U".charAt(0),btnU);
        panInputs.add(btnU);

        HangmanBox btnV = new HangmanBox("V", btnDimension);
        btnV.addActionListener(new HangmanBtnListener());
        this.map.put("V".charAt(0),btnV);
        panInputs.add(btnV);

        HangmanBox btnW = new HangmanBox("W", btnDimension);
        btnW.addActionListener(new HangmanBtnListener());
        this.map.put("W".charAt(0),btnW);
        panInputs.add(btnW);

        HangmanBox btnX = new HangmanBox("X", btnDimension);
        btnX.addActionListener(new HangmanBtnListener());
        this.map.put("X".charAt(0),btnX);
        panInputs.add(btnX);

        HangmanBox btnY = new HangmanBox("Y", btnDimension);
        btnY.addActionListener(new HangmanBtnListener());
        this.map.put("Y".charAt(0),btnY);
        panInputs.add(btnY);

        HangmanBox btnZ = new HangmanBox("Z", btnDimension);
        btnZ.addActionListener(new HangmanBtnListener());
        this.map.put("Z".charAt(0),btnZ);
        panInputs.add(btnZ);

        JPanel panStatus = new JPanel();
        panStatus.setOpaque(false);
        constraint.gridy = 4;
        constraint.gridx = 0;
        constraint.gridwidth = 4;
        this.add(panStatus, constraint);
        panStatus.setLayout(new GridLayout(0, 1, 0, 0));

        lblNumguesses = new CustomLabel("numGuesses");
        panStatus.add(lblNumguesses);

        lblStatusUpdate = new CustomLabel("status update");
        panStatus.add(lblStatusUpdate);


    }//end initialize


    //===============================================================================================
    //											GETTERS AND SETTERS
    //===============================================================================================


    /**
     * updates the current word at the top of the GUI
     *
     * @param word
     */
    public void setCurrentWord(String word) {
        lblToHoldCurrent.setText(word);
    }

    /**
     * update the number of guesses on the right side of the GUI
     *
     * @param str
     */
    public void setNumGuesses(String str) {
        lblNumguesses.setText(str);
    }

    /**
     * updates the message on the right side of the GUI
     *
     * @param str - message
     */
    public void setStatusUpdate(String str) {
        lblStatusUpdate.setText(str);
    }

    public void setDisabled(Character c){
        map.get(c).setDisabled();
    }

    /**
     * updates the icon image in the CENTER panel
     *
     * @param strFileName - relative path to the new file
     */
    public void setImageIcon(String strFileName) {
        lblImage.setIcon(new ImageIcon(HangmanView.class.getResource(strFileName)));
        this.repaint();
    }//end setImageIcon

    /**
     * class that listens for one the A-Z buttons to be pressed in the HangmanView
     * changes the background color of the button to black
     * passes the value pressed to the makeGuess method of the controller
     *
     * @author josephmalandruccolo
     */
    public class HangmanBtnListener implements ActionListener {


        @Override
        /**
         *
         */
        public void actionPerformed(ActionEvent e) {
            HangmanBox btnPressed = (HangmanBox) e.getSource();
            String strBtnLbl = btnPressed.getText();

            HangmanView.this.observable.notifyObservers(strBtnLbl.charAt(0));

        }//end actionPerformed
    }//end HangmanBtnListnener

}//end HangmanView
