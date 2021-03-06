/***
* MainFrame - GUI for Main Frame - Mooldi application
* @authors: Carina Ekström, Ivana Zdjuic
* @version: 1.0
**/
package se.examination.gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import se.examination.otherclasses.DivGame;
import se.examination.otherclasses.FileHandler;
import se.examination.otherclasses.MultiGame;
import se.examination.otherclasses.Player;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainFrame implements ActionListener{

	//MainFrame and StartPage
	private JFrame frmMooldi;
	private JPanel startPage = new JPanel();
	private JTextField textFieldName;
	private JButton btnMulti;
	private JButton btnDivision;
	
	//Common
	private FileHandler fileHandler = new FileHandler();
	private Player player = new Player();
	private char gameType;					//'m' = multiplikation, 'd' = division

	//MultiPage
	private JPanel multiPage = new JPanel();	
	private MultiGame game = new MultiGame();
	private Timer timer = new Timer(10000,null);
	private JProgressBar progressBar;
	private JLabel lblHejNamn;
	private JLabel lblXTalet;
	private JLabel lblCompleted;
	private JLabel lblResultError;
	private JLabel lblProgressMess;
	private JTextField textFieldSvar;
	private JButton btnSluta;
	private JButton btnOKnext;
	private final int MAX_MULTI = 679; 
	
	//DivPage
	private JPanel divPage = new JPanel();
	private DivGame gameDivision= new DivGame();
	private Timer timerDiv = new Timer(15000,null);
	private JProgressBar progressBarDivision;
	private JLabel lblHejNamnDivision;
	private JLabel lblXTaletDivision;
	private JLabel lblCompletedDivision;
	private JLabel lblResultErrorDivision;
	private JLabel lblProgressMessDiv;
	private JTextField textFieldSvarDivision;
	private JButton btnSlutaDivision;
	private JButton btnOKnextDivision;
	private final int MAX_DIV = 583; 

	//Congratulation page
	private JPanel congratsPage = new JPanel();
	private JLabel lblGrattis = new JLabel("");
	private JLabel lblDuHarKlarat = new JLabel("");
	private JButton btnClose = new JButton("St\u00E4ng");
	private Timer timerCongrats = new Timer(250,null);
	private JButton btnNewMulti = new JButton("Multiplikation");
	private JButton btnNewDiv = new JButton("Division");
	private JLabel lblVillDuSpela = new JLabel("Vill du spela igen?");


	/**
	 * Constructor - create the application.
	 */
	public MainFrame() {
		createGUI();
		addActionListeners();
	}

	/**
	 * Get Mooldi frame
	 * @return frmMooldi Main frame for Mooldi application
	 */
	public JFrame getFrmMooldi(){
		return frmMooldi;
	}
	

	/**
	 * Initialize the contents of the main frame.
	 */
	private void createGUI() {
		//Create MainFrame
		frmMooldi = new JFrame();
		frmMooldi.setTitle("MOOLDI");
		frmMooldi.setBounds(100, 100, 750, 600);
		frmMooldi.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmMooldi.addWindowListener(new WindowAdapter() {		//TODO: Kolla om det g�r att flytta ner till �vriga ActionListeners
		   public void windowClosing(WindowEvent evt) {
		     onExit();
		   }
		});
		frmMooldi.getContentPane().setLayout(new CardLayout(0, 0));
		
		//Create pages
		startPage.setBackground(new Color(0, 255, 255));
		frmMooldi.getContentPane().add(startPage, "name_23428416361482");
		startPage.setLayout(null);
		
		multiPage.setBackground(Color.GREEN);
		frmMooldi.getContentPane().add(multiPage, "name_23490729527832");
		multiPage.setLayout(null);
		
		divPage.setBackground(Color.PINK);
		frmMooldi.getContentPane().add(divPage, "name_271421026775");
		divPage.setLayout(null);
		
		congratsPage.setBackground(Color.YELLOW);
		frmMooldi.getContentPane().add(congratsPage, "name_2783046100684");
		congratsPage.setLayout(null);
		
		//Add components to pages
		createStartPageGUI();
		createMultiPageGUI();
		createDivPageGUI();
		createCongratsPageGUI();
				
	}

	/**
	 * Initialize the contents of start page.
	 */
	public void createStartPageGUI(){
		//Buttons
		btnMulti = new JButton("Multiplikation");
		btnMulti.setBounds(192, 397, 143, 25);
		btnMulti.setEnabled(false);
		startPage.add(btnMulti);
		
		btnDivision = new JButton("Division");
		btnDivision.setBounds(404, 397, 143, 25);
		btnDivision.setEnabled(false);
		startPage.add(btnDivision);

		//Labels and text fields
		JLabel lblVlkommenTill = new JLabel("V\u00E4lkommen till");
		lblVlkommenTill.setBounds(325, 91, 103, 15);
		startPage.add(lblVlkommenTill);
		
		JLabel lblMooldi = new JLabel("MOOLDI");
		lblMooldi.setFont(new Font("Century Schoolbook L", Font.BOLD, 60));
		lblMooldi.setBounds(239, 105, 355, 62);
		startPage.add(lblMooldi);
		
		JLabel lblSkrivDittNamn = new JLabel("Skriv ditt namn:");
		lblSkrivDittNamn.setBounds(247, 243, 128, 15);
		startPage.add(lblSkrivDittNamn);
		
		textFieldName = new JTextField();
		textFieldName.addKeyListener(new KeyAdapter() {   //TODO: Kolla om det g�r att flytta ner till �vriga ActionListeners
			@Override
			public void keyTyped(KeyEvent arg0) {
				btnMulti.setEnabled(true);
				btnDivision.setEnabled(true);
			}
		});
		textFieldName.setBounds(379, 241, 114, 19);
		startPage.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblVljVadDu = new JLabel("V\u00E4lj vad du vill tr\u00E4na p\u00E5:");
		lblVljVadDu.setBounds(287, 363, 209, 15);
		startPage.add(lblVljVadDu);

	}

	/**
	 * Initialize the contents of multiplication page.
	 */
	public void createMultiPageGUI(){
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1, 1);
		multiPage.add(layeredPane);

		//Labels and text fields
		lblHejNamn = new JLabel();
		lblHejNamn.setForeground(Color.DARK_GRAY);
		lblHejNamn.setFont(new Font("Dialog", Font.PLAIN, 55));
		lblHejNamn.setBounds(41, 43, 633, 79);
		multiPage.add(lblHejNamn);
		
		lblCompleted = new JLabel("");
		lblCompleted.setBounds(70, 410, 500, 15);
		multiPage.add(lblCompleted);

		lblXTalet = new JLabel();
		lblXTalet.setHorizontalAlignment(SwingConstants.CENTER);
		lblXTalet.setFont(new Font("Dialog", Font.BOLD, 32));
		lblXTalet.setBounds(270, 168, 200, 79);
		multiPage.add(lblXTalet);
		
		textFieldSvar = new JTextField();
		textFieldSvar.setBounds(301, 256, 138, 36);
		textFieldSvar.setColumns(10);
		textFieldSvar.requestFocusInWindow();
		multiPage.add(textFieldSvar);
				
		lblResultError = new JLabel("Tyv\u00E4rr var det fel svar - f\u00F6rs\u00F6k igen!");
		lblResultError.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		lblResultError.setForeground(Color.RED);
		lblResultError.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultError.setBounds(122, 295, 509, 34);
		multiPage.add(lblResultError);

		lblProgressMess = new JLabel("");
		lblProgressMess.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProgressMess.setForeground(Color.DARK_GRAY);
		lblProgressMess.setHorizontalAlignment(SwingConstants.CENTER);
		lblProgressMess.setBounds(29, 342, 673, 35);
		multiPage.add(lblProgressMess);

		lblProgressMessDiv = new JLabel("");
		lblProgressMessDiv.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProgressMessDiv.setForeground(Color.DARK_GRAY);
		lblProgressMessDiv.setHorizontalAlignment(SwingConstants.CENTER);
		lblProgressMessDiv.setBounds(29, 342, 673, 35);
		divPage.add(lblProgressMessDiv);

		//Buttons
		btnSluta = new JButton("Sluta spela och spara po\u00E4ngen");
		btnSluta.setBounds(419, 440, 255, 25);
		multiPage.add(btnSluta);
		
		btnOKnext = new JButton("OK");
		btnOKnext.setBounds(468, 261, 117, 25);
		multiPage.add(btnOKnext);
		
		//Progressbar
		progressBar = new JProgressBar();
		progressBar.setMaximum(MAX_MULTI);				
		progressBar.setBounds(70, 437, 200, 14);
		multiPage.add(progressBar);	
		
	}
	
	/**
	 * Initialize the contents of division page.
	 */
	public void createDivPageGUI(){
		JLayeredPane layeredPaneDivision = new JLayeredPane();
		layeredPaneDivision.setBounds(0, 0, 1, 1);
		divPage.add(layeredPaneDivision);
		
		//Labels and text fields
		lblHejNamnDivision = new JLabel();
		lblHejNamnDivision.setForeground(Color.DARK_GRAY);
		lblHejNamnDivision.setFont(new Font("Dialog", Font.PLAIN, 55));
		lblHejNamnDivision.setBounds(41, 43, 633, 79);
		divPage.add(lblHejNamnDivision);
		
		lblCompletedDivision = new JLabel("");
		lblCompletedDivision.setBounds(70, 410, 500, 15);
		divPage.add(lblCompletedDivision);

		lblXTaletDivision = new JLabel();
		lblXTaletDivision.setHorizontalAlignment(SwingConstants.CENTER);
		lblXTaletDivision.setFont(new Font("Dialog", Font.BOLD, 32));
		lblXTaletDivision.setBounds(270, 168, 200, 79);
		divPage.add(lblXTaletDivision);
		
		textFieldSvarDivision = new JTextField();
		textFieldSvarDivision.setBounds(301, 256, 138, 36);
		textFieldSvarDivision.setColumns(10);
		textFieldSvarDivision.requestFocusInWindow();
		divPage.add(textFieldSvarDivision);
				
		lblResultErrorDivision = new JLabel("Tyv\u00E4rr var det fel svar - f\u00F6rs\u00F6k igen!");
		lblResultErrorDivision.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		lblResultErrorDivision.setForeground(Color.RED);
		lblResultErrorDivision.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultErrorDivision.setBounds(122, 295, 509, 34);
		divPage.add(lblResultErrorDivision);
		
		//Buttons
		btnSlutaDivision = new JButton("Sluta spela och spara po\u00E4ngen");
		btnSlutaDivision.setBounds(419, 440, 255, 25);
		divPage.add(btnSlutaDivision);
		
		btnOKnextDivision = new JButton("OK");
		btnOKnextDivision.setBounds(468, 261, 117, 25);
		divPage.add(btnOKnextDivision);
		
		//Progressbar
		progressBarDivision = new JProgressBar();
		progressBarDivision.setMaximum(MAX_DIV);
		progressBarDivision.setBounds(70, 437, 200, 14);
		divPage.add(progressBarDivision);
		
	}
	
	/**
	 * Initialize the contents of congratulation page.
	 */
	public void createCongratsPageGUI(){
		lblGrattis.setForeground(Color.BLUE);
		lblGrattis.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrattis.setFont(new Font("Century Schoolbook L", Font.BOLD, 48));
		lblGrattis.setBounds(71, 124, 614, 127);
		congratsPage.add(lblGrattis);
		
		lblDuHarKlarat.setForeground(Color.BLUE);
		lblDuHarKlarat.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuHarKlarat.setFont(new Font("Century Schoolbook L", Font.BOLD, 24));
		lblDuHarKlarat.setBounds(71, 236, 626, 100);
		congratsPage.add(lblDuHarKlarat);
		
		lblVillDuSpela.setHorizontalAlignment(SwingConstants.CENTER);
		lblVillDuSpela.setBounds(298, 402, 167, 16);
		congratsPage.add(lblVillDuSpela);
		
		btnClose.setForeground(Color.BLACK);
		btnClose.setBackground(Color.WHITE);
		btnClose.setBounds(478, 447, 120, 25);
		congratsPage.add(btnClose);
		
		btnNewMulti.setForeground(Color.BLACK);
		btnNewMulti.setBackground(Color.WHITE);
		btnNewMulti.setBounds(172, 447, 120, 25);
		congratsPage.add(btnNewMulti);
		
		btnNewDiv.setForeground(Color.BLACK);
		btnNewDiv.setBackground(Color.WHITE);
		btnNewDiv.setBounds(324, 447, 120, 25);
		congratsPage.add(btnNewDiv);
	}

	/**
	 * Initiate game when user selects to play Multiplication. 
	 * Open saved file if the user has played before, otherwise create a new game structure. 
	 * Show multiplication page with data from the saved file (if it exists).
	 */
	public void onClickMulti(){
		if (player.getName() == "")
			player.setName(textFieldName.getText());
		
		if (!fileHandler.startMultiGame(player, game)) 			//if this user not already has an ongoing game			
			game.newMultArray();
		
		lblHejNamn.setText("Hej " + player.getName() + "!");
		lblCompleted.setText("Du har klarat av totalt " + player.getPoints() + " av " + MAX_MULTI + " tal.");
	
		startPage.setVisible(false);
		multiPage.setVisible(true);

		runGame();
	}
	
	/**
	 * Initiate game when user selects to play Division. 
	 * Open saved file if the user has played before, otherwise create a new game structure. 
	 * Show division page with data from the saved file (if it exists).
	 */
	public void onClickDivision(){
		if (player.getName() == "")
			player.setName(textFieldName.getText());
		
		if (!fileHandler.startDivGame(player, gameDivision)) 	//if this user not already has an ongoing game			
			gameDivision.newDivArray();
		
		lblHejNamnDivision.setText("Hej " + player.getName() + "!");
		lblCompletedDivision.setText("Du har klarat av totalt " + player.getPoints() + " av " + MAX_DIV + " tal.");
		
		startPage.setVisible(false);
		divPage.setVisible(true);
		
		runGame();
	}


	/**
	 * Initiate a new game round by cleaning up the page, get a new random number to calculate and start the timer. 
	 */
	public void runGame(){
		if (gameType == 'm'){
			if ((player.getPoints() < MAX_MULTI) && (player.getCompleted() < 169)){
				lblResultError.setVisible(false);
				progressBar.setValue(player.getPoints());
				
				if (player.getPoints() > 0) {
					if (player.getPoints() % 100 == 0)
						lblProgressMess.setText("Snyggt! 100 nya po\u00E4ng avklarade!");				
					else if (player.getPoints() == Math.ceil(MAX_MULTI/2))
						lblProgressMess.setText("H\u00E4rligt, nu �r du halvv\u00E4gs!");
					else 
						lblProgressMess.setText("");
				}
				
				textFieldSvar.setText("");
				lblXTalet.setText(game.runGame());
				if (!timer.isRunning())
					timer.start();
				else
					timer.restart(); 
			}
			else {
				lblGrattis.setText("Grattis " + player.getName() + "!");
				lblDuHarKlarat.setText("Du har klarat hela multiplikationstabellen!");
				multiPage.setVisible(false);
				congratsPage.setVisible(true);
				timerCongrats.start();
			}
		}
		else if (gameType == 'd'){
			if ((player.getPoints() < MAX_DIV) && (player.getCompleted() < 169)){
				lblResultErrorDivision.setVisible(false);
				progressBarDivision.setValue(player.getPoints());
				
				if (player.getPoints() > 0) {
					if (player.getPoints() % 100 == 0)
						lblProgressMessDiv.setText("Snyggt! 100 nya po\u00E4ng avklarade!");				
					else if (player.getPoints() == Math.ceil(MAX_DIV/2))
						lblProgressMessDiv.setText("H\u00E4rligt, nu �r du halvv\u00E4gs!");
					else 
						lblProgressMessDiv.setText("");
				}
				
				textFieldSvarDivision.setText("");
				lblXTaletDivision.setText(gameDivision.runGame());
				if (!timerDiv.isRunning())
					timerDiv.start();
				else
					timerDiv.restart(); 
			}
			else {
				lblGrattis.setText("Grattis " + player.getName() + "!");
				lblDuHarKlarat.setText("Du har klarat hela divisionstabellen!");
				divPage.setVisible(false);
				congratsPage.setVisible(true);
				timerCongrats.start();
			}
		}
	}
		
	/**
	 * Check if answer is correct when user enters an answer and either press Enter or OK-button. 
	 * If correct: update progressbar and run a new game round.
	 * If wrong: show error message.
	 */
	public void onAnswering(){
		try{
			if (gameType == 'm'){
				if (game.checkAnswer(Integer.parseInt(textFieldSvar.getText())) == true){
					player.increasePoints();
					if (game.isCleared()){
						player.increaseCompleted();
					}	
					lblCompleted.setText("Du har klarat av totalt " + player.getPoints() + " av " + MAX_MULTI + " tal.");
					progressBar.setValue(player.getPoints());
					runGame();
				} else {
					textFieldSvar.setText("");
					lblResultError.setVisible(true);
				}
			}
			else if (gameType == 'd'){
				if (gameDivision.checkAnswer(Integer.parseInt(textFieldSvarDivision.getText())) == true){
					player.increasePoints();
					if (gameDivision.isCleared()){
						player.increaseCompleted();
					}
					lblCompletedDivision.setText("Du har klarat av totalt " + player.getPoints() + " av " + MAX_DIV + " tal.");
					progressBarDivision.setValue(player.getPoints());
					
					runGame();
				} else {
					textFieldSvarDivision.setText("");
					lblResultErrorDivision.setVisible(true);
				}				
			}
		} catch (NumberFormatException e){
			e.getMessage();
		}
	}
	

	/**
	 * Save game - when user press Save-button
	 */
	public void saveGame(){
		if (gameType == 'm'){
			fileHandler.saveMultiGameToFile(player, game);	
			JOptionPane.showMessageDialog(frmMooldi, "Dina po\u00E4ng har sparats", "Spara", JOptionPane.INFORMATION_MESSAGE);
		}
		else if (gameType == 'd'){
			fileHandler.saveDivGameToFile(player, gameDivision);
			JOptionPane.showMessageDialog(frmMooldi, "Dina po\u00E4ng har sparats", "Spara", JOptionPane.INFORMATION_MESSAGE);
		}
		frmMooldi.dispose();
	}
	
	/**
	 * onExit - Check if user wants to save the result when pressing X-button
	 */
	public void onExit() {
		int answer = JOptionPane.showConfirmDialog(frmMooldi, "Vill du spara innan du avslutar Mooldi?", "Spara", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		if (answer == JOptionPane.YES_OPTION)
			saveGame();
		else
			frmMooldi.dispose();
	}
			
	/**
	 * Action listeners
	 */	
	public void addActionListeners() {
		//StartPage
		btnMulti.addActionListener(this);	
		btnDivision.addActionListener(this);
		
		//MultiPage
		textFieldSvar.addActionListener(this);
		btnSluta.addActionListener(this);
		btnOKnext.addActionListener(this);
		timer.addActionListener(this);
		
		//DivPage
		textFieldSvarDivision.addActionListener(this);
		btnSlutaDivision.addActionListener(this);
		btnOKnextDivision.addActionListener(this);
		timerDiv.addActionListener(this);
		
		//CongratsPage
		btnClose.addActionListener(this);
		btnNewDiv.addActionListener(this);
		btnNewMulti.addActionListener(this);
		timerCongrats.addActionListener(this);
		
	}

	/**
	 * Action handlers
	 */	
	@Override
	public void actionPerformed(ActionEvent e) {
		//StartPage
		if (e.getSource() == btnMulti) {
			gameType = 'm';
			onClickMulti();			
		}
		if (e.getSource() == btnDivision) {
			gameType = 'd';
			onClickDivision();			
		}
		
		//CongratsPage
		if (e.getSource() == btnNewMulti) {
			gameType = 'm';
			fileHandler.deleteGameFile(player, gameType);
			player.setCompleted(0);
			player.setPoints(0);
			congratsPage.setVisible(false);
			onClickMulti();			
		}
		if (e.getSource() == btnNewDiv) {
			gameType = 'd';
			fileHandler.deleteGameFile(player, gameType);
			player.setCompleted(0);
			player.setPoints(0);
			congratsPage.setVisible(false);
			onClickDivision();						
		}
		
		//MultiPage
		if ((e.getSource() == textFieldSvar)||(e.getSource() == btnOKnext)) {
			onAnswering();			
		}
		if (e.getSource() == btnSluta)  {
			saveGame();			
		}
		if (e.getSource() == timer){
			runGame();
		}

		//DivPage
		if ((e.getSource() == textFieldSvarDivision)||(e.getSource() == btnOKnextDivision)) {
			onAnswering();			
		}
		if (e.getSource() == btnSlutaDivision) {
			saveGame();
		}
		if (e.getSource() == timerDiv){
			runGame();
		}
		
		//CongratsPage
		if (e.getSource() == btnClose)  {
			saveGame();			
		}
		if (e.getSource() == timerCongrats){
			Random r = new Random();
			lblGrattis.setForeground(new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256),r.nextInt(256)));
		}
		
	}
}
