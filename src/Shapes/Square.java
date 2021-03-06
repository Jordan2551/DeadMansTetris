package Shapes;


import java.awt.Color;
import java.awt.Graphics;

public class Square {

	public static final int TILE_SIZE = 20;
	private int width, height;
	private int x, y;
	
	public Square(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = TILE_SIZE; 
		this.height = TILE_SIZE;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void moveRight() {
		this.x += width;
	}
	
	public void moveLeft() {
		this.x -= width;
	}
	
	public void moveDown() {
		this.y += 20;
	}


	
}
