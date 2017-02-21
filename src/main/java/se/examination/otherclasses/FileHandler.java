/***
* FileHandler - Methods for handling saved game data - Mooldi application
* @authors: Carina Ekstrom, Ivana Zdjuic
* @version: 1.0
**/
package se.examination.otherclasses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {

	/**
	 * Fetches information on the player, and the player's total results. 
	 * Writes to a textfile named as NAME_multi.txt
	 * Note! Currently the folder gamefiles must exist - in next version this folder will be created if it doesn't exist
	 * @param player The current Player object
	 * @param game The current MultiGame object
	 */
	public void saveMultiGameToFile(Player player, MultiGame game){
		int points = player.getPoints();
		int completed = player.getCompleted();
		int[][] resArr = game.getResultArr();
		String fileName = "gamefiles/" + player.getName() + "_multi.txt";
		File file = new File(fileName);
		try{
			//file.mkdir();		TODO! Mappen ska skapas om den inte finns
			file.createNewFile();
		
			FileWriter writer = new FileWriter(file);
			
			writer.write(points+"\n");
			writer.write(completed+"\n");
			
			for (int x = 0; x < 13; x++){
				for (int y = 0; y < 13; y++){
					writer.write(resArr[x][y]+"\n");
				}
			}
			
			writer.flush();
			writer.close();
		
		} catch(IOException e){
			System.out.println(e.getMessage());
		} catch(SecurityException e){
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Fetches information on the player, and the player's total results. 
	 * Writes to a textfile named as NAME_div.txt
	 * Note! Currently the folder gamefiles must exist - in next version this folder will be created if it doesn't exist
	 * @param player The current Player object
	 * @param game The current DivGame object
	 */
	public void saveDivGameToFile(Player player, DivGame game){
		int points = player.getPoints();
		int completed = player.getCompleted();
		int[][] resArr = game.getResultArr();
		String fileName = "gamefiles/" + player.getName() + "_div.txt";
		File file = new File(fileName);
		try{
			//file.mkdir();		TODO! Mappen ska skapas om den inte finns
			file.createNewFile();
		
			FileWriter writer = new FileWriter(file);
			
			writer.write(points+"\n");
			writer.write(completed+"\n");
			
			for (int x = 0; x < 13; x++){
				for (int y = 0; y < 13; y++){
					writer.write(resArr[x][y]+"\n");
				}
			}
			
			writer.flush();
			writer.close();
		
		} catch(IOException e){
			System.out.println(e.getMessage());
		} catch(SecurityException e){
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Deletes the file for a specific user and gametype. 
	 * @param player The current Player object
	 * @param gameType The current gametype (m = multi, d = div)
	 */
	public boolean deleteGameFile(Player player, char gameType){
		String extension = "";
		if (gameType == 'm')
			extension = "_multi.txt";
		else if (gameType == 'd')
			extension = "_div.txt";
		
		String fileName = "gamefiles/" + player.getName() + extension; 
		File file = new File(fileName);
		return file.delete();
	}
	
	/**
	 * Checks if a file NAME_multi.txt exists. If so, reads the file 
	 * and saves the values as current player's results.
	 * @param player The current Player object
	 * @param game The current MultiGame object
	 * @return True if the file exists, i.e. if the player has a saved game. False if there is a new player.
	 */
	public boolean startMultiGame(Player player, MultiGame game){
		String fileName = "gamefiles/" + player.getName() + "_multi.txt"; 
		File file = new File(fileName);
		Boolean exists = file.exists();
		int[][] resArr = game.getResultArr();

		try{
			if (exists){
				FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				player.setPoints(Integer.parseInt(bufferedReader.readLine()));
				player.setCompleted(Integer.parseInt(bufferedReader.readLine()));
				
				for (int x = 0; x < 13; x++){
					for (int y = 0; y < 13; y++){
						resArr[x][y] = Integer.parseInt(bufferedReader.readLine());
					}
				}
				bufferedReader.close();
			}
		} catch (IOException e){
			System.out.println(e.getMessage());
		} 

		return exists;
	}

	/**
	 * Checks if a file NAME_div.txt exists.
	 * Reads the file and saves the values as current player's results.
	 * @param player The current Player object
	 * @param game The current DivGame object
	 * @return True if the file exists, i.e. if the player has a saved game. False if there is a new player.
	 */
	public boolean startDivGame(Player player, DivGame game){
		String fileName = "gamefiles/" + player.getName() + "_div.txt"; 
		File file = new File(fileName);
		Boolean exists = file.exists();
		int[][] resArr = game.getResultArr();

		try{
			if (exists){
				FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				player.setPoints(Integer.parseInt(bufferedReader.readLine()));
				player.setCompleted(Integer.parseInt(bufferedReader.readLine()));
				
				for (int x = 0; x < 13; x++){
					for (int y = 0; y < 13; y++){
						resArr[x][y] = Integer.parseInt(bufferedReader.readLine());
					}
				}
				bufferedReader.close();
			}
		} catch (IOException e){
			System.out.println(e.getMessage());
		} 

		return exists;
	}
}
