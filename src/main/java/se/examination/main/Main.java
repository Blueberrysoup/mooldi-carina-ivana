/***
* Main - main class for Mooldi application
* @authors: Carina Ekström, Ivana Zdjuic
* @version: 1.0
**/
package se.examination.main;

import se.examination.gui.MainFrame;

public class Main {

	/**
	 * Main method
	 */
	public static void main(String[] args) {
		MainFrame window = new MainFrame();
		window.getFrmMooldi().setVisible(true);
	}

}
