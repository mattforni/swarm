package com.mattforni.games.swarm;

/*
 * This adds a bee or a ship to their respective collections via the
 * drawing panel's addNewBee method.
 *
 * @author <Matt Fornaciari>
 **/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AddBeeButton extends JButton {

	private static final long serialVersionUID = 1L;

	public AddBeeButton(DrawingPanel dp) {
		super("Recruit .");
		
		addActionListener(new AddListener(dp));
	}
	
	private class AddListener implements ActionListener {

		private DrawingPanel _dp;
		
		public AddListener(DrawingPanel dp) {
			_dp = dp;
		}
		
		public void actionPerformed(ActionEvent arg0) {
			_dp.addNewBee();
		}
		
	}
}
