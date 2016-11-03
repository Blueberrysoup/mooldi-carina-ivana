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

	final int EASY = 2;
	final int MEDIUM = 5;	
	final int HARD = 10;
	Random rand = new Random();
	Integer currX = 0;
	Integer currY = 0;
	
	/**
	 * TODO 
	 */
	public void newDivArrays(){
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
		//returnera true om ett tal (dvs currX / currY) är "avklarat" dvs om antal återstående försök på det talet är 0
		return false;
	}

	/**
	 * TODO
	 */
	public int[][] getResultArr(){
		return resultArr;
	}
	
}
