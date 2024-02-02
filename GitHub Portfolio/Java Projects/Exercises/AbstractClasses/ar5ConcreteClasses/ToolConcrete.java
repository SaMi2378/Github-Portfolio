package ar5ConcreteClasses;
import ar5AbstractClasses.*;
/**
 * This is the concrete class implementing the abstract methods
 * @author Abdul Razak
 *
 */

public class ToolConcrete extends ToolAbstract{

	@Override
	public boolean push(int millimeters) {
		System.out.println("Override Abstract Method - I am pushing "+millimeters+" Millimeters");
		return true;
	}

	@Override
	public boolean pull(int millimeters) {
		System.out.println("Implement Interface Method - I am pulling "+millimeters+" Millimeters");
		return true;
	}

	@Override
	public boolean rotate(int degrees) {
		System.out.println("Override Abstract Method - I am rotating "+degrees+" degrees");
		return true;
	}
}
