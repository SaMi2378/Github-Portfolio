//package ar5;

/**
 * Write a description of class Aircraft here.
 * 
 * @author Abdul Razak
 * @version 1.0
 */
public class Aircraft 
{
	protected int altitude = 0;
	protected int speed = 0;
	
	/**
	 * Set the aircraft stationary on the ground
	 */
	public Aircraft() 
	{
	}

	/**
	 * Make sure the aircraft is above ground and not
	 * going backwards.
	 * 
	 * @param altitude
	 * @param speed
	 */
	public Aircraft(int altitude, int speed) 
	{
		setAltitude(altitude);
		setSpeed(speed);
	}

	/**
	 * @return the altitude
	 */
	public int getAltitude() 
	{
		return altitude;
	}

	/**
	 * Make sure the aircraft at or above sea level
	 * @param altitude the altitude to set
	 */
	public void setAltitude(int altitude) 
	{
		if(altitude >= 0){
			this.altitude = altitude;
		}
	}

	/**
	 * Don't let the aircraft fly backwards
	 * @return the speed
	 */
	public int getSpeed() 
	{
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) 
	{
		if(speed >= 0){
			this.speed = speed;
		}
	}
}
