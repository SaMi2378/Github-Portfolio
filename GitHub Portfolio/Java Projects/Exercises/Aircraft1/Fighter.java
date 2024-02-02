//package ar5;

/**
 * Write a description of class Fighter here.
 * 
 * @author Abdul Razak
 * @version 1.0
 */
public class Fighter
{

	private int altitude = 0;
	private int speed = 0;
	private int nbrBullets = 600;

	/**
	 * Constructor for objects of class Fighter
	 */
	public Fighter()
	{
	}

	/**
	 * Create a Fighter making sure that altitude, speed 
	 * and nbrBullets are kept >= 0
	 * 
	 * @param altitude
	 * @param speed
	 * @param nbrBullets
	 */
	public Fighter(int altitude, int speed, int nbrBullets)
	{
		if(altitude > 0){
			this.altitude = altitude;
		}
		if(speed > 0){
			this.speed = speed;
		}
		if(nbrBullets > 0){
			this.nbrBullets = nbrBullets;
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
     * @return number of bullets onboard
     */
    public int getNbrBullets(){
        return nbrBullets;
    }

    /**
     * Set the number of bullets onboard ignore if
     * the actual parameter is <0
     * @param nbrBullets number of bombs
     */
    public void setNbrBullets(int nbrBullets)
    {
        if(nbrBullets >= 0){
            this.nbrBullets = nbrBullets;
        }
    }

	/**
	 * Fire the fighter's machine guns
	 */
	public void fireGuns()
	{
		int nbrFired = (int) (Math.random() * 100 + 80);
		if(nbrFired >nbrBullets){
			nbrFired = nbrBullets;
		}
		if(nbrFired > 0){
			System.out.print("Fighter is shooting");
			for(int i = 0; i < nbrFired; i++){
				if(i % 4 == 0){
					System.out.print(":");
				}
				nbrBullets--;
			}
			System.out.println();
		}
		else {
			System.out.println("Fighter is out of ammo");
		}
	}

	/**
	 * Get description of a fighter
	 */
	public String toString()
	{
		String s;
		s = "Fighter  ";
		s+= "[speed " + speed + " mph at altitude ";
		s += altitude + " ft] ";
		s += "has " + nbrBullets + " bullets left";
		return s;
	}

}