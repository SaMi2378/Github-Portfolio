package array2;

/**
 * Simple class that records the name and age of a person
 * 
 * @author Abdul Razak 
 * @version 1.0
 */
public class Person
{
    // instance variables - replace the example below with your own
    private String name;
    private int age;

    /**
     * Constructor for objects of class Person
     */
    public Person()
    {
        // initialise instance variables
        name = "";
        age = 0;
    }

    /**
     * Parameter constructor for Person
     */
    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }
    
    /**
     * Set the person's name
     * 
     * @param  name   the new name to use
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * Get the person's name
     * 
     * @return the person's name 
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Set the person's age
     * 
     * @param  age  the person's age
     */
    public void setAge(int age)
    {
        this.age = age;
    }
    
    /**
     * Get the person's age
     * 
     * @return the person's age 
     */
    public int getAge()
    {
        return age;
    }
    
    /**
     * The string to use when printing out
     */
    public String toString()
    {
        return name + " (" + age + " years old)";
    }
}
