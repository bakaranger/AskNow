package tokenAnnotation;

public class token {
	//TODO: extend to other functionality
	private static String value = null;
	private static String posTag = null;
	private static String nerStart = null;
	private static String nerEnd = null;
	private static String nerTag = null;
	private static String lemma = null;
	private static Integer index = null;
	private static Boolean isPartOfPhrase = null;
	private static String phraseID = null; 		//TODO: Use ENUM later here.
	
	public token(Integer index, String value, String posTag, String nerTag, String lemma){
		this.index = index;
		this.value = value;
		this.posTag = posTag;
		this.nerTag = nerTag;
		this.lemma = lemma;
		this.isPartOfPhrase = false;
	}

	public static String getValue() {
		return value;
	}

	public static String getPosTag() {
		return posTag;
	}

	public static String getNerStart() {
		return nerStart;
	}

	public static String getNerEnd() {
		return nerEnd;
	}

	public static String getNerTag() {
		return nerTag;
	}

	public static String getLemma() {
		return lemma;
	}

	public static Integer getIndex() {
		return index;
	}
	
	public static Boolean isPartOfPhrase(){
		return isPartOfPhrase;
	}
	
	//TODO: implement all getters and setters for the above attributes
}
