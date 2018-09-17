package practice;

//Problem Statement: Print all the duplicate characters in a string

import java.util.HashMap;
import java.util.Map;

public class DuplicateCharacterPrinter {
	public static void printDuplicateCharacters(String sample){
		System.out.println(sample);
		sample = sample.toLowerCase(); //This converts the sample string to lower case so that upper case letters do not disrupt the count.
		
		/* We create a HashMap as it allows direct access via the get and put methods in amortized constant time. This allows us to quickly
		 * determine which characters are already in the HashMap, and is faster than iterating through an array to see if a particular
		 * character has already been added, and incrementing its value if it has been.
		 */
		
		HashMap<Character, Integer> characterMap = new HashMap<Character, Integer>();
		for(int i = 0; i < sample.length(); i++){
			if(characterMap.containsKey(sample.charAt(i))){ //If a key with the same value as the current character exists
				characterMap.put(sample.charAt(i), characterMap.get(sample.charAt(i)) + 1); //We increment the value associated with that key
			}else{
				characterMap.put(sample.charAt(i), 1); //If there is no such key, we create one and set its associated value to 1
			}
		}
		
		for(Map.Entry<Character, Integer> currentEntry : characterMap.entrySet()){ //We iterate through each entry in the HashMap
			/* If the associated value of the current entry (or key/value pair) is greater than 1, then we know that character 
			 * was duplicated in the string, and so we print the key/value pair. This will display both the duplicated character,
			 * as well as the number of times it appeared in the string.
			 */
			if(currentEntry.getValue() > 1){ 
				System.out.println(currentEntry.getKey() + ": " + currentEntry.getValue());
			}
		}
	}

	public static void main(String[] args) {
		printDuplicateCharacters("Hello");
		System.out.println("--------------------");
		printDuplicateCharacters("printDuplicateCharacters");
		System.out.println("--------------------");
	}
	
}
