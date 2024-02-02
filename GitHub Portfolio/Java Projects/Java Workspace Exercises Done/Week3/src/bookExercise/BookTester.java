package bookExercise;
/**
 * Tester class
 * @author 
 *
 */
public class BookTester {
	
	/**
	 * The maim method.
	 * @param args
	 */
	 public static void main (String[] args)
	 {
		 
		 //add the code here.
		 
		 Book bk1;
		 bk1 = new Book("Naveed Sabir", "Rules of Life");
		 
		 bk1.printBookTitle();
		 bk1.printBookAuthor();
		 bk1.setPages(37);
		 
		 System.out.println("");
		 System.out.println("");
		 bk1.setRefNumber("31742");
		 bk1.setBorrowed();
		 bk1.setBorrowed();
		 bk1.printDetails();
		 
	 }	 
	 
}