import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.JLabel;

public class Card extends JLabel implements MouseListener{
	
	Icon faceicon;
	Icon backicon;
	boolean faceup = false;
	
	int num;
	int iconWidthHalf, iconHeightHalf;
	boolean mousePressedOnMe = false;
	
	
	public Card(Icon face, Icon back,int num){
		super(back);
		this.faceicon= face;
		this.backicon= back;
		this.num = num;
		// catch mouse clicks
		this.addMouseListener(this);
		this.iconHeightHalf = back.getIconHeight()/2;
		this.iconWidthHalf= face.getIconWidth()/2;
		
	}
	
	public int getNum(){
		return num;
	}
	
	private boolean overIcon(int x, int y){
		
		int distX = Math.abs(x-(this.getWidth()/2));
		int distY = Math.abs(y-(this.getHeight()/2));
		//outside
		if (distX > iconHeightHalf || distY > iconWidthHalf){
			return false;
		}
		// inside
		return true;
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (overIcon(arg0.getX(), arg0.getY())){
			this.flipUp();
		}
		
	}

	private void flipUp() {
		if (this.faceup){
			return;
		}
		
		if (this.faceup){
			this.setIcon(faceicon); // flips the card up
			
		}
		
	}
	
	private void flipDown(){
		if (!this.faceup){
			return;
			}
		
		this.setIcon(backicon);
		this.faceup = false;
		// card is flipped down
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		this.mousePressedOnMe = false;
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		if (overIcon(arg0.getX(), arg0.getY())){
			this.mousePressedOnMe = true;
			
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		if (this.mousePressedOnMe){
			this.mousePressedOnMe = false;
			this.mouseClicked(arg0);
		}
		
	}
	
}
