import java.util.Random;

/**
 * The TestAirfield class is used to test the AirField class
 * 
 * @author Abdul Razak
 * @version 1.0
 */
public class TestAirfield
{
    // instance variables - replace the example below with your own
    private Random rnd;

    /**
     * Constructor for objects of class TestAirfield
     */
    public TestAirfield()
    {
        rnd = new Random();
    }

    public void test_001()
    {
        Airfield af = new Airfield();
        addPlanes_A(af, 10);
        addMineLayers(af, 5); // Add MineLayer planes
        af.listAllPlanes();
        af.planesToAttack();
        af.listAllPlanes();        
    }

    private void addPlanes_A(Airfield af, int nbrPlanes)
    {
        int type;
        Fighter f;
        Bomber b;
        TorpedoPlane t;
        
        for(int i = 0; i < nbrPlanes; i++){
            type = rnd.nextInt(4);
            if(type == 0){
                f = new Fighter(rnd.nextInt(100)+80, rnd.nextInt(80)+200, rnd.nextInt(200) + 300);
                af.addFighter(f);
            }
            else if(type == 1) {
                b = new Bomber(rnd.nextInt(100)+80, rnd.nextInt(80)+200, rnd.nextInt(20) + 40);
                af.addBomber(b);

            }
            else {
                t = new TorpedoPlane(rnd.nextInt(100)+80, rnd.nextInt(80)+200, rnd.nextInt(4));
                af.addTorpedoPlane(t);
            }
        }
    }
/**
    public void test_001()
    {
        Airfield af = new Airfield();
        addPlanes_A(af, 10);
        addMineLayers(af, 5); // Add MineLayer planes
        af.listAllPlanes();
        af.planesToAttack();
        af.listAllPlanes();
    }
*/
    private void addMineLayers(Airfield af, int nbrPlanes)
    {
        MineLayer m;
        for (int i = 0; i < nbrPlanes; i++)
        {
            int altitude = rnd.nextInt(100) + 80;
            int speed = rnd.nextInt(80) + 200;
            int nbrMines = rnd.nextInt(15) + 10;
            m = new MineLayer(altitude, speed, nbrMines);
            af.addMineLayer(m); // Add the MineLayer to the airfield
        }
    }

    
    
    public static void main(String[] args)
    {
        TestAirfield test = new TestAirfield();
        test.test_001();
    }
    
}
