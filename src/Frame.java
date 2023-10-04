import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame extends JFrame{

	AnimationPanel panel = new AnimationPanel();
	Platform platform = new Platform();
	Bricks bricks;
	
	Frame(){
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		for(int i = 0; i < 48; i++) {
			bricks = new Bricks(i);
			panel.add(bricks);
		
		}

		for(Bricks a : Bricks.brickList) {
			System.out.println(a.getId());
				
		}
		
		panel.add(platform,BorderLayout.SOUTH);
		this.add(panel);
		panel.revalidate();
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
		
	}
	
	
}
