import java.util.HashSet;

/**
 * Этот класс является предком любого класса,
 * представляющего некоторый участвующий в сцене или упоминаемый в ней объект.
 * Реализован базовый функционал для работы всех таких объектов.
 * @author Алексей
 *
 */
public abstract class FairyTaleObject implements IFairyTaleObject{
	//TODO: не забыть в конструкторе и в соответствующих геттерах и сеттерах всем эмоциям выдавать в качестве источника этот объект
	
	/**
	 * Список эмоций, которые передаются этому объекту
	 */
	private HashSet<IEmotion> emotionalAffection;
	
	/**
	 * Способ, которым объект передвигается в данный момент
	 */
	private IMovingStrategy movingStrategy;
	
	/**
	 * Локация, в которой находится объект
	 */
	private ILocation location;
	
	/**
	 * Объект, который находится рядом с этим объектом и с которым можно взаимодействовать
	 */
	private IFairyTaleObject objectNearby;
	
	/**
	 * Множество объектов, для которых этот объект является objectNearBy.
	 * При перемещении объекта соединения со всеми - разрываются, а затем список обнуляется
	 */
	private HashSet<IFairyTaleObject> nearObjects;
	
	
	
	public FairyTaleObject(HashSet<IEmotion> emotionalAffection, IMovingStrategy movingStrategy, ILocation location, IFairyTaleObject objectNearby) {
		this.emotionalAffection = emotionalAffection;
		this.movingStrategy = movingStrategy;
		this.location = location;
		this.objectNearby = objectNearby;
		this.nearObjects = new HashSet<>();
	}

	/**
	 * Метод получает какую-то строку, которую должен сыграть объект.
	 * Название объекта добавляется и локация к этой строке и это всё передаётся 
	 */
	public void act(String text) {
		this.location.act(this.getSceneName() + " | " + text);
	}
	
	public void addEmotionalAffection(IEmotion emotion) {
		this.emotionalAffection.add(emotion);
		this.act("те, кто взаимодействует с " + this.getSceneName() + " теперь будут получать эмоцию " + emotion);
	}

	/**
	 * Стандартная реализация воздействия предмета на человека.
	 * Заключается в том, что заданные эмоции передаются ему
	 */
	public void affectHuman(IHuman human) {
		human.affect(this.emotionalAffection);
		
	}
	
	public IScene getScene() {
		return this.location.getScene();
	}

	public IMovingStrategy getMovingStrategy() {
		return movingStrategy;
	}

	public void setMovingStrategy(IMovingStrategy movingStrategy) {
		this.act("Режим перемещения " + this.getSceneName() + " был изменён с " + this.movingStrategy + " на " + movingStrategy);
		this.movingStrategy = movingStrategy;
	}
	
	public void move() {
		this.movingStrategy.move(this);
	}
	
	public void move(ILocation location) throws UnacceptableMovingException{
		this.movingStrategy.move(this, location);
	}

	public void move(IFairyTaleObject object) throws UnacceptableMovingException{
		this.movingStrategy.move(this, object);
		
	}

	public boolean canMove(ILocation location) {
		return this.movingStrategy.canMove(this, location);
	}

	public boolean canMove(IFairyTaleObject object) {
		return this.movingStrategy.canMove(this, object);
	}
	
	public ILocation getLocation() {
		return location;
	}

	public void setLocation(ILocation location) {
		this.location = location;
	}

	public IFairyTaleObject getObjectNearby() {
		return objectNearby;
	}

	public void setObjectNearby(IFairyTaleObject objectNearby) {
		this.objectNearby = objectNearby;
	}
	
	public void unsetObjectNearby() {
		this.objectNearby = new NoFairyTaleObject(this.getScene());
	}
	
	public void notifyAboutMoving() {
		for (IFairyTaleObject object : this.nearObjects) {
			object.unsetObjectNearby();
		}
	}
	
	public void addNearObject(IFairyTaleObject object) {
		this.nearObjects.add(object);
	}

	public HashSet<IEmotion> getEmotionalAffection() {
		return emotionalAffection;
	}

	public void setEmotionalAffection(HashSet<IEmotion> emotionalAffection) {
		this.emotionalAffection = emotionalAffection;
	}
}
