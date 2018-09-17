package practice;

//Problem Statement: Implement the insertion sort algorithm.

public class InsertionSorter {
	public static int[] insertionSort(int[] toSort){
		/* We will iterate through the array from the second element. Based on the insertion sort algorithm, the first
		 * element is automatically sorted.
		 */
		for(int i = 1; i < toSort.length; i++){
			int temp = toSort[i]; //We store the element we are inserting in the temp variable
			int compare = i - 1; //This value is the index of the element we are currently comparing to
			while(compare >= 0 && toSort[compare] > temp){
				/* This loop continues for as long as the elements are we compare against are larger than the value in
				 * the temp variable, or until we reach the end of the array.
				 */
				toSort[compare + 1] = toSort[compare]; //This shifts the current element one index higher in the array
				compare--; //We move one index closer to the beginning of the array
			}
			toSort[compare + 1] = temp; //We insert the value into the array
		}
		
		return(toSort);
	}

	public static void main(String[] args) {
		int[] testArray = {7,5,13,9,2,16,4,8};
		testArray = insertionSort(testArray);
		for(int i = 0; i < testArray.length; i++){
			System.out.print(testArray[i] + " ");
		}
	}	
}
