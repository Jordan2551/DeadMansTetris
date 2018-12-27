package Shapes;

import java.awt.Color;

import Shapes.Enums.BlockTypes;

public abstract class Block {

	Square squares[];
	final BlockTypes blockType;
	final int NOS = 4;
	Color color;

	public Block(BlockTypes blockType) {
		this.blockType = blockType;
		squares = new Square[4];
	}

	public Square[] getSquares() {
		return squares;
	}
	
	public void rotate() {
		for (Square square : squares) {
			square.setX(square.getY() * -1);
			square.setY(square.getX());
		}
	}

}
