package week2;
import java.util.*;

/**
* Example 3
* Simple program to demonstrate sorting an ArrayList in java using
collections.sort
* @author Abdul Razak
*/
public class ArrayListSort {
	
	public static void main(String args[]){
		// Declaring an arrayList of integers
		// Notice the use of "Integer" wrapper class
		ArrayList<Integer> arraylist = new ArrayList<Integer>();

		// Initialising the elements

		arraylist.add(15);
		arraylist.add(5);
		arraylist.add(6);
		arraylist.add(2);

		/**
		 *  Printing the ArrayList elements before the sorting using a "for-each"loop
		 */

		System.out.println("Before Sorting:");
		for(int element: arraylist){
			System.out.println(element);
		}
		/* Sorting of ArrayList using Collections.sort*/

		Collections.sort(arraylist);
		/* Printing the ArrayList elements after sorting*/

		System.out.println();
		System.out.println("After Sorting:");
		for(int element: arraylist){
			System.out.println(element);
		}
	}
}