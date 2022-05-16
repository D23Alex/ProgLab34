/*
 * Это тот самый интерфейс абстрактного класса
 */
public interface IFairyTaleObject {
	
	/**
	 * Метод передаёт текст куда надо для того, чтобы отыграть его в сценке.
	 * @param text текст
	 */
	public void act(String text);
	
	/**
	 * Метод возвращает строковое представление названия объекта, которое будет использоваться в сцене
	 * @return
	 */
	public String getSceneName();
	
	/**
	 * Метод добавляет указанную в параметие эмоцию
	 * в список эмоций, которые отдаёт объект при контакте человека с ним
	 * @param emotion эмоция, которую необходимо добавить
	 */
	public void addEmotionalAffection(IEmotion emotion);
	
	/**
	 * Метод вычисляет место нахождения объекта
	 * @return место нахождения объекта
	 */
	public ILocation getLocation();
	
	/**
	 * Метод отвечает за перемещение вокруг локации
	 */
	public void move();
	
	/**
	 * Метод отвечает за перемещение в определённую локацию
	 * @param location локация, куда производится попытка перемещения
	 */
	public void move(ILocation location) throws UnacceptableMovingException;

	/**
	 * метод отвечает за перемещение к определённому предмету.
	 * После перемещения предмет считается соседним
	 * @param object предмет, к которому надо двигаться
	 */
	public void move(IFairyTaleObject object) throws UnacceptableMovingException;
	
	/**
	 * Метод определяет, способен ли объект переместиться в данную локацию
	 * @param location локация, которая проверяется
	 * @return true, если можем переместиться в эту локацию, иначе false
	 */
	public boolean canMove(ILocation location);
	
	/**
	 * Метод определяет, способен ли объект переместиться к даннмоу объекту
	 * @param object объект, к которому перемещаемся
	 * @return true, если можем переместиться, иначе false
	 */
	public boolean canMove(IFairyTaleObject object);
	
	/**
	 * Сеттер
	 * @param movingStrategy
	 */
	public void setMovingStrategy(IMovingStrategy movingStrategy);
	
	/**
	 * Изменить локацию объекта на данную.
	 * Внимание, для корректного перемещения объекта стоит использовать метод move,
	 * в логике которого есть и связь с объектами разных локаций, и способность выбрасывать ошибки
	 * @param location локация, на которую меняется объект
	 */
	public void setLocation(ILocation location);
	
	/**
	 * Метод обращается к локации, в которой состоит объект и выдаёт сцену,
	 * в которой состоит локация; в этой сцене, соответственно, состоит и объект
	 * @return
	 */
	public IScene getScene();
	
	/**
	 * Узнать соседний объект
	 * @return соседний объект
	 */
	public IFairyTaleObject getObjectNearby();

	/**
	 * Установить соседний объект
	 * @param objectNearby соседний объект
	 */
	public void setObjectNearby(IFairyTaleObject objectNearby);
	
	/**
	 * Установить в качестве объекта рядом ничего
	 */
	public void unsetObjectNearby();
	
	/**
	 * Метод сообщает всем объектам, которые считают объект this соседним,
	 * о том, что объект переместился и более соседним не является
	 */
	public void notifyAboutMoving();
	
	/**
	 * Сообщает о том, что к объекту this переместился объект object
	 */
	public void addNearObject(IFairyTaleObject object);
	
	/**
	 * Метод описывает воздействия объекта на человека,
	 * когда человек с объектом взаимодействует
	 * @param human человек, на которого так или иначе влияет предмет
	 */
	public void affectHuman(IHuman human);
	
}
