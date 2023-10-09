
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Frame extends JFrame{

	AnimationPanel panel = new AnimationPanel();
	
	Frame(){
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel);
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
		
	}

}
