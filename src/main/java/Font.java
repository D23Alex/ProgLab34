/**
 * ���� �������� ��������� ������
 * @author �������
 *
 */
public enum Font {
	ITALLIC("�������"), JAGGED("�������� �����");
    private String type;
    Font(String type){
        this.type = type;
    }
    public String getType(){ return type;}
}
