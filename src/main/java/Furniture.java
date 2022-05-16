import java.util.HashSet;

public class Furniture extends FairyTaleObject {
	
	public enum FurnitureType {
		FIREPLACE("камин"),
		TABLE("стол"),
		SOFA("диван");
		private String name;
		FurnitureType(String name){
	        this.name = name;
	    }
	    public String getName(){ return name;}
	}
	
	private FurnitureType type;
	
	private Color color;

	

	public Furniture(HashSet<IEmotion> emotionalAffection, IMovingStrategy movingStrategy, ILocation location,
			IFairyTaleObject objectNearby, Furniture.FurnitureType type, Color color) {
		super(emotionalAffection, movingStrategy, location, objectNearby);
		this.type = type;
		this.color = color;
	}

	public String getSceneName() {
		return this.toString();
	}
	
	@Override
	public String toString() {
		return this.type.getName() + " цвета " + this.color;
	}

	public FurnitureType getType() {
		return type;
	}

	public void setType(FurnitureType type) {
		this.type = type;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
