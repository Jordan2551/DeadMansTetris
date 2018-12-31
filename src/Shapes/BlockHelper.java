package Shapes;

import java.util.concurrent.ThreadLocalRandom;

import Shapes.Enums.BlockTypes;

public class BlockHelper {

	public static Block generateBlock() {
		int randomBlock = ThreadLocalRandom.current().nextInt(0, 7);
		boolean[][] squares = null;
		if (randomBlock == BlockTypes.IBLOCK.getValue())
			squares = new boolean[][] { { true }, { true }, { true }, { true } };
		else if (randomBlock == BlockTypes.JBLOCK.getValue())
			squares = new boolean[][] { { true }, { true, true, true } };
		else if (randomBlock == BlockTypes.LBLOCK.getValue())
			squares = new boolean[][] { { false, false, true }, { true, true, true } };
		else if (randomBlock == BlockTypes.OBLOCK.getValue())
			squares = new boolean[][] { { true, true }, { true, true } };
		else if (randomBlock == BlockTypes.SBLOCK.getValue())
			squares = new boolean[][] { { false, true, true }, { true, true } };
		else if (randomBlock == BlockTypes.TBLOCK.getValue())
			squares = new boolean[][] { { false, true, false }, { true, true, true } };
		else if (randomBlock == BlockTypes.ZBLOCK.getValue())
			squares = new boolean[][] { { true, true }, { false, true, true } };
		Block block = new Block(squares);
		return block;
	}


	public static void rotate(Block block) {
		int rowLength = block.getSquares().length;
		int colLength = block.getSquares()[0].length;
		boolean[][] rotated = new boolean[colLength][rowLength];
		for (int row = 0; row < rotated.length; row++) {
			rotated[row] = reverseCol(block, row, rowLength);
		}
		block.setSquares(rotated);
	}

	private static boolean[] reverseCol(Block block, int col, int rowLength) {
		boolean[] reversedColumn = new boolean[rowLength];
		for (int i = 0; i < rowLength; i++) {
			reversedColumn[i] = block.getSquares()[(rowLength - 1) - i][col];
		}
		return reversedColumn;
	}

}
