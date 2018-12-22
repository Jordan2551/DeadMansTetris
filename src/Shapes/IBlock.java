package Shapes;

import Shapes.Enums.BlockTypes;

public class IBlock extends Block {

	public IBlock() {
		super(BlockTypes.IBLOCK);
		squares[0] = new Square(620, 0);
		squares[1] = new Square(620, 25);
		squares[2] = new Square(620, 50);
		squares[3] = new Square(620, 75);
	}
	
}
