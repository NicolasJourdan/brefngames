package Game.Games.Hangman.View;

import Game.Games.DisplayPanel;
import Game.Games.Hangman.Controller.HangmanController;
import Parameter.Model.ThemeEnum;
import Player.Player;
import Repository.Parameter.ThemeParameterRepository;
import Utils.UI.CustomLabel;
import Utils.UI.CustomPanel.CustomGameBackgroundPanel;

import java.awt.*;

import javax.swing.*;

import Game.Games.Hangman.View.HangmanBox;
import Utils.UI.FileGetter;
import Utils.UI.Utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GUI for a Hangman Game
 * @author josephmalandruccolo
 *
 */
public class HangmanView extends CustomGameBackgroundPanel {





	//===============================================================================================
	//											PROPERTIES
	//===============================================================================================

	private static CustomLabel lblToHoldCurrent;	//placeholder of the current word
	private static JLabel lblNumguesses;	//number of guesses remaining
	private static JLabel lblStatusUpdate;	//last status
	private static JLabel lblImage;			//image icon
	private DisplayPanel firstPlayerDisplay;
	private DisplayPanel secondPlayerDisplay;
	private DisplayPanel currentPlayer;
	private DisplayPanel otherPlayer;



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

	public void updateCurrentPlayer(Player currentPlayer){
		if(currentPlayer != this.currentPlayer.getPlayer()){
			changePlayer();
		}
	}

