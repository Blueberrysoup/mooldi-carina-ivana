/***
* GameInterface - Interface for Game methods - Mooldi application
* @authors: Carina Ekström, Ivana Zdjuic
* @version: 1.0
**/
package se.examination.interfaces;

public interface GameInterface {

	/**
	 * Presents a new number to calculate by fetching two random integers from a predefined result matrix
	 * If the number is already cleared, it fetches a new number
	 * @return String The value to calculate, formatted as e.g. "4 * 11" or "64 / 8" 
	 */
	public String runGame();

	/**
	 * Checks if the answer entered by the player is correct or not
	 * If correct answer, the corresponding entry in result matrix is decreased by 1.
	 * @param answer The answer entered by the player
	 * @return True if correct answer, otherwise false
	 */
	public boolean checkAnswer(int answer);

	/**
	 * Checks if the current number (e.g. 4*11 or 64/8) has been answered correctly a specified number of times. 
	 * When a number is cleared it will never show again.
	 * @return True if the number is cleared, otherwise false
	 */
	public boolean isCleared();
	
}
