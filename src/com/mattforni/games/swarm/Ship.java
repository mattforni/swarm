package com.mattforni.games.swarm;

import java.awt.Color;
import java.awt.Point;

import com.mattforni.graphics.Image;

/*
 * This class is exactly like the Bee class in terms of functionality, but extends from the Image
 * class instead of the Ellipse class since it is an image that I am using instead of a shape. 
 *
 * @author <Matt Fornaciari>
 **/

public class Ship extends Image implements SwarmConstants {
	
    private BeeBehavior _behavior;
    private Holder _holder;
    private Direction _direction;
    
	public Ship(DrawingPanel dp, Holder holder, boolean queen, Point p) {
		super("images/mship.png", dp, p.x, p.y, 90, 70);
		
		_holder = holder;
		_direction = new Direction();
		
		_behavior = new MoveRandomlyBehavior();
		setFillColor(Color.PINK);
		setLocation(DP_WIDTH/2, DP_HEIGHT/2);

		_behavior.setTarget(this);
		_behavior.start();
	}
	
	public Ship(DrawingPanel dp, Holder holder, Point p) {
		super("images/ship.png", dp, p.x, p.y, 70, 60);
		
		_holder = holder;
		_direction = new Direction();

		_behavior = _holder.getBehavior().copy();
		_behavior.setTarget(this);
		_behavior.start();
	}
    
    public Direction getDirection(){
    	return _direction;
    }

    public void setDirection(Direction direction){
    	_direction = direction;
    }

    public void react(){
    	_behavior.stop();
    	_behavior = _holder.getBehavior().copy();
    	_behavior.setTarget(this);
    	_behavior.start();
    }

}
