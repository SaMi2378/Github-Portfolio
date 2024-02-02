package personExercise;

public class Person {
	
	private String name;
	private int age;
	
	
	public Person (String insertName, int insertAge)
	{
		name = insertName;
		age = insertAge;
		
	}
	
	public void setName (String newName)
	{
		name = newName;
	}
	
	public String getName()
	{
		return name;
	}
		
	public void setAge (int newAge)
	{
		age = newAge;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public void printDetails()
	{
		System.out.println("##################################");
		System.out.println("# Printing details of the person...");
		System.out.println("##################################");
		System.out.println("# Name: " + getName() );
		System.out.println("# Age: " + getAge() );
		System.out.println("##################################");
	}
	
	
}
