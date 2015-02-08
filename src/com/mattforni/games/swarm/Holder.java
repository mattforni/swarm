package com.mattforni.games.swarm;

/*
 * VERY simple holder pattern intended to help us keep track of the current selected behavior.
 *
 * @author <Matt Fornaciari>
 **/

public class Holder implements SwarmConstants {
	
	private BeeBehavior _currBehavior;
	
	public Holder() {
		_currBehavior = new DoNothingBehavior();
	}
	
	public BeeBehavior getBehavior() {
		return _currBehavior;
	}
	
	public void setBehavior(BeeBehavior behavior) {
		_currBehavior = behavior;
	}

}
