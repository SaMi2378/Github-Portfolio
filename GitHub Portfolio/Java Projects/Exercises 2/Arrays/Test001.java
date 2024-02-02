
public class Test001 {
	
	public static void main(String[] args) {
		Dog d1 = new Dog(new Long(56498), "Fido"); 
		Dog d2 = new Dog(new Long(56498), "Rover");

		System.out.println(d1); 
		System.out.println(d2);

		if(d1.compareTo(d2) == 0) { 
			System.out.println("Same doggy");
		}
		else {
			
			System.out.println("Different doggy");
		}

	}

}
