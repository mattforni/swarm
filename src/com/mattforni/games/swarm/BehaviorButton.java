package com.mattforni.games.swarm;

/*
 * This is a specific instance of the JRadioButton.  Basically it just watches to see which action
 * is selected and when a new action is selected as the current action it updates the holder.
 *
 * @author <Matt Fornaciari>
 **/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

public class BehaviorButton extends JRadioButton {

	private static final long serialVersionUID = 1L;
	
	public BehaviorButton(String name, boolean tf, BeeBehavior action, Holder holder) {
		super(name, tf);
		addActionListener(new ActionsListener(holder, action));
	}
	
	private class ActionsListener implements ActionListener {
		
		private Holder _holder;
		private BeeBehavior _action;
		
		public ActionsListener(Holder holder, BeeBehavior action) {
			_holder = holder;
			_action = action;
		}

		public void actionPerformed(ActionEvent e) {
			_holder.setBehavior(_action);
		}
	}


}
