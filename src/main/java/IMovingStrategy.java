/**
 * ����������� ������� "���������". ������ FairyTaleObject �������� IMovingStrategy.
 * � ����������� �� ���������� ������������ ����� ������ �� �������.
 * ��� �� ������������ �����. �� � ����� ������ �� �����
 * �������� ������ �������� ���������� IFairyTaleObject,
 * � ���������� ���������� ����������� ��������������� �������, ����������� ��� ���������
 * @author �������
 *
 */
public interface IMovingStrategy {
	
	/**
	 * ����� �������� �� ����������� ������� ������ ��� �������,
	 * � ������� �� ���������. ������ �������� �� ���������, � �������� �������
	 * @param movingObject ������, ������� ��������� ������ �����������
	 */
	public void move(IFairyTaleObject movingObject);
	
	/**
	 * ����� �������� �� ����������� � ����������� �������
	 * ����������� � �� �� ���������, ��� ������ ��������� ��� ������ ��������� �����,
	 * ��������� �������� objectNearBy,
	 * ��� ������������� ����� � �����-�� ����� �������, �� �� ����� � �����-�� ��������
	 * @param location �������, ���� ������������ ������� �����������
	 */
	public void move(IFairyTaleObject movingObject, ILocation location) throws UnacceptableMovingException;

	/**
	 * ����� �������� �� ����������� � ������������ ��������.
	 * ����� ����������� ������� ��������� ��������.
	 * ���� ������������ � ���� �������, � �������� ��� ���������, �� ������ �� ����������.
	 * �����������: ����� ������������ � ������� �� ������ �������,
	 * ���� ��� ������� �������� ��� �����������
	 * @param object �������, � �������� ���� ���������
	 */
	public void move(IFairyTaleObject movingObject, IFairyTaleObject object) throws UnacceptableMovingException;
	
	/**
	 * ����� ����������, �������� �� ������ ������������� � ������ �������
	 * @param location �������, ������� �����������
	 * @return true, ���� ����� ������������� � ��� �������, ����� false
	 */
	public boolean canMove(IFairyTaleObject movingObject, ILocation location);
	
	/**
	 * ����� ����������, �������� �� ������ ������������� � ������� �������
	 * @param object ������, � �������� ������������
	 * @return true, ���� ����� �������������, ����� false
	 */
	public boolean canMove(IFairyTaleObject movingObject, IFairyTaleObject object);
}
