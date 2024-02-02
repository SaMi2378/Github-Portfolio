import java.util.ArrayList;

/**
 * This class represents an Airfield in a World War 2 air warfare game.
 * 
 * Although the Fighter, Bomber and TorpedoPlane classes all inherit from
 * Aircraft there is no attempt to use polymorphism and the class has 3
 * ArrayLists one for each type of aircraft.
 * 
 * 
 * @author Abdul Razak
 * @version 1.0
 */
public class Airfield
{
    private ArrayList<Fighter> fighters;
    private ArrayList<Bomber> bombers;
    private ArrayList<TorpedoPlane> torpPlanes;
    private ArrayList<MineLayer> mineLayers;		// Added field for MineLayer planes
    
    /**
     * Constructor for objects of class Airfield
     */
    public Airfield()
    {
        fighters = new ArrayList<Fighter>();
        bombers = new ArrayList<Bomber>();
        torpPlanes = new ArrayList<TorpedoPlane>();
        mineLayers = new ArrayList<MineLayer>();   // Initialize the MineLayer ArrayList
        
    }

    /**
     * Print a list of all aircraft at this airfield
     */
    public void listAllPlanes()
    {
        System.out.println("### Aircraft at this airfield ###");
        for(Fighter f : fighters){
            System.out.println(f);
        }
        for(Bomber b : bombers){
            System.out.println(b);
        }
        for(TorpedoPlane t : torpPlanes){
            System.out.println(t);
        }
        for (MineLayer m : mineLayers) // Include MineLayer planes in the listing
        {
            System.out.println(m);
        }
        System.out.println("#############################");
    }

    /**
     * Method to add a Fighter to this Airfield
     * @param f the Fighter object to add
     */
    public void addFighter(Fighter f)
    {
        fighters.add(f);
    }

    /**
     * Method to add a Bomber to this Airfield
     *
     * @param b the Bomber object to add
     */
    public void addBomber(Bomber b)
    {
        bombers.add(b);
    }

     /**
     * Method to add a TorpedoPlane to this Airfield
     * @param t the TorpedoPlane object to add
     */
   public void addTorpedoPlane(TorpedoPlane t)
    {
        torpPlanes.add(t);
    }

   
   /**
    * Method to add a MineLayer to this Airfield
    * 
    * @param m the MineLayer object to add
    */
   public void addMineLayer(MineLayer m)
   {
       mineLayers.add(m);
   }
   
    /**
     * Any plane flying above 120 feet and more than 100mph should
     * use their weapons.
     */
    public void planesToAttack()
    {
        System.out.println("### Aircraft attacking ###");
        for(Fighter f : fighters){
            if(f.getSpeed() > 100 && f.getAltitude() > 120) {
                f.fireGuns();
            }
        }
        for(Bomber b : bombers){
            if(b.getSpeed() > 100 && b.getAltitude() > 120) {
                b.dropBombs();
            }
        }
        for(TorpedoPlane t : torpPlanes){
            if(t.getSpeed() > 100 && t.getAltitude() > 120) {
                t.dropTorp();
            }
        }
        
        for (MineLayer m : mineLayers)
        {
            if (m.getSpeed() > 100 && m.getAltitude() > 120)
            {
                m.dropMine();
            }
        }
        
        System.out.println("#############################");
    }

}
