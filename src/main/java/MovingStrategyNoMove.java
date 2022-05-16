/**
 * ��������� ������������ ����������� ������� - �������� �����-�� ������
 * @author �������
 *
 */
public class MovingStrategyNoMove extends MovingStrategy{
	
	public void move(IFairyTaleObject movingObject) {
		movingObject.act(movingObject.getSceneName() + " ������� �� ����� � �� ������������ ������");
	}

	public void move(IFairyTaleObject movingObject, ILocation location) {
		movingObject.act(movingObject.getSceneName() + " ������� �� ����� � �� ������������ � " + location.getName());
	}

	public void move(IFairyTaleObject movingObject, IFairyTaleObject object) {
		movingObject.act(movingObject.getSceneName() + " ������� �� ����� � �� ������������ � ������� " + object.getSceneName());
		
	}

	public boolean canMove(IFairyTaleObject movingObject, ILocation location) {
		movingObject.act(movingObject.getSceneName() + " ������������ �� �������� ");
		return false;
	}

	public boolean canMove(IFairyTaleObject movingObject, IFairyTaleObject object) {
		movingObject.act(movingObject.getSceneName() + " ������������ �� �������� ");
		return false;
	}

	@Override
	public String toString() {
		return "������������� �����������";
	}

}
