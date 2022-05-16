/*
 * ��� ��� ����� ��������� ������������ ������
 */
public interface IFairyTaleObject {
	
	/**
	 * ����� ������� ����� ���� ���� ��� ����, ����� �������� ��� � ������.
	 * @param text �����
	 */
	public void act(String text);
	
	/**
	 * ����� ���������� ��������� ������������� �������� �������, ������� ����� �������������� � �����
	 * @return
	 */
	public String getSceneName();
	
	/**
	 * ����� ��������� ��������� � ��������� ������
	 * � ������ ������, ������� ����� ������ ��� �������� �������� � ���
	 * @param emotion ������, ������� ���������� ��������
	 */
	public void addEmotionalAffection(IEmotion emotion);
	
	/**
	 * ����� ��������� ����� ���������� �������
	 * @return ����� ���������� �������
	 */
	public ILocation getLocation();
	
	/**
	 * ����� �������� �� ����������� ������ �������
	 */
	public void move();
	
	/**
	 * ����� �������� �� ����������� � ����������� �������
	 * @param location �������, ���� ������������ ������� �����������
	 */
	public void move(ILocation location) throws UnacceptableMovingException;

	/**
	 * ����� �������� �� ����������� � ������������ ��������.
	 * ����� ����������� ������� ��������� ��������
	 * @param object �������, � �������� ���� ���������
	 */
	public void move(IFairyTaleObject object) throws UnacceptableMovingException;
	
	/**
	 * ����� ����������, �������� �� ������ ������������� � ������ �������
	 * @param location �������, ������� �����������
	 * @return true, ���� ����� ������������� � ��� �������, ����� false
	 */
	public boolean canMove(ILocation location);
	
	/**
	 * ����� ����������, �������� �� ������ ������������� � ������� �������
	 * @param object ������, � �������� ������������
	 * @return true, ���� ����� �������������, ����� false
	 */
	public boolean canMove(IFairyTaleObject object);
	
	/**
	 * ������
	 * @param movingStrategy
	 */
	public void setMovingStrategy(IMovingStrategy movingStrategy);
	
	/**
	 * �������� ������� ������� �� ������.
	 * ��������, ��� ����������� ����������� ������� ����� ������������ ����� move,
	 * � ������ �������� ���� � ����� � ��������� ������ �������, � ����������� ����������� ������
	 * @param location �������, �� ������� �������� ������
	 */
	public void setLocation(ILocation location);
	
	/**
	 * ����� ���������� � �������, � ������� ������� ������ � ����� �����,
	 * � ������� ������� �������; � ���� �����, ��������������, ������� � ������
	 * @return
	 */
	public IScene getScene();
	
	/**
	 * ������ �������� ������
	 * @return �������� ������
	 */
	public IFairyTaleObject getObjectNearby();

	/**
	 * ���������� �������� ������
	 * @param objectNearby �������� ������
	 */
	public void setObjectNearby(IFairyTaleObject objectNearby);
	
	/**
	 * ���������� � �������� ������� ����� ������
	 */
	public void unsetObjectNearby();
	
	/**
	 * ����� �������� ���� ��������, ������� ������� ������ this ��������,
	 * � ���, ��� ������ ������������ � ����� �������� �� ��������
	 */
	public void notifyAboutMoving();
	
	/**
	 * �������� � ���, ��� � ������� this ������������ ������ object
	 */
	public void addNearObject(IFairyTaleObject object);
	
	/**
	 * ����� ��������� ����������� ������� �� ��������,
	 * ����� ������� � �������� ���������������
	 * @param human �������, �� �������� ��� ��� ����� ������ �������
	 */
	public void affectHuman(IHuman human);
	
}
