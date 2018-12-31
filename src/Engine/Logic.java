package Engine;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import Shapes.Block;
import Shapes.BlockHelper;
import Shapes.Square;
import Shapes.TopLeft;
import Shapes.Enums.BlockTypes;

/*	In this class I use a boolean grid for the game, it is specified as follows:
 * 
 * 	The number of rows is the number of squares which perfectly fit the height
 *  of the screen.
 *  
 *  The number of columns is the number of squares we can fit for the width.
 * 
 * 
 */

//TODO: MAKE A GRID BASED SYSTEM THAT DETERMINES BASED ON WHERE THE BLOCK LANDS, THE LOCATION IN THE ARRAY IT SHOULD BE
//FOR EXAMPLE, AN I BLOCK SHOULD TAKE UP 4 SLOTS OF THE SAME ROW INDEX, IT WOULD SET THOSE VALUES TO TRUE
public class Logic {

	// Grid row and column count
	private boolean[][] grid;
	private final int GRID_RC;
	private final int GRID_CC;

	private Block movingBlock;
	private Block secondaryBlock;
	private boolean gameOver;
	private int score;

	public Logic() {
		GRID_RC = (GamePanel.height / Square.TILE_SIZE);
		GRID_CC = (GamePanel.width / Square.TILE_SIZE);
		grid = new boolean[GRID_RC][GRID_CC];
	}

	public void setMovingBlock(Block block) {
		this.movingBlock = block;
	}

	public Block getMovingBlock() {
		return movingBlock;
	}

	public boolean[][] getGrid() {
		return grid;
	}

	public boolean getGameOver() {
		return gameOver;
	}

	public void performTick() {
		moveDown();
	}
	
	public void rotate() {
		BlockHelper.rotate(movingBlock);
	}

	public void moveDown() {
		// Move blocks top left 1 row down
		boolean collided = false;
		TopLeft potentialTopLeft = movingBlock.getTopLeft();
		potentialTopLeft.setRow(potentialTopLeft.getRow() + 1);
		for (int row = 0; row < movingBlock.getSquares().length; row++) {
			for (int col = 0; col < movingBlock.getSquares()[row].length; col++) {
				// Refer to the squares array for Block to get an idea why this if statement is
				// here
				if (movingBlock.getSquares()[row][col]) {
					// The spot is below the bottom of the screen (collide with bottom) or The spot
					// on the grid is taken or
					if ((potentialTopLeft.getRow() + row == GRID_RC)
							|| grid[potentialTopLeft.getRow() + row][potentialTopLeft.getCol() + col])
						collided = true;
				}
			}
		}
		if (collided) {
			collideBlocks();
			checkForScore();
		} else
			movingBlock.setTopLeft(potentialTopLeft);
	}

	// Executes the necessary logic and checks for when two blocks collide
	private void collideBlocks() {
		TopLeft topLeft = movingBlock.getTopLeft();
		for (int row = 0; row < movingBlock.getSquares().length; row++) {
			for (int col = 0; col < movingBlock.getSquares()[row].length; col++) {
				// Only set the true values of the moving block to the false values of the grid
				if (movingBlock.getSquares()[row][col]) {
					grid[topLeft.getRow() + row][topLeft.getCol() + col] = movingBlock.getSquares()[row][col];
				}
			}
		}
		movingBlock = BlockHelper.generateBlock();
		System.out.println(printBoard());
	}

	public void moveRight() {
		// Our desired new topLeft is one shifted by a column to the right
		TopLeft desiredTopLeft = movingBlock.getTopLeft();
		desiredTopLeft.setCol(desiredTopLeft.getCol() + 1);
		// Make sure the edge of the block can only touch the right wall
		if (movingBlock.getSquares()[0].length + desiredTopLeft.getCol() <= GRID_CC) {
			movingBlock.setTopLeft(desiredTopLeft);
		}
	}

	public void moveLeft() {
		// Our desired new topLeft is one shifted by a column to the right
		TopLeft desiredTopLeft = movingBlock.getTopLeft();
		desiredTopLeft.setCol(desiredTopLeft.getCol() - 1);
		if (desiredTopLeft.getCol() >= 0) {
			movingBlock.setTopLeft(desiredTopLeft);
		}
	}

	// Scans the grid for full rows, adds to score and resets that part of the grid
	private void checkForScore() {
		for (int row = 0; row < grid.length; row++) {
			boolean rowScore = true;
			for (int col = 0; col < grid[row].length; col++) {
				if (!grid[row][col])
					rowScore = false;
			}
			if (rowScore) {
				score++;
				// Reset the row
				for (int col = 0; col < grid[row].length; col++) {
					grid[row][col] = false;
				}
			}
		}
	}

	private String printBoard() {
		String b = "";
		for (int i = 0; i < grid.length; i++) {
			b += i + "\t";
			for (int j = 0; j < grid[0].length; j++) {
				b += grid[i][j] + "\t";
			}
			b += "\n";
		}
		b += "Score: " + score;
		return b;
	}

}
