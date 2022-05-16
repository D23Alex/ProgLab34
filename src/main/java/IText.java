/**
 * Интерфейс определяет текст
 * @author Алексей
 *
 */
public interface IText {
	
	/**
	 * Геттер текста
	 * @return текст
	 */
	public String getText();
	
	/**
	 * Метод узнаёт и возвращает автора текста
	 * @return объект-человек - автор текста
	 */
	public IHuman getAuthor();
}
