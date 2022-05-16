/**
 * —тратеги€ передвижени€ недвижимого объекта - например какой-то мебели
 * @author јлексей
 *
 */
public class MovingStrategyNoMove extends MovingStrategy{
	
	public void move(IFairyTaleObject movingObject) {
		movingObject.act(movingObject.getSceneName() + " осталс€ на месте и не переместилс€ никуда");
	}

	public void move(IFairyTaleObject movingObject, ILocation location) {
		movingObject.act(movingObject.getSceneName() + " осталс€ на месте и не переместилс€ в " + location.getName());
	}

	public void move(IFairyTaleObject movingObject, IFairyTaleObject object) {
		movingObject.act(movingObject.getSceneName() + " осталс€ на месте и не переместилс€ к объекту " + object.getSceneName());
		
	}

	public boolean canMove(IFairyTaleObject movingObject, ILocation location) {
		movingObject.act(movingObject.getSceneName() + " перемещатьс€ не способен ");
		return false;
	}

	public boolean canMove(IFairyTaleObject movingObject, IFairyTaleObject object) {
		movingObject.act(movingObject.getSceneName() + " перемещатьс€ не способен ");
		return false;
	}

	@Override
	public String toString() {
		return "невозможность перемещени€";
	}

}
