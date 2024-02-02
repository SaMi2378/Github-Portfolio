package week2;
import java.util.*;

/**
* Example 5
* Simple program to demonstrate searching an ArrayList in java using Collection.binarySearch()
* @author Abdul Razak
*/
	public class ArrayListSearch {
		public static void main(String args[]) {

			// create an ArrayList of Strings

			ArrayList<String> myList=new ArrayList<String>();

			// populate the ArrayList with String elements

			myList.add("Data");
			myList.add("Structures");
			myList.add("and");
			myList.add("Algorithms");
			myList.add("is");
			myList.add("Fun");

			// search the list for the element 'Structures'

			int index=Collections.binarySearch(myList, "Structures");

			// displaying the index of the search element "Structures".

			System.out.println("'Structures' is available at index: "+index);
		}
}