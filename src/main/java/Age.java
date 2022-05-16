
public abstract class Age implements IAge, Comparable<IAge> {
	
	public int compareTo(IAge o) {
		return Integer.parseInt(this.getAgeString()) - Integer.parseInt(o.getAgeString());
	}
	
	@Override
	public String toString() {
		return this.getAgeString();
	}
	
}
