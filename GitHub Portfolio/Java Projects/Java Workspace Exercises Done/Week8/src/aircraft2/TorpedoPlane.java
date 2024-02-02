package aircraft2;

public class TorpedoPlane extends Aircraft
{
	private int nbrTorp;
	
	public TorpedoPlane()
	{
		super();
		nbrTorp = 100;
	}
	
	public TorpedoPlane(int altitude, int speed, int nbrTorp)
	{
		super(altitude, speed);
		setNbrTorp(nbrTorp);
	}
	
	public int getNbrTorp()
	{
		return nbrTorp;
	}
	
	public void setNbrTorp(int nbrTorp)
	{
		if(nbrTorp >=0)
		{
			this.nbrTorp = nbrTorp;
		}
	}
	public void dropTorp()
    {
		int nbrToFire = (int) (Math.random() * 7 + 15);
		if(nbrToFire > nbrTorp)
		{
			nbrToFire = nbrTorp;
		}
		if(nbrToFire > 0){
			System.out.print("TorpedoPlane is dropping a torpedo ");
			for(int i = 0; i < nbrToFire; i++){
				System.out.print("+-> ");
				nbrTorp--;
			}
			System.out.println();
		}
		else 
		{
			System.out.println("TorpedoPlane has no more torpedos.");
		}
    }

	 public String toString()
	    {
	        String s;
	        s = "TorpedoPlane   ";
	        s+= "[speed " + speed + " mph at altitude ";
	        s += altitude + " ft] ";
	        s += "has " + nbrTorp + " torpedos left";
	        return s;
	
	    }
}
