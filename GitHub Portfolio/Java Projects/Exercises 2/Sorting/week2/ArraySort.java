package week2;
import java.util.Arrays;

/**
* Example 2
* Simple program to demonstrate sorting an array in java using Arrays.sort
* @author Abdul Razak
*/
public class ArraySort {
 public static void main(String[] args) {
 // initialising unsorted array of integers called intArray

 int intArray[] = {2, 1, 6, 9, 4,-7,-4,5};
 // printing all the elements available in the array using the "for - each" loop

 System.out.println("The unsorted int array is:");
 for (int number : intArray) {
 System.out.println("Number = " + number);
 }
 // sorting the array using Arrays.sort()

 Arrays.sort(intArray);
 // printing all the elements available in the array after sorting

 System.out.println();
 System.out.println("The sorted int array is:");
 for (int number : intArray) {
 System.out.println("Number = " + number);
 }
 }
}