package Shapes;

import Engine.GamePanel;
import Shapes.Enums.BlockTypes;

public class IBlock extends Block {

	public IBlock() {
		super(BlockTypes.IBLOCK);
		squares[0] = new Square(GamePanel.width / 2, 0);
		squares[1] = new Square(GamePanel.width / 2, 20);
		squares[2] = new Square(GamePanel.width / 2, 40);
		squares[3] = new Square(GamePanel.width / 2, 60);
	}
	
}
