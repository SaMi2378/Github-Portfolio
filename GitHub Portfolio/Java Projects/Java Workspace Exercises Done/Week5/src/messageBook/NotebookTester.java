package messageBook;

/**
 * A tester class to test the Notebook class's methods.
 * @author Abdul Razak
 * version 19/02/2023
 */


public class NotebookTester
{
	public static void main(String args[]){
		
		
		
	Notebook myNotebook = new Notebook(); //Creating object of type Notebook.

	//Exercise 1: I have provided the solution for this exercise.
	//Invoking (calling) various methods.
	
	System.out.println("*** [Exercise 1] ***");
	myNotebook.storeMessage("Buy bread.");
	myNotebook.storeMessage("Charge phone.");
	myNotebook.storeMessage("Meet Abdul in class at 9.00 am.");
	myNotebook.storeMessage("Meet Andrew in class at 02.00 pm.");
	myNotebook.storeMessage("Complete and submit the worksheet.");
	myNotebook.storeMessage("Gio Naveed.");
	myNotebook.storeMessage("Today is a new day, make it count.");
	myNotebook.storeMessage("The only way to do great work is to love what you do.");
	myNotebook.storeMessage("chiachu.");
	myNotebook.numberOfMessages();
	myNotebook.printNumberOfMessages();
	myNotebook.showMessage(2);
	myNotebook.showMessage(4);
	myNotebook.showMessage(3);
	myNotebook.showMessage(0);
	myNotebook.showMessage(1);
	myNotebook.showMessage(5);
	myNotebook.showMessage(6);
	myNotebook.showMessage(8);
	myNotebook.showMessage(7);
	
	
	// Please refer to Collection Worksheet to complete the exercises below.
	
	//Exercise 2
	System.out.println("");
	System.out.println("*** [Exercise 2] ***");
	myNotebook.removeMessage(5);
	myNotebook.showMessage(5);
	myNotebook.removeMessage(61);

	/* Question of Exercise 2
	 * If we input invalid index values, it doesn't do anything. 
	 * After we modify the code, it will print out an Error message 
	 */
	
	
	//Exercise 3
	System.out.println("");
	System.out.println("*** [Exercise 3 - Notebook 2] ***");
	Notebook myNotebook2 = new Notebook();
	myNotebook2.storeMessage("Go home early!");
	myNotebook2.storeMessage("Naveed pagal a pura.");
	myNotebook2.storeMessage("Have an appointment with the GP.");
	myNotebook2.storeMessage("Get appointment to do the knowledge test Wolvehampton.");
	myNotebook2.storeMessage("Naveed Mercedes Yaris driver.");
	myNotebook2.listMessagesForEach();
	
	
	
	
	//Exercise 4
	
	System.out.println("");
	System.out.println("*** [Exercise 4 - Notebook 3] ***");
	Notebook myNotebook3 = new Notebook();
	myNotebook3.storeMessage("Do all the weekly tasks.");
	myNotebook3.storeMessage("The quick brown fox jumps over the lazy dog.");
	myNotebook3.storeMessage("Start the mock assignment.");
	myNotebook3.storeMessage("Study harder than before.");
	myNotebook3.storeMessage("Organize the time better.");
	myNotebook3.listMessagesWhile();
	
	/* Question of Exercise 3
	 * Answer: If we set the index value to 3, then the system will only print
	 * the messages which are written from the 3rd position to onwards.
	 * For example in this case, if we use index=3, only the last two lines of the notebook will be printed. 
	 * */
	
	//Exercise 5
	System.out.println("");
	System.out.println("*** [Exercise 5 - Notebook 4] ***");
	Notebook myNotebook4 = new Notebook();
	myNotebook4.storeMessage("Get the car serviced.");
	myNotebook4.storeMessage("Shopping in Liverpool.");
	myNotebook4.storeMessage("Meet at Liverpool station.");
	myNotebook4.storeMessage("Must meet with Abdul.");
	myNotebook4.storeMessage("Get the carpet cleaned.");
	myNotebook4.listMessagesWhile();
	myNotebook4.hasMessage("Liverpool");
	myNotebook4.hasMessage("meet");
	myNotebook4.hasMessage("car");
	myNotebook4.hasMessage("pool");
	
	/* Question of Exercise 5
	 * The contains method, searches in all the lenght and all the lines of the notebook, 
	 * if there is a word same to the one which the user has input, then it will return true. 
	 * In case the word is not in the messages, it will show false.
	 */
	
	//exercise 6
	
	System.out.println("");
	System.out.println("*** [Exercise 6 - Notebook 5] ***");
	Notebook myNotebook5 = new Notebook();
	myNotebook5.storeMessage("Get the car serviced.");
	myNotebook5.storeMessage("Shopping in Liverpool.");
	myNotebook5.storeMessage("Meet at Liverpool station.");
	myNotebook5.storeMessage("Must meet with Abdul.");
	myNotebook5.storeMessage("Get the carpet cleaned.");
	myNotebook5.listMessagesWhile();
	myNotebook5.showMessages("Manchester");
	myNotebook5.showMessages("meet");
	myNotebook5.showMessages("car");
	myNotebook5.showMessages("pool");
	
	
	}
	
}