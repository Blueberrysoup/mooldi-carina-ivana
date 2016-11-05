package se.examination.otherclasses;
import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

import org.junit.Test;

import se.examination.otherclasses.DivGame;
import se.examination.otherclasses.FileHandler;
import se.examination.otherclasses.Player;

public class FileHandlerTest {

	public static final Logger LOG = Logger.getLogger(FileHandler.class.getName());
	private FileHandler fh = new FileHandler();
	
	@Test
	public void testSaveDivGameToFile() {
		Player player = new Player();
		DivGame dGame = new DivGame();
		player.setName("Testare1");
		player.setPoints(28);
		player.setCompleted(15);
		dGame.newDivArray();
		fh.saveDivGameToFile(player, dGame);
		
		String fileName = "gamefiles/" + player.getName() + "_div.txt"; 
		File file = new File(fileName);
		try{
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			LOG.info("Testing the saveDivGameToFile method. First line in file should be 28 (Points)");
			assertEquals(28, Integer.parseInt(bufferedReader.readLine()));
			LOG.info("Testing the saveDivGameToFile method. Second line in file should be 15 (Completed)");
			assertEquals(15, Integer.parseInt(bufferedReader.readLine()));
			LOG.info("Testing the saveDivGameToFile method. Third line in file should be 0");
			assertEquals(0, Integer.parseInt(bufferedReader.readLine()));
			bufferedReader.close();
			file.delete();
		} catch (IOException e){
			e.getMessage();
		} 			
	}
	
	/*
	@Test (expected = java.io.IOException.class)
	public void testSaveDivGameToFile_IOException() {
		//assertEquals(expected, );
		//TODO: Kolla hur man provocerar fram IOException
	}
	*/
	//TOOD: Testa SecurityException
	
	/*
	@Test
	public void testStartDivGame() {
		Player player = new Player();
		DivGame dGame = new DivGame();
		player.setName("Testare2");
		FileHandler fh = new FileHandler();
		fh.startDivGame(player, dGame);
		
		//TODO: Skapa fil så att det finns något att läsa från. Kolla de 3 första raderna
	}
	*/
	//TODO: Testa startDivGame() då det inte finns någon fil
	//TOOD: Testa IOException

}
