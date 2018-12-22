package Engine;

import java.util.ArrayList;
import java.util.List;

import Shapes.Block;
import Shapes.IBlock;
import Shapes.Square;

public class Logic {

	private List<Block> blocks;
	private final int PANEL_BOTTOM;
	
	public Logic(int PANEL_BOTTOM) {
		this.PANEL_BOTTOM = PANEL_BOTTOM;
		blocks = new ArrayList<Block>();
	}
	
	public void addBlock(Block block){
		blocks.add(new IBlock());
	}
	
	public List<Block> getBlocks(){
		return blocks;
	}

	public void performTick() {
		for (int i = 0; i < blocks.size(); i++) {
			// move block only if block has not landed
			if(!blocks.get(i).landed()) {
				checkCollision();
				blocks.get(i).moveDown();
			}
			
			
		}
	}
	
	private void checkCollision() {			
		for (Block block : blocks) {
			if(!block.landed()) {
				for (Square square : block.getSquares()) {
					if(square.getY() >= PANEL_BOTTOM - 75)
						block.setLanded(true);
				}	
			}
		}
	}
	
}
