
public class AgeDefined extends Age {
	private int age;
	
	AgeDefined(int age) {
		this.age = age;
	}

	public String getAgeString() {
		return "" + this.age;
	}

	public boolean isDefined() {
		return true;
	}

}
