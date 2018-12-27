package Shapes;

import Engine.GamePanel;
import Shapes.Enums.BlockTypes;

public class OBlock extends Block {

	public OBlock() {
		super(BlockTypes.OBLOCK);
		squares[0] = new Square(GamePanel.width / 2, 0);
		squares[1] = new Square((GamePanel.width / 2) + Square.TILE_SIZE, 0);
		squares[2] = new Square(GamePanel.width / 2, Square.TILE_SIZE);
		squares[3] = new Square((GamePanel.width / 2) + Square.TILE_SIZE , Square.TILE_SIZE);
	}

}
