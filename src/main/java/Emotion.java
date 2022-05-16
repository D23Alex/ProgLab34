public class Emotion implements IEmotion {
	
	/**
	 * ��� ������, ��� ���������� � �������� � ���������� � �� ��� ����
	 */
	private Emote type;
	
	/**
	 * ������� ���������� ���� ������
	 */
	private float value;
	
	/**
	 * �������, ������� �������������� ���������� ���� ������
	 */
	private IFairyTaleObject trigger;
	

	Emotion(Emote type, float value, IFairyTaleObject trigger) {
		this.type = type;
		this.value = value;
		this.trigger = trigger;
	}

	/**
	 * �����������, ��������� ������ �� ������ ������ � ���������
	 * @param anotherEmotion ������, ������� �������
	 */
	public Emotion(IEmotion anotherEmotion) {
		this.type = anotherEmotion.getType();
		this.value = anotherEmotion.getValue();
		this.trigger = anotherEmotion.getTrigger();
	}
	
	@Override
	public String toString() {
		return "������ " + this.type.getName() + ", ������� ���������� - " + this.value + ", ������� - " + this.trigger.getSceneName();
	}

	public IFairyTaleObject getTrigger() {
		return trigger;
	}

	public Emote getType() {
		return type;
	}

	public float getValue() {
		return value;
	}

	public void setType(Emote type) {
		this.type = type;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public void setTrigger(IFairyTaleObject trigger) {
		this.trigger = trigger;
	}
	
}
