import java.util.HashSet;

/**
 * ����� �������� �� ��������� ������������ �������� � ������
 * @author �������
 *
 */
public class UnknownHuman extends NoFairyTaleObject implements IHuman {

	UnknownHuman(IScene scene) {
		super(scene);
	}

	public void compareAge(IHuman human) throws IncomparibleAgeException {
		
	}

	public IAge getAge() {
		return new AgeUndefined();
	}

	public boolean isAManInPrime() {
		return false;
	}

	public String getName() {
		return "�����������";
	}

	public void dress(IOutfit outfit) {
		
	}

	public void undress() {
		
	}

	public void remember(IFairyTaleObject object) {
	
	}

	public void forget(IFairyTaleObject object) {

	}

	public void lookAround() {
		
	}

	public boolean isRemembered(IFairyTaleObject object) {
		return false;
	}

	public void showEmotion() {
		
	}

	/**
	 * ������� ������ ��������� ��� �� ���������� - ��� � �������
	 */
	public IEmotion getCurrentEmotion() {
		return new Emotion(Emote.NOEMOTION, 0, new NoFairyTaleObject(this.getScene()));
	}

	public void affect(HashSet<IEmotion> emotions) {
		
	}

	public void visuallyAnalize(IFairyTaleObject object) {
		
	}

}
