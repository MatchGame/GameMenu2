import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MemoryGame {
	private JFrame mainframe;
	private Container mainContentPane;
	private ImageIcon cardIcon[];
	
	public MemoryGame(){
		// main window
		this.mainframe = new JFrame("Memeory Game");
		this.mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainframe.setSize(400,500);
		
		
	}

}
