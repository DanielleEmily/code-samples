package practice;

//Find the middle element of a singly linked list in a single loop statement where the size of the linked list is not known.

import java.util.LinkedList;
import java.util.ListIterator;

public class MiddleLinkedElementFinder {
	private static class Result{
		/* This class exists to allow us to return the iterator which points to the middle element of the linked list, as
		 * well as whether or not the list is even. In this case the empty constructor and setters would not be used, and
		 * so they have not been included. Whether or not the list is even is important as it will change how we print
		 * the results. An even length LinkedList will have 2 middle elements, while an odd length LinkedList will have 1
		 */
		ListIterator<String> middleElement;
		boolean even;

		Result(ListIterator<String> iter, boolean even){
			this.middleElement = iter;
			this.even = even;
		}
		
		public ListIterator<String> getMiddleElement(){
			return(this.middleElement);
		}
		
		public boolean getIsEven(){
			return(this.even);
		}
	}
	
	public static Result findMiddleElement(LinkedList<String> elementList){
		//First we create 3 iterators, one to track the current middle node, one to track the previous middle node, and another to track the current node
		ListIterator<String> middleNode = elementList.listIterator();
		ListIterator<String> evenMiddleNode = elementList.listIterator(); //This is used in the case that the LinkedList has an even length
		ListIterator<String> currentNode = elementList.listIterator();
		int length = 0; //This is used to track the size of the LinkedList
		
		/* We cannot only use length and divide it by 2 to find the middle node, as returning either the middle node or the element stored in
		 * the middle node would require us to iterate through the LinkedList again to reach that point.
		 */
		
		while(currentNode.hasNext()){ //The loop will continue for as long as there are nodes in the linked list
			length++; //Increase the known length of the LinkedList
			if(length % 2 == 0){
				middleNode.next();
				if(length != 2){ //We skip the first time the MiddleNode iterator is moved to track the node behind it.
					evenMiddleNode.next();
				}
			}
			currentNode.next();
		}
		
		//We test the final length of the string to determine of it is even
		if(length % 2 == 0){
			Result finalResult = new Result(evenMiddleNode, true);
			/*When the size of the LinkedList is even, the element closer to the start of the list is returned. This will
			 * allow us to print both of the middle elements in an even length LinkedList.
			 */
			return(finalResult);
		}else{
			Result finalResult = new Result(middleNode, false);
			return(finalResult);
		}
	}
	
	public static void main(String[] args){
		LinkedList<String> oddList = new LinkedList<String>();
		oddList.add("Here");
		oddList.add("are");
		oddList.add("some");
		oddList.add("elements");
		oddList.add("for");
		oddList.add("the");
		oddList.add("LinkedList");
		Result testResult = findMiddleElement(oddList);
		if(testResult.getIsEven()){
			//By returning the element closer to the start of the list, both of the middle elements in an even length LinkedList can be printed
			System.out.println(testResult.getMiddleElement().next());
			System.out.println(testResult.getMiddleElement().next());
			System.out.println("--------------------");
		}else{
			//An odd length LinkedList will have a single middle element
			System.out.println(testResult.getMiddleElement().next());
			System.out.println("--------------------");
		}
		
		LinkedList<String> evenList = new LinkedList<String>();
		evenList.add("Here");
		evenList.add("are");
		evenList.add("some");
		evenList.add("more");
		evenList.add("elements");
		evenList.add("for");
		evenList.add("the");
		evenList.add("LinkedList");
		testResult = findMiddleElement(evenList);
		if(testResult.getIsEven()){
			System.out.println(testResult.getMiddleElement().next());
			System.out.println(testResult.getMiddleElement().next());
			System.out.println("--------------------");
		}else{
			System.out.println(testResult.getMiddleElement().next());
			System.out.println("--------------------");
		}
	}
}
