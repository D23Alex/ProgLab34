/**
 * Класс представляет никакой объект - Null Object Pattern
 * Пример использования - у каждой эмоции есть объект триггер.
 * Если эмоция равна нулю, то и триггера нет, то есть триггером и выступает NoFairyTaleObject.
 * Или например, когда рядом нет никакого объекта.
 * Большинство его методов просто ничего не делают, хотя для наглядности
 * вполне можно было бы выводить сообщение о "ничего не делании"
 * @author Алексей
 *
 */
public class NoFairyTaleObject implements IFairyTaleObject {
	
	private IScene scene;
	
	NoFairyTaleObject(IScene scene) {
		this.scene = scene;
	}

	public void act(String text) {
		
	}

	public String getSceneName() {
		return "ничего";
	}

	public ILocation getLocation() {
		return new NoLocation(this.scene);
	}

	public void move() {
		
	}

	public void move(ILocation location) throws UnacceptableMovingException {
		
	}

	public void move(IFairyTaleObject object) throws UnacceptableMovingException {
		
	}

	public boolean canMove(ILocation location) {
		return false;
	}

	public boolean canMove(IFairyTaleObject object) {
		return false;
	}

	public void setMovingStrategy(IMovingStrategy movingStrategy) {
		
	}

	public void setLocation(ILocation location) {
		
	}

	public IFairyTaleObject getObjectNearby() {
		return new NoFairyTaleObject(this.scene);
	}

	public void setObjectNearby(IFairyTaleObject objectNearby) {
		
	}

	public void affectHuman(IHuman human) {
		
	}

	public void addEmotionalAffection(IEmotion emotion) {
		
	}
	
	@Override
	public String toString() {
		return this.getSceneName();
	}

	@Override
	public void unsetObjectNearby() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyAboutMoving() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addNearObject(IFairyTaleObject object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IScene getScene() {
		// TODO Auto-generated method stub
		return null;
	}

}
