package Shapes.Enums;

public enum BlockTypes {
	IBLOCK(1), OBLOCK(0), JBLOCK(2), LBLOCK(3), SBLOCK(4), TBLOCK(5), ZBLOCK(6);

	private int value;

	private BlockTypes(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
}
