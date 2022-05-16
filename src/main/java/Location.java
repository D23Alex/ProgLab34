import java.util.HashSet;

/**
 * ����� ������������� ���������� ���������� �������.
 * ����� ����� ��������� 1 ��� ��������� ����� �������.
 * ������� ����� ����� ������ �������, ���� ����� �����.
 * ������� ����� ����� FairyTaleObject - ��������, ��� � ��� ����������
 * @author �������
 *
 */
public class Location implements ILocation{
	
	/**
	 * �������� ���� ������� � ���� ������, ��������, "������� ������" ��� "����� ����"
	 */
	private String name;
	
	/**
	 * ������ �������, ���� ����� ������������� �� ���� �������
	 */
	private HashSet<ILocation> availableLocations;
	
	/**
	 * ������ �����, � ������� ��������� ������ �������
	 */
	private IScene scene;
	
	/**
	 * ��������� �������� ������ ���� ������� 
	 * (����, ����������, �������� � ��� ����� ��������)
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
	 * ����� act 
	 */
	public void act(String text) {
		this.scene.act(this.getName() + " > " + text);
	}
	
	public void connect(ILocation location) {
		this.availableLocations.add(location);
		this.act("������� " + this.getName() + " ��������� � " + location.getName());
	}
	
	/**
	 * @Override
	 * ��������� ������������� ������� ������� �� � ��������,
	 * ������������ � ��� ��������, ���� ������� �������,
	 * � �������� �������, ���� ������� �������
	 */
	public String toString() {
		String toReturn = "������� " + this.getName();
		
		if (!this.objects.isEmpty()) {
			toReturn += ", � ������� ����:";
			int cntr = 0;
			for (IFairyTaleObject object : this.objects) {
				cntr ++;
				toReturn += cntr + ") " + object.getSceneName();
			}
		}
		
		if (!this.availableLocations.isEmpty()) {
			toReturn += ", �� ������� ����� ������������� �:";
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
		//TODO: ������� ���� ������ � ��� ��� ���-��, ���� ����� �� ����, ����� ����� ����� ������� �������������
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
