package com.mattforni.games.swarm;

/*
 * Like the BehaviorButton this is also an extension of the JRadioButton class.  This class
 * merely keeps track of which skin should be displayed.
 *
 * @author <Matt Fornaciari>
 **/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

import com.mattforni.games.swarm.SwarmConstants.SKIN;

public class SkinButton extends JRadioButton {

	private static final long serialVersionUID = 1L;

	public SkinButton(SKIN skin, String text, boolean tf, DrawingPanel dp) {
		super(text, tf);	
		addActionListener(new SkinListener(skin, dp));
	}
	
	private class SkinListener implements ActionListener {
		
		private DrawingPanel _dp;
		private SKIN _skin;
		
		public SkinListener(SKIN skin, DrawingPanel dp) {
			_skin = skin;
			_dp = dp;
		}

		public void actionPerformed(ActionEvent e) {
			_dp.setSkin(_skin);
		}
		
		
	}
}
