import java.time.LocalDateTime;
import java.util.HashSet;

/**
 * Класс определяет всю сцену.
 * Сцена может воспроизводить действия и сообщать о них:
 * подготовительные действия до начала акта, действия самого акта и может быть что-то ещё.
 * Сцена имеет набор локаций - Location.
 * Сцена отвечает за вывод информации о всех действиях на всех этапах.
 * Сцена существует во времени - и с этим временем можно взаимодействовать,
 * это время отражается при выводе информации
 * 
 * @author Алексей
 *
 */
public abstract class Scene implements IScene {
	
	/**
	 * Время начала сцены
	 */
	private LocalDateTime startTime;
	
	/**
	 * Название сценки.
	 */
	private String name;
	
	/**
	 * Дата и время, каждой реплике в сценке соответствуют некоторые дата и время. Каждый раз выводится время
	 */
	private LocalDateTime currentDateTime;
	
	/**
	 * Набор задействованных в сцене объектов
	 */
	private HashSet<IFairyTaleObject> objects;
	
	/**
	 * Набор задействованных в сцене локаций
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
		System.out.println("Сцена '" + this.name + "' в " + this.currentDateTime.toLocalTime() + " > " + text);
		
	}
	
	public void timePass(int seconds) {
		this.currentDateTime.plusSeconds(seconds);
		
	}
	
	@Override
	public String toString() {
		String toReturn = "Сцена '" + this.name + "', начало которой " + this.startTime;
		if (!this.locations.isEmpty()) {
			toReturn += ", содержащая локации: ";
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
