package week2;

/**
* Example 1
* Simple program to demonstrate Bubble sort in java
* @author Abdul Razak
*
*/

public class BubbleSort {
// Default constructor
public BubbleSort() {
}

 // This is the method used for the Bubble sort.
// Notice the nested for loop.
 public void bubbleSort(int array[]) {
 int n = array.length;
 int k;
 for (int m = n; m >= 0; m--) {
 for (int i = 0; i < n - 1; i++) {
 k = i + 1;
 if (array[i] > array[k]) {
 swapNumbers(i, k, array);
 }
 }
 printNumbers(array);
 }
 }
 // This is a simple method to swap numbers

 public void swapNumbers(int i, int j, int[] array) {

 int temp;
 temp = array[i];
 array[i] = array[j];
 array[j] = temp;
 }

 // simple method to print the elements of the array

 public void printNumbers(int[] input) {

 for (int i = 0; i < input.length; i++) {
 System.out.print(input[i] + ", ");
 }
 System.out.println("\n");
 }

 // main method

 public static void main(String[] args) {

 //Creating instance of BubbleSort class
 BubbleSort bs= new BubbleSort();

 // declaring and initialising an array of integers with 9 elements
 int[] input = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };

 // Invoking the bubbleSort method
 bs.bubbleSort(input);

 }
}
