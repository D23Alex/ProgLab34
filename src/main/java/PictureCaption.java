/**
 * ����� ���������� ������-������� �������.
 * ��������� ����������� ����������� ������������� ������� ��� ��� ���� �������
 * @author �������
 *
 */
public class PictureCaption extends Text implements IPictureCaption {
	
	/**
	 * ���� ������
	 */
	private Color fontColor;
	
	/**
	 * ��� ������
	 */
	private Font fontType;
	
	/**
	 * ���� ����
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
		return "������� �������: " +  super.toString() + ", " + this.fontType.getType() + " ����� ����� " + this.fontColor.getCode() + " �� ����" + this.backgroundColor.getCode();
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
