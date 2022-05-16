import java.util.HashSet;

/**
 * ��������� ����� ������ �������� �� ���������� ����������� �������.
 * ����������� Null Object Pattern
 * @author �������
 *
 */
public class NoLocation extends Location {

	public NoLocation(String name, HashSet<ILocation> availableLocations, IScene scene,
			HashSet<IFairyTaleObject> objects) {
		super(name, availableLocations, scene, objects);
		this.setAvailableLocations(new HashSet<>());
		this.setName("�����");
		this.setScene(scene);
		this.setObjects(new HashSet<>());
	}

	public NoLocation(IScene scene) {
		super(null, null, null, null);
		this.setAvailableLocations(new HashSet<>());
		this.setName("�����");
		this.setScene(scene);
		this.setObjects(new HashSet<>());
	}



}
