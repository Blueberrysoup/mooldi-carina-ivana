/***
* MultiGame - Methods for Multiplication Page - Mooldi application
* @authors: Carina Ekström, Ivana Zdjuic
* @version: 1.0
**/
package se.examination.otherclasses;

import java.util.Random;

import se.examination.interfaces.GameInterface;

public class MultiGame implements GameInterface{
	
	int[][] resultArr = new int[13][13];
	final int EASY = 2;
	final int MEDIUM = 5;	
	final int HARD = 10;
	Random rand = new Random();
	Integer currX = 0;
	Integer currY = 0;
	
	/**
	 * Initiates the resultArr for first time users.
	 * Each entry tells how many times a number (e.g. 7*6) has to be answered correctly in order to say that it is cleared.
	 * Easy numbers like 2*5 must not be answered as many times as harder numbers like 9*8.
	 * 
	 * The indices for each entry in the array corresponds to the number to calculate, e.g. resultArr[7][12] means 7 * 12 
	 * and this entry is initiated to 10 since 7*12 is considered "hard".
	 */
	public void newMultArray(){
		for (int y = 0; y <= 12; y++){
			resultArr[0][y] = EASY;
			resultArr[1][y] = EASY;
			resultArr[2][y] = EASY;
			resultArr[3][y] = MEDIUM;
			resultArr[4][y] = MEDIUM;
			resultArr[5][y] = MEDIUM;
			resultArr[6][y] = HARD;
			resultArr[7][y] = HARD;
			resultArr[8][y] = HARD;
			resultArr[9][y] = HARD;			
			resultArr[10][y] = EASY;
			resultArr[11][y] = MEDIUM;
			resultArr[12][y] = HARD;
		}
		for (int x = 0; x <= 12; x++){
			if ((x <= 2) || (x == 10)){
				resultArr[x][0] = EASY;
				resultArr[x][1] = EASY;
				resultArr[x][2] = EASY;
				resultArr[x][3] = EASY;
				resultArr[x][4] = EASY;
				resultArr[x][5] = EASY;
				resultArr[x][6] = EASY;
				resultArr[x][7] = EASY;
				resultArr[x][8] = EASY;
				resultArr[x][9] = EASY;			
				resultArr[x][10] = EASY;
				resultArr[x][11] = EASY;
				resultArr[x][12] = EASY;
			}			
		}
	}
	
	/**
	 * Presents a new number to calculate by fetching two random integers from the result matrix
	 * If the number is already cleared, it fetches a new number
	 * @return String The value to calculate, formatted as e.g. "4 * 11" 
	 */
	public String runGame(){
		do{
			currX = rand.nextInt(13);
			currY = rand.nextInt(13);
		} while (resultArr[currX][currY] == 0);	
		
		String ret = currX.toString() + " * " + currY.toString();
		return ret;
	}
	
	/**
	 * Checks if the answer entered by the player is correct or not. 
	 * If correct answer, the corresponding entry in result matrix is decreased by 1.
	 * @param answer The answer entered by the player
	 * @return True if correct answer, otherwise false
	 */
	public boolean checkAnswer(int answer){
		boolean result = false;
		if ((currX.intValue() * currY.intValue()) == answer){ 
			resultArr[currX][currY]--;
			result = true;
		}		
		return result;
	}
	
	/**
	 * Checks if the current number (e.g. 4*11) has been answered correctly a specified number of times. 
	 * When a number is cleared it will never show again.
	 * @return True if the number is cleared, otherwise false
	 */
	public boolean isCleared(){
		return (resultArr[currX][currY] == 0);
	}

	/**
	 * Returns resultArr. Used in FileHandler class to save the current results in a file when the user quits the game
	 * @return The result matrix
	 */
	public int[][] getResultArr(){
		return resultArr;
	}
	
}
