package aircraft2;


/**
 * Write a description of class Fighter here.
 * 
 * @author Abdul Razak 
 * @version 1.0
 */
public class Fighter extends Aircraft
{

	private int nbrBullets;

	/**
	 * Constructor for objects of class Fighter
	 */
	public Fighter()
	{
		super();
		nbrBullets = 600;
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
		super(altitude, speed);
		setNbrBullets(nbrBullets);
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
