package ar5main;

import ar5AbstractClasses.ToolAbstract;
import ar5ConcreteClasses.*;

public class UseTool {

	/**This is the main method
	 * @author Abdul Razak
	 * @param args
	 */
	public static void main(String[] args) {
		
//	It would be possible to have several implementations of tool 
//   assigned to the interface Tool
		
		ToolAbstract t = new ToolConcrete();
		t.push(20);
		t.rotate(30);
		t.bounce(3);
		t.flatten();
		t.pull(35);
	}
	
	

}
