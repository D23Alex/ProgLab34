
public class AgeUndefined implements IAge {
	
	public AgeUndefined() {
		
	}

	public String getAgeString() {
		return "неизвестно";
	}

	public boolean isDefined() {
		return false;
	}

}
