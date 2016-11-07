package se.examination.otherclasses;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Random;
import java.util.logging.Logger;

import org.junit.Test;

public class MultiGameTest {

	public static final Logger LOG = Logger.getLogger(MultiGame.class.getName());
	MultiGame multiGame = new MultiGame();
	Random rand = new Random();
	
	@Test
	public void testNewMultArray_getResultArr() {
		multiGame.newMultArray();
		int[][] res = multiGame.getResultArr();
		LOG.info("Testing the newMultArry and getResultArr methods with x=0 and y=0");
		assertEquals(2, res[0][0]);
		LOG.info("Testing the newMultArry and getResultArr methods with x=8 and y=10");
		assertEquals(2, res[8][10]);
		LOG.info("Testing the newMultArry and getResultArr methods with x=11 and y=4");
		assertEquals(2, res[11][4]);
		LOG.info("Testing the newMultArry and getResultArr methods with x=7 and y=5");
		assertEquals(5, res[7][5]);
		LOG.info("Testing the newMultArry and getResultArr methods with x=3 and y=12");
		assertEquals(5, res[3][12]);
		LOG.info("Testing the newMultArry and getResultArr methods with x=12 and y=4");
		assertEquals(5, res[12][4]);
		LOG.info("Testing the newMultArry and getResultArr methods with x=6 and y=6");
		assertEquals(10, res[6][6]);
		LOG.info("Testing the newMultArry and getResultArr methods with x=11 and y=11");
		assertEquals(10, res[11][11]);
		LOG.info("Testing the newMultArry and getResultArr methods with x=12 and y=12");
		assertEquals(10, res[12][12]);
	}

	@Test (expected = ArrayIndexOutOfBoundsException.class)
	public void testGetResultArr_OutOfBounds() {
		System.out.println("test började");
		multiGame.newMultArray();
		int[][] res = multiGame.getResultArr();
		LOG.info("Testing the getResultArr method with ArrayIndexOutOfBounds");
		assertEquals(2, res[13][13]);
	}
	
	@Test
	public void testRunGame() {
		String actual = multiGame.runGame();
		String expected = Integer.toString(multiGame.getCurrX()) + " * " + Integer.toString(multiGame.getCurrY());
		LOG.info("Testing the runGame method with currX = " + multiGame.getCurrX() + ", currY = " + multiGame.getCurrY() + " and actual = " + actual);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCheckAnswer_true() {
		int x = 0;
		int y = 0;
		int answer = 0;
		int[][] res = multiGame.getResultArr();
		int valueBefore = 0;
		int valueAfter = 0;
		for (int i = 0; i < 10; i++){
			x = rand.nextInt(13);
			y = rand.nextInt(13);
			multiGame.setCurrX(x);
			multiGame.setCurrY(y);
			answer = x * y;
			valueBefore = res[x][y];
			LOG.info("Testing the checkAnswer method with currX = " + x + ", currY = " + y + " and answer = " + answer);
			assertTrue(multiGame.checkAnswer(answer));
			
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
		int[][] res = multiGame.getResultArr();
		int valueBefore = 0;
		int valueAfter = 0;
		for (int i = 0; i < 10; i++){
			x = rand.nextInt(13);
			y = rand.nextInt(13);
			multiGame.setCurrX(x);
			multiGame.setCurrY(y);
			answer = x * y + 1;
			valueBefore = res[x][y];
			LOG.info("Testing the checkAnswer method with currX = " + x + ", currY = " + y + " and answer = " + answer);
			assertFalse(multiGame.checkAnswer(answer));

			LOG.info("Testing the checkAnswer method and resultArray entry has not changed since answer was incorrect");
			valueAfter = res[x][y];
			assertTrue(valueBefore == valueAfter);
		}
	}

	@Test
	public void testIsCleared() {
		multiGame.newMultArray();
		int x = 0;
		int y = 0;
		for (int i = 0; i < 10; i++){
			x = rand.nextInt(13);
			y = rand.nextInt(13);
			multiGame.setCurrX(x);
			multiGame.setCurrY(y);
			LOG.info("Testing the isCleared method with currX = " + x + " and currY = " + y);
			assertFalse(multiGame.isCleared());
		}
		
	}
}
