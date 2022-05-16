/**
 * Класс определяет объект-подпись картины.
 * Расширяет возможности суперкласса кастомизацией надписи тем или иным образом
 * @author Алексей
 *
 */
public class PictureCaption extends Text implements IPictureCaption {
	
	/**
	 * Цвет текста
	 */
	private Color fontColor;
	
	/**
	 * Тип шрифта
	 */
	private Font fontType;
	
	/**
	 * Цвет фона
	 */
	private Color backgroundColor;
	
	
	
	public PictureCaption(String text, IHuman author, Color fontColor, Font fontType, Color backgroundColor) {
		super(text, author);
		this.fontColor = fontColor;
		this.fontType = fontType;
		this.backgroundColor = backgroundColor;
	}

	@Override
	public String toString() {
		return "подпись картины: " +  super.toString() + ", " + this.fontType.getType() + " шрифт цвета " + this.fontColor.getCode() + " на фоне" + this.backgroundColor.getCode();
	}
	
	public Color getFontColor() {
		return fontColor;
	}
	public void setFontColor(Color fontColor) {
		this.fontColor = fontColor;
	}
	public Font getFontType() {
		return fontType;
	}
	public void setFontType(Font fontType) {
		this.fontType = fontType;
	}
	public Color getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	
	
}
