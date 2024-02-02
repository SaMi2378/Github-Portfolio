
/**
 * Write a description of class TorpedoPlane here.
 * 
 * @author Abdul Razak
 * @version 1
 */
public class TorpedoPlane extends Aircraft
{
     private int nbrTorps;

    /**
     * Constructor for objects of class TorpedoPlane
     */
    public TorpedoPlane()
    {
        super();
        nbrTorps = 10;
    }

    /**
     * Create a TorpedoPlane making sure that altitude, speed 
     * and nbrTorps are kept >= 0
     * 
     * @param altitude
     * @param speed
     * @param nbrTorps
     */
    public TorpedoPlane(int altitude, int speed, int nbrTorps) 
    {
        super(altitude, speed);
        setNbrTorps(nbrTorps);
    }

    /**
     * @return number of torpedos onboard
     */
    public int getNbrTorps(){
        return nbrTorps;
    }

    /**
     * Set the number of torpedos onboard ignore if
     * the actual parameter is <0
     * @param nbrTorps number of torpedos
     */
    public void setNbrTorps(int nbrTorps)
    {
        if(nbrTorps >= 0){
            this.nbrTorps = nbrTorps;
        }
    }

    /**
     * Drop a torpedo
     */
    public void dropTorp()
    {
        int nbrToDrop = (int) (Math.random() * 20 + 20);
        if(nbrToDrop >nbrTorps){
            nbrToDrop = nbrTorps;
        }
        if(nbrToDrop > 0){
            System.out.print("TorpedoPlane is dropping a torpedo ");
                System.out.println(" ==> ");
                nbrTorps--;
        }
        else {
            System.out.println("TorpedoPlane has no more torpedos");
        }
    }
    
    public void useWeapons()
    {
        dropTorp(); // Call the existing dropTorp method
    }

    /**
     * Get description of a TorpedoPlane
     */
    public String toString()
    {
        String s;
        s = "TorpedoPlane   ";
        s+= "[speed " + speed + " mph at altitude ";
        s += altitude + " ft] ";
        s += "has " + nbrTorps + " torpedoes left";
        return s;
    }

}
