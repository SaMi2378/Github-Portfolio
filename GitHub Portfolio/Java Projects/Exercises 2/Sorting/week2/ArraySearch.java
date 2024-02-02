package week2;
import java.util.Arrays;

/**
* Example 4
* Simple program to demonstrate searching an array in java using
Arrays.binarySearch()
* @author Abdul Razak
*/
	public class ArraySearch {
		public static void main(String[] args) {
			// initialising unsorted array of integers.

			int intArray[] = {36,27,15,3,7,9,50,45};
			// sorting the array

			Arrays.sort(intArray);

			// printing all the elements available in the array using a"for-each" loop

			System.out.println("The sorted int array is:");
			for (int number : intArray) {
				System.out.println("Number = " + number);
			}
			// entering the value to be searched

			int searchValue = 15;
			// finding the index of the search value in the array.

			int index = Arrays.binarySearch(intArray,searchValue);
			System.out.println("The index of element 15 is : " + index);
		}
}