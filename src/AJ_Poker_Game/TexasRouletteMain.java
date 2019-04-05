package AJ_Poker_Game;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.synth.SynthSpinnerUI;



public class TexasRouletteMain {
	public static void main(String[] args) {
	
		JFrame main_frame = new JFrame();
		main_frame.setTitle("AJ Poker Game");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel top_panel = new JPanel();
		top_panel.setLayout(new BorderLayout());
		//create new game, input should be number of bots to play against
		TexasRoulette one = new TexasRoulette();
		//input game into UI
		top_panel.add(TexasRouletteImpl, BorderLayout.CENTER);
		main_frame.setContentPane(top_panel);

		main_frame.pack();
		main_frame.setVisible(true);
		
		
		
	}
}
