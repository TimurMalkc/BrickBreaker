import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JLabel;

public class Bricks extends JLabel {
	
	private int id;
	static ArrayList<Bricks> brickList = new ArrayList<Bricks>();

	Bricks(int argId){
		
		this.setId(argId);
		this.setPreferredSize(new Dimension(70,50));
		this.setBackground(Color.red);
		this.setOpaque(true);
		brickList.add(this);
		
		
	}
	
	
	
	public int getId(){
		return this.id;
	}
	
	public void setId(int argId) {
		this.id = argId;
	}
}
