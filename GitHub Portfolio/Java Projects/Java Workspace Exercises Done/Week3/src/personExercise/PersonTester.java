package personExercise;

public class PersonTester {

	public static void main (String[] args)
	{
		
		Person p1;
		p1 = new Person("Naveed Sabir", 24);
		p1.printDetails();
		System.out.println("");
		System.out.println("#########################");
		System.out.println("# Changing details...");
		System.out.println("#########################");
		System.out.println("");
		p1.setName("Sami Ullah");
		p1.setAge(22);
		p1.printDetails();
		
		
	}
	
}
