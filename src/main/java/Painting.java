import java.util.HashSet;

/**
 * ����� ������������ �������. ������� ��������������� ���,
 * ��� ����������, �������� ������ � �������� ������ �������.
 * ��� ������ ������������ Enum
 * @author �������
 *
 */
public class Painting extends FairyTaleObject implements IPainting{
	
	/**
	 * ��������� �������� ����, ��� ����������
	 */
	private String paintingDescription;
	
	/**
	 * �������� �����, ��������������� � �������
	 */
	private HashSet<Color> mainColors;
	
	/**
	 * ������-������� �������
	 */
	private IPictureCaption pictureCaption;

	public Painting(HashSet<IEmotion> emotionalAffection, IMovingStrategy movingStrategy, ILocation location,
			IFairyTaleObject objectNearby, String paintingDescription, HashSet<Color> mainColors,
			IPictureCaption pictureCaption) {
		super(emotionalAffection, movingStrategy, location, objectNearby);
		this.paintingDescription = paintingDescription;
		this.mainColors = mainColors;
		this.pictureCaption = pictureCaption;
	}

	public String getSceneName() {
		return "�������, ������������ " + this.paintingDescription;
	}
	
	@Override
	public String toString() {
		String colors = "";
		if (this.mainColors.size() < 1)
			colors = "����������";
		for (Color currentColor : this.mainColors) {
			colors += currentColor.getCode();
		}
		return "�������: ���������� - " + this.paintingDescription + ", �������� �����: " + colors + this.pictureCaption;
	}

	public String getPaintingDescription() {
		return paintingDescription;
	}

	public void setPaintingDescription(String paintingDescription) {
		this.paintingDescription = paintingDescription;
	}

	public HashSet<Color> getMainColors() {
		return mainColors;
	}

	public void setMainColors(HashSet<Color> mainColors) {
		this.mainColors = mainColors;
	}

	public IPictureCaption getPictureCaption() {
		return pictureCaption;
	}

	public void setPictureCaption(IPictureCaption pictureCaption) {
		this.pictureCaption = pictureCaption;
	}
	
	

}
