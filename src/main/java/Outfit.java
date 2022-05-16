import java.util.HashSet;

/**
 * Класс реализует одеяние человека
 * @author Алексей
 *
 */
public class Outfit implements IOutfit{
	
	private String name;
	
	private String description;
	
	private HashSet<IEmotion> affectingEmotions;

	public Outfit(String name, String description, HashSet<IEmotion> affectingEmotions) {
		this.name = name;
		this.description = description;
		this.affectingEmotions = affectingEmotions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public HashSet<IEmotion> getAffectingEmotions() {
		return affectingEmotions;
	}

	public void setAffectingEmotions(HashSet<IEmotion> affectingEmotions) {
		this.affectingEmotions = affectingEmotions;
	}

	public void addEmotionalAffection(IEmotion emotion) {
		this.affectingEmotions.add(emotion);
	}
	
}