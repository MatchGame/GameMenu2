import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu2 extends JFrame {

	private JPanel contentPane;
	private static int mode = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu2 frame = new Menu2(mode);
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
	public Menu2(int mode) {
		this.mode = mode;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnEasy = new JButton("Easy");
		btnEasy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.revalidate();
				contentPane.repaint();
				MemoryGame Game = new MemoryGame(4);
				Game.newGame(3,2,mode);
				
				
			}
		});
		contentPane.add(btnEasy);
		
		JButton btnMedium = new JButton("Medium");
		btnMedium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				MemoryGame Game = new MemoryGame(20);
				Game.newGame(19,6,mode);
			}
		});
		contentPane.add(btnMedium);
		
		JButton btnHard = new JButton("Hard");
		btnHard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemoryGame Game = new MemoryGame(34);
				Game.newGame(33,8,mode);
			}
		});
		contentPane.add(btnHard);
	}
	
	public JPanel returnContent(){
		return contentPane;
	}

}
