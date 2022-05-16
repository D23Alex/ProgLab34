/**
 * Класс ошибки реализует ошибку передвижения в недоступное место.
 * @author Алексей
 *
 */
public class UnacceptableMovingException extends Exception {
	
	/**
	 * Попытка переместиться в недоступную локацию
	 * @param object перемещающийся объект
	 * @param location локация, куда была попытка переместиться
	 */
	public UnacceptableMovingException(IFairyTaleObject object, ILocation location) {
		super("Попытка несанкционированного перемещения: перемещение " + object.getSceneName() + " в локацию " + location.getName() + " невозможно, поскольку из локации " + object.getLocation() + ", где находится " + object.getSceneName() + " не существует пути в локацию" + location.getName());
	}
	
	/**
	 * Попытка переместиться к недоступному предмету
	 * @param movingObject перемещающийся объект
	 * @param object объект, к которому была попытка переместиться
	 */
	public UnacceptableMovingException(IFairyTaleObject movingObject, IFairyTaleObject object) {
		super("Попытка несанкционированного перемещения: перемещение " + movingObject.getSceneName() + " к объекту " + object.getSceneName() + " невозможно, поскольку из локации " + movingObject.getLocation() + ", где находится " + movingObject.getSceneName() + " не существует пути в локацию" + object.getLocation().getName() + ", где находится " + object.getSceneName());
	}
}
