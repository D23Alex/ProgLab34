/**
 * ��������� ���������� �������������� � ��������
 * @author �������
 *
 */
public interface IEmotion {
	
	/**
	 * �������� ��������� ������, ������� �������� ��� ������ �� ������ �������
	 * @return ������, ���������� �� ������
	 */
	public IFairyTaleObject getTrigger();
	
	/**
	 * �������� ��� ������
	 * @return
	 */
	public Emote getType();
	
	/**
	 * �������� ����� �� 0 �� 1 - ������� ���������� ���� ������
	 * @return
	 */
	public float getValue();
	
	
	public void setValue(float value);
	
	
	public void setTrigger(IFairyTaleObject trigger);
	
	
}
