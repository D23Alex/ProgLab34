import java.util.HashSet;

/**
 * ���� ����� �������� ������� ������ ������,
 * ��������������� ��������� ����������� � ����� ��� ����������� � ��� ������.
 * ���������� ������� ���������� ��� ������ ���� ����� ��������.
 * @author �������
 *
 */
public abstract class FairyTaleObject implements IFairyTaleObject{
	//TODO: �� ������ � ������������ � � ��������������� �������� � �������� ���� ������� �������� � �������� ��������� ���� ������
	
	/**
	 * ������ ������, ������� ���������� ����� �������
	 */
	private HashSet<IEmotion> emotionalAffection;
	
	/**
	 * ������, ������� ������ ������������� � ������ ������
	 */
	private IMovingStrategy movingStrategy;
	
	/**
	 * �������, � ������� ��������� ������
	 */
	private ILocation location;
	
	/**
	 * ������, ������� ��������� ����� � ���� �������� � � ������� ����� �����������������
	 */
	private IFairyTaleObject objectNearby;
	
	/**
	 * ��������� ��������, ��� ������� ���� ������ �������� objectNearBy.
	 * ��� ����������� ������� ���������� �� ����� - �����������, � ����� ������ ����������
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
	 * ����� �������� �����-�� ������, ������� ������ ������� ������.
	 * �������� ������� ����������� � ������� � ���� ������ � ��� �� ��������� 
	 */
	public void act(String text) {
		this.location.act(this.getSceneName() + " | " + text);
	}
	
	public void addEmotionalAffection(IEmotion emotion) {
		this.emotionalAffection.add(emotion);
		this.act("��, ��� ��������������� � " + this.getSceneName() + " ������ ����� �������� ������ " + emotion);
	}

	/**
	 * ����������� ���������� ����������� �������� �� ��������.
	 * ����������� � ���, ��� �������� ������ ���������� ���
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
		this.act("����� ����������� " + this.getSceneName() + " ��� ������ � " + this.movingStrategy + " �� " + movingStrategy);
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
