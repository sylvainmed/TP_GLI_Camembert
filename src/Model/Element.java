package Model;

public class Element {

	private String name;
	private int value;
	final static int NB_ELEMENTS=2;

	public Element(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public int getValue() {
		return value;
	}
	
}
