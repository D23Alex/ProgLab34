import java.time.LocalDateTime;
import java.util.HashSet;

/**
 * ����� ���������� �����
 * @author �������
 *
 */
public class SceneNo1 extends Scene {

	public SceneNo1(LocalDateTime startTime, String name, LocalDateTime currentDateTime,
			HashSet<IFairyTaleObject> objects, HashSet<ILocation> locations) {
		super(startTime, name, currentDateTime, objects, locations);
	}

	public void execute() {
		
		System.out.println(this);
		
		this.prepare();
		
		//TODO: ����������� ��� �������� ������� � �������
		
		// ������� ������� ������ "����������� �������", ������� ����� ������������ �� ������
		
		// ��������� ������������
		IMovingStrategy noMove = new MovingStrategyNoMove();
		IMovingStrategy walk = new MovingStrategyWalk();
		IMovingStrategy propellerFly = new MovingStrategyPropellerFly();
		
		IFairyTaleObject noObject = new NoFairyTaleObject(this);
		ILocation noLocation = new NoLocation(this);
		IHuman unknownHuman = new UnknownHuman(this);
		IOutfit noOutfit = new Outfit("���������� ������", "��� ������", new HashSet<>());
		
		// ���������� �������
		ILocation hallArea = new Location("��������", new HashSet<>(), this, new HashSet<>());
		ILocation room = new Location("������� ������", new HashSet<>(), this, new HashSet<>());
		
		// ���������� ����������
		IHuman karlson = new Human(new HashSet<>(), walk, noLocation, noObject, "�������", new AgeUndefined(), Human.Gender.MALE, noOutfit, new HashSet<>(), new HashSet<>());
		IHuman littleOne = new Human(new HashSet<>(), walk, noLocation, noObject, "�����", new AgeDefined(7), Human.Gender.MALE, noOutfit, new HashSet<>(), new HashSet<>());
		IHuman frequenBoque = new HouseTourturer(new HashSet<>(), walk, noLocation, noObject, "������ ���", new AgeUndefined(), Human.Gender.FEMALE, noOutfit, new HashSet<>(), new HashSet<>());
		
		// ���������� ��������
		IFairyTaleObject fireplace = new Furniture(new HashSet<>(), noMove, noLocation, noObject, Furniture.FurnitureType.FIREPLACE, Color.BLUE);
		IFairyTaleObject painting = new Painting(new HashSet<>(), noMove, noLocation, noObject, "����������� ���������� �������, ������ ������������� ������", new HashSet<>(), new PictureCaption("������� ����� �������", unknownHuman, Color.GREEN, Font.JAGGED, Color.BLUE));
		
		// ���������� ��������
		IOutfit littleOneOutfit = new Outfit("������� ������", "�������� ����� ������� ������, ��������� �� ������ - ����� ����� � ������� �������", new HashSet<>());
		IOutfit karlsonOutfit = new Outfit("������ �������, ������������ � ����� �����", "������ ������� � ������� �������� �� �����, ������������ � ����� �����; ��������, ��������, ���� ��������, ������ �������� ����� �����������", new HashSet<>());
		IOutfit frequenBoqueOutfit = new Outfit("����� �����", "����� ���������� �����, ������������ ����� ������", new HashSet<>());
		IOutfit ghostOutfit = new Outfit("������ ��������", "������ ��������, ������ �� ���������, �������� ����������", new HashSet<>());
		
		// ���������� ������
		// TODO: �� ������� ���, ��� ��� � ������ ���� �� ����� ������������ � �������� ������ SMILE
		IEmotion karlsonAffectingEmotion = new Emotion(Emote.SMILE, 0.15f, karlson);
		IEmotion littleOneAffectingEmotion = new Emotion(Emote.SMILE, 0.25f, littleOne);
		IEmotion frequenBoqueAffectingEmotion = new Emotion(Emote.FEAR, 0.30f, frequenBoque);
		
		IEmotion ghostOutfitAffectingEmotionFear = new Emotion(Emote.FEAR, 0.99f, noObject);
		
		IEmotion fireplaceAffectingEmotionSmile = new Emotion(Emote.SMILE, 0.05f, fireplace);
		
		IEmotion karlsonLaughEmotion = new Emotion(Emote.LAUGH, 0.80f, noObject);
		
		IEmotion paintingLaughEmotion = new Emotion(Emote.LAUGH, 0.10f, painting);
		
		// ���������� �������� �������
		HashSet<ILocation> hallAreaAvailableLocations = new HashSet<>();
		hallAreaAvailableLocations.add(room);
		
		HashSet<ILocation> roomAvailableLocations = new HashSet<>();
		roomAvailableLocations.add(hallArea);
		
		// ���������� �������� �������� (���� ������ ���� ���� ���)
		HashSet<IFairyTaleObject> roomObjects = new HashSet<>();
		roomObjects.add(fireplace);
		roomObjects.add(painting);
		
		HashSet<IFairyTaleObject> hallAreaObjects = new HashSet<>();
		hallAreaObjects.add(frequenBoque);
		hallAreaObjects.add(littleOne);
		hallAreaObjects.add(karlson);
		
		HashSet<IFairyTaleObject> littleOneMemory = new HashSet<>();
		littleOneMemory.add(karlson);
		
		HashSet<IFairyTaleObject> karlsonMemory = new HashSet<>();
		karlsonMemory.add(littleOne);
		karlsonMemory.add(littleOne);
		
		HashSet<IFairyTaleObject> frequenBoqueMemory = new HashSet<>();
		frequenBoqueMemory.add(littleOne);
		
		// ���������� �������� ������
		HashSet<IEmotion> fireplaceAffectingEmotions = new HashSet<>();
		fireplaceAffectingEmotions.add(fireplaceAffectingEmotionSmile);
		
		HashSet<IEmotion> littleOneAffectingEmotions = new HashSet<>();
		littleOneAffectingEmotions.add(littleOneAffectingEmotion);
		
		HashSet<IEmotion> karlsonAffectingEmotions = new HashSet<>();
		karlsonAffectingEmotions.add(karlsonAffectingEmotion);
		
		HashSet<IEmotion> frequenBoqueAffectingEmotions = new HashSet<>();
		frequenBoqueAffectingEmotions.add(frequenBoqueAffectingEmotion);
		
		HashSet<IEmotion> ghostOutfitAffectingEmotions = new HashSet<>();
		ghostOutfitAffectingEmotions.add(ghostOutfitAffectingEmotionFear);
		
		HashSet<IEmotion> karlsonLaughEmotions = new HashSet<>();
		karlsonLaughEmotions.add(karlsonLaughEmotion);
		
		//���������� �������� ������
		HashSet<Color> pictureMainColors = new HashSet<>();
		pictureMainColors.add(Color.RED);
		
		// ������ ������� ������������ ������ � ������������ ����� ����� ������� �����
		
		// �������
		hallArea.connect(room);
		hallArea.addObject(littleOne);
		hallArea.addObject(karlson);
		hallArea.addObject(frequenBoque);
		
		room.connect(hallArea);
		room.addObject(painting);
		room.addObject(fireplace);
		
		// ���������
		littleOne.setLocation(hallArea);
		littleOne.remember(karlson);
		littleOne.dress(littleOneOutfit);
		littleOne.addEmotionalAffection(littleOneAffectingEmotion);

		karlson.setLocation(hallArea);
		karlson.remember(littleOne);
		karlson.remember(painting);
		karlson.dress(karlsonOutfit);
		karlson.addEmotionalAffection(karlsonAffectingEmotion);
		
		frequenBoque.setLocation(hallArea);
		frequenBoque.remember(littleOne);
		frequenBoque.dress(frequenBoqueOutfit);
		frequenBoque.addEmotionalAffection(frequenBoqueAffectingEmotion);

		// �������
		fireplace.setLocation(room);
		fireplace.addEmotionalAffection(fireplaceAffectingEmotionSmile);
		
		painting.setLocation(room);
		painting.addEmotionalAffection(paintingLaughEmotion);
		
		//�������
		ghostOutfit.addEmotionalAffection(ghostOutfitAffectingEmotionFear);
		
		this.introduce();
		
		//TODO: ��������� �������� �����
		
		// ����� �������� � ��������
		try {
			littleOne.move(karlson);
		} catch (UnacceptableMovingException e) {
			this.act(e.getMessage());
		}
		
		// ����� ����������� ��������
		littleOne.visuallyAnalize(karlson);
		
		// ������� ����������� ������
		karlson.visuallyAnalize(littleOne);
		
		// ������
		littleOne.showEmotion();
		karlson.showEmotion();
		
		// ����� � ������� ������� �� ��������� � �������
		try {
			karlson.move(room);
		} catch (UnacceptableMovingException e) {
			this.act(e.getMessage());
		}
		
		try {
			littleOne.move(karlson);
		} catch (UnacceptableMovingException e) {
			this.act(e.getMessage());
		}
		
		// ���������� ������
		karlson.showEmotion();
		littleOne.showEmotion();
		
		// ������� ����������
		karlson.lookAround();
		
		// ������� ���� ���� ������ o_O
		karlson.undress();
		
		// ������� ����� ������ ����������
		karlson.dress(ghostOutfit);
		karlson.affect(karlsonLaughEmotions);
		IEmotion karlsonCurrentEmotion = karlson.getCurrentEmotion();
		
		// ������� ������ ����� ����������� � ������ �� ���������
		karlson.setMovingStrategy(propellerFly);
		
		// ������� �������� ������� � �������� ��������� �� �������
		try {
			karlson.move(fireplace);
		} catch (UnacceptableMovingException e) {
			this.act(e.getMessage());
		}
		karlson.move();
		karlson.showEmotion();
		
		
		// ������� �������� � ����� �������
		karlson.forget(painting);
		
		// ����� ����������
		littleOne.lookAround();
		
		// ����� �������� � ������
		try {
			littleOne.move(fireplace);
		} catch (UnacceptableMovingException e) {
			this.act(e.getMessage());
		}
		
		// ����� �������� � �������
		try {
			littleOne.move(painting);
		} catch (UnacceptableMovingException e) {
			this.act(e.getMessage());
		}
		
		// ����� ������������ �������, �� ���� ��������������� � ���, ��� ��������� �� ���� ����� ���� ��� ��� ��� � ������ ��������� �������� ����
		littleOne.visuallyAnalize(painting);
		
		// � ������� ������� ������ ���
		try {
			frequenBoque.move(room);
		} catch (UnacceptableMovingException e) {
			this.act(e.getMessage());
		}
		
		// ������� ��������� � ������ ���
		try {
			karlson.move(frequenBoque);
		} catch (UnacceptableMovingException e) {
			this.act(e.getMessage());
		}
		
		// ������ ��� ������������ � ��������������� � �����������-���������
		frequenBoque.visuallyAnalize(karlson);
		
		// ������ ��� ��������� ������
		frequenBoque.showEmotion();
		
		// ����� ���������
		

	}

}
