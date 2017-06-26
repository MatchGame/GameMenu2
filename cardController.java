import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.util.TimerTask;
import java.util.Vector;

public class cardController implements ActionListener {
	private Vector turnedCards;
	private Timer turnDowntimer;
	private final int turnDownDelay = 2000; // measured in millesenconds
	
	public cardController(){
		this.turnedCards = new Vector(2);
		this.setTurnDowntimer(new Timer(this.turnDownDelay,this));
		this.getTurnDowntimer().setRepeats(false);
	}
		
	
	public boolean checkForTwo(Card card){
		if (this.turnedCards.size() < 2){
			return
			toAddCards(card);
		}
		return false;
	}
	
	protected boolean toAddCards(Card card){
		this.turnedCards.add(card);
		
		if (this.turnedCards.size() == 2) {
			Card otherCard = (Card)this.turnedCards.get(0);
			if(otherCard.getNum() == card.getNum()){
				this.turnedCards.clear();
			}else{
				this.getTurnDowntimer().start();
			}
			
		
		}
			
		return true;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		for (int i = 0; i<this.turnedCards.size();i++){
			Card card = (Card)this.turnedCards.get(i);
			card.flipDown();
		}
		
		this.turnedCards.clear();
	}


	public Timer getTurnDowntimer() {
		return turnDowntimer;
	}


	public void setTurnDowntimer(Timer turnDowntimer) {
		this.turnDowntimer = turnDowntimer;
	}
}



