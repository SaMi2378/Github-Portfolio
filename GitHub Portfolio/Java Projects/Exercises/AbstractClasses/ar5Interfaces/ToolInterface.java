package ar5Interfaces;
/**
 * This is the interface containing three methods(all abstract by default).
 * @author Abdul Razak
 *
 */
public interface ToolInterface {
	
	// the abstract keyword is assumed in an interface declaration
	
		public  boolean pull(int millimeters);
		public  boolean bounce(int meters);
		public  boolean flatten();
	}
