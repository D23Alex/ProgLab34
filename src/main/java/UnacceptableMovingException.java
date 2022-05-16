/**
 * ����� ������ ��������� ������ ������������ � ����������� �����.
 * @author �������
 *
 */
public class UnacceptableMovingException extends Exception {
	
	/**
	 * ������� ������������� � ����������� �������
	 * @param object �������������� ������
	 * @param location �������, ���� ���� ������� �������������
	 */
	public UnacceptableMovingException(IFairyTaleObject object, ILocation location) {
		super("������� �������������������� �����������: ����������� " + object.getSceneName() + " � ������� " + location.getName() + " ����������, ��������� �� ������� " + object.getLocation() + ", ��� ��������� " + object.getSceneName() + " �� ���������� ���� � �������" + location.getName());
	}
	
	/**
	 * ������� ������������� � ������������ ��������
	 * @param movingObject �������������� ������
	 * @param object ������, � �������� ���� ������� �������������
	 */
	public UnacceptableMovingException(IFairyTaleObject movingObject, IFairyTaleObject object) {
		super("������� �������������������� �����������: ����������� " + movingObject.getSceneName() + " � ������� " + object.getSceneName() + " ����������, ��������� �� ������� " + movingObject.getLocation() + ", ��� ��������� " + movingObject.getSceneName() + " �� ���������� ���� � �������" + object.getLocation().getName() + ", ��� ��������� " + object.getSceneName());
	}
}
