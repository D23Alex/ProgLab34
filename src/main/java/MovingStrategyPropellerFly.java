/**
 * Стратегия передвижения с помощью полёта, используя пропеллер.
 * Реализовать её может, например, Карлсон
 * @author Алексей
 *
 */
public class MovingStrategyPropellerFly extends MovingStrategy {
	
	public void move(IFairyTaleObject movingObject) {
		movingObject.act("пропеллер " + movingObject.getSceneName() + " начинает раскручиваться...");
		movingObject.act(movingObject.getSceneName() + " набрал необходимую для дальнейшего полёта высоту...");
		movingObject.act(movingObject.getSceneName() + " облетел " + movingObject.getLocation().getName() + " по периметру");
	}
	
	/**
	 * Метод передвижения в другую локацию на пропеллере
	 * Метод делегирует логику движения суперклассу,
	 * сам лишь кастомизирует его нужным образом - то есть полёт.
	 */
	public void move(IFairyTaleObject movingObject, ILocation location) throws UnacceptableMovingException{
		// осуществляем непосредственное перемещение
		super.move(movingObject, location);
		movingObject.act("пропеллер " + movingObject.getSceneName() + " начинает раскручиваться...");
		movingObject.act(movingObject.getSceneName() + " набрал необходимую для дальнейшего полёта высоту...");
		movingObject.act(movingObject.getSceneName() + " взял курс на " + location.getName() + "...");
		movingObject.act(movingObject.getSceneName() + " летит " + location.getName() + "...");
		movingObject.act(movingObject.getSceneName() + " приземлился в " + location.getName());
		
	}

	/**
	 * Метод передвижения к другому объекту на пропеллере
	 * Метод делегирует логику движения суперклассу,
	 * сам лишь кастомизирует его нужным образом - то есть под полёт
	 */
	public void move(IFairyTaleObject movingObject, IFairyTaleObject object) throws UnacceptableMovingException{
		ILocation oldLocation = movingObject.getLocation();
		// осуществляем непосредственное перемещение
		super.move(movingObject, object);
		if (!movingObject.equals(object)) {
			movingObject.act("пропеллер " + movingObject.getSceneName() + " начинает раскручиваться...");
			movingObject.act(movingObject.getSceneName() + " набрал необходимую для дальнейшего полёта высоту...");
			ILocation location = object.getLocation();
			if (!oldLocation.equals(location)) {
				movingObject.act(movingObject.getSceneName() + " взял курс на " + location.getName() + "...");
				movingObject.act(movingObject.getSceneName() + " летит " + location.getName() + "...");
				movingObject.act(movingObject.getSceneName() + " прилетел в " + location.getName());
			}
			movingObject.act(movingObject.getSceneName() + " подлетел к " + object.getSceneName());
		}
		
	}
	
	@Override
	public String toString() {
		return "полёт с помощью пропеллера";
	}
}
