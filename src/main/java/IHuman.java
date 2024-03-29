import java.util.HashSet;

public interface IHuman extends IFairyTaleObject{
	//TODO: ����� ������� �������������, �� ���������� ������� � ���� �������. � ����� �� �������������, � ��� ���������, ��� �� ��� ���������� � ������ + Location.toString()
	
	/**
	 * ����� ��� �����, �������� �� ������� �������� � ����� �������� ���? �������-�� ����� ��������
	 * @param human ������� ��� ���������
	 * @throws IncomparibleAgeException ���� � ������ �� ����� ������� ����������,
	 * �� ���� ��������� ������������, ������������� �������, ���������� ��������������� ����������
	 */
	public void compareAge(IHuman human) throws IncomparibleAgeException;
	
	public IAge getAge();
	
	/**
	 * ����� ������������, �������� �� ���� ������� �������� � ����� �������� ���
	 * @return true, ���� �������� ���� ������� �������� � ����� �������� ���, ����� false
	 */
	public boolean isAManInPrime();
	
	/**
	 * �������� ��� ��������
	 * @return ��� ��������
	 */
	public String getName();
	
	/**
	 * ����� �������� � ��������� ������
	 * @param outfit - ������, � ������� �������� ��������
	 */
	public void dress(IOutfit outfit);
	
	/**
	 * ����� � �������� ������
	 */
	public void undress();
	
	/**
	 * ����� �������� �� ����������� ��������� ����.
	 * ���� �������� ��������� ���� ��, �� ������ �� ����������.
	 * ���� �������� ��������� ������, ������� ��� ������ - ������ �� ����������
	 */
	public void remember(IFairyTaleObject object);
	
	/**
	 * ����� �������� �� ��������� ��������� ����
	 */
	public void forget(IFairyTaleObject object);
	
	/**
	 * ����� �������� "�����������" �������� �� ��������� ���������� � ��� �������,
	 * ��� �� ���������, � ����� ����������� ���� �������� � ��� �����������
	 */
	public void lookAround();
	
	/**
	 * ����� ��������� ��������� ������������ �������.
	 * �������, ������� �������� ������������� ������,
	 * ������� ��� � ������, �������� ��� ��������� �������� � ���������������,
	 * �� ���� �������� �����-�� ������
	 * @param object ������, � ������� ���������������
	 */
	public void visuallyAnalize(IFairyTaleObject object);
	
	/**
	 * ����� ���������, ������ ������� �������� ���� ��� ���
	 * @param object ������, ������ � ������� �����������
	 * @return true, ���� ������, ����� false
	 */
	public boolean isRemembered(IFairyTaleObject object);
	
	/**
	 * ����� ������������������ ������. ����� ��� ������ �������
	 * ���������������� �� ���� ������, ������� �������� �������� � ������ ������.
	 * ��������, ��������, ���� ������� ��� ��������, ���� �����.
	 */
	public void showEmotion();
	
	/**
	 * �������� �� ������, ������� ��������� �������� � ������ ������
	 * @return ������
	 */
	public IEmotion getCurrentEmotion();
	
	/**
	 * �������� �������� this ��������� ������
	 * @param emotions ������ ������, ������� ���������� ��������
	 */
	public void affect(HashSet<IEmotion> emotions);
	
}
