import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

public class AnimationPanel extends JPanel implements ActionListener, KeyListener{

	Timer timer = new Timer(10,this);
	int panelWidth = 600;
	int panelHeight = 700;
	int ballX = 300;
	int ballY = 300;
	int ballHeight = 20;
	int ballWidth = 20;
	int ballVelocityX = 5;
	int ballVelocityY = 5;
	int platformX = 300;
	int platformY = 650;
	int platformWidth = 100;
	int platformHeight = 20;
	ArrayList<Bricks> rects = new ArrayList<Bricks>();
	Rectangle ballRect = new Rectangle(ballX,ballY,ballWidth,ballHeight);
	Rectangle platformRect = new Rectangle(platformX, platformY, platformWidth, platformHeight);
	
	AnimationPanel(){
		
		this.setPreferredSize(new Dimension(panelWidth,panelHeight));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(this);
		timer.start();
		
		for(int i = 0; i < 3; i++) {
			for(int z = 0; z < 11; z++) {
				Bricks rect = new Bricks(20+z+z*50, i+i*50, 50, 50);
				rects.add(rect);
			}	
		}
		
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2D = (Graphics2D) g;
		g2D.setPaint(Color.red);
		
		for(Bricks rect : rects) {
			if(rect.getBroken() == false)
				g2D.fillRect(rect.x, rect.y, 50, 50);
		}
		
		
		g2D.setPaint(Color.white);
		g2D.fillOval(ballX, ballY, ballWidth, ballHeight);
		
		ballRect = new Rectangle(ballX,ballY,ballWidth,ballHeight);
		
		g2D.setPaint(Color.blue);
		g2D.fillRect(platformX, platformY, platformWidth, platformHeight);
		platformRect = new Rectangle(platformX, platformY, platformWidth, platformHeight);
		
		Toolkit.getDefaultToolkit().sync();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(ballX >= panelWidth - ballWidth || ballX<0)
			ballVelocityX *= -1;
		
		if(ballY >= panelHeight - ballHeight || ballY<0 || platformRect.intersects(ballRect))
			ballVelocityY *= -1;
	
		for(Bricks rect : rects) {
			if(rect.intersects(ballRect) && rect.getBroken() == false) {
				rect.setBroken(true);
				ballVelocityY *= -1;
				ballVelocityX *= -1;
				
				
			}
		}
		
		ballX += ballVelocityX;
		ballY += ballVelocityY; 
		
		repaint();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				platformX -= 10;
				break;
			case KeyEvent.VK_RIGHT:
				platformX += 10;
				break;
		}
			
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}

