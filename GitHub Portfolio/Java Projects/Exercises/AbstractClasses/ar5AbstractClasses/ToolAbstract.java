package ar5AbstractClasses;
import ar5Interfaces.ToolInterface;
/**
 * This is the abstract class containing two abstract methods and two concrete methods.
 * 
 * @author Abdul Razak
 *
 */
public abstract class ToolAbstract implements ToolInterface {
	
	// the abstract keyword is assumed in an interface declaration
	
		public abstract boolean push(int millimeters);
		
		public abstract boolean rotate(int degrees);

		public boolean flatten() {
			System.out.println("Default Abstract Method - I am Flattening");
			return true;
		}
		public boolean bounce(int times) {
			System.out.println("Default Abstract Method - I am Bouncing "+times+" Times");
			return true;
		}
	}

