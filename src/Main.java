import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;


public class Main {
	/**
	 * @param args
	 * @throws IOException 
	 */
	
	static int difficulty = 0;
	
	public static void main(String args[]) throws IOException{
		final JFrame window = new JFrame("Java Tenis 2017");
		
		final JPanel menuPanel = new JPanel();
		
		
		
		// Top Logo
		BufferedImage logo = ImageIO.read(new File("resources/logo.png"));
		JLabel logoLabel = new JLabel(new ImageIcon(logo));
		logoLabel.setBounds(195, 30, 409, 234);
		
		// Difficulty Radio Buttons
		JRadioButton easyRadio = new JRadioButton("Easy");
		easyRadio.setBounds(250, 350 , 100, 20);
		easyRadio.setSelected(true);
		easyRadio.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  difficulty = 0;
			  }
		});
		
		JRadioButton mediumRadio = new JRadioButton("Medium");
		mediumRadio.setBounds(350, 350 , 100, 20);
		mediumRadio.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  difficulty = 1;
			  }
		});
		
		JRadioButton hardRadio = new JRadioButton("Hard");
		hardRadio.setBounds(450, 350 , 100, 20);
		hardRadio.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  difficulty = 2;
			  }
		});
		
	
	
		ButtonGroup dificultyGroup = new ButtonGroup();
		dificultyGroup.add(easyRadio);
		dificultyGroup.add(mediumRadio);
		dificultyGroup.add(hardRadio);
		
		// Play button
		JButton playButton = new JButton("Play");
		playButton.setBounds(350, 300 , 100, 20);
		playButton.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  //menuPanel.setVisible(false);
				  window.remove(menuPanel);
				  GamePanel game = new GamePanel(difficulty);
				  window.add(game);
				  //game.setFocusable(true);
				  game.requestFocusInWindow();
				  
				  window.setContentPane(game);
				  game.revalidate();
				  game.repaint();
			  }
		});
		
		// Info button
	    JButton infoButton = new JButton("Info");
	    infoButton.setBounds(350, 400 , 100, 20);
	    infoButton.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
			   // System.exit(0);
			  }
		});
	    
	    // Exit button
		JButton exitButton = new JButton("Exit");
		exitButton.setBounds(350, 450 , 100, 20);
		exitButton.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
			    System.exit(0);
			  }
		});
		
		
		menuPanel.setLayout(null);
		menuPanel.setSize(800, 600);
		menuPanel.setBackground(Color.white);
		menuPanel.add(logoLabel);
		menuPanel.add(playButton);
		menuPanel.add(easyRadio);
		menuPanel.add(mediumRadio);
		menuPanel.add(hardRadio);
		menuPanel.add(infoButton);
        menuPanel.add(exitButton);       
        menuPanel.setFocusable(false);
		window.add(menuPanel);
		
		//window.add(new GamePanel(0));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.setVisible(true);
		window.setSize(800, 600);
		
    }

}