	public void changePlayer(){
		DisplayPanel tmp = this.currentPlayer;
		this.currentPlayer = this.otherPlayer;
		this.otherPlayer = tmp;
		this.currentPlayer.setFocus(true);
		this.otherPlayer.setFocus(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Player[] players) {

		//===============================================================================================
		//											NORTH JPANEL - HOLDS CURRENT WORD
		//===============================================================================================

		this.setLayout(new GridBagLayout());
		GridBagConstraints constraint = new GridBagConstraints();
		this.firstPlayerDisplay = new DisplayPanel(players[0], true);
		this.currentPlayer = this.firstPlayerDisplay;
		this.secondPlayerDisplay = new DisplayPanel(players[1], false);
		this.otherPlayer = this.secondPlayerDisplay;
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
		Dimension panInputsDimension = new Dimension(800, 500 / 3);
		panInputs.setPreferredSize(panInputsDimension);
		Dimension btnDimension = new Dimension(800 / 11, 500 / 11);
		panInputs.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		HangmanBox btnA = new HangmanBox("A");
		btnA.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnA.setPreferredSize(btnDimension);
		btnA.addActionListener(new HangmanBtnListener());
		panInputs.add(btnA);

		HangmanBox btnB = new HangmanBox("B");
		btnB.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnB.setPreferredSize(btnDimension);
		btnB.addActionListener(new HangmanBtnListener());
		panInputs.add(btnB);

		HangmanBox btnC = new HangmanBox("C");
		btnC.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnC.setPreferredSize(btnDimension);
		btnC.addActionListener(new HangmanBtnListener());
		panInputs.add(btnC);

		HangmanBox btnD = new HangmanBox("D");
		btnD.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnD.setPreferredSize(btnDimension);
		btnD.addActionListener(new HangmanBtnListener());
		panInputs.add(btnD);

		HangmanBox btnE = new HangmanBox("E");
		btnE.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnE.setPreferredSize(btnDimension);
		btnE.addActionListener(new HangmanBtnListener());
		panInputs.add(btnE);

		HangmanBox btnF = new HangmanBox("F");
		btnF.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnF.setPreferredSize(btnDimension);
		btnF.addActionListener(new HangmanBtnListener());
		panInputs.add(btnF);

		HangmanBox btnG = new HangmanBox("G");
		btnG.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnG.setPreferredSize(btnDimension);
		btnG.addActionListener(new HangmanBtnListener());
		panInputs.add(btnG);

		HangmanBox btnH = new HangmanBox("H");
		btnH.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnH.setPreferredSize(btnDimension);
		btnH.addActionListener(new HangmanBtnListener());
		panInputs.add(btnH);

		HangmanBox btnI = new HangmanBox("I");
		btnI.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnI.setPreferredSize(btnDimension);
		btnI.addActionListener(new HangmanBtnListener());
		panInputs.add(btnI);

		HangmanBox btnJ = new HangmanBox("J");
		btnJ.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnJ.setPreferredSize(btnDimension);
		btnJ.addActionListener(new HangmanBtnListener());
		panInputs.add(btnJ);

		HangmanBox btnK = new HangmanBox("K");
		btnK.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnK.setPreferredSize(btnDimension);
		btnK.addActionListener(new HangmanBtnListener());
		panInputs.add(btnK);

		HangmanBox btnL = new HangmanBox("L");
		btnL.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnL.setPreferredSize(btnDimension);
		btnL.addActionListener(new HangmanBtnListener());
		panInputs.add(btnL);

		HangmanBox btnM = new HangmanBox("M");
		btnM.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnM.setPreferredSize(btnDimension);
		btnM.addActionListener(new HangmanBtnListener());
		panInputs.add(btnM);

		HangmanBox btnN = new HangmanBox("N");
		btnN.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnN.setPreferredSize(btnDimension);
		btnN.addActionListener(new HangmanBtnListener());
		panInputs.add(btnN);

		HangmanBox btnO = new HangmanBox("O");
		btnO.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnO.setPreferredSize(btnDimension);
		btnO.addActionListener(new HangmanBtnListener());
		panInputs.add(btnO);

		HangmanBox btnP = new HangmanBox("P");
		btnP.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnP.setPreferredSize(btnDimension);
		btnP.addActionListener(new HangmanBtnListener());
		panInputs.add(btnP);

		HangmanBox btnQ = new HangmanBox("Q");
		btnQ.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnQ.setPreferredSize(btnDimension);
		btnQ.addActionListener(new HangmanBtnListener());
		panInputs.add(btnQ);

		HangmanBox btnR = new HangmanBox("R");
		btnR.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnR.setPreferredSize(btnDimension);
		btnR.addActionListener(new HangmanBtnListener());
		panInputs.add(btnR);

		HangmanBox btnS = new HangmanBox("S");
		btnS.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnS.setPreferredSize(btnDimension);
		btnS.addActionListener(new HangmanBtnListener());
		panInputs.add(btnS);

		HangmanBox btnT = new HangmanBox("T");
		btnT.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnT.setPreferredSize(btnDimension);
		btnT.addActionListener(new HangmanBtnListener());
		panInputs.add(btnT);

		HangmanBox btnU = new HangmanBox("U");
		btnU.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnU.setPreferredSize(btnDimension);
		btnU.addActionListener(new HangmanBtnListener());
		panInputs.add(btnU);

		HangmanBox btnV = new HangmanBox("V");
		btnV.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnV.setPreferredSize(btnDimension);
		btnV.addActionListener(new HangmanBtnListener());
		panInputs.add(btnV);

		HangmanBox btnW = new HangmanBox("W");
		btnW.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnW.setPreferredSize(btnDimension);
		btnW.addActionListener(new HangmanBtnListener());
		panInputs.add(btnW);

		HangmanBox btnX = new HangmanBox("X");
		btnX.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnX.setPreferredSize(btnDimension);
		btnX.addActionListener(new HangmanBtnListener());
		panInputs.add(btnX);

		HangmanBox btnY = new HangmanBox("Y");
		btnY.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnY.setPreferredSize(btnDimension);
		btnY.addActionListener(new HangmanBtnListener());
		panInputs.add(btnY);

		HangmanBox btnZ = new HangmanBox("Z");
		btnZ.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnZ.setPreferredSize(btnDimension);
		btnZ.addActionListener(new HangmanBtnListener());
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
	 * @param word
	 */
	public void setCurrentWord(String word){lblToHoldCurrent.setText(word);}

	/**
	 * update the number of guesses on the right side of the GUI
	 * @param str
	 */
	public void setNumGuesses(String str){lblNumguesses.setText(str);}

	/**
	 * updates the message on the right side of the GUI
	 * @param str - message
	 */
	public void setStatusUpdate(String str){lblStatusUpdate.setText(str);}

	/**
	 * updates the icon image in the CENTER panel
	 * @param strFileName - relative path to the new file
	 */
	public void setImageIcon(String strFileName){
		lblImage.setIcon(new ImageIcon(HangmanView.class.getResource(strFileName)));
		this.repaint();
	}//end setImageIcon

	/**
	 * class that listens for one the A-Z buttons to be pressed in the HangmanView
	 * changes the background color of the button to black
	 * passes the value pressed to the makeGuess method of the controller
	 * @author josephmalandruccolo
	 *
	 */
	public class HangmanBtnListener implements ActionListener {


		@Override
		/**
		 *
		 */
		public void actionPerformed(ActionEvent e) {
			HangmanBox btnPressed = (HangmanBox) e.getSource();
			btnPressed.setDisabled();

			String strBtnLbl = btnPressed.getText();

			HangmanView.this.observable.notifyObservers(strBtnLbl.charAt(0));

		}//end actionPerformed
	}//end HangmanBtnListnener

}//end HangmanView
