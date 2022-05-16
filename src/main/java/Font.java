/**
 * Енам содержит различные шрифты
 * @author Алексей
 *
 */
public enum Font {
	ITALLIC("италлик"), JAGGED("неровные буквы");
    private String type;
    Font(String type){
        this.type = type;
    }
    public String getType(){ return type;}
}
