package Shapes.Blocks;

import java.util.concurrent.ThreadLocalRandom;

import Shapes.Enums.BlockTypes;

public class BlockHelper {

	public static Block generateBlock() {
		int randomBlock = ThreadLocalRandom.current().nextInt(0, 7);
		Block block = null;
		if (randomBlock == BlockTypes.IBLOCK.getValue())
			block = new IBlock();
		else if (randomBlock == BlockTypes.JBLOCK.getValue())
			block = new JBlock();
		else if (randomBlock == BlockTypes.LBLOCK.getValue())
			block = new LBlock();
		else if (randomBlock == BlockTypes.OBLOCK.getValue())
			block = new OBlock();
		else if (randomBlock == BlockTypes.SBLOCK.getValue())
			block = new SBlock();
		else if (randomBlock == BlockTypes.TBLOCK.getValue())
			block = new TBlock();
		else if (randomBlock == BlockTypes.ZBLOCK.getValue())
			block = new ZBlock();
		return block;
	}



}
