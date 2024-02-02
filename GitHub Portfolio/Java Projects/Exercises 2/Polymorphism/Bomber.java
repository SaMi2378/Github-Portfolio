/**
 * Write a description of class Bomber here.
 * 
 * @author Abdul Razak
 * @version 1.0
 */
public class Bomber extends Aircraft
{
    private int nbrBombs;

    /**
     * Constructor for objects of class Bomber
     */
    public Bomber()
    {
        super();
        nbrBombs = 10;
    }

    /**
     * Create a Bomber making sure that altitude, speed 
     * and nbrBombs are kept >= 0
     * 
     * @param altitude
     * @param speed
     * @param nbrBombs
     */
    public Bomber(int altitude, int speed, int nbrBombs) 
    {
        super(altitude, speed);
        setNbrBombs(nbrBombs);
    }

    /**
     * @return number of bombs onboard
     */
    public int getNbrBombs(){
        return nbrBombs;
    }

    /**
     * Set the number of bombs onboard ignore if
     * the actual parameter is <0
     * @param nbrBombs number of bombs
     */
    public void setNbrBombs(int nbrBombs)
    {
        if(nbrBombs >= 0){
            this.nbrBombs = nbrBombs;
        }
    }

    /**
     * Drop some bombs
     */
    public void dropBombs()
    {
        int nbrToDrop = (int) (Math.random() * 20 + 20);
        if(nbrToDrop >nbrBombs){
            nbrToDrop = nbrBombs;
        }
        if(nbrToDrop > 0){
            System.out.print("Bomber is dropping bombs ");
            for(int i = 0; i < nbrToDrop; i++){
                System.out.print("@");
                nbrBombs--;
            }
            System.out.println();
        }
        else {
            System.out.println("Bomber has no more bombs");
        }
    }

    public void useWeapons()
    {
        dropBombs(); // Call the existing dropBombs method
    }
    
    
    /**
     * Get description of a bomber
     */
    public String toString()
    {
        String s;
        s = "Bomber   ";
        s+= "[speed " + speed + " mph at altitude ";
        s += altitude + " ft] ";
        s += "has " + nbrBombs + " bombs left";
        return s;
    }

}
