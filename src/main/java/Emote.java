
public enum Emote {
	FEAR {
		public String getName() { return "страх"; }
		public String getExpression() { return "Aaaa-Aa-Aa-Aaaaa! *звуки крика от страха*"; }
	},
	LAUGH {
		public String getName() { return "смех"; }
		public String getExpression() { return "Ха-ха-ха-ха-ха-ха-ха-ха-ха-ха-ха-ха-ха-ха-ха"; }
	},
	SMILE {
		public String getName() { return "улыбка"; }
		public String getExpression() { return "Хе-хе *улыбаясь*"; }
	},
	NOEMOTION {
		public String getName() { return "нет эмоции"; }
		public String getExpression() { return "*не выражает какой-либо эмоции*"; }
	}
	;
	
	public abstract String getName();
	public abstract String getExpression();
	
}
