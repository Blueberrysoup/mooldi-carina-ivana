/***
* MultiGame - Methods for Multiplication Page - Mooldi application
* @authors: Carina Ekström, Ivana Zdjuic
* @version: 1.0
**/
package se.examination.otherclasses;

import java.util.Random;

import se.examination.interfaces.GameInterface;

public class MultiGame implements GameInterface{
	
	private int[][] resultArr = new int[13][13];
	private final int EASY = 2;
	private final int MEDIUM = 5;	
	private final int HARD = 10;
	private Integer currX = 0;
	private Integer currY = 0;
	
	/*
	 * Getters and setters - only to be used for unit test purpose
	 */	
	public Integer getCurrX() {
		return currX;
	}

	public void setCurrX(Integer currX) {
		this.currX = currX;
	}

	public Integer getCurrY() {
		return currY;
	}

	public void setCurrY(Integer currY) {
		this.currY = currY;
	}

	/**
	 * Initiates the resultArr for first time users.
	 * Each entry tells how many times a number (e.g. 7*6) has to be answered correctly in order to say that it is cleared.
	 * Easy numbers like 2*5 must not be answered as many times as harder numbers like 9*8.
	 * 
	 * The indices for each entry in the array corresponds to the number to calculate, e.g. resultArr[7][12] means 7 * 12 
	 * and this entry is initiated to 10 since 7*12 is considered "hard".
	 */
	public void newMultArray(){
		
		try{
			//1. Set all entries to EASY
			for (int x = 0; x <= 12; x++){
				for (int y = 0; y <=12; y++){
					resultArr[x][y] = EASY;
				}
			}	
			
			//2. Set tables 3-9 and 12 to MEDIUM
			for (int x = 0; x <= 12; x++){
				for (int y = 0; y <= 12; y++){
					if (((x >= 3) && (x <= 9) && (y >= 3) && (y <= 9))
							|| ((x == 12) && (y >= 3) && (y <= 5))
							|| ((x >= 3) && (x <= 5) && (y == 12))) {
								resultArr[x][y] = MEDIUM;
					}
				}
			}	
	
			//3. Finally, set tables 6-9 and 12 to HARD
			for (int x = 0; x <= 12; x++){
				for (int y = 0; y <= 12; y++){
					if (((((x >= 6) && (x <= 9)) || (x == 12)) && (((y >= 6) && (y <= 9)) || (y == 12)))
							|| ((x == 11) || (x == 12)) && ((y == 11) || (y == 12))) {
								resultArr[x][y] = HARD;
					}
				}
			}	
		}catch(ArrayIndexOutOfBoundsException e){
			e.getMessage();
		}

	}
	
	/**
	 * Presents a new number to calculate by fetching two random integers from the result matrix
	 * If the number is already cleared, it fetches a new number. 
	 * To prevent an infinite loop if all entries are 0 - try max 169 times (i.e. the number of entries in the matrix)
	 * @return String The value to calculate, formatted as e.g. "4 * 11" 
	 */
	public String runGame(){
		Random rand = new Random();
		String ret = "";
		int count = 0;
		do{
			currX = rand.nextInt(13);
			currY = rand.nextInt(13);
			count++;
		} while ((resultArr[currX][currY] == 0) && (count <= 169));	
		
		if (count <= 169)
			ret = currX.toString() + " * " + currY.toString();
		else
			ret = "GAME OVER!";

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
