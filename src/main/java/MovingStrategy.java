/**
 * ����� �������� �� ����������� ��������.
 * ���������� ���� ���������� ���� ���������.
 * ��������� ���� ������������� ���, � ���� ����� ������������
 * ������������ �� ���� ������� � ����������� ����������
 * @author �������
 *
 */
public abstract class MovingStrategy implements IMovingStrategy {

	public void move(IFairyTaleObject movingObject, ILocation location) throws UnacceptableMovingException {
		if (!canMove(movingObject, location))
			throw new UnacceptableMovingException(movingObject, location);
		
		movingObject.setLocation(location);
		location.addObject(movingObject);
		//����� ������ ��� �������� �������
		movingObject.setObjectNearby(new NoFairyTaleObject(movingObject.getScene()));
		
		// �������� ����, ��� �� ����
		movingObject.notifyAboutMoving();

	}
	
	public void move(IFairyTaleObject movingObject, IFairyTaleObject object) throws UnacceptableMovingException {
		if (!canMove(movingObject, object))
			throw new UnacceptableMovingException(movingObject, object);
		
		// ���� ������������ � ���� �������, � �������� ��� ���������, �� ������ �� ����������
		// ��������, ��� ���� ������, ������� �������� ��� ObjectNearBy ������, �� �� ��� �� �����, �� �� ��� �������� objectNearBy
		if (object.equals(movingObject.getObjectNearby()))
			return;
		
		// ������� ���������� �� ������� �������, � �������� ������������, ���� ��������
		movingObject.setLocation(object.getLocation());
		object.getLocation().addObject(movingObject);
		movingObject.setObjectNearby(object);
		object.addNearObject(movingObject);
		
		// �������� ����, ��� �� ����
		movingObject.notifyAboutMoving();
		
	}

	public boolean canMove(IFairyTaleObject movingObject, ILocation location) {
		if (movingObject.getLocation().equals(location))
			return true;
		ILocation currentLocation = movingObject.getLocation();
		for (ILocation anotherLocation : currentLocation.getAvailableLocations()) {
			if (anotherLocation.equals(location)) {
				movingObject.act(movingObject.getSceneName() + " ����� ������������� � ������� " + location.getName());
				return true;
			}
		}
		movingObject.act(movingObject.getSceneName() + " �� ����� ������������� � ������� " + location.getName());
		return false;
	}

	public boolean canMove(IFairyTaleObject movingObject, IFairyTaleObject object) {
		// �� ����� ������� � ����� �������, ���� �� ����� ������� � ������� ����� �������
		if ( canMove(movingObject, object.getLocation()) ) {
			movingObject.act(movingObject.getSceneName() + " ����� ������������� � ������� " + object.getSceneName());
			return true;
		}
		movingObject.act(movingObject.getSceneName() + " �� ����� ������������� � ������� " + object.getSceneName());
		return false;
	}
	
	@Override
	public String toString() {
		return "�����������";
	}

}
