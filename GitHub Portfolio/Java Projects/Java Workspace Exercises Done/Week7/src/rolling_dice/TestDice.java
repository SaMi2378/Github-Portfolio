package rolling_dice;

public class TestDice {

	
	
	public static void main(String args[]){
		// exercise 1 
		Dice d1 = new Dice();
		d1.roll();
		System.out.println(d1.getValue());
		d1.roll();
		System.out.println(d1.getValue());
		d1.roll();
		System.out.println(d1.getValue());

		
		
		// Rolling - exercise 2 with values 1-10.
		Dice d2 = new Dice();
		d2.roll10();
		System.out.println(d2.getValue());
		d2.roll10();
		System.out.println(d2.getValue());
		d2.roll10();
		System.out.println(d2.getValue());


		
		// Exercise 3
		Dice d3 = new Dice();
		d3.rollDice01(25);
		d3.rollDice02(2500);
		//
		
	}
	
	
}
