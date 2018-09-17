package practice;

//Problem Statement: Implement the bubble sort algorithm.

public class BubbleSorter {
	public static int[] bubbleSort(int[] toSort){
		int length = toSort.length;
		boolean isSwapped = true; //Used to track if a swap has occurred
		while(isSwapped){
			isSwapped = false;
			/* If no swaps occur during an iteration of the while loop, the array is sorted and we can exit the
			 * while loop
			 */
			for(int i = 0; i < (length - 1); i++){
				/*We use this loop to compare each pair in the array, and swap them if the current element is
				 * greater than the following element. For this reason we stop before the end of the array to
				 * prevent an ArrayIndexOutOfBoundsException.
				 */
				if(toSort[i] > toSort[i + 1]){
					//Here we swap the two elements using a temporary variable to hold one of the values.
					int temp = toSort[i];
					toSort[i] = toSort[i + 1];
					toSort[i + 1] = temp;
					isSwapped = true; //A swap has occurred and so we cannot guarantee that the array is sorted
				}
			}
			length--; 
			/* Since the greatest element has been sorted to the end of the array, we no longer need to iterate to
			 * the end of the array
			 */
			if(length == 1){
				break; 
				//We exit the loop if the length we need to check will cause the for loop to exit without executing
			}
		}
		
		return(toSort);
	}

	public static void main(String[] args) {
		int[] testArray = {7,5,13,9,2,16,4,8};
		testArray = bubbleSort(testArray);
		for(int i = 0; i < testArray.length; i++){
			System.out.print(testArray[i] + " ");
		}
	}

}
