package com.mattforni.games.swarm;

/*
 * This just quits the program -- that's it.
 *
 * @author <Matt Fornaciari>
 **/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class QuitButton extends JButton {

	private static final long serialVersionUID = 1L;

	public QuitButton() {
		super("Terminate .");
		
		addActionListener(new QuitListener());
	}
	
	private class QuitListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}
		
	}

	
}
