import java.time.LocalDateTime;
import java.util.HashSet;

/**
 * �����-�������� ��� main
 * @author �������
 *
 */
public class Program {

	public static void main(String[] args) {
		//TODO: ������� IScene SceneNo1 � ���������, ���� ������ ���
		IScene scene = new SceneNo1(LocalDateTime.of(1980, 2, 14, 13, 20), "���������� � �������", LocalDateTime.of(1980, 2, 14, 13, 20), new HashSet<>(), new HashSet<>());
		scene.execute();
	}

}
