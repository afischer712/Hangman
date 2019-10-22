// imports
import java.io.*;							// File, filenotfoundexception
import java.util.*;							//Scanner, Random

/**
 * 
 * This class fills an array with words from the text file "Words.txt" and then chooses one at random
 * to be used within Application.java
 * 
 * @author Adam Fischer
 * @version 11/20/2018
 * Programming Project 1
 * Fall 2018
 *
 */

public class Dictionary {
	
	public static String hangWord;// this is the word used for the game of hangman (and the only instance variable)
	
	/**
	 * This method fills the arrayList words with words from the text file and then chooses one at random
	 * 
	 * @return - returns hangWord, which is the random word that is used in the game
	 * @throws FileNotFoundException
	 */
	
	public static String getRandomWord() throws FileNotFoundException {
		
		ArrayList<String> words = new ArrayList<String>();// creates the arrayList
		
		Scanner fileName = new Scanner(new File("Words.txt"));// accesses the text file
		
		//creates a random number to draw from words
		Random r = new Random();
		int random = r.nextInt(100)+1;
		
		while(fileName.hasNext()) {// fills words with the words from the text file
			
			String word = fileName.next();
			words.add(word);
			
		}// end while
		
		//takes the word at the random variable from the arrayList
		hangWord = words.get(random);
		
		//returns the string
		return hangWord;
		
	}// end getRandomWord
	
	

}// end class
