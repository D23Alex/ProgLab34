import java.time.LocalDateTime;
import java.util.HashSet;

/**
 * Класс конкретной сцены
 * @author Алексей
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
		
		//TODO: подготовить все играющие объекты и локации
		
		// Сначала объявим всякие "константные объекты", которые будут передаваться по ссылке
		
		// Стратегии передвижения
		IMovingStrategy noMove = new MovingStrategyNoMove();
		IMovingStrategy walk = new MovingStrategyWalk();
		IMovingStrategy propellerFly = new MovingStrategyPropellerFly();
		
		IFairyTaleObject noObject = new NoFairyTaleObject(this);
		ILocation noLocation = new NoLocation(this);
		IHuman unknownHuman = new UnknownHuman(this);
		IOutfit noOutfit = new Outfit("отсутствие одежды", "без одежды", new HashSet<>());
		
		// Объявление локаций
		ILocation hallArea = new Location("Корридор", new HashSet<>(), this, new HashSet<>());
		ILocation room = new Location("Комната Малыша", new HashSet<>(), this, new HashSet<>());
		
		// Объявление персонажей
		IHuman karlson = new Human(new HashSet<>(), walk, noLocation, noObject, "Карлсон", new AgeUndefined(), Human.Gender.MALE, noOutfit, new HashSet<>(), new HashSet<>());
		IHuman littleOne = new Human(new HashSet<>(), walk, noLocation, noObject, "Малыш", new AgeDefined(7), Human.Gender.MALE, noOutfit, new HashSet<>(), new HashSet<>());
		IHuman frequenBoque = new HouseTourturer(new HashSet<>(), walk, noLocation, noObject, "Фрекен Бок", new AgeUndefined(), Human.Gender.FEMALE, noOutfit, new HashSet<>(), new HashSet<>());
		
		// Объявление объектов
		IFairyTaleObject fireplace = new Furniture(new HashSet<>(), noMove, noLocation, noObject, Furniture.FurnitureType.FIREPLACE, Color.BLUE);
		IFairyTaleObject painting = new Painting(new HashSet<>(), noMove, noLocation, noObject, "Изображение малелького зверька, скорее напоминающего лисицу", new HashSet<>(), new PictureCaption("Портрет моего Кролика", unknownHuman, Color.GREEN, Font.JAGGED, Color.BLUE));
		
		// Объявление костюмов
		IOutfit littleOneOutfit = new Outfit("детская пижама", "комплект новой детской пижамы, сделанной из хлопка - белые штаны и красная рубашка", new HashSet<>());
		IOutfit karlsonOutfit = new Outfit("зелёная рубашка, заправленная в белые брюки", "зелёная рубашка с большим карманом на груди, заправленная в белые брюки; комплект, вероятно, сшит бабушкой, причём выполнен очень качественно", new HashSet<>());
		IOutfit frequenBoqueOutfit = new Outfit("синий халат", "синий бамбуковый халат, заправленный белым поясом", new HashSet<>());
		IOutfit ghostOutfit = new Outfit("костюм призрака", "костюм призрака, сшитый из наволочек, выглядит устрашающе", new HashSet<>());
		
		// Объявление эмоций
		// TODO: мы сделаем так, что они в начале друг на друга воздействуют и получают эмоцию SMILE
		IEmotion karlsonAffectingEmotion = new Emotion(Emote.SMILE, 0.15f, karlson);
		IEmotion littleOneAffectingEmotion = new Emotion(Emote.SMILE, 0.25f, littleOne);
		IEmotion frequenBoqueAffectingEmotion = new Emotion(Emote.FEAR, 0.30f, frequenBoque);
		
		IEmotion ghostOutfitAffectingEmotionFear = new Emotion(Emote.FEAR, 0.99f, noObject);
		
		IEmotion fireplaceAffectingEmotionSmile = new Emotion(Emote.SMILE, 0.05f, fireplace);
		
		IEmotion karlsonLaughEmotion = new Emotion(Emote.LAUGH, 0.80f, noObject);
		
		IEmotion paintingLaughEmotion = new Emotion(Emote.LAUGH, 0.10f, painting);
		
		// Объявление множеств локаций
		HashSet<ILocation> hallAreaAvailableLocations = new HashSet<>();
		hallAreaAvailableLocations.add(room);
		
		HashSet<ILocation> roomAvailableLocations = new HashSet<>();
		roomAvailableLocations.add(hallArea);
		
		// Объявление множеств объектов (люди входят сюда если что)
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
		
		// Объявление множеств эмоций
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
		
		//Объявление множеств цветов
		HashSet<Color> pictureMainColors = new HashSet<>();
		pictureMainColors.add(Color.RED);
		
		// Теперь следует установление связей и зависимостей между всеми частями сцены
		
		// ЛОКАЦИИ
		hallArea.connect(room);
		hallArea.addObject(littleOne);
		hallArea.addObject(karlson);
		hallArea.addObject(frequenBoque);
		
		room.connect(hallArea);
		room.addObject(painting);
		room.addObject(fireplace);
		
		// ПЕРСОНАЖИ
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

		// Объекты
		fireplace.setLocation(room);
		fireplace.addEmotionalAffection(fireplaceAffectingEmotionSmile);
		
		painting.setLocation(room);
		painting.addEmotionalAffection(paintingLaughEmotion);
		
		//Костюмы
		ghostOutfit.addEmotionalAffection(ghostOutfitAffectingEmotionFear);
		
		this.introduce();
		
		//TODO: Прописать сценарий здесь
		
		// Малыш подходит к карлсону
		try {
			littleOne.move(karlson);
		} catch (UnacceptableMovingException e) {
			this.act(e.getMessage());
		}
		
		// Малыш осматривает Карлсона
		littleOne.visuallyAnalize(karlson);
		
		// Карлсон осматривает малыша
		karlson.visuallyAnalize(littleOne);
		
		// Эмоции
		littleOne.showEmotion();
		karlson.showEmotion();
		
		// Малыш и Карлсон заходят из корридора в комнату
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
		
		// Проявление эмоций
		karlson.showEmotion();
		littleOne.showEmotion();
		
		// Карлсон осмотрелся
		karlson.lookAround();
		
		// Карлсон снял свой костюм o_O
		karlson.undress();
		
		// Карлсон надел костюм приведения
		karlson.dress(ghostOutfit);
		karlson.affect(karlsonLaughEmotions);
		IEmotion karlsonCurrentEmotion = karlson.getCurrentEmotion();
		
		// Карлсон меняет режим перемещения с ходьбы на пропеллер
		karlson.setMovingStrategy(propellerFly);
		
		// Карлсон облетает комнату и начинает кудахтать от радости
		try {
			karlson.move(fireplace);
		} catch (UnacceptableMovingException e) {
			this.act(e.getMessage());
		}
		karlson.move();
		karlson.showEmotion();
		
		
		// Карлсон забывает о своей картине
		karlson.forget(painting);
		
		// Малыш осмотрелся
		littleOne.lookAround();
		
		// Малыш подходит к камину
		try {
			littleOne.move(fireplace);
		} catch (UnacceptableMovingException e) {
			this.act(e.getMessage());
		}
		
		// Малыш подходит к картине
		try {
			littleOne.move(painting);
		} catch (UnacceptableMovingException e) {
			this.act(e.getMessage());
		}
		
		// Малыш разглядывает картину, то есть взаимодействует с ней, она действует на него Кроме того она ещё даёт и полное текстовое описание себя
		littleOne.visuallyAnalize(painting);
		
		// В комнату заходит Фрекен бок
		try {
			frequenBoque.move(room);
		} catch (UnacceptableMovingException e) {
			this.act(e.getMessage());
		}
		
		// Карлсон подлетает к Фрекен бок
		try {
			karlson.move(frequenBoque);
		} catch (UnacceptableMovingException e) {
			this.act(e.getMessage());
		}
		
		// Фрекен бок разглядывает и взаимодействует с приведением-Карлсоном
		frequenBoque.visuallyAnalize(karlson);
		
		// Фрекен бок проявляет эмоцию
		frequenBoque.showEmotion();
		
		// Конец спектакля
		

	}

}
