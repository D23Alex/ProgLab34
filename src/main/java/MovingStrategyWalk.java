
public class MovingStrategyWalk extends MovingStrategy{
	
	public void move(IFairyTaleObject movingObject) {
		movingObject.act(movingObject.getSceneName() + " обошёл пешком " + movingObject.getLocation().getName() + " по периметру");
	}

	/**
	 * Метод передвижения в другую локацию пешком
	 * Метод делегирует логику движения суперклассу,
	 * сам лишь кастомизирует его нужным образом - то есть под ходьбу
	 */
	public void move(IFairyTaleObject movingObject, ILocation location) throws UnacceptableMovingException{
		// осуществляем непосредственное перемещение
		super.move(movingObject, location);
		movingObject.act(movingObject.getSceneName() + " направился в " + location.getName() + "...");
		movingObject.act(movingObject.getSceneName() + " идёт пешком " + location.getName() + "...");
		movingObject.act(movingObject.getSceneName() + " пришёл в " + location.getName());
	}

	/**
	 * Метод передвижения к другому объекту пешком
	 * Метод делегирует логику движения суперклассу,
	 * сам лишь кастомизирует его нужным образом - то есть под ходьбу
	 */
	public void move(IFairyTaleObject movingObject, IFairyTaleObject object) throws UnacceptableMovingException{
		ILocation oldLocation = movingObject.getLocation();
		// осуществляем непосредственное перемещение
		super.move(movingObject, object);
		if (!movingObject.equals(object)) {
			movingObject.act(movingObject.getSceneName() + " начинает движение пешком...");
			ILocation location = object.getLocation();
			if (!oldLocation.equals(location)) {
				movingObject.act(movingObject.getSceneName() + " направился в " + location.getName() + "...");
				movingObject.act(movingObject.getSceneName() + " идёт пешком в " + location.getName() + "...");
				movingObject.act(movingObject.getSceneName() + " прибыл в " + location.getName());
			}
			movingObject.act(movingObject.getSceneName() + " подошёл к " + object.getSceneName());
		}
		
	}

	@Override
	public String toString() {
		return "ходьба";
	}

}
