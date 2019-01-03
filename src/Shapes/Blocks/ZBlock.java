package Shapes.Blocks;

public class ZBlock extends Block {

	public ZBlock() {
		super();
		boolean[][][] rotations = getRotations();
		setRotations(rotations);
		setSquares(rotations[0]);
	}

	@Override
	public boolean[][][] getRotations() {
		// TODO Auto-generated method stub
		boolean[][][] rotations = new boolean[][][] {
				{ { true, true, false }, { false, true, true }, { false, false, false } },
				{ { false, false, true }, { false, true, true }, { false, true, false } },
				{ { false, false, false }, { true, true, false }, { false, true, true } },
				{ { false, true, false }, { true, true, false }, { true, false, false } }, };
		return rotations;
	}

}
