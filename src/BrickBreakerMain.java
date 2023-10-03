import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BrickBreakerMain extends JFrame{

	static JFrame frame = new JFrame();
	static BrickBreakerAnimation panel = new BrickBreakerAnimation();
	
	public static void main(String[] args) {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		
		frame.add(panel);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
		
		
	}
	
	
}
