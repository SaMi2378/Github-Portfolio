
public class Dog {
	private Long chipID;
	private String name;
	
	public Dog (Long chipID, String name) {
		
		this.chipID = chipID;
		this.name = name;
		
	}
	
	public String toString() {
		String s;
		s = name + " (" + chipID + ")";
		return s;
	}
	
	public int compareTo(Object obj) {
		Dog d = (Dog) obj;
		if(d == null)
			return 1;
		else
		return name.compareTo(d.name);
	}
	
}
