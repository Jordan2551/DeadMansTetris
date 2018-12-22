package Engine;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import Shapes.Enums.BlockTypes;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import Shapes.*;;

public class GamePanel extends JPanel implements Runnable{

	//Panel
	private int width, height;
	private boolean running;
	private Thread gameThread;
	
	//Logic
	Logic logic;
	
	//Graphics
	private BufferedImage img;
	private Graphics2D graphics;
	
		
	public GamePanel(int width, int height) {
		this.width = width;
		this.height = height;
		logic = new Logic(this.height);
		setPreferredSize(new Dimension(width, height));
		logic.addBlock(new IBlock());
		//Focus on the panel as soon as its created
		setFocusable(true);
		requestFocus();
		start();
	}

	public void start() {
		running = true;
		gameThread = new Thread(this);
		gameThread.start();
		
	}
	
	public void stop() {
		running = false;
		try {
			gameThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		long before = System.nanoTime();
		long now;
		final double nOT = 10D; 
		final double fps = 1000000000 / nOT;
		double delta = 0;
				
		while(running) {
			now = System.nanoTime();
			delta += (now - before) / fps;
			before = now;
			if(delta >= 1) {
				tick();
				repaint();
				delta--;
			}
		}
	}
	
	public void tick() {
		logic.performTick();
	}
	
	public void paint(Graphics g) {
		//Repaint the entire canvas
		super.paint(g);
		setBackground(Color.black);
		for (int i = 0; i < logic.getBlocks().size(); i++) {
			for (Square square : logic.getBlocks().get(i).getSquares()) {
				g.setColor(Color.red);
				g.fillRect(square.getX(), square.getY(), square.getWidth(), square.getHeight());
			}
		}
		
	}
	

	

	
	
}
