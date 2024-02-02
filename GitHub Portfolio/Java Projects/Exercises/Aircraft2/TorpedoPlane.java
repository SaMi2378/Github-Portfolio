/**
 * Write a description of class TorpedoPlane here.
 * 
 * @author Sami Ullah
 * @version 1.0 
 */
public class TorpedoPlane extends Aircraft {
	
	private int nbrTorps;
	
	/**
	 * Constructor for objects of class TorpedoPlane
	 */

	public TorpedoPlane()
	{
		super();
		nbrTorps = 100;
		
	}
	
	public TorpedoPlane(int altitude, int speed, int nbrTorps)
	{
		super(altitude, speed);
		setNbrTorps(nbrTorps);
		
	}
	
	public int getNbrTorps() {
		return nbrTorps;
	}
	
	public void setNbrTorps(int nbrTorps) {
		if (nbrTorps >= 0) {
			this.nbrTorps = nbrTorps;
		}
	}
	
	public void dropTorps()
	{
		int nbrFired = (int) (Math.random() * 0 + 1);
		if(nbrFired >nbrTorps){
			nbrFired = nbrTorps;
		}
		if(nbrFired > 0){
			System.out.print("TorpedoPlane is dropping torpedos ");
			for(int i = 0; i < nbrFired; i++){
				if(i % 4 == 0){
					System.out.print("+-> ");
				}
				nbrTorps--;
			}
			System.out.println();
		}
		else {
			System.out.println("TorpedoPlane is out of ammo");
		}
		
	}
	
	public String toString()
	{
		String s;
		s = "TorpedoPlane  ";
		s+= "[speed " + speed + " mph at altitude ";
		s += altitude + " ft] ";
		s += "has " + nbrTorps + " Torpedos left";
		return s;
	}

	
	
	
}
