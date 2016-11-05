package se.examination.otherclasses;

import static org.junit.Assert.*;

import java.util.Random;
import java.util.logging.Logger;

import org.junit.Test;

public class DivGameTest {

	public static final Logger LOG = Logger.getLogger(DivGame.class.getName());
	DivGame divGame = new DivGame();
	Random rand = new Random();
	
	@Test
	public void testNewDivArray_getResultArr() {
		divGame.newDivArray();
		int[][] res = divGame.getResultArr();
		LOG.info("Testing the newMultArry and getResultArr methods with x=0 and y=0");
		assertEquals(0, res[0][0]);
		LOG.info("Testing the newMultArry and getResultArr methods with x=1 and y=9");
		assertEquals(0, res[1][9]);
		LOG.info("Testing the newMultArry and getResultArr methods with x=12 and y=1");
		assertEquals(0, res[12][1]);
		LOG.info("Testing the newMultArry and getResultArr methods with x=2 and y=2");
		assertEquals(2, res[2][2]);
		LOG.info("Testing the newMultArry and getResultArr methods with x=10 and y=12");
		assertEquals(2, res[10][12]);
		LOG.info("Testing the newMultArry and getResultArr methods with x=11 and y=10");
		assertEquals(2, res[11][10]);
		LOG.info("Testing the newMultArry and getResultArr methods with x=5 and y=5");
		assertEquals(5, res[5][5]);
		LOG.info("Testing the newMultArry and getResultArr methods with x=5 and y=12");
		assertEquals(5, res[5][12]);
		LOG.info("Testing the newMultArry and getResultArr methods with x=12 and y=4");
		assertEquals(5, res[12][4]);
		LOG.info("Testing the newMultArry and getResultArr methods with x=6 and y=6");
		assertEquals(10, res[6][6]);
		LOG.info("Testing the newMultArry and getResultArr methods with x=11 and y=11");
		assertEquals(10, res[11][11]);
		LOG.info("Testing the newMultArry and getResultArr methods with x=12 and y=12");
		assertEquals(10, res[12][12]);
	}

	@Test (expected = java.lang.ArrayIndexOutOfBoundsException.class)
	public void testGetResultArr_OutOfBounds() {
		divGame.newDivArray();
		int[][] res = divGame.getResultArr();
		LOG.info("Testing the getResultArr method with ArrayIndexOutOfBounds");
		assertEquals(2, res[13][13]);
	}
	
	@Test
	public void testRunGame() {
		String actual = divGame.runGame();
		String expected = Integer.toString(divGame.getCurrX()*divGame.getCurrY()) + " / " + Integer.toString(divGame.getCurrX());
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCheckAnswer_true() {
		int x = 0;
		int y = 0;
		int answer = 0;
		int[][] res = divGame.getResultArr();
		int valueBefore = 0;
		int valueAfter = 0;
		for (int i = 0; i < 10; i++){
			x = rand.nextInt(13);
			y = rand.nextInt(13);
			divGame.setCurrX(x);
			divGame.setCurrY(y);
			answer = y;
			valueBefore = res[x][y];
			LOG.info("Testing the checkAnswer method with currX = " + x + ", currY = " + y + " and answer = " + answer);
			assertTrue(divGame.checkAnswer(answer));
			
			LOG.info("Testing the checkAnswer method and resultArray entry has decreased since answer was correct");
			valueAfter = res[x][y];
			assertTrue(valueBefore == (valueAfter+1));
		}
	}

	@Test
	public void testCheckAnswer_false() {
		int x = 0;
		int y = 0;
		int answer = 0;
		int[][] res = divGame.getResultArr();
		int valueBefore = 0;
		int valueAfter = 0;
		for (int i = 0; i < 10; i++){
			x = rand.nextInt(13);
			y = rand.nextInt(13);
			divGame.setCurrX(x);
			divGame.setCurrY(y);
			answer = y + 1;
			valueBefore = res[x][y];
			LOG.info("Testing the checkAnswer method with currX = " + x + ", currY = " + y + " and answer = " + answer);
			assertFalse(divGame.checkAnswer(answer));

			LOG.info("Testing the checkAnswer method and resultArray entry has not changed since answer was incorrect");
			valueAfter = res[x][y];
			assertTrue(valueBefore == valueAfter);
		}
	}

	@Test
	public void testIsCleared_true() {
		divGame.newDivArray();
		for (int i = 0; i < 10; i++){
			divGame.setCurrX(rand.nextInt(2));
			divGame.setCurrY(rand.nextInt(2));
			assertTrue(divGame.isCleared());
		}		
	}

	@Test
	public void testIsCleared_false() {
		divGame.newDivArray();
		int x = 0;
		int y = 0;
		for (int i = 0; i < 10; i++){
			x = rand.nextInt(13);
			y = rand.nextInt(13);
			divGame.setCurrX(x);
			divGame.setCurrY(y);
			LOG.info("Testing the isCleared method with currX = " + x + " and currY = " + y);
		}
	}
}
