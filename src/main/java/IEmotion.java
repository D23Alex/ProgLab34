/**
 * Интерфейс определяет взаимодействие с эмоциями
 * @author Алексей
 *
 */
public interface IEmotion {
	
	/**
	 * Получить последний объект, который выставил эту эмоцию на данный уровень
	 * @return объект, повлиявший на эмоцию
	 */
	public IFairyTaleObject getTrigger();
	
	/**
	 * Получить тип эмоции
	 * @return
	 */
	public Emote getType();
	
	/**
	 * Получить число от 0 до 1 - степень проявления этой эмоции
	 * @return
	 */
	public float getValue();
	
	
	public void setValue(float value);
	
	
	public void setTrigger(IFairyTaleObject trigger);
	
	
}
