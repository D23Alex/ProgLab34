/**
 * ����� ������������ ������� ������ - Null Object Pattern
 * ������ ������������� - � ������ ������ ���� ������ �������.
 * ���� ������ ����� ����, �� � �������� ���, �� ���� ��������� � ��������� NoFairyTaleObject.
 * ��� ��������, ����� ����� ��� �������� �������.
 * ����������� ��� ������� ������ ������ �� ������, ���� ��� �����������
 * ������ ����� ���� �� �������� ��������� � "������ �� �������"
 * @author �������
 *
 */
public class NoFairyTaleObject implements IFairyTaleObject {
	
	private IScene scene;
	
	NoFairyTaleObject(IScene scene) {
		this.scene = scene;
	}

	public void act(String text) {
		
	}

	public String getSceneName() {
		return "������";
	}

	public ILocation getLocation() {
		return new NoLocation(this.scene);
	}

	public void move() {
		
	}

	public void move(ILocation location) throws UnacceptableMovingException {
		
	}

	public void move(IFairyTaleObject object) throws UnacceptableMovingException {
		
	}

	public boolean canMove(ILocation location) {
		return false;
	}

	public boolean canMove(IFairyTaleObject object) {
		return false;
	}

	public void setMovingStrategy(IMovingStrategy movingStrategy) {
		
	}

	public void setLocation(ILocation location) {
		
	}

	public IFairyTaleObject getObjectNearby() {
		return new NoFairyTaleObject(this.scene);
	}

	public void setObjectNearby(IFairyTaleObject objectNearby) {
		
	}

	public void affectHuman(IHuman human) {
		
	}

	public void addEmotionalAffection(IEmotion emotion) {
		
	}
	
	@Override
	public String toString() {
		return this.getSceneName();
	}

	@Override
	public void unsetObjectNearby() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyAboutMoving() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addNearObject(IFairyTaleObject object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IScene getScene() {
		// TODO Auto-generated method stub
		return null;
	}

}
