public class Emotion implements IEmotion {
	
	/**
	 * Тип эмоции, где содержится и название и проявление и всё что надо
	 */
	private Emote type;
	
	/**
	 * Степень проявления этой эмоции
	 */
	private float value;
	
	/**
	 * Объекты, которые способствовали накоплению этой эмоции
	 */
	private IFairyTaleObject trigger;
	

	Emotion(Emote type, float value, IFairyTaleObject trigger) {
		this.type = type;
		this.value = value;
		this.trigger = trigger;
	}

	/**
	 * Конструктор, создающий эмоцию на основе данной в параметре
	 * @param anotherEmotion эмоция, которую передаём
	 */
	public Emotion(IEmotion anotherEmotion) {
		this.type = anotherEmotion.getType();
		this.value = anotherEmotion.getValue();
		this.trigger = anotherEmotion.getTrigger();
	}
	
	@Override
	public String toString() {
		return "эмоция " + this.type.getName() + ", степень проявления - " + this.value + ", вызвана - " + this.trigger.getSceneName();
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
