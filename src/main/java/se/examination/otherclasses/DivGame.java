/***
* DivGame - Methods for Division Page - Mooldi application
* @authors: Carina Ekström, Ivana Zdjuic
* @version: 1.0
**/
package se.examination.otherclasses;

import java.util.Random;

import se.examination.interfaces.GameInterface;

public class DivGame implements GameInterface{
	
	int[][] resultArr = new int[13][13];

	final int NO_USE = 0;
	final int EASY = 2;
	final int MEDIUM = 5;	
	final int HARD = 10;
	Random rand = new Random();
	Integer currX = 0;
	Integer currY = 0;
	
	/**
	 * Initiates the resultArr for first time users.
	 * Each entry tells how many times a number (e.g. 56/7) has to be answered correctly in order to say that it is cleared.
	 * Easy numbers like 30/10 must not be answered as many times as harder numbers like 63/9. Division by 0 and 1 and not used at all.
	 * 
	 * The indices for each entry in the array corresponds to the number to calculate, e.g. resultArr[7][6] means 42/6 since 7*6=42
	 * This entry is initiated to 10 since 42/6 is considered "hard".
	 */
	public void newDivArray(){
		//1. Set all entries to EASY
		for (int x = 0; x <= 12; x++){
			for (int y = 0; y <=12; y++){
				resultArr[x][y] = EASY;
			}
		}	
		
		//2. Set tables 0-1 to NO_USE
		for (int x = 0; x <= 12; x++){
			for (int y = 0; y <= 12; y++){
				if ((x == 0) || (x == 1) || (y == 0) || (y == 1)) {
					resultArr[x][y] = NO_USE;
				}
			}
		}	
		
		//3. Set tables 3-9 and 12 to MEDIUM
		for (int x = 0; x <= 12; x++){
			for (int y = 0; y <= 12; y++){
				if (((x >= 3) && (x <= 9) && (y >= 3) && (y <= 9))
						|| ((x == 12) && (y >= 3) && (y <= 5))
						|| ((x >= 3) && (x <= 5) && (y == 12))) {
							resultArr[x][y] = MEDIUM;
				}
			}
		}	

		//4. Finally, set tables 6-9 and 12 to HARD
		for (int x = 0; x <= 12; x++){
			for (int y = 0; y <= 12; y++){
				if (((((x >= 6) && (x <= 9)) || (x == 12)) && (((y >= 6) && (y <= 9)) || (y == 12)))
						|| ((x == 11) || (x == 12)) && ((y == 11) || (y == 12))) {
							resultArr[x][y] = HARD;
				}
			}
		}	
		
}
	
	/**
	 * Presents a new number to calculate by fetching two random integers from a predefined result matrix
	 * If the number is already cleared, it fetches a new number
	 * @return String The value to calculate, formatted as e.g. "64 / 8" 
	 */
	public String runGame(){
		//slumpa fram divisionstal
		//returnera som en sträng att visa i GUI:t, t.ex. 63 / 7
		return "63 / 7";
	}
	
	/**
	 * Checks if the answer entered by the player is correct or not
	 * If correct answer, the corresponding entry in result matrix is decreased by 1.
	 * @param answer The answer entered by the player
	 * @return True if correct answer, otherwise false
	 */	
	public boolean checkAnswer(int answer){
		//ta in svaret som spelaren angivit
		//räkna ut talet currX / currY och se om det är == answer
		//om rätt: räkna ner i resultarrayen
		//returnera true/false beroende på om det är rätt svar
		return true;
	}
	
	/**
	 * Checks if the current number (e.g. 64/8) has been answered correctly a specified number of times. 
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
