import java.util.HashSet;

/**
 * Интерфейс определяет наряды и всё про них
 * @author Алексей
 *
 */
public interface IOutfit {
	
	/**
	 * Метод возвращает полное описание костюма
	 * @return полное описание костюма
	 */
	public String getDescription();
	
	/**
	 * метод возвращает название этого костюма, например "порванная белая пижама"
	 * @return  название этого костюма
	 */
	public String getName();
	
	/**
	 * Метод возвращает множество эмоций, которые передаёт этот костюм
	 * @return множество эмоций, которые передаёт костюм
	 */
	public HashSet<IEmotion> getAffectingEmotions();
	
	/**
	 * Метод добавляет указанную в параметие эмоцию
	 * в список эмоций, которые отдаёт объект при контакте человека с ним
	 * @param emotion эмоция, которую необходимо добавить
	 */
	public void addEmotionalAffection(IEmotion emotion);
}
