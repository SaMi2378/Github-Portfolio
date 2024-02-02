package bookExercise;
/**
 * A class that maintains information on a book.
 * This might form part of a larger application such
 * as a library system, for instance.
 *
 * @author (Insert your name here.)
 * @version (Insert today's date here.)
 */
public class Book
{
    // The fields.
    private String author;
    private String title;
    private int pages;
    private String refNumber;
    private int borrowed;
        

    /**
     * The constructor - set the author and title fields when this object
     * is constructed.
     */
    
    public Book(String bookAuthor, String bookTitle)
    {
        author = bookAuthor;
        title = bookTitle;
        refNumber = "";
        borrowed = 0;
    }

    // Add the methods here ...
    
    public void setPages(int newPages)
    {
    	pages = newPages;
    	
    }
    
    public int getPages()
    
    {
    	return pages;
    	
    }
    
    public void setRefNumber(String newRefNumber)
    {
    	
    	

    	System.out.println("##############################");
    	System.out.println("# Inserting Reference Number....");
    	if (newRefNumber.length() > 3 )
    	{
    		refNumber = newRefNumber;
    		
    		System.out.println("# Reference number inserted Succesfully...!");

    		System.out.println("##############################");
    		System.out.println("");
    	}
    	else
    	{
    		System.out.println("# ERROR!! The reference number must have more than 3 numbers...");
    		System.out.println("##############################");
    		System.out.println("");
    	};

    	
    }

    public String getRefNumber()
    {
        return refNumber;
    }
    
    
    public void setBorrowed()
    {	
    	
    	borrowed += 1;
    }
    public int getBorrowed()
    {
    	return borrowed;
    }
    
    
    public void printDetails()
    {
    	System.out.println("##############################");
    	System.out.println("# Book Details...");
    	System.out.println("# The Title --> " + title + ".");
    	System.out.println("# The Author of the book --> " + author+".");
    	System.out.println("# The book has got " + getPages()+ " pages.");
    	if (refNumber.length() == 0) 
    	{
    		System.out.println("# Book Reference Number: ???" ); 		
    	}
    	else
    	{
    		System.out.println("# Book Reference Number: "+ getRefNumber() ); 		
    		
    	};
    	System.out.println("# The book has been borrowed " + getBorrowed()+ " times.");
    	System.out.println("##############################");
    		
    	
    }
    
    public void printBookAuthor()
    {
    	System.out.println("The Author of the book is: "+ author);
    }
    
    public void printBookTitle()
    {
    	System.out.println("The title of the book is: "+ title);
    }
    
}
