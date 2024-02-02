import java.util.ArrayList;



public class TestClass {

	
			private ArrayList<Fighter2> fighters;
		    private ArrayList<Bomber2> bombers;
		    private ArrayList<TorpedoPlane> torpedoPlanes;
		    /**
		     * Constructor for objects of class TestAircraft
		     */

		    public TestClass()
		    {
		        // initialise instance variables
		        fighters = new ArrayList<Fighter2>();
		        bombers = new ArrayList<Bomber2>();   
		        torpedoPlanes = new ArrayList<TorpedoPlane>();
		    }
		
	
		    public void test_1()
		    {
		        createFighters();
		        displayFighters();  
		        createBombers();
		        displayBombers();
		    }

		    public void testFighters()
		    {
		        createFighters();
		        displayFighters();  
		        attackWithFighters();
		        displayFighters();
		    }

		    public void testBombers()
		    {
		        createBombers();
		        displayBombers();
		        attackWithBombers();
		        displayBombers();
		    }
		    
		    public void testTorpedoPlanes()
		    {
		        createTorpedoPlanes();
		        displayTorpedoPlanes();
		        attackWithTorpedoPlanes();
		        displayTorpedoPlanes();
		    }
		    

		    private void createFighters()
		    {
		        fighters.clear();
		        Fighter2 f;
		        f = new Fighter2(1000,230,500);
		        fighters.add(f);
		        f = new Fighter2(900,330,440);
		        fighters.add(f);
		        f = new Fighter2(220,120,450);
		        fighters.add(f);
		        f = new Fighter2(1100,500,300);
		        fighters.add(f);
		        f = new Fighter2(1000,230,560);
		        fighters.add(f);
		    }

		    private void attackWithFighters()
		    {
		        for(Fighter2 f : fighters){
		            f.fireGuns();
		        }
		    }

		    private void displayFighters()
		    {
		        System.out.println("## Fighters ##");
		        for(Fighter2 f : fighters){
		            System.out.println(f);
		        }
		        System.out.println("-----------------------------");
		    }

		    private void createBombers()
		    {
		        bombers.clear();
		        Bomber2 b;
		        b = new Bomber2(100, 230, 20);
		        bombers.add(b);
		        b = new Bomber2(110, 280, 18);
		        bombers.add(b);
		        b = new Bomber2(400, 300, 60);
		        bombers.add(b);
		        b = new Bomber2(420, 290, 50);
		        bombers.add(b);
		        b = new Bomber2(260, 290, 36);
		        bombers.add(b);
		    }

		    private void attackWithBombers()
		    {
		        System.out.println("## Bombers Attack ##");
		        for(Bomber2 b : bombers){
		            b.dropBombs();
		        }
		    }

		    private void displayBombers()
		    {
		        System.out.println("## Bombers ##");
		        for(Bomber2 b : bombers){
		            System.out.println(b);
		        }
		        System.out.println("-----------------------------");
		    }
		    
		    
		    private void createTorpedoPlanes()
		    {
		        torpedoPlanes.clear();
		        TorpedoPlane t;
		        t = new TorpedoPlane(100, 230, 10);
		        torpedoPlanes.add(t);
		        t = new TorpedoPlane(110, 280, 10);
		        torpedoPlanes.add(t);
		        t = new TorpedoPlane(400, 300, 10);
		        torpedoPlanes.add(t);
		        t = new TorpedoPlane(420, 290, 10);
		        torpedoPlanes.add(t);
		        t = new TorpedoPlane(260, 290, 10);
		        torpedoPlanes.add(t);
		    }

		    private void attackWithTorpedoPlanes()
		    {
		        System.out.println("## TorpedoPlanes Attack ##");
		        for(TorpedoPlane t : torpedoPlanes){
		            t.dropTorps();
		        }
		    }

		    private void displayTorpedoPlanes()
		    {
		        System.out.println("## TorpedoPlanes ##");
		        for(TorpedoPlane t : torpedoPlanes){
		            System.out.println(t);
		        }
		        System.out.println("-----------------------------");
		    }
		    
		    
		    public static void main(String[] args) {
		    	
		    	TestClass ta = new TestClass();
		    	//ta.test_1();
		    	ta.testFighters();
		    	ta.testBombers();
		    	ta.testTorpedoPlanes();
		    }
}

