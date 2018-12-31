package Engine;
import java.awt.Color;

import javax.swing.JFrame;


public class Window extends JFrame{
	
	public Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Dead Man's Tetris");
		pack();
		setLocationRelativeTo(null);
		setSize(600, 1050);
		setContentPane(new GamePanel(600, 1000));
		setVisible(true);
	}

}
