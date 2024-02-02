//package ar5;

/**
 * Write a description of class Bomber here.
 * 
 * @author Abdul Razak 
 * @version 1.0
 */
public class Bomber
{
    // instance variables - replace the example below with your own
    private int altitude = 0;
    private int speed = 0;
    private int nbrBombs = 10;

    /**
     * Constructor for objects of class Bomber
     */
    public Bomber()
    {
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
        if(altitude > 0){
            this.altitude = altitude;
        }
        if(speed > 0){
            this.speed = speed;
        }
        if(nbrBombs > 0){
            this.nbrBombs = nbrBombs;
        }
    }

    /**
     * @return the altitude
     */
    public int getAltitude() 
    {
        return altitude;
    }

    /**
     * Make sure aircraft is above gorund
     * @param altitude the altitude to set
     */
    public void setAltitude(int altitude) 
    {
        if(altitude > 0){
            this.altitude = altitude;
        }
    }

    /**
     * @return the speed
     */
    public int getSpeed() 
    {
        return speed;
    }

    /**
     * Make sure the aircraft is not going backwards
     * @param speed the speed to set
     */
    public void setSpeed(int speed) 
    {
        if(speed > 0){
            this.speed = speed;
        }
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
