import java.time.LocalDateTime;
import java.util.HashSet;

/**
 * Класс-оболочка для main
 * @author Алексей
 *
 */
public class Program {

	public static void main(String[] args) {
		//TODO: создать IScene SceneNo1 и запустить, пока напишу так
		IScene scene = new SceneNo1(LocalDateTime.of(1980, 2, 14, 13, 20), "Привидение и картина", LocalDateTime.of(1980, 2, 14, 13, 20), new HashSet<>(), new HashSet<>());
		scene.execute();
	}

}
