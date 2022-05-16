/**
 * Реализуется паттерн "Стратегия". Всякий FairyTaleObject обладает IMovingStrategy.
 * В зависимости от реализации перемещаться будет объект по разному.
 * Или не перемещаться вовсе. Но в любом случае мы будем
 * вызывать методы движения интерфейса IFairyTaleObject,
 * а конкретная реализация перемещения предоставляется классам, реализующим эту стратегию
 * @author Алексей
 *
 */
public interface IMovingStrategy {
	
	/**
	 * Метод отвечает за перемещение Объекта вокруг той локации,
	 * в которой он находится. Вокруг означает по периметру, в пределах локации
	 * @param movingObject объект, который совершает данное перемещение
	 */
	public void move(IFairyTaleObject movingObject);
	
	/**
	 * Метод отвечает за перемещение в определённую локацию
	 * Перемещение в то же помещение, где объект находится уже сейчас считается фичёй,
	 * поскольку обнуляет objectNearBy,
	 * что символизирует прилёт в какую-то точку комнаты, но не рядом с каким-то объектом
	 * @param location локация, куда производится попытка перемещения
	 */
	public void move(IFairyTaleObject movingObject, ILocation location) throws UnacceptableMovingException;

	/**
	 * Метод отвечает за перемещение к определённому предмету.
	 * После перемещения предмет считается соседним.
	 * Если перемещаемся к тому объекту, у которого уже находимся, то ничего не происходит.
	 * Особенность: можно перемещаться к объекту из другой локации,
	 * если эта локация доступна для перемещения
	 * @param object предмет, к которому надо двигаться
	 */
	public void move(IFairyTaleObject movingObject, IFairyTaleObject object) throws UnacceptableMovingException;
	
	/**
	 * Метод определяет, способен ли объект переместиться в данную локацию
	 * @param location локация, которая проверяется
	 * @return true, если можем переместиться в эту локацию, иначе false
	 */
	public boolean canMove(IFairyTaleObject movingObject, ILocation location);
	
	/**
	 * Метод определяет, способен ли объект переместиться к даннмоу объекту
	 * @param object объект, к которому перемещаемся
	 * @return true, если можем переместиться, иначе false
	 */
	public boolean canMove(IFairyTaleObject movingObject, IFairyTaleObject object);
}
