/***
* Player - Methods for a player's current status - Mooldi application
* @authors: Carina Ekström, Ivana Zdjuic
* @version: 1.0
**/
package se.examination.otherclasses;

public class Player {
	String name = "";
	int points = 0;
	int completed = 0;
	
	/**
	 * Get current player's name
	 * @return String Current player's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set current player's name
	 * @param name Current player's name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get current player's points, i.e number of correct answers
	 * @return points Current player's points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Set current player's points, i.e number of correct answers
	 * @param points Current player's points
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * Increase current player's points (i.e number of correct answers) by one
	 */
	public void increasePoints() {
		points++;
	}

	/**
	 * Get current player's completed score
	 * @return completed Current player's completed score
	 */
	public int getCompleted() {
		return completed;
	}

	/**
	 * Set current player's completed score
	 * @param completed Current player's completed score
	 */
	public void setCompleted(int completed) {
		this.completed = completed;
	}
	
	/**
	 * Increase current player's completed numbers by one
	 */
	public void increaseCompleted() {
		completed++;
	}
}
