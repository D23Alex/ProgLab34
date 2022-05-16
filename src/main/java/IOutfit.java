import java.util.HashSet;

/**
 * ��������� ���������� ������ � �� ��� ���
 * @author �������
 *
 */
public interface IOutfit {
	
	/**
	 * ����� ���������� ������ �������� �������
	 * @return ������ �������� �������
	 */
	public String getDescription();
	
	/**
	 * ����� ���������� �������� ����� �������, �������� "��������� ����� ������"
	 * @return  �������� ����� �������
	 */
	public String getName();
	
	/**
	 * ����� ���������� ��������� ������, ������� ������� ���� ������
	 * @return ��������� ������, ������� ������� ������
	 */
	public HashSet<IEmotion> getAffectingEmotions();
	
	/**
	 * ����� ��������� ��������� � ��������� ������
	 * � ������ ������, ������� ����� ������ ��� �������� �������� � ���
	 * @param emotion ������, ������� ���������� ��������
	 */
	public void addEmotionalAffection(IEmotion emotion);
}
