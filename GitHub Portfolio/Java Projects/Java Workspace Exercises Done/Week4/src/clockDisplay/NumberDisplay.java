package clockDisplay;
/**
 * The NumberDisplay class represents a digital number display that can hold
 * values from zero to a given limit. The limit can be specified when creating
 * the display. The values range from zero (inclusive) to limit-1. If used,
 * for example, for the seconds on a digital clock, the limit would be 60, 
 * resulting in display values from 0 to 59. When incremented, the display 
 * automatically rolls over to zero when reaching the limit.
 * 
 * @author A. Razak
 * @version 12/02/2023
 */
public class NumberDisplay
{
    private int limit;
    private int value;
    private int value2;
    /**
     * Constructor for objects of class NumberDisplay.
     * Set the limit at which the display rolls over.
     */
    public NumberDisplay(int rollOverLimit)
    {
        limit = rollOverLimit;
        value = 0;
        value2 = 0;
    }

    /**
     * Return the current value.
     */
    public int getValue()
    {
        return value;
    }

    /**
     * Return the display value (that is, the current value as a two-digit
     * String. If the value is less than ten, it will be padded with a leading
     * zero).
     */
    public String getDisplayValue()
    {
        if(value < 10) {
        	
            return "0" + value;
            
        }
        else {
        	 
            return "" + value;
        }
    }
        public void printDisplayValue(){
        	
        	if(value < 10) {
           	
               
               
           }
           else {
           
        }
        	
        
    }
        
     // this get display is for exercise 6   
        
        public String getDisplayValue2()
        {
            if(value  ==0) {
            	
                return "" + 12;
                
            }
            else if (value == 24)
            {
                	
                	return "" + 12;
            }
            else if (value <10)
            {
            	return "0" + value;
            }
            else
            {
            	return "" + value%12;
            	
            }
            	 
               
        }
            public void printDisplayValue2()
            {
            	
            	if(value < 10) 
            	{
         
                   
                }
                else 
                {
               
            	}
            	
        	}
        	
       	
    /**
     * Set the value of the display to the new specified value. If the new
     * value is less than zero or over the limit, do nothing.
     */
    public void setValue(int newValue)
    {
        if((newValue >= 0) && (newValue < limit)) {
            value = newValue;
        }
        
    }

    /**
     * Increment the display value by one, rolling over to zero if the
     * limit is reached.
     */
    public void increment()
    
    {
    	if ((value < limit-1))				// This is the same increment function created with if statement.
    	{									// First we put a condition that when the values is smaller than limit -1 (60-1=59) 
    		value = value + 1;				// then the value will be incremented by 1.
    	}									// for example the value is 58 which is less than 60 - 1 = 59 then we will add 1 
    	else if (value == (limit-1))		// the second condition is that when the value reaches the 59 or 23 near the limit,
    	{
	    		value = 0;					// the value resets to 00
	    		
    	}
    	else if (value >= 0)				// Then the last condition we have to put is that when the value is 0 or greater 
    	{
    		
    		value = value + 1;				// the value will increase by 1.
    	}
    	
    	
    	// value = (value + 1) % limit;    // this is the same function but using the modulo operator.
    }
    
    public void increment2()
    {
    	if (value >= 0 && value <limit)
    	{
    		value +=1;
    		value2 += 1;
    	}
    	else if (value >= 13)
    	{
    		value2 = value % 12;
    	}
    	else if (value == 0)
    	{
    		value2 = 12;
    		value2 +=1;
    		
    	}
    	
    }
    
}
