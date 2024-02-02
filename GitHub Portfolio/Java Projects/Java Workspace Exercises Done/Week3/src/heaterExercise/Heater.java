package heaterExercise;

public class Heater {
	
	private int min;
	private int max;
	private int temperature;
	private int increment;
	
	
	public Heater (int pMin, int pMax)
	{
		min = pMin;
		max = pMax;
		increment = 5;
		temperature = min + 10;
	}
	
	public int getTemperature()
	{
		return temperature;
	}
	
	public int getMin()
	{
		return min;
	}
	
	public int getMax()
	{
		return max;
	}
	public int getIncrement()
	{
		return increment;
	}
	
	
	public void setWarmer()
	{
		if (temperature <=(max-increment))
		{
			temperature = temperature + increment;
		}
		else if ((temperature > (max-increment)) && (temperature < max))
		{
			temperature = temperature + (max - temperature);
		}
	}
	
	public int getWarmer()
	{
		return temperature;
	}
	
	public void setCooler()
	{
		if (temperature >=(min+increment))
		{
			temperature = temperature - increment;
		}
		else if ((temperature < (min+increment)) && (temperature > min))
		{
			temperature = min;
		}
	}
	
	public int getCooler()
	{
		return temperature;
	}
	
	public void setIncrement(int newIncrement)
	{
		if (newIncrement > 0)
		{
			increment = newIncrement;
			
		}
	}
	
	
	
	
	public void printDetails()
	{	

		System.out.println("##############################################");
		System.out.println("# Actual Temperature: " + getTemperature() + " degrees celcius.");
		System.out.println("# Maximum temperature: " + getMax() + " degrees celcius.");
		System.out.println("# Minimum temperature: " + getMin() + " degrees celcius.");
		System.out.println("# Current increment: " + getIncrement() + " degrees celcius.");
		System.out.println("##############################################");
		
		
	}

}


