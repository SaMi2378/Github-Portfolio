package aircraft2;


import java.util.ArrayList;



/**
 * Write a description of class TestAircraft here.
 * 
 * @author Abdul Razak
 * @version 1.0
 */
public class TestAircraft2
{
    // instance variables - replace the example below with your own
    private ArrayList<Fighter> fighters;
    private ArrayList<Bomber> bombers;
    private ArrayList<TorpedoPlane> torpedoPlanes;
    /**
     * Constructor for objects of class TestAircraft
     */
    public TestAircraft2()
    {
        // initialise instance variables
        fighters = new ArrayList<Fighter>();
        bombers = new ArrayList<Bomber>();   
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
        Fighter f;
        f = new Fighter(1000,230,500);
        fighters.add(f);
        f = new Fighter(900,330,440);
        fighters.add(f);
        f = new Fighter(220,120,450);
        fighters.add(f);
        f = new Fighter(1100,500,300);
        fighters.add(f);
        f = new Fighter(1000,230,560);
        fighters.add(f);
    }

    private void attackWithFighters()
    {
        for(Fighter f : fighters){
            f.fireGuns();
        }
    }

    private void displayFighters()
    {
        System.out.println("## Fighters ##");
        for(Fighter f : fighters){
            System.out.println(f);
        }
        System.out.println("-----------------------------");
    }

    private void createBombers()
    {
        bombers.clear();
        Bomber b;
        b = new Bomber(100, 230, 20);
        bombers.add(b);
        b = new Bomber(110, 280, 18);
        bombers.add(b);
        b = new Bomber(400, 300, 60);
        bombers.add(b);
        b = new Bomber(420, 290, 50);
        bombers.add(b);
        b = new Bomber(260, 290, 36);
        bombers.add(b);
    }

    private void attackWithBombers()
    {
        System.out.println("## Bombers Attack ##");
        for(Bomber b : bombers){
            b.dropBombs();
        }
    }

    private void displayBombers()
    {
        System.out.println("## Bombers ##");
        for(Bomber b : bombers){
            System.out.println(b);
        }
        System.out.println("-----------------------------");
    }
    
    
    private void createTorpedoPlanes()
    {
        torpedoPlanes.clear();
        TorpedoPlane t;
        t = new TorpedoPlane(100, 230, 30);
        torpedoPlanes.add(t);
        t = new TorpedoPlane(110, 280, 28);
        torpedoPlanes.add(t);
        t = new TorpedoPlane(400, 300, 90);
        torpedoPlanes.add(t);
        t = new TorpedoPlane(420, 290, 55);
        torpedoPlanes.add(t);
        t = new TorpedoPlane(260, 290, 36);
        torpedoPlanes.add(t);
    }

    private void attackWithTorpedoPlanes()
    {
        System.out.println("## TorpedoPlanes Attack ##");
        for(TorpedoPlane t : torpedoPlanes){
            t.dropTorp();
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
    	
    	TestAircraft2 ta = new TestAircraft2();
    	//ta.test_1();
    	ta.testFighters();
    	ta.testBombers();
    	ta.testTorpedoPlanes();
}}
