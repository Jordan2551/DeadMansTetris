package Shapes.Blocks;

public class OBlock extends Block {

	public OBlock() {
		super();
		boolean[][][] rotations = getRotations();
		setRotations(rotations);
		setSquares(rotations[0]);
	}

	@Override
	public boolean[][][] getRotations() {
		// TODO Auto-generated method stub
		boolean[][][] rotations = new boolean[][][] {
			{ { true, true}, { true, true} }
		};
		return rotations;
	}

}
