package com.mattforni.games.swarm;

/*
 * This is the Frame in which the entirety of the program is held.  As you can see the frame is constructed
 * here in segments and added to the Swarm frame until we have the entire frame. There are three panels
 * added to this grame, the drawing panel, the behavior buttons and the add bee, quit buttons and the skin
 * options. 
 *
 * @author <Matt Fornaciari>
 **/

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Swarm extends JFrame implements SwarmConstants {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DrawingPanel _dp;
	private Vector<String> _actions;
	private Holder _holder;
	
	public Swarm() {
		super("Swarm-ish");
	
		_actions = new Vector<String>();
		_holder = new Holder();
		initActions();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		construct();
		
		pack();
		setVisible(true);
	}
	
	private void initActions() {
		_actions.add("R & R .");
		_actions.add("Coup D'etat .");
		_actions.add("Roll Out .");
	}
	
	/** begin frame construction **/
	private void construct() {
		setLayout(new BorderLayout());
		
		constructCenter(DP_WIDTH, DP_HEIGHT);
		constructEast(_actions);
		constructSouth();
	}
	
	/**** begin center panel construction ****/
	private void constructCenter(int width, int height) {
		_dp = new DrawingPanel(width, height, _holder);
		add(_dp, BorderLayout.CENTER);
	}
	/**** end center panel construction ****/
	
	/**** begin east panel construction ****/
	private void constructEast(Vector<String> actions) {
		JPanel actions_pnl = new JPanel(new GridLayout(3, 1));
		
		BehaviorButton relax = new BehaviorButton(actions.get(0), true, new DoNothingBehavior(), _holder);
	    BehaviorButton coup = new BehaviorButton(actions.get(1), false, new FollowLeaderBehavior(_dp.getQueen()), _holder);
	    BehaviorButton random = new BehaviorButton(actions.get(2), false, new MoveRandomlyBehavior(), _holder);
	    
	    // Group the radio buttons.
	    ButtonGroup action_grp = new ButtonGroup();
	    action_grp.add(relax);
	    action_grp.add(coup);
	    action_grp.add(random);
	    
	    actions_pnl.add(relax);
	    actions_pnl.add(coup);
	    actions_pnl.add(random);
	    
	    add(actions_pnl, BorderLayout.EAST);
	}
	/**** end east panel construction ****/
	
	/**** begin south panel construction ****/
	private void constructSouth() {
		JPanel button_pnl = new JPanel(new GridLayout(1, 3));
		
		// create the two required buttons : | add bee | quit |
		AddBeeButton bee_btn = new AddBeeButton(_dp);
		QuitButton quit_btn = new QuitButton();
		
		button_pnl.add(bee_btn);
		button_pnl.add(quit_btn);

		// create the skins panel
		JPanel skins = new JPanel(new GridLayout(3, 1));
		skins.add(new JLabel("Skins"));
		
		SkinButton orig = new SkinButton(SKIN.orig, "original .", true, _dp);
		SkinButton space = new SkinButton(SKIN.future, "future .", false, _dp);
		
		ButtonGroup skin_grp = new ButtonGroup();
		skin_grp.add(orig);
		skin_grp.add(space);
		
		skins.add(orig);
		skins.add(space);
		
		button_pnl.add(skins);		
		
		add(button_pnl, BorderLayout.SOUTH);		
	}
	/**** end south panel construction ****/
	/** end frame construction **/
}
