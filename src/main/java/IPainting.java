import java.util.HashSet;

public interface IPainting extends IFairyTaleObject{
	
	
	public String getPaintingDescription();

	
	public void setPaintingDescription(String paintingDescription);
	

	public HashSet<Color> getMainColors();
	
	
	public void setMainColors(HashSet<Color> mainColors);

	
	public IPictureCaption getPictureCaption();

	
	public void setPictureCaption(IPictureCaption pictureCaption);
}
