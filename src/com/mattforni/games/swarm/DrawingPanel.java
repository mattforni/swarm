package com.mattforni.games.swarm;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JPanel;

import com.mattforni.graphics.Image;

/*
 * The Drawing Panel is the rendering system for the application and is where
 * all of the shapes are displayed.  
 * 
 * It has two collections of graphics and two backgrounds, one for each skin, as well a
 * holder to tell the shapes how to behave.  It is this class that holds all of the graphical
 * information and it is the only class that knows how to render the images.  
 * 
 * @author <Matt Fornaciari>
 *
 */

public class DrawingPanel extends JPanel implements SwarmConstants {

	private static final long serialVersionUID = 1L;
	private GraphicsCollection _bees, _ships, _use;
	private Holder _holder;
	private Bee _queen;
	private Random _r;
	private Image _currBkg, _beeBkg, _shipBkg;

	public DrawingPanel(int width, int height, Holder holder) {
		super();
		setBackground(java.awt.Color.white);
		setSize(new Dimension(width, height));
		setPreferredSize(new Dimension(width, height));
		addMouseListener(new BeeClickListener());
		setVisible(true);	
		
		_beeBkg = new Image("images/honeycomb.jpg", this, 0, 0, 500, 500);
		_shipBkg = new Image("images/space.jpg", this, 0, 0, 500, 500);
		_currBkg = _beeBkg;
		
		_bees = new GraphicsCollection(this);
		_ships = new GraphicsCollection(this);
		_use = _bees;
		_holder = holder;
		
		_queen = new Bee(this, _holder, true, new Point(DP_WIDTH/2, DP_HEIGHT/2));
		new MoveRandomlyBehavior().setTarget(_queen);
		_bees.addGraphic(_queen);
		_ships.addGraphic(_queen);
		_r = new Random();
		
	}
	
	public Bee getQueen() {
		return _queen;
	}
	
	public void setSkin(SKIN skin) {		
		if (skin == SKIN.orig) {
			_use = _bees;
			_currBkg = _beeBkg;	
		}
		else {
			_use = _ships;
			_currBkg = _shipBkg;
		}
	}
	
	public void addNewBee() {
		Point p = new Point(_r.nextInt(DP_WIDTH), _r.nextInt(DP_HEIGHT));
		_bees.addGraphic(new Bee(this, _holder, false, p));
		_ships.addGraphic(new Ship(this, _holder, p));
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D brush = (Graphics2D)g;
		
		// objects to paint go here
		_currBkg.paint(brush);
		_use.paintAllGraphics(brush);
	}
	
	/* this is the mouse listener class that tells the 
	 * collection where i clicked so that it can do the 
	 * rest */
    private class BeeClickListener extends MouseAdapter {
    	public void mouseClicked(MouseEvent e){
    		_bees.respondToMouseClick(e.getPoint());
    		_ships.respondToMouseClick(e.getPoint());
    	}
    }
	
}

