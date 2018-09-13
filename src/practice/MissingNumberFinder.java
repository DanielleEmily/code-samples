package practice;

import java.util.ArrayList;
import java.util.Arrays;

public class MissingNumberFinder {
	
	public static ArrayList<Integer> findMissingNumbers(int[] numberArray, int minValue, int maxValue){
		ArrayList<Integer> missingNumbers = new ArrayList<Integer>();
		Arrays.sort(numberArray); // Sorts the array into ascending order to make finding missing values much simpler
		
		/* First we check to see if the first number in the numberArray is equal to the minValue. This will tell us if the first
		 * element in the array is missing. If the first element is missing, we check the difference between the minValue and the
		 * first value in the array, and add the numbers from the minValue to the first value -1
		 */
		
		if(numberArray[0] > minValue){
			for(int num = minValue; num < numberArray[0]; num++){
				missingNumbers.add(num);
			}
		}
		
		/* Next, we step through the array to search for missing numbers. We check to see if the difference between subsequent
		 * elements in the array is greater than one, if so, we add all the missing numbers between the subsequent elements to
		 * the missingNumbers ArrayList. By only adding missing elements in the event that the difference is greater than one,
		 * we are able to handle duplicates in the array, as the difference between these elements will be 0
		 */
		
		for(int currentIndex = 0; currentIndex < numberArray.length - 1; currentIndex++){
			if((numberArray[currentIndex + 1] - numberArray[currentIndex]) > 1){
				for(int num = numberArray[currentIndex] + 1; num < numberArray[currentIndex + 1]; num++){
					missingNumbers.add(num);
				}
			}
		}
		
		/* Finally, if the last number in the numberArray is less than the max value, then we add all numbers between it and the
		 * max value to the missingNumbers ArrayList
		 */
		
		if(numberArray[numberArray.length -1] < maxValue){
			for(int num = numberArray[numberArray.length -1] + 1; num <= maxValue; num++){
				missingNumbers.add(num);
			}
		}
		
		return(missingNumbers); //Return the missingNumbers array list containing all the missing numbers
	}

	public static void main(String[] args) {
		int[] testArray = {4,6,9};
		ArrayList<Integer> missingNumbers = findMissingNumbers(testArray, 0, 12);
		System.out.println(missingNumbers);
	}
}
