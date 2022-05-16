
public enum Emote {
	FEAR {
		public String getName() { return "�����"; }
		public String getExpression() { return "Aaaa-Aa-Aa-Aaaaa! *����� ����� �� ������*"; }
	},
	LAUGH {
		public String getName() { return "����"; }
		public String getExpression() { return "��-��-��-��-��-��-��-��-��-��-��-��-��-��-��"; }
	},
	SMILE {
		public String getName() { return "������"; }
		public String getExpression() { return "��-�� *��������*"; }
	},
	NOEMOTION {
		public String getName() { return "��� ������"; }
		public String getExpression() { return "*�� �������� �����-���� ������*"; }
	}
	;
	
	public abstract String getName();
	public abstract String getExpression();
	
}
