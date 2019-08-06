/* WaffleWords.java 
 * 
 * WaffleWords.java takes as input an integer and outputs "waffle words" that are the same length 
 * as that integer. Waffle words have the following qualities:
 * 
 * 1. They are words that can be found in a dictionary (e.g., a text file, such as the one 
 *    provided, which contain a list of words). 
 * 2. If you choose the right letter to remove from a waffle word, the resulting word will also be
 *    a waffle word. The letter that is removed can be at any location in the waffle word.  
 * 
 * See README for more info.
 * 
 * Eli Epperson 
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.StringBuilder;
import java.io.File;
import java.io.FileNotFoundException;

public class WaffleWords {

	public static ArrayList<String> getWaffleWords(
			ArrayList<String> currentWaffles, ArrayList<ArrayList<String>> dic) {

		ArrayList<String> results = new ArrayList<String>();
		ArrayList<String> failed = new ArrayList<String>();
		String alphabet = "abcdefghijklmnopqrstuvwxyz";

		// Get the length of the waffle words
		// in the currentWaffle object.
		int waffleLength = currentWaffles.get(1).length();

		for (int i = 0; i < currentWaffles.size(); i++) {
			String waffleAtIndex = currentWaffles.get(i);
			String firstLetter;
			int positionInAlphabet;

			if (waffleLength > 1) {
			
				/* In this loop, add a letter to the current waffle word and test whether the
				 * resulting word is a dictionary word. "<=" is used because I also want to add 
				 * a letter at the end of the waffle word being tested.
				 */
				for (int j = 0; j <= waffleAtIndex.length(); j++) {
					for (int k = 0; k < 26; k++) {
						String testString;
						
						// Letters are added to the StringBuilder tester.  
						StringBuilder tester = new StringBuilder(waffleAtIndex);
						testString = tester.insert(j, alphabet.charAt(k)).toString();
						firstLetter = String.valueOf(testString.charAt(0));
						positionInAlphabet = alphabet.indexOf(firstLetter);

						if (failed.contains(testString)) {
							// Do nothing: testString is not a dictionary word.
						
						} else if (results.contains(testString)) {
							// Do nothing: testString is a waffle word and is already in results.
						
						// Test if testString is in the dictionary. If so, add it to results. 
						} else if (dic.get(positionInAlphabet).contains(testString)) {
							results.add(testString);
						
						// Otherwise, testString is not in the dictionary, so add it to failed. 
						} else {
							failed.add(testString);
						}
					}
				}
			
			// When the waffle word is of length 1, just add letters to the end of the waffle word
			// to avoid testing duplicate strings. 
			} else {
				firstLetter = String.valueOf(waffleAtIndex.charAt(0));
				positionInAlphabet = alphabet.indexOf(firstLetter);

				// Determine if the result of adding a letter to the end of a
				// waffle word results in a dictionary word.
				for (int k = 0; k < 26; k++) {
					String test = currentWaffles.get(i) + String.valueOf(alphabet.charAt(k));

					if (dic.get(positionInAlphabet).contains(test)) {
						results.add(test);
					}
				}
			}
		}
		return results;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input = 0;
		
		System.out.println("Enter the length of the waffle words to be found. ");	
		
		// Make sure the input is a positive integer.
		while (input <= 0) {
			System.out.println("The length must be a positive integer.");
		    
			while (!scan.hasNextInt()) {
		        System.out.println("The length must be a positive integer.");
		        scan.next(); 
		    }
			input = scan.nextInt();
			
		}
		System.out.println("Finding waffle words...");

		ArrayList<String> waffleWords = new ArrayList<String>();

		// Populate waffleWords with letters of the alphabet that are words on their own:
		// "a" and "i".
		waffleWords.add("a");
		waffleWords.add("i");

		// Edit below to change which file is used to populate the dictionary and where the
		// program should look for the file. 
		// ********************************************************************************

			String desktop = System.getProperty("user.home") + "/Desktop/";
			File inputFile = new File(desktop + "english-words.txt");
		
		// ********************************************************************************
		
		Scanner in = null;

		try {
			in = new Scanner(inputFile);
		} catch (FileNotFoundException fnf) {
			System.out.println("Could not open input file.");
		}

		// An ArrayList of ArrayLists. The outer ArrayList is of size 26.
		// Each of the 26 inner ArrayLists corresponds to a respective letter of the alphabet.
		ArrayList<ArrayList<String>> dictionary = new ArrayList<ArrayList<String>>(26);

		// Populate dictionary with empty ArrayList<String> objects
		for (int i = 0; i < 26; i++) {
			ArrayList<String> singleLetterArray = new ArrayList<String>();
			dictionary.add(i, singleLetterArray);
		}

		// Populate dictionary
		int letterCount = -1;
		while (in.hasNext()) {
			String word = in.next();

			// Do not add single letter words to dictionary
			if (word.length() == 1) {
				letterCount++;

			} else {
				dictionary.get(letterCount).add(word);
			}
		}

		for (int i = 0; i < input - 1; i++) {
			waffleWords = getWaffleWords(waffleWords, dictionary);
		}
		
		Collections.sort(waffleWords);
		System.out.println("There are "+waffleWords.size()+" waffle words of length "+input+".");
		System.out.println("The waffle words of this length are:\n" + waffleWords.toString());
		scan.close();

	}

}
