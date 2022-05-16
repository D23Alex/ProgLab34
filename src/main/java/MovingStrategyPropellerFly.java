/**
 * ��������� ������������ � ������� �����, ��������� ���������.
 * ����������� � �����, ��������, �������
 * @author �������
 *
 */
public class MovingStrategyPropellerFly extends MovingStrategy {
	
	public void move(IFairyTaleObject movingObject) {
		movingObject.act("��������� " + movingObject.getSceneName() + " �������� ��������������...");
		movingObject.act(movingObject.getSceneName() + " ������ ����������� ��� ����������� ����� ������...");
		movingObject.act(movingObject.getSceneName() + " ������� " + movingObject.getLocation().getName() + " �� ���������");
	}
	
	/**
	 * ����� ������������ � ������ ������� �� ����������
	 * ����� ���������� ������ �������� �����������,
	 * ��� ���� ������������� ��� ������ ������� - �� ���� ����.
	 */
	public void move(IFairyTaleObject movingObject, ILocation location) throws UnacceptableMovingException{
		// ������������ ���������������� �����������
		super.move(movingObject, location);
		movingObject.act("��������� " + movingObject.getSceneName() + " �������� ��������������...");
		movingObject.act(movingObject.getSceneName() + " ������ ����������� ��� ����������� ����� ������...");
		movingObject.act(movingObject.getSceneName() + " ���� ���� �� " + location.getName() + "...");
		movingObject.act(movingObject.getSceneName() + " ����� " + location.getName() + "...");
		movingObject.act(movingObject.getSceneName() + " ����������� � " + location.getName());
		
	}

	/**
	 * ����� ������������ � ������� ������� �� ����������
	 * ����� ���������� ������ �������� �����������,
	 * ��� ���� ������������� ��� ������ ������� - �� ���� ��� ����
	 */
	public void move(IFairyTaleObject movingObject, IFairyTaleObject object) throws UnacceptableMovingException{
		ILocation oldLocation = movingObject.getLocation();
		// ������������ ���������������� �����������
		super.move(movingObject, object);
		if (!movingObject.equals(object)) {
			movingObject.act("��������� " + movingObject.getSceneName() + " �������� ��������������...");
			movingObject.act(movingObject.getSceneName() + " ������ ����������� ��� ����������� ����� ������...");
			ILocation location = object.getLocation();
			if (!oldLocation.equals(location)) {
				movingObject.act(movingObject.getSceneName() + " ���� ���� �� " + location.getName() + "...");
				movingObject.act(movingObject.getSceneName() + " ����� " + location.getName() + "...");
				movingObject.act(movingObject.getSceneName() + " �������� � " + location.getName());
			}
			movingObject.act(movingObject.getSceneName() + " �������� � " + object.getSceneName());
		}
		
	}
	
	@Override
	public String toString() {
		return "���� � ������� ����������";
	}
}
