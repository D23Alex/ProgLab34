import java.util.HashSet;

/**
 * Класс предоставляет функционал конкретной локации.
 * Сцена может содержать 1 или несколько таких локаций.
 * Локация имеет набор других локаций, куда можно пойти.
 * Локация имеет набор FairyTaleObject - Объектов, что в ней содержатся
 * @author Алексей
 *
 */
public class Location implements ILocation{
	
	/**
	 * Название этой локации в виде строки, например, "Комната Малыша" или "Крыша дома"
	 */
	private String name;
	
	/**
	 * список локаций, куда можно переместиться их этой локации
	 */
	private HashSet<ILocation> availableLocations;
	
	/**
	 * Объект сцены, к которой относится данная локация
	 */
	private IScene scene;
	
	/**
	 * множество объектов внутри этой локации 
	 * (сюда, разумеется, включены и все живые существа)
	 */
	private HashSet<IFairyTaleObject> objects;

	public Location(String name, HashSet<ILocation> availableLocations, IScene scene,
			HashSet<IFairyTaleObject> objects) {
		this.name = name;
		this.availableLocations = availableLocations;
		this.scene = scene;
		this.objects = objects;
	}

	public void addObject(IFairyTaleObject object) {
		this.objects.add(object);
	}

	/**
	 * Метод act 
	 */
	public void act(String text) {
		this.scene.act(this.getName() + " > " + text);
	}
	
	public void connect(ILocation location) {
		this.availableLocations.add(location);
		this.act("Локация " + this.getName() + " соединена с " + location.getName());
	}
	
	/**
	 * @Override
	 * строковое представление локации состоит из её названия,
	 * содержащихся в ней объектов, если таковые имеются,
	 * и соседних локаций, если таковые имеются
	 */
	public String toString() {
		String toReturn = "локация " + this.getName();
		
		if (!this.objects.isEmpty()) {
			toReturn += ", в которой есть:";
			int cntr = 0;
			for (IFairyTaleObject object : this.objects) {
				cntr ++;
				toReturn += cntr + ") " + object.getSceneName();
			}
		}
		
		if (!this.availableLocations.isEmpty()) {
			toReturn += ", из которой можно переместиться в:";
			int cntr = 0;
			for (ILocation location: this.availableLocations) {
				cntr ++;
				toReturn += cntr + ") " + location.getName();
			}
		}
		
		return toReturn;
	}

	public IScene getScene() {
		return scene;
	}

	public void setScene(IScene scene) {
		this.scene = scene;
	}

	public HashSet<IFairyTaleObject> getObjects() {
		return objects;
	}

	public void setObjects(HashSet<IFairyTaleObject> objects) {
		this.objects = objects;
	}

	public HashSet<ILocation> getAvailableLocations() {
		//TODO: вывести этот список в чат или что-то, хотя лучше не надо, пусть лучше когда человек осматривается
		return availableLocations;
	}

	public void setAvailableLocations(HashSet<ILocation> availableLocations) {
		this.availableLocations = availableLocations;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	

}
