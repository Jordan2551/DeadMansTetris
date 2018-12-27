package Shapes;

import Shapes.Enums.BlockTypes;

public class LBlock extends Block {

	public LBlock() {
		super(BlockTypes.LBLOCK);
		squares[0] = new Square(620, 0);
		squares[1] = new Square(400, 25);
		squares[2] = new Square(100, 50);
		squares[3] = new Square(299, 75);
	}
	
}
