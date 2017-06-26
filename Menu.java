import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Menu extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JPanel contentPane2;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		// Game Menu
		JMenu options = new JMenu("Options");
		menuBar.add(options);
		// Sub Menu
		newMenuItem("New Game" , options, this);
		newMenuItem("Exit" , options, this);
		// About Menu
		JMenu aboutMenu = new JMenu("About");
		menuBar.add(aboutMenu);
		newMenuItem("Help", aboutMenu, this);
		newMenuItem("About", aboutMenu, this);
		newMenuItem("etc...", aboutMenu, this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 567, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));

		
		
		JButton btnPracticeMode = new JButton("Practice Mode");
		btnPracticeMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menu2 menu = new Menu2(1);
				contentPane.revalidate();
				contentPane.repaint();
				setContentPane(menu.getContentPane());
			}
		});
				
		contentPane.add(btnPracticeMode);
		
		JButton btnComputerMode = new JButton("Computer Mode");
		btnComputerMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu2 menu = new Menu2(2);
				contentPane.revalidate();
				contentPane.repaint();
				
				setContentPane(menu.getContentPane());
				
				}});
		contentPane.add(btnComputerMode);
	}
	
	private void newMenuItem(String string, JMenu menuBar, ActionListener listener) {
		JMenuItem newitem = new JMenuItem(string);
		newitem.setActionCommand(string);
		newitem.addActionListener(listener);
		menuBar.add(newitem);

	}
	
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("New Game")){
			setContentPane(contentPane);
		}
		if(arg0.getActionCommand().equals("Exit")){
			System.exit(0);
		}
	
}
}


