/**
 * Класс символизирует текстовую информацию. Характеризуется самим текстом и автором
 * @author Алексей
 *
 */
public class Text implements IText {
	
	/**
	 * Текст
	 */
	private String text;
	
	/**
	 * Собственно автор текста
	 */
	private IHuman author;
	
	
	
	public Text(String text, IHuman author) {
		this.text = text;
		this.author = author;
	}

	@Override
	public String toString() {
		return "текст - '" + this.text + "', автор -  " + this.author.getSceneName();
	}

	/**
	 * Геттер текста
	 * @return текст
	 */
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public IHuman getAuthor() {
		return author;
	}

	public void setAuthor(IHuman author) {
		this.author = author;
	}
	
	
	
}
