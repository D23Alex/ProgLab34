import java.util.HashSet;

/**
 * Класс Домомучительницы. Экземпляр этого класса - Фрекен Бок, например
 * @author Алексей
 *
 */
public class HouseTourturer extends Human {

	private String role = "домомучительница";
	
	public HouseTourturer(HashSet<IEmotion> emotionalAffection, IMovingStrategy movingStrategy, ILocation location,
			IFairyTaleObject objectNearby, String name, IAge age, Human.Gender gender, IOutfit outfit,
			HashSet<IFairyTaleObject> memory, HashSet<IEmotion> emotions) {
		super(emotionalAffection, movingStrategy, location, objectNearby, name, age, gender, outfit, memory, emotions);
	}
	
	/**
	 * Домомучительницы проявляют эмоцию страха не так, как все остальные люди...
	 */
	public void showEmotion() {
		IEmotion mainEmotion = this.getCurrentEmotion();
		// если это эмоция страха - то проявляем, иначе вызываем супер.
		if (mainEmotion.getType() == Emote.FEAR) {
			this.act(this.getSceneName() + " проявляет эмоцию: 'Аaa-аaa-аaa! Матильда, помоги!!!!'" );
			return;
		}
		super.showEmotion();
	}
	
}