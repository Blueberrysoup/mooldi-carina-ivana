/***
* MainFrame - GUI for Main Frame - Mooldi application
* @authors: Carina Ekström, Ivana Zdjuic
* @version: 1.0
**/
package se.examination.gui;

import java.awt.CardLayout;
import java.awt.Color;
//import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import se.examination.otherclasses.DivGame;
import se.examination.otherclasses.FileHandler;
import se.examination.otherclasses.MultiGame;
import se.examination.otherclasses.Player;

public class MainFrame implements ActionListener{

	private JFrame frmMooldi;
	private JTextField textFieldName;
	private JButton btnMulti;
	private JButton btnDivision;
	private JPanel startPage = new JPanel();
	private JPanel multiPage = new JPanel();
	private JPanel divPage = new JPanel();
	private JLabel lblHejNamn;
	private JLabel lblHejNamnDivision;
	private Player player = new Player();
	private MultiGame game = new MultiGame();
	private DivGame gameDivision= new DivGame();
	private FileHandler fileHandler = new FileHandler();
	private Timer timer = new Timer(10000,null);
	private Timer timerDiv = new Timer(15000,null);
	private JButton btnSluta;
	private JLabel lblXTalet;
	private JTextField textFieldSvar;
	private JLabel labelCurrPoints;
	private JLabel labelCompleted;
	private JButton btnOKnext;
	private JLabel labelResultError;
	private JProgressBar progressBar;
	private JButton btnSlutaDivision;
	private JLabel lblXTaletDivision;
	private JTextField textFieldSvarDivision;
	private JLabel labelCurrPointsDivision;
	private JLabel labelCompletedDivision;
	private JButton btnOKnextDivision;
	private JLabel labelResultErrorDivision;
	private JProgressBar progressBarDivision;



	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		MainFrame window = new MainFrame();
		window.frmMooldi.setVisible(true);
	}
	

	/**
	 * Create the application.
	 */
	public MainFrame() {
		System.out.println("mainFrame constructor entered");
		createGUI();
		addActionListeners();
	}

	/**
	 * Initialize the contents of the main frame.
	 */
	private void createGUI() {
		//Create MainFrame
		frmMooldi = new JFrame();
		frmMooldi.setTitle("MOOLDI");
		frmMooldi.setBounds(100, 100, 750, 600);
		frmMooldi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMooldi.getContentPane().setLayout(new CardLayout(0, 0));
		
		//Create pages
		startPage.setBackground(Color.CYAN);
		frmMooldi.getContentPane().add(startPage, "name_23428416361482");
		startPage.setLayout(null);
		
		multiPage.setBackground(Color.BLUE);
		frmMooldi.getContentPane().add(multiPage, "name_23490729527832");
		multiPage.setLayout(null);
		
		divPage.setBackground(Color.PINK);
		frmMooldi.getContentPane().add(divPage, "name_23428416361482");
		divPage.setLayout(null);
		
		//Add components to pages
		createStartPageGUI();
		createMultiPageGUI();
		createDivPageGUI();
		
	}

	/**
	 * Initialize the contents of start page
	 */
	public void createStartPageGUI(){
		//Labels - text fields
		JLabel lblVlkommenTill = new JLabel("Välkommen till");
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
		textFieldName.setBounds(379, 241, 114, 19);
		startPage.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblVljVadDu = new JLabel("Välj vad du vill träna på:");
		lblVljVadDu.setBounds(287, 363, 209, 15);
		startPage.add(lblVljVadDu);

		//Buttons
		btnMulti = new JButton("Multiplikation");
		
		btnMulti.setBounds(192, 397, 143, 25);
		startPage.add(btnMulti);
		
		btnDivision = new JButton("Division");
		btnDivision.setBounds(404, 397, 143, 25);
		startPage.add(btnDivision);
	}

	/**
	 * Initialize the contents of multiplication page.
	 */
	public void createMultiPageGUI(){
		//Labels - text fields
		lblHejNamn = new JLabel();
		lblHejNamn.setForeground(Color.LIGHT_GRAY);
		lblHejNamn.setFont(new Font("Dialog", Font.PLAIN, 55));
		lblHejNamn.setBounds(41, 43, 633, 79);
		multiPage.add(lblHejNamn);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1, 1);
		multiPage.add(layeredPane);
		
		labelCurrPoints = new JLabel("");
		labelCurrPoints.setHorizontalAlignment(SwingConstants.CENTER);
		labelCurrPoints.setBounds(279, 333, 188, 15);
		multiPage.add(labelCurrPoints);		

		labelCompleted = new JLabel("");
		labelCompleted.setBounds(70, 410, 500, 15);
		multiPage.add(labelCompleted);

		lblXTalet = new JLabel();
		lblXTalet.setHorizontalAlignment(SwingConstants.CENTER);
		lblXTalet.setFont(new Font("Dialog", Font.BOLD, 32));
		lblXTalet.setBounds(306, 168, 133, 79);
		multiPage.add(lblXTalet);
		
		textFieldSvar = new JTextField();
		textFieldSvar.setBounds(301, 256, 138, 36);
		multiPage.add(textFieldSvar);
		textFieldSvar.setColumns(10);
				
		labelResultError = new JLabel("Tyvärr var det fel svar - försök igen!");
		labelResultError.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		labelResultError.setForeground(Color.RED);
		labelResultError.setHorizontalAlignment(SwingConstants.CENTER);
		labelResultError.setBounds(122, 304, 509, 34);
		multiPage.add(labelResultError);

		//Button
		btnSluta = new JButton("Sluta spela och spara poängen");
		btnSluta.setBounds(419, 440, 255, 25);
		multiPage.add(btnSluta);
		
		btnOKnext = new JButton("OK");
		btnOKnext.setBounds(468, 261, 117, 25);
		multiPage.add(btnOKnext);
		
		//Progressbar
		progressBar = new JProgressBar();
		progressBar.setMaximum(679);//TODO hitta metoden som sumerar elementer i matrisen
		progressBar.setBounds(70, 437, 148, 14);
		multiPage.add(progressBar);
		
	}
	
	/**
	 * Initialize the contents of multiplication page.
	 */
	public void createDivPageGUI(){
		//Labels - text fields
		lblHejNamnDivision = new JLabel();
		lblHejNamnDivision.setForeground(Color.LIGHT_GRAY);
		lblHejNamnDivision.setFont(new Font("Dialog", Font.PLAIN, 55));
		lblHejNamnDivision.setBounds(41, 43, 633, 79);
		divPage.add(lblHejNamnDivision);
		
		JLayeredPane layeredPaneDivision = new JLayeredPane();
		layeredPaneDivision.setBounds(0, 0, 1, 1);
		divPage.add(layeredPaneDivision);
		
		labelCurrPointsDivision = new JLabel("");
		labelCurrPointsDivision.setHorizontalAlignment(SwingConstants.CENTER);
		labelCurrPointsDivision.setBounds(279, 333, 188, 15);
		divPage.add(labelCurrPointsDivision);		

		labelCompletedDivision = new JLabel("");
		labelCompletedDivision.setBounds(70, 410, 500, 15);
		divPage.add(labelCompletedDivision);

		lblXTaletDivision = new JLabel();
		lblXTaletDivision.setHorizontalAlignment(SwingConstants.CENTER);
		lblXTaletDivision.setFont(new Font("Dialog", Font.BOLD, 32));
		lblXTaletDivision.setBounds(306, 168, 234, 79);
		divPage.add(lblXTaletDivision);
		
		textFieldSvarDivision = new JTextField();
		textFieldSvarDivision.setBounds(301, 256, 138, 36);
		divPage.add(textFieldSvarDivision);
		textFieldSvarDivision.setColumns(10);
				
		labelResultErrorDivision = new JLabel("Tyvärr var det fel svar - försök igen!");
		labelResultErrorDivision.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		labelResultErrorDivision.setForeground(Color.RED);
		labelResultErrorDivision.setHorizontalAlignment(SwingConstants.CENTER);
		labelResultErrorDivision.setBounds(122, 304, 509, 34);
		divPage.add(labelResultErrorDivision);

		//Button
		btnSlutaDivision = new JButton("Sluta spela och spara poängen");
		btnSlutaDivision.setBounds(419, 440, 255, 25);
		divPage.add(btnSlutaDivision);
		
		btnOKnextDivision = new JButton("OK");
		btnOKnextDivision.setBounds(468, 261, 117, 25);
		divPage.add(btnOKnextDivision);
		
		//Progressbar
		progressBarDivision = new JProgressBar();
		progressBarDivision.setMaximum(583);
		progressBarDivision.setBounds(70, 437, 148, 14);
		divPage.add(progressBarDivision);
		
	}

	/**
	 * Initialize game when user selects to run Multiplication
	 */
	public void onClickMulti(){
		player.setName(textFieldName.getText());
		
		if (!fileHandler.startMultiGame(player, game)) 	//if this user not already has an ongoing game			
			game.newMultArray();
		
		lblHejNamn.setText("Hej " + textFieldName.getText() + "!");
		labelCurrPoints.setText("ANTAL RÄTT: " + player.getPoints());
		labelCompleted.setText("Du har klarat av " + player.getPoints() + " av 679 tal.");
		
		startPage.setVisible(false);
		multiPage.setVisible(true);
		
		runGame();
	}
	
	public void onClickDivision(){
		player.setName(textFieldName.getText());
		
		if (!fileHandler.startDivGame(player, gameDivision)) 	//if this user not already has an ongoing game			
			gameDivision.newDivArray();
		
		lblHejNamnDivision.setText("Hej " + textFieldName.getText() + "!");
		labelCurrPointsDivision.setText("ANTAL RÄTT: " + player.getPoints());
		labelCompletedDivision.setText("Du har klarat av " + player.getPoints() + " av 583 tal.");
		
		startPage.setVisible(false);
		divPage.setVisible(true);
		
		runDivGame();
	}


	/**
	 * Fetch new numbers to calculate
	 */
	public void runGame(){
		labelResultError.setVisible(false);
		progressBar.setValue(player.getPoints());
		textFieldSvar.setText("");
		lblXTalet.setText(game.runGame());
		if (!timer.isRunning())
			timer.start();
		else
			timer.restart(); 
	}
	
	public void runDivGame(){
		labelResultErrorDivision.setVisible(false);
		progressBarDivision.setValue(player.getPoints());
		textFieldSvarDivision.setText("");
		lblXTaletDivision.setText(gameDivision.runGame());
		if (!timerDiv.isRunning())
			timerDiv.start();
		else
			timerDiv.restart(); 
	}
	
	/**
	 * Check if answer is correct when user enters an answer and either press Enter or OK-button. 
	 */
	public void onAnswering(){
		try{
			if (game.checkAnswer(Integer.parseInt(textFieldSvar.getText())) == true){
					player.increasePoints();
					if (game.isCleared()){
						player.increaseCompleted();
					}	
					labelCompleted.setText("Du har klarat av " + player.getPoints() + " av 679 tal.");
					progressBar.setValue(player.getPoints());
					labelCurrPoints.setText("ANTAL RÄTT: " + player.getPoints());	
					runGame();
			} else {
				textFieldSvar.setText("");
				labelResultError.setVisible(true);
			}
		} catch (NumberFormatException e){
			e.getMessage();
		}
	}

	public void onAnsweringDiv(){
		try{
			if (gameDivision.checkAnswer(Integer.parseInt(textFieldSvarDivision.getText())) == true){
					player.increasePoints();
					if (gameDivision.isCleared()){
						player.increaseCompleted();
					}
					labelCompletedDivision.setText("Du har klarat av " + player.getPoints() + " av 583 tal.");
					progressBarDivision.setValue(player.getPoints());
					
					labelCurrPointsDivision.setText("ANTAL RÄTT: " + player.getPoints());	
					runDivGame();
			} else {
				textFieldSvarDivision.setText("");
				labelResultErrorDivision.setVisible(true);
			}
		} catch (NumberFormatException e){
			e.getMessage();
		}
	}

	

	/**
	 * Save game - when user presses Save-button
	 */
	public void saveGame(){
		
		fileHandler.saveMultiGameToFile(player, game);	
		System.exit(0);
	}
	
	public void saveDivGame(){
		fileHandler.saveDivGameToFile(player, gameDivision);
		System.exit(0);
	}

	/**
	 * Action listeners
	 */	
	public void addActionListeners() {
		btnMulti.addActionListener(this);	
		btnDivision.addActionListener(this);
		textFieldSvar.addActionListener(this);
		btnSluta.addActionListener(this);
		btnOKnext.addActionListener(this);
		textFieldSvarDivision.addActionListener(this);
		btnSlutaDivision.addActionListener(this);
		btnOKnextDivision.addActionListener(this);
		timer.addActionListener(this);
		timerDiv.addActionListener(this);
	}

	/**
	 * Action handlers
	 */	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnMulti) {
			onClickMulti();			
		}
		if (e.getSource() == btnDivision) {
			onClickDivision();			
		}
		if ((e.getSource() == textFieldSvar)||(e.getSource() == btnOKnext)) {
			onAnswering();			
		}
		if ((e.getSource() == textFieldSvarDivision)||(e.getSource() == btnOKnextDivision)) {
			onAnsweringDiv();			
		}
		if (e.getSource() == btnSluta)  {
			saveGame();			
		}
		
		if (e.getSource() == btnSlutaDivision) {
			saveDivGame();
		}
		
		if (e.getSource() == timer){
			runGame();
		}
		
		if (e.getSource() == timerDiv){
			runDivGame();
		}
		
	}
}
