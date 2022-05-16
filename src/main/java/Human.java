import java.util.HashSet;

/**
 * ����� ���������� ������� ���� �������.
 * ���������� ������� ������������ ����������.
 * ������� ����� ������, ����������� �������, ������ ��� �� ������ � ��� ������ (������ �������� �������)
 * @author �������
 *
 */
public class Human extends FairyTaleObject implements IHuman {
	
	/**
	 * ��� �������� - ��� ��� ����� (������� ���� ��)
	 */
	private String name;
	
	/**
	 * ������� ��������
	 */
	private IAge age;
	
	/**
	 * ��� ��������
	 * @author �������
	 *
	 */
	public enum Gender {
		MALE { String getGender() { return "�������"; } },
		FEMALE{ String getGender() { return "�������"; } };
		abstract String getGender();
	}
	/**
	 * ��� ��������
	 * @author �������
	 *
	 */
	private Gender gender;
	
	/**
	 * ����� ��������
	 */
	private IOutfit outfit;
	
	private HashSet<IFairyTaleObject> memory;
	
	/**
	 * ����� ���� ������, ������� ���������� �������
	 */
	private HashSet<IEmotion> emotions;
	
	private String role = "�������";
	
	

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
	 * ����� ���������� ��������� �������� ����� �������� � ��������� ������� � ������������
	 */
	public void compareAge(IHuman human) throws IncomparibleAgeException {
		if (!this.age.isDefined() || !human.getAge().isDefined())
			throw new IncomparibleAgeException(this, human);
		
		String actingString = "������� " + this.getSceneName() + ": " + this.getAge().getAgeString() + ", ������� " + human.getSceneName() + ": " + human.getAge().getAgeString() + "; " + this.getSceneName();
		if (Integer.parseInt(this.getAge().getAgeString()) > Integer.parseInt(this.getAge().getAgeString()))
			actingString += " ������ " + human.getSceneName();
		else if (Integer.parseInt(this.getAge().getAgeString()) < Integer.parseInt(this.getAge().getAgeString()))
			actingString += " ������ " + human.getSceneName();
		else
			actingString += " ������� �������� � " + human.getSceneName();
		this.act(actingString);
		
	}
	
	public void dress(IOutfit outfit) {
		this.outfit = outfit;
		this.act(this.getSceneName() + " ��� ���� � " + outfit.getName());
	}

	public void undress() {
		//TODO: ������ NullOutfit
		this.act(this.getSceneName() + " ���� � ���� ������");
	}
	
	public void remember(IFairyTaleObject object) {
		if (this.equals(object) || this.memory.contains(object))
			return;
		this.memory.add(object);
		this.act(this.getSceneName() + " �������� " + object.getSceneName());
	}

	public void forget(IFairyTaleObject object) {
		this.memory.remove(object);
		this.act(this.getSceneName() + " ����� " + object.getSceneName());
		
	}
	
	public boolean isRemembered(IFairyTaleObject object) {
		if (this.memory.contains(object)) {
			this.act(this.getSceneName() + " ��� ������ " + object.getSceneName());
			return true;
		}
		this.act(this.getSceneName() + " ��� ����� " + object.getSceneName());
		return false;
	}
	
	public void lookAround() {
		this.act(this.getSceneName() + " ���������� ������: " + this.getLocation());;
		for (IFairyTaleObject currentObject : this.getLocation().getObjects()) {
			
			this.remember(currentObject);
		}
	}
	
	public void visuallyAnalize(IFairyTaleObject object) {
		this.act(this.getSceneName() + " ����������� " + object.getSceneName() + "; ����� ��� " + object);
		if (!this.memory.contains(object))
			this.remember(object);
		object.affectHuman(this);
	}

	public boolean isAManInPrime() {
		
		if( (this.gender == Gender.MALE && (!this.age.isDefined() || (Integer.parseInt(this.age.getAgeString()) >= 25 && Integer.parseInt(this.age.getAgeString()) <= 45))) ) {
			this.act(this.getSceneName() + " �������� �������� � ����� �������� ���: ");
			return true;
		}
		this.act(this.getSceneName() + " �� �������� �������� � ����� �������� ���: ");
		return false;
	}
	
	public void showEmotion() {
		IEmotion emotion = this.getCurrentEmotion();
		this.act(this.getSceneName() + " ��������� ������: " + emotion.getType().getExpression());
	}
	
	// �������� Null Object Pattern...s
	public IEmotion getCurrentEmotion() {
		IEmotion answer = new Emotion(Emote.NOEMOTION, 0, new NoFairyTaleObject(this.getScene()));
		
		for (IEmotion currentEmotion: this.emotions) {
			if (currentEmotion.getValue() >= answer.getValue())
				answer = currentEmotion;
		}
		
		//act("������, ������������ " + this.getSceneName() + " - " + answer.getType().getName() + " � ������� " + answer.getValue() + ", ��������� " + answer.getTrigger().getSceneName());
		
		return answer;
	}
	
	/**
	 * ����� �������� �� ����������� �������� �� ������ �����.
	 * ��� � ������ �������, ������� ������� ����� ������, �������� ��������,
	 * ��, ������ �����, ��� � ������� ����� ������, ������� ���������� � ������
	 * ��������, ������ ������ ������ ���������� �������, � ����� �����
	 * ���� ��� �� ���� ��������� �������� ��������, ���, ����������, ����������� � �������� ������.
	 * ����� ����, ��� �������� ��� ������ �� ������, ������ �� ��� � �������� �������� ��������������� ���� �������,
	 * ��� ��������� ��� ����� ���� ������ � �������� �������� ������ �� ������,
	 * ���� ��� ����� ����������� ��������� � �������� ��������
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
	 * ����� �������� �� ����������� �� �������� this ������ ������
	 */
	public void affect(HashSet<IEmotion> emotions) {
		HashSet<IEmotion> emotionsToAdd = new HashSet<>();
		
		for (IEmotion anotherEmotion : emotions) {
			this.act("������ �� " + this.getSceneName() + " ������������ ������ " + anotherEmotion.getType().getName() + " � ������� " + anotherEmotion.getValue() + ", ��������� " + anotherEmotion.getTrigger().getSceneName());
			boolean foundFlag = false;
			for (IEmotion humanEmotion : this.emotions) {
				//TODO: "==" ��� equals?
				if (humanEmotion.getType().equals(anotherEmotion.getType())) {
					// ���� ����� ������ ��� ���� - �� ���������� ������� � ����� ��������
					humanEmotion.setValue(anotherEmotion.getValue());
					humanEmotion.setTrigger(anotherEmotion.getTrigger());
					foundFlag = true;
					break;
				}
			}
			// ���� �� ���� ����� ������ � ��������, �� ���������
			if (!foundFlag)
				emotionsToAdd.add(new Emotion(anotherEmotion));
		}
		
		this.emotions.addAll(emotionsToAdd);
	}
	
	
	
	/**
	 * �������, ����� �������� � ������-���� �������, ���������� ���
	 */
	public void move(IFairyTaleObject object) throws UnacceptableMovingException {
		super.move(object);
		if (!this.memory.contains(object))
			this.remember(object);
	}

	@Override
	public String toString() {
		return this.getRole() + this.name + ", ��� - " + this.gender.getGender() + ", ������� - " + this.age.getAgeString() +  ", ������: " + this.outfit.getName() + ", ���������� ������ - " + this.getCurrentEmotion().getType().getName();
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
