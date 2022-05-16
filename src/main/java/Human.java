import java.util.HashSet;

/**
 * Класс определяет объекты типа человек.
 * Реализован базовый человеческий функционал.
 * Человек может ходить, осматривать локации, читать или не читать и так дальше (смотри описание методов)
 * @author Алексей
 *
 */
public class Human extends FairyTaleObject implements IHuman {
	
	/**
	 * Имя человека - как его звать (фамилия сюда же)
	 */
	private String name;
	
	/**
	 * Возраст человека
	 */
	private IAge age;
	
	/**
	 * Пол человека
	 * @author Алексей
	 *
	 */
	public enum Gender {
		MALE { String getGender() { return "мужской"; } },
		FEMALE{ String getGender() { return "женский"; } };
		abstract String getGender();
	}
	/**
	 * Пол человека
	 * @author Алексей
	 *
	 */
	private Gender gender;
	
	/**
	 * Наряд человека
	 */
	private IOutfit outfit;
	
	private HashSet<IFairyTaleObject> memory;
	
	/**
	 * Набор всех эмоций, которые испытывает человек
	 */
	private HashSet<IEmotion> emotions;
	
	private String role = "человек";
	
	

	public Human(HashSet<IEmotion> emotionalAffection, IMovingStrategy movingStrategy, ILocation location,
			IFairyTaleObject objectNearby, String name, IAge age, Human.Gender gender, IOutfit outfit,
			HashSet<IFairyTaleObject> memory, HashSet<IEmotion> emotions) {
		super(emotionalAffection, movingStrategy, location, objectNearby);
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.outfit = outfit;
		this.memory = memory;
		this.emotions = emotions;
	}

	/**
	 * Метод производит сравнение возраста этого человека с возрастом другого и отчитывается
	 */
	public void compareAge(IHuman human) throws IncomparibleAgeException {
		if (!this.age.isDefined() || !human.getAge().isDefined())
			throw new IncomparibleAgeException(this, human);
		
		String actingString = "возраст " + this.getSceneName() + ": " + this.getAge().getAgeString() + ", возраст " + human.getSceneName() + ": " + human.getAge().getAgeString() + "; " + this.getSceneName();
		if (Integer.parseInt(this.getAge().getAgeString()) > Integer.parseInt(this.getAge().getAgeString()))
			actingString += " старше " + human.getSceneName();
		else if (Integer.parseInt(this.getAge().getAgeString()) < Integer.parseInt(this.getAge().getAgeString()))
			actingString += " младше " + human.getSceneName();
		else
			actingString += " равного возраста с " + human.getSceneName();
		this.act(actingString);
		
	}
	
	public void dress(IOutfit outfit) {
		this.outfit = outfit;
		this.act(this.getSceneName() + " был одет в " + outfit.getName());
	}

	public void undress() {
		//TODO: надеть NullOutfit
		this.act(this.getSceneName() + " снял с себя одежду");
	}
	
	public void remember(IFairyTaleObject object) {
		if (this.equals(object) || this.memory.contains(object))
			return;
		this.memory.add(object);
		this.act(this.getSceneName() + " запомнил " + object.getSceneName());
	}

	public void forget(IFairyTaleObject object) {
		this.memory.remove(object);
		this.act(this.getSceneName() + " забыл " + object.getSceneName());
		
	}
	
	public boolean isRemembered(IFairyTaleObject object) {
		if (this.memory.contains(object)) {
			this.act(this.getSceneName() + " ещё помнит " + object.getSceneName());
			return true;
		}
		this.act(this.getSceneName() + " уже забыл " + object.getSceneName());
		return false;
	}
	
	public void lookAround() {
		this.act(this.getSceneName() + " осмотрелся вокруг: " + this.getLocation());;
		for (IFairyTaleObject currentObject : this.getLocation().getObjects()) {
			
			this.remember(currentObject);
		}
	}
	
	public void visuallyAnalize(IFairyTaleObject object) {
		this.act(this.getSceneName() + " анализирует " + object.getSceneName() + "; перед ним " + object);
		if (!this.memory.contains(object))
			this.remember(object);
		object.affectHuman(this);
	}

	public boolean isAManInPrime() {
		
		if( (this.gender == Gender.MALE && (!this.age.isDefined() || (Integer.parseInt(this.age.getAgeString()) >= 25 && Integer.parseInt(this.age.getAgeString()) <= 45))) ) {
			this.act(this.getSceneName() + " является мужчиной в самом расцвете сил: ");
			return true;
		}
		this.act(this.getSceneName() + " не является мужчиной в самом расцвете сил: ");
		return false;
	}
	
