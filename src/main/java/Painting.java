import java.util.HashSet;

/**
 * Класс репрезентует картину. Картина характеризуется тем,
 * что нарисовано, основным цветом и объектом класса подпись.
 * Для цветов используется Enum
 * @author Алексей
 *
 */
public class Painting extends FairyTaleObject implements IPainting{
	
	/**
	 * Текстовое описание того, что нарисовано
	 */
	private String paintingDescription;
	
	/**
	 * Основные цвета, задействованные в картине
	 */
	private HashSet<Color> mainColors;
	
	/**
	 * Объект-подпись картины
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
		return "картина, изображающая " + this.paintingDescription;
	}
	
	@Override
	public String toString() {
		String colors = "";
		if (this.mainColors.size() < 1)
			colors = "неизвестно";
		for (Color currentColor : this.mainColors) {
			colors += currentColor.getCode();
		}
		return "картина: изображено - " + this.paintingDescription + ", основные цвета: " + colors + this.pictureCaption;
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
