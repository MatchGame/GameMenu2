import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.MenuBar;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.event.AncestorListener;
import javax.swing.BoxLayout;

public class MemoryGame implements ActionListener{
	private JFrame mainframe;
	private Container mainContentPane;
	private Component menu;
	private ImageIcon cardIcon[];
	private ArrayList<Card> cards = new ArrayList<Card>();
	//private GameMenu sizes = new GameMenu();
	private int difficulty = 0;
	private int mode = 0;
	private int gridLayout = 0;
	private cardController controller;
	private Timer timer;
	
	

	public MemoryGame(int num){
		// main window
		this.mainframe = new JFrame("Memory Game");
		this.mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainframe.setSize(1500,1500);
		this.mainContentPane = this.mainframe.getContentPane();
		this.mainContentPane.setLayout(new BoxLayout(this.mainContentPane, BoxLayout.PAGE_AXIS));
		
		JLabel time = new JLabel("00:00");
		mainContentPane.add(time);
		// need to load up the cards
		this.cardIcon = loadcardIcons(num);
		controller = new cardController();

	}
	
	

	private Image getScaledImage(Image srcImg, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();

	    return resizedImg;
	}

	// this will load the card icons onto the cards
	private ImageIcon[] loadcardIcons(int j) {
		ImageIcon icon[] = new ImageIcon[j];
		for(int i = 0; i < j; i++){
			String filename = "Images/face"+i+".jpg";
			icon[i] = new ImageIcon(filename);
			Image image =icon[i].getImage();
			Image newimg = image.getScaledInstance(125, 125, java.awt.Image.SCALE_SMOOTH);
			icon[i] = new ImageIcon(newimg);
		}

		return icon;
	}

	// creating the card making
	public JPanel makeCards(int num2, int size){
		//gridSize = sizes.getGridLayout();
		JPanel panel = new JPanel(new GridLayout(size,size));
		// all cards have the same back
	
		
		ImageIcon backIcon = new ImageIcon("Images/backgroung.jpg");
		Image image = backIcon.getImage();
		Image reSizedBkg = image.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
		backIcon = new ImageIcon(reSizedBkg);

		
		// generating a CPU
		

		// adding a certain amount of cards
		int cardsToAdd[] = new int[(num2-1)*2];
		for (int i = 0; i < num2-1 ; i ++){
			cardsToAdd[2*i] = i;
			cardsToAdd[2*i+1] = i;
		}

		randomizeCardArray(cardsToAdd);


		// make card Object
		for (int i = 0; i < cardsToAdd.length; i++){
			int num = cardsToAdd[i];
			Card newCard = new Card(this.controller,this.cardIcon[num], backIcon, num);
			panel.add(newCard);
			cards.add(newCard);
		}
		
	
		return panel;
	}

	private void randomizeCardArray(int[] t) {
		Random random = new Random();
		for (int i = 0; i < t.length; i++ ){
			int rand = random.nextInt(t.length);
			// swapping the cards
			int s = t[rand];
			t[rand] = t[i];
			t[i] = s;
		}


	}
	

	public void newGame(int num,int size,int mode){
		this.mainContentPane.removeAll();
		//creating a new Game
		this.mainContentPane.add(makeCards(num,size));
		startTime = System.currentTimeMillis();
		// showing the main window

		this.mainframe.setVisible(true);
		
		
		
		
		
		
		Computer computer = new Computer(cards);
		
		while(){
		Card[] chosen = computer.generateCards();
		chosen[0].flipUp();
		chosen[1].flipUp();
		}
		
			
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("New Game")){
			newGame(difficulty-1,gridLayout, mode);
		}
		if(arg0.getActionCommand().equals("Exit")){
			System.exit(0);
		}
		/*
		if(arg0.getActionCommand().equals("Easy")){
			difficulty = 5;
			gridLayout = 2;
		}
		if(arg0.getActionCommand().equals("Medium")){
			difficulty = 9;
			gridLayout = 4;
		}
		if(arg0.getActionCommand().equals("Hard")){
			difficulty = 9;
			gridLayout = 4;
		}
		if(arg0.getActionCommand().equals("Practice")){
			mode = 1;
		}
		if(arg0.getActionCommand().equals("1 vs 1")){
			mode = 1;
		}
		if(arg0.getActionCommand().equals("1 vs CPU")){
			mode = 3;
		}
		*/
	}
		
		
		
		public ImageIcon[] getIcon(){
			return cardIcon;
		}
		
		public ArrayList<Card> getCards(){
			return cards;
		}
		
		public Container getContent(){
			return mainContentPane;
		}
		
		public void setSize(int size){
			this.gridLayout = size;
		}


		public boolean checkforWin(){
			int count = 0;
			
			for (int i = 0;  i < cards.size();i++){
				if (cards.get(i).faceup == false){
					count +=1;
				}
			}
			if (count == 0){
				long estimatedTime = System.currentTimeMillis() - startTime;
				double finalpoints = 0;
            	System.out.print("Time to Finish: " + estimatedTime);
            	if(estimatedTime < 30000){
            		finalPoints = 1000 * estimatedTime/0.8;
            	} else if(estimatedTime < 45000){
            		finalPoints = 800 * estimatedTime/0.5;
            	} else if(estimatedTime < 100000){
            		finalPoints = 600 * estimatedTime/0.2;
            	} else{
            		finalPoints = 0;
            	}
            	System.out.print("Final Score: " + finalPoints);
				return true;
			}else{
				return false;
			}
		}



}


