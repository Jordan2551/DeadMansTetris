package Shapes;

import java.awt.Color;

import Shapes.Enums.BlockTypes;

public class Block {

	/*
	* The squares array is the layout of a Tetris block on a grid.
	 * For example: an O block looks like this:
	 * {	
	 * 		{true, true},
	 * 		{true, true}
	 * }
	 * For example: an L block looks like this:
	 * {	
	 * 		{true, false},
	 * 		{true, false},
	 * 		{true, true}
	 * }	
	 * 
	 * 
	 */
	private boolean[][] squares;
	private TopLeft topLeft;
//	private final BlockTypes blockType;
	private final int NOS = 4;

	public Block(boolean[][] squares) {
//		this.blockType = blockType;
		this.squares = squares;
		this.topLeft = new TopLeft(0, 0);
	}

	public boolean[][] getSquares() {
		return squares;
	}
	
	//A deep copy of blocks
	public TopLeft getTopLeft() {
		return new TopLeft(topLeft.getRow(), topLeft.getCol());
	}

	public void setTopLeft(int row, int col) {
		topLeft.setRow(row);
		topLeft.setCol(col);
	}

	public void setTopLeft(TopLeft topLeft) {
		this.topLeft = topLeft;
	}

//	public void rotate() {
//		for (Square square : squares) {
//			square.setX(square.getY() * -1);
//			square.setY(square.getX());
//		}
//	}

}
