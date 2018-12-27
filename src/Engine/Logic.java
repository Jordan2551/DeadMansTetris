package Engine;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import Shapes.Block;
import Shapes.IBlock;
import Shapes.LBlock;
import Shapes.OBlock;
import Shapes.Square;
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

	private Block movingBlock;
	private Block secondaryBlock;
	private List<Block> staticBlocks;
	private boolean[][] grid;
	private int score;

	public Logic() {
		staticBlocks = new ArrayList<Block>();
		grid = new boolean[GamePanel.height / (Square.TILE_SIZE)][(GamePanel.width / Square.TILE_SIZE)];
	}

	public void addStaticBlock(Block block) {
		staticBlocks.add(new IBlock());
	}

	public void setMovingBlock(Block block) {
		this.movingBlock = block;
	}

	public Block getMovingBlock() {
		return movingBlock;
	}

	public List<Block> getStaticBlocks() {
		return staticBlocks;
	}

	// Get all blocks on the screen (used for painting the blocks)
	public List<Block> getAllBlocks() {
		List<Block> allBlocks = staticBlocks;
		allBlocks.add(movingBlock);
		return allBlocks;
	}

	public void performTick() {
		moveDown();
	}

	//Check for moving blocks' collision with static blocks or the bottom of panel
	private void checkCollision() {
		for (Square square : movingBlock.getSquares()) {
			if (square.getY() >= GamePanel.height - 75) {
				// Collision means moving block stops moving!
				staticBlocks.add(movingBlock);
				movingBlock = generateBlock();
			}
		}
	}

	public void moveDown() {
		boolean collided = false;
		for (Square square : movingBlock.getSquares()) {
			//TODO:: find if any of the squares hit the 'bottom' of the row for them	
			// Make a method call squareCollided? Which checks if the square is -20 from another square on the panel
			// If it is, then we have a collision
			if (square.getY() == GamePanel.height - 20) {
				collided = true;
				collidedBlocks();
			}
		}
		if (!collided) {
			for (Square square : movingBlock.getSquares()) {
				square.moveDown();
			}
		}
	}

	//Executes the necessary logic and checks for when two blocks collide
	private void collidedBlocks() {
		staticBlocks.add(movingBlock);
		addToGrid();
		checkForScore();
		movingBlock = generateBlock();
		System.out.println(printBoard());
	}
	
	public void moveRight() {
		boolean collided = false;
		for (Square square : movingBlock.getSquares()) {
			if (square.getX() == GamePanel.width - (square.getWidth()))//TODO:: FIX GRAPHIC ERROR, ITS NOT SUPPOSED TO STICK OUT
				collided = true;
		}
		if (!collided) {
			for (Square square : movingBlock.getSquares()) {
				square.moveRight();
			}
		}
	}

	public void moveLeft() {
		boolean collided = false;
		for (Square square : movingBlock.getSquares()) {
			if (square.getX() == 0) {
				collided = true;
			}
		}
		if (!collided) {
			for (Square square : movingBlock.getSquares()) {
				square.moveLeft();
			}
		}
	}
	
	public void rotate() {
		movingBlock.rotate();
	}
	
	public Block generateBlock() {
		int randomBlock = ThreadLocalRandom.current().nextInt(0, 2);
		if(randomBlock == BlockTypes.IBLOCK.getValue())
			return new IBlock();
		else if(randomBlock == BlockTypes.OBLOCK.getValue())
			return new OBlock();
		
		return new IBlock();
	}
	
	//Adds the moving block which has just landed to the grid 
	private void addToGrid() {
		for (Square square : movingBlock.getSquares()) {
			int gridC = getGridColumn(square);
			int gridR = getGridRow(gridC);
			grid[gridR][gridC] = true;
		}
		printBoard();
	}
	
	//Scans the grid for full rows, adds to score and resets that part of the grid
	private void checkForScore() {
		for (int i = 0; i < grid.length; i++) {
			boolean rowScore = true;
			for (int j = 0; j < grid[0].length; j++) {
				if(!grid[i][j])
					rowScore = false;
			}
			if(rowScore) {
				score++;
				//Reset the row
				for (int c = 0; c < grid[0].length; c++) {
					grid[i][c] = false;
				}
			}
		}
	}
	
	//Gets the column that I want to fill with a block
	private int getGridColumn(Square square) {
		return square.getX() / Square.TILE_SIZE;
	}
	
	//Gets the row that we want to fill with a block
	private int getGridRow(int column) {
		for (int i = 0; i < grid.length; i++) {
			if(grid[i][column])
				return i - 1;	//Indicate that the next row to fill is just above this one
		}
		return grid.length - 1; //Bottom of column is the bottom of the grid
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
