/**
 * ���� ����� ���������� ������, ����������� ��� ������� �������� 2 ��������,
 * ����� ������� ���� ���� �� 1 �������������
 * @author �������
 *
 */
public class IncomparibleAgeException extends Exception {

	/**
	 * ����������� �������� ����� 2 ����� �, ����������� �� ������ �������,
	 * ����� ������ � ��������� ����, ��� ��� ����
	 * � �� ����� ������� �� �� ����� �� ����������
	 * @param human1 ������ �������
	 * @param human2 ������ �������
	 */
	public IncomparibleAgeException(IHuman human1, IHuman human2) {
		// TODO: ������ ���������� � ����� � ������� ��������� message ������ � �������, ��� � ������ ����������
		super("������� 1) " + human1.getSceneName()  + " � 2) " + human2.getSceneName() + " �������� ����������, ������ ��� ������� ������� �������� - " + human1.getAge() + ", ������� - " + human2.getAge());
	}

}
