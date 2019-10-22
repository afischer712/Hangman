// Imports
import java.io.FileNotFoundException;			//used for ArrayLists
import java.util.*;								//used for Scanner

/**
 * This class uses Dicionary.java to play a game of hangman. It also keeps track of the score and 
 * loops the game with sentinel input
 * 
 * @author Adam Fischer
 * @version 11/30/2018
 * Programming Project 1
 * Fall 2018
 *
 */
public class Application {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner input = new Scanner(System.in);
		
		int wins = 0, losses = 0;							// for score
		int guess = 6;										// number of incorrect guesses left
		char again = 'y';									// for repeating the game
		boolean win = false;								// for figuring out whether or not the game is over
		String hangWord = "" ;								// random word from Dictionary						
		int count;											// for going through each char to see if they match
		boolean correct;									// to see if there are any correct in the word
		char x;												// for user input of char
		int fillCount;										// used to fill the blanks ArrayList
		
		
		do {// activates the game (will loop with sentinel input)
			
			// this takes the random word from Dictionary.java and puts it into a variable in Application
			hangWord = Dictionary.getRandomWord();
			
			count = hangWord.length()-1; 		// sets count to one less than the length of the word (to account for starting at 0)
			fillCount = hangWord.length();		// tells blanks how many characters hangWord has
			
			
			ArrayList<Character> blanks = new ArrayList<Character>(); //creates the arrayList blanks
			while(fillCount>0) {
				blanks.add('_');
				fillCount--;
			}// end while loop to fill blanks with down spaces (used for the guessing of letters)
			
			
			ArrayList<Character> word = new ArrayList<Character>();// creates the arrayList word (used to contain hangWord)
			for(int i = 0; i<hangWord.length(); i++) {
				
				word.add(hangWord.charAt(i));
				
			}// end for loop to fill array list that contains the word
			
			
			System.out.println("Welcome to hangman!");
			System.out.printf("You have lost %d times.%nYou have won %d times.%n", losses, wins);	// this keeps score
			
			
			
			do {// creates the part of the game that is actually played with guessing letters
				
				for(int i = 0; i<blanks.size(); i++) {
				
					System.out.print(blanks.get(i) + " ");
					
				}// end for to print the blanks for the word (with the correct number to account for the word)
				
				
				// these two reset before the guessing to allow for the process to repeat
				correct = false;
				count = hangWord.length()-1;
				
				
				if(win == false) {// goes through the guessing while the game isn't over
					
					System.out.print("\nEnter a (lowercase) letter:");
				
					x = input.next().charAt(0);
				
					
					while(count>-1) {// this loops through the word as the if checks to see if
									 // the letters match the one guessed
						
						if(x == hangWord.charAt(count)) {
						
							blanks.set(count, word.get(count));
							correct=true;
							
						}// end if 
					
						count--;
					
					}// end while loop for the letters matched with the word
				
					
					if(correct==false) {// this takes away a guess for incorrect letters
						guess--;
					}// end if
					
					if(blanks.equals(word)) {// this checks to see if all of the letters have been guessed
						win = true;			 // and will set it up to end the game when that happens
					}
				
				}// end if for winning
				
				
				System.out.printf("You have %d incorrect guesses left%n", guess);
				
				
			}// end do while for guessing system
			while(guess>0 && win == false);				// this checks to see if the game is over and ends the loop
			
	
			if(win == true) { 		// this if - else accounts for whether the player won or lost and keeps score
				
				System.out.println("You won! Congradulations!");
				wins++;
				
			}// end if for win
			else {
				
				System.out.println("You lost! Too bad!");
				losses++;
				
			}// end else for loss
			
			
			
			// this gets sentinel input to end the loop of the game
			System.out.printf("The word was %s.%n", hangWord);
			System.out.println("Would you like to play the game again? (y/n)");
			again = input.next().charAt(0);
			
			// these reset the game in case the player decides to play again
			guess = 6;
			win = false;
			
			
			
		}// end do while for the game
		while(again == 'y');
		
		
	}// end main

}// end class Application
