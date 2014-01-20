package algorithm.comp3203;

import java.awt.Color;

import javax.swing.JFrame;

public class GUIFrame extends JFrame {

	public GUI gui;
	public GUIFrame(){
		gui = new GUI();
		gui.createSim();
	}
	
	public void createAndShowGUIFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(gui);
		setBackground(Color.white);
		pack();
		setVisible(true);
	}
	
}
