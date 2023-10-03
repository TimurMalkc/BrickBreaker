import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class BrickBreakerAnimation extends JPanel implements ActionListener{

	int xSize = 40;
	int ySize = 40;
	int xVelocity = 5;
	int yVelocity = 5;
	int panelHeight = 700;
	int panelWidth = 600;
	int x = 300;
	int y = panelHeight-ySize;
	
	Timer timer = new Timer(5,this);
	
	BrickBreakerAnimation(){
		
		this.setPreferredSize(new Dimension(panelWidth,panelHeight));
		this.setBackground(Color.black);
		timer.start();
		
	}
	
	@Override
	public void paint(Graphics g) {
		
		super.paint(g);
		
		Graphics2D g2D = (Graphics2D) g;
		
		g2D.setPaint(Color.white);
		g2D.fillOval(x, y, xSize, ySize);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(x >= panelWidth - xSize || x < 0) {
			xVelocity *= -1;
		}
		
		x += xVelocity;
		
		if(y >= panelHeight - ySize || y < 0) {
			yVelocity *= -1;
		}
		
		y += yVelocity;
		
		repaint();
	}
	
	
}
