package Shapes.Blocks;

public class IBlock extends Block {

	public IBlock() {
		super();
		boolean[][][] rotations = getRotations();
		setRotations(rotations);
		setSquares(rotations[0]);
	}

	@Override
	public boolean[][][] getRotations() {
		// TODO Auto-generated method stub
		boolean[][][] rotations = new boolean[][][] {
				{ { false, false, true, false }, { false, false, true, false }, { false, false, true, false },
						{ false, false, true, false } },
				{ { false, false, false, false }, { true, true, true, true }, { false, false, false, false },
						{ false, false, false, false } } };
		return rotations;
	}

}
