/**
 * Класс отвечает за перемещение объектов.
 * Реализован весь функционал всех стратегий.
 * Стратегии лишь кастомизируют его, а этот класс осуществляет
 * телепортацию со всей логикой и выбрасывает исключения
 * @author Алексей
 *
 */
public abstract class MovingStrategy implements IMovingStrategy {

	public void move(IFairyTaleObject movingObject, ILocation location) throws UnacceptableMovingException {
		if (!canMove(movingObject, location))
			throw new UnacceptableMovingException(movingObject, location);
		
		movingObject.setLocation(location);
		location.addObject(movingObject);
		//рядом теперь нет никакого объекта
		movingObject.setObjectNearby(new NoFairyTaleObject(movingObject.getScene()));
		
		// сообщаем всем, что мы ушли
		movingObject.notifyAboutMoving();

	}
	
	public void move(IFairyTaleObject movingObject, IFairyTaleObject object) throws UnacceptableMovingException {
		if (!canMove(movingObject, object))
			throw new UnacceptableMovingException(movingObject, object);
		
		// если перемещаемся к тому объекту, у которого уже находимся, то ничего не происходит
		// проблема, что если объект, который числился как ObjectNearBy уходит, то он уже не рядом, но всё ещё является objectNearBy
		if (object.equals(movingObject.getObjectNearby()))
			return;
		
		// локация заменяется на локацию объекта, к которому перемещаемся, если доступна
		movingObject.setLocation(object.getLocation());
		object.getLocation().addObject(movingObject);
		movingObject.setObjectNearby(object);
		object.addNearObject(movingObject);
		
		// сообщаем всем, что мы ушли
		movingObject.notifyAboutMoving();
		
	}

	public boolean canMove(IFairyTaleObject movingObject, ILocation location) {
		if (movingObject.getLocation().equals(location))
			return true;
		ILocation currentLocation = movingObject.getLocation();
		for (ILocation anotherLocation : currentLocation.getAvailableLocations()) {
			if (anotherLocation.equals(location)) {
				movingObject.act(movingObject.getSceneName() + " может переместиться в локацию " + location.getName());
				return true;
			}
		}
		movingObject.act(movingObject.getSceneName() + " не может переместиться в локацию " + location.getName());
		return false;
	}

	public boolean canMove(IFairyTaleObject movingObject, IFairyTaleObject object) {
		// мы можем подойти к этому объекту, если мы можем подойти к локации этого объекта
		if ( canMove(movingObject, object.getLocation()) ) {
			movingObject.act(movingObject.getSceneName() + " может переместиться к объекту " + object.getSceneName());
			return true;
		}
		movingObject.act(movingObject.getSceneName() + " не может переместиться к объекту " + object.getSceneName());
		return false;
	}
	
	@Override
	public String toString() {
		return "перемещение";
	}

}