	public void showEmotion() {
		IEmotion emotion = this.getCurrentEmotion();
		this.act(this.getSceneName() + " проявляет эмоцию: " + emotion.getType().getExpression());
	}
	
	// сплошные Null Object Pattern...s
	public IEmotion getCurrentEmotion() {
		IEmotion answer = new Emotion(Emote.NOEMOTION, 0, new NoFairyTaleObject(this.getScene()));
		
		for (IEmotion currentEmotion: this.emotions) {
			if (currentEmotion.getValue() >= answer.getValue())
				answer = currentEmotion;
		}
		
		//act("Эмоция, испытываемая " + this.getSceneName() + " - " + answer.getType().getName() + " в степени " + answer.getValue() + ", вызванный " + answer.getTrigger().getSceneName());
		
		return answer;
	}
	
	/**
	 * Метод отвечает за воздействие человека на других людей.
	 * Как и другие объекты, человек передаёт набор эмоций, которыми обладает,
	 * но, помимо этого, ещё и передаёт набор эмоций, которые содержатся в ОДЕЖДЕ
	 * человека, причём эмоции одежды передаются первыми, а затем могут
	 * быть или не быть перекрыты эмоциями человека, что, собственно, коррелирует с реальной жизнью.
	 * После того, как получены все эмоции от одежды, каждой из них в качестве триггера устанавливается этот человек,
	 * что позволяет нам иметь кого угодно в качестве триггера эмоции на одежде,
	 * ведь оно будет установлено правильно в процессе передачи
	 */
	public void affectHuman(IHuman human) {
		HashSet<IEmotion> emotionsFromOutfit = this.outfit.getAffectingEmotions();
		for (IEmotion currentEmotion : emotionsFromOutfit) {
			currentEmotion.setTrigger(this);
		}
		human.affect(emotionsFromOutfit);
		super.affectHuman(human);
	}

	/**
	 * Метод отвечает за воздействие НА человека this данных эмоций
	 */
	public void affect(HashSet<IEmotion> emotions) {
		HashSet<IEmotion> emotionsToAdd = new HashSet<>();
		
		for (IEmotion anotherEmotion : emotions) {
			this.act("Теперь на " + this.getSceneName() + " воздействует эмоция " + anotherEmotion.getType().getName() + " в степени " + anotherEmotion.getValue() + ", вызванный " + anotherEmotion.getTrigger().getSceneName());
			boolean foundFlag = false;
			for (IEmotion humanEmotion : this.emotions) {
				//TODO: "==" или equals?
				if (humanEmotion.getType().equals(anotherEmotion.getType())) {
					// если такая эмоция уже была - то выставляем причину и новое значение
					humanEmotion.setValue(anotherEmotion.getValue());
					humanEmotion.setTrigger(anotherEmotion.getTrigger());
					foundFlag = true;
					break;
				}
			}
			// если не было такой эмоции у человека, то добавляем
			if (!foundFlag)
				emotionsToAdd.add(new Emotion(anotherEmotion));
		}
		
		this.emotions.addAll(emotionsToAdd);
	}
	
	
	
	/**
	 * Человек, когда подходит к какому-либо объекту, запоминает его
	 */
	public void move(IFairyTaleObject object) throws UnacceptableMovingException {
		super.move(object);
		if (!this.memory.contains(object))
			this.remember(object);
	}

	@Override
	public String toString() {
		return this.getRole() + this.name + ", пол - " + this.gender.getGender() + ", возраст - " + this.age.getAgeString() +  ", одежда: " + this.outfit.getName() + ", выражаемая эмоция - " + this.getCurrentEmotion().getType().getName();
	}

	public IAge getAge() {
		return age;
	}

	public void setAge(IAge age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public IOutfit getOutfit() {
		return outfit;
	}

	public void setOutfit(IOutfit outfit) {
		this.outfit = outfit;
	}

	public HashSet<IFairyTaleObject> getMemory() {
		return memory;
	}

	public void setMemory(HashSet<IFairyTaleObject> memory) {
		this.memory = memory;
	}

	public HashSet<IEmotion> getEmotions() {
		return emotions;
	}

	public void setEmotions(HashSet<IEmotion> emotions) {
		this.emotions = emotions;
	}

	public String getSceneName() {
		return this.name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	

	
	
}
