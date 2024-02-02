package shapeExercise;

public class Tester {
	
	
	public static void main(String[] args) 
	{
		
		
		Circle circle = new Circle("Red", 5.0);
	    Triangle triangle = new Triangle("Blue", 4.0, 3.0);

	    System.out.println("Circle Area: " + circle.area());
	    System.out.println("Circle Color: " + circle.getColor());
	    System.out.println();
	    System.out.println("Triangle Area: " + triangle.area());
	    System.out.println("Triangle Color: " + triangle.getColor());
	    
	}

}
