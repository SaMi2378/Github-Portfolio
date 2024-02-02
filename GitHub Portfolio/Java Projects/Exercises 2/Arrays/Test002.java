import java.util.Random;

public class Test002 {
	
	private static final int NO_DOGS_IN_POUND = 200000;
	private static final int NO_REPORTED_LOST = 2000;
	private static final int RANGE = NO_DOGS_IN_POUND * 2;
	private static final Random rnd = new Random();
	private Dog dogPound[] = new Dog [NO_DOGS_IN_POUND];
	private Dog reportedLost[] = new Dog [NO_REPORTED_LOST];

	public Test002(){
		long id;
	
		
		for (int i = 0; i < NO_DOGS_IN_POUND; i++){
			
			id = Math.abs(rnd.nextInt()) % RANGE;
			dogPound[i] = new Dog(id, "");
		}
		for(int i = 0; i < NO_REPORTED_LOST; i++){
			id = Math.abs(rnd.nextInt()) % RANGE;
			reportedLost[i] = new Dog(id, "");
		}	
	}
	
	public void pause(long delay){
		try{
			Thread.sleep(delay);
			}
		catch (Exception e){
			e.printStackTrace();
		}
	}

	
}

