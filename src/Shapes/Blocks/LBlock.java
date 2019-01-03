package Shapes.Blocks;

public class LBlock extends Block {

	public LBlock() {
		super();
		boolean[][][] rotations = getRotations();
		setRotations(rotations);
		setSquares(rotations[0]);
	}

	@Override
	public boolean[][][] getRotations() {
		// TODO Auto-generated method stub
		boolean[][][] rotations = new boolean[][][] {
				{ { false, false, true }, { true, true, true }, { false, false, false } },
				{ { false, true, false }, { false, true, false }, { false, true, true } },
				{ { false, false, false }, { true, true, true }, { true, false, false } },
				{ { true, true, false }, { false, true, false }, { false, true, false } } };
		return rotations;
	}

}
