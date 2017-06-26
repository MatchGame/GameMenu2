import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.AWTException;
import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;



public class Computer extends cardController{
	ArrayList<Card> cards;
	Random rand = new Random();
	private int random1;
	private int random2;
	
	
	public Computer(ArrayList<Card> cards){
		this.cards = cards;
	}
	
	public Card[] generateCards(){
		random1 = rand.nextInt(cards.size());
		random2 = rand.nextInt(cards.size());
		
		Card card1 = cards.get(random1);
		Card card2 = cards.get(random2);
	
		Card[] Choice = new Card[2];
		Choice[0] = card1;
		Choice[1] = card2;
		
		return Choice;
		
		
		
		
	}
	
}
	