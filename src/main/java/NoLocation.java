import java.util.HashSet;

/**
 * Ёкземпл€р этого класса отвечает за отсутствие определЄнной локации.
 * –еализуетс€ Null Object Pattern
 * @author јлексей
 *
 */
public class NoLocation extends Location {

	public NoLocation(String name, HashSet<ILocation> availableLocations, IScene scene,
			HashSet<IFairyTaleObject> objects) {
		super(name, availableLocations, scene, objects);
		this.setAvailableLocations(new HashSet<>());
		this.setName("нигде");
		this.setScene(scene);
		this.setObjects(new HashSet<>());
	}

	public NoLocation(IScene scene) {
		super(null, null, null, null);
		this.setAvailableLocations(new HashSet<>());
		this.setName("нигде");
		this.setScene(scene);
		this.setObjects(new HashSet<>());
	}



}
