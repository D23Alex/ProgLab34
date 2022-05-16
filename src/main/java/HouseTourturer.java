import java.util.HashSet;

/**
 * ����� ����������������. ��������� ����� ������ - ������ ���, ��������
 * @author �������
 *
 */
public class HouseTourturer extends Human {

	private String role = "����������������";
	
	public HouseTourturer(HashSet<IEmotion> emotionalAffection, IMovingStrategy movingStrategy, ILocation location,
			IFairyTaleObject objectNearby, String name, IAge age, Human.Gender gender, IOutfit outfit,
			HashSet<IFairyTaleObject> memory, HashSet<IEmotion> emotions) {
		super(emotionalAffection, movingStrategy, location, objectNearby, name, age, gender, outfit, memory, emotions);
	}
	
	/**
	 * ���������������� ��������� ������ ������ �� ���, ��� ��� ��������� ����...
	 */
	public void showEmotion() {
		IEmotion mainEmotion = this.getCurrentEmotion();
		// ���� ��� ������ ������ - �� ���������, ����� �������� �����.
		if (mainEmotion.getType() == Emote.FEAR) {
			this.act(this.getSceneName() + " ��������� ������: '�aa-�aa-�aa! ��������, ������!!!!'" );
			return;
		}
		super.showEmotion();
	}
	
}