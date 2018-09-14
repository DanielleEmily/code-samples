package practice;

//Find the middle element of a singly linked list in a single pass where the size of the linked list is not known.

import java.util.LinkedList;
import java.util.ListIterator;

public class MiddleLinkedElementFinder {
	public static ListIterator<String> findMiddleElement(LinkedList<String> elementList){
		//First we create 3 iterators, one to track the current middle node, one to track the previous middle node, and another to track the current node
		ListIterator<String> middleNode = elementList.listIterator();
		ListIterator<String> prevMiddleNode = elementList.listIterator(); //This is used in the case that the LinkedList has an even length
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
					prevMiddleNode.next();
				}
			}
			currentNode.next();
		}
		//When the size of the LinkedList is even, the element closer to the start of the list is returned
		System.out.println(length);
		
		if(length % 2 == 1){
			return(middleNode);
		}else{
			return(prevMiddleNode);
		}
		
	}
	
	public static void main(String[] args){
		LinkedList<String> testList = new LinkedList<String>();
		testList.add("Here");
		testList.add("are");
		testList.add("some");
		testList.add("elements");
		testList.add("for");
		testList.add("the");
		//testList.add("LinkedList");
		ListIterator<String> testIterator = findMiddleElement(testList);
		System.out.println(testIterator.next());
	}
}
