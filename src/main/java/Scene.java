import java.time.LocalDateTime;
import java.util.HashSet;

/**
 * ����� ���������� ��� �����.
 * ����� ����� �������������� �������� � �������� � ���:
 * ���������������� �������� �� ������ ����, �������� ������ ���� � ����� ���� ���-�� ���.
 * ����� ����� ����� ������� - Location.
 * ����� �������� �� ����� ���������� � ���� ��������� �� ���� ������.
 * ����� ���������� �� ������� - � � ���� �������� ����� �����������������,
 * ��� ����� ���������� ��� ������ ����������
 * 
 * @author �������
 *
 */
public abstract class Scene implements IScene {
	
	/**
	 * ����� ������ �����
	 */
	private LocalDateTime startTime;
	
	/**
	 * �������� ������.
	 */
	private String name;
	
	/**
	 * ���� � �����, ������ ������� � ������ ������������� ��������� ���� � �����. ������ ��� ��������� �����
	 */
	private LocalDateTime currentDateTime;
	
	/**
	 * ����� ��������������� � ����� ��������
	 */
	private HashSet<IFairyTaleObject> objects;
	
	/**
	 * ����� ��������������� � ����� �������
	 */
	private HashSet<ILocation> locations;
	
	

	public Scene(LocalDateTime startTime, String name, LocalDateTime currentDateTime, HashSet<IFairyTaleObject> objects,
			HashSet<ILocation> locations) {
		this.startTime = startTime;
		this.name = name;
		this.currentDateTime = currentDateTime;
		this.objects = objects;
		this.locations = locations;
	}

	public void act(String text) {
		System.out.println("����� '" + this.name + "' � " + this.currentDateTime.toLocalTime() + " > " + text);
		
	}
	
	public void timePass(int seconds) {
		this.currentDateTime.plusSeconds(seconds);
		
	}
	
	@Override
	public String toString() {
		String toReturn = "����� '" + this.name + "', ������ ������� " + this.startTime;
		if (!this.locations.isEmpty()) {
			toReturn += ", ���������� �������: ";
			int cntr = 0;
			for (ILocation currentLocation : this.locations) {
				cntr++;
				toReturn += cntr + ") " + currentLocation;
			}
		}
		return toReturn;
	}
	
	public HashSet<IFairyTaleObject> getObjects() {
		return objects;
	}

	public void setObjects(HashSet<IFairyTaleObject> objects) {
		this.objects = objects;
	}

	public HashSet<ILocation> getLocations() {
		return locations;
	}

	public void setLocations(HashSet<ILocation> locations) {
		this.locations = locations;
	}

	public void introduce() {
		// TODO Auto-generated method stub
	}

	public void prepare() {
		this.objects.clear();
		this.locations.clear();
	}

	public void addObject(IFairyTaleObject object) {
		this.objects.add(object);
	}

	public void addLocation(ILocation location) {
		this.locations.add(location);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getCurrentDateTime() {
		return currentDateTime;
	}

	public void setCurrentDateTime(LocalDateTime currentDateTime) {
		this.currentDateTime = currentDateTime;
	}
	
	

}
