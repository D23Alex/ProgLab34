/**
 * ����� ������������� ��������� ����������. ��������������� ����� ������� � �������
 * @author �������
 *
 */
public class Text implements IText {
	
	/**
	 * �����
	 */
	private String text;
	
	/**
	 * ���������� ����� ������
	 */
	private IHuman author;
	
	
	
	public Text(String text, IHuman author) {
		this.text = text;
		this.author = author;
	}

	@Override
	public String toString() {
		return "����� - '" + this.text + "', ����� -  " + this.author.getSceneName();
	}

	/**
	 * ������ ������
	 * @return �����
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
