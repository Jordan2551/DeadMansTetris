package Shapes;

import Shapes.Enums.BlockTypes;

public abstract class Block {

	Square squares[];
	final BlockTypes blockType;
	final int NOS = 4;
	boolean landed = false;
	
	public Block(BlockTypes blockType) {
		this.blockType = blockType;
		squares = new Square[4];
	}
	
	public boolean landed() {
		return landed;
	}
	
	//Moves every block in collection
	public void moveDown() {
		if(!landed) {
			for (int i = 0; i < NOS; i++) {
				//FOR TESTING 
				squares[i].setY(squares[i].getY() + 25);
			}
		}
	}
	
	public Square[] getSquares() {
		return squares;
	}

	public void setLanded(boolean landed) {
		this.landed = landed;
	}
	

	
	
}
