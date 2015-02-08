package com.mattforni.games.swarm;

/* 
 * This is the Bee class and it extends the Ellipse class to give it it's shape.  It also
 * extends the Directional interface so that it may respond to BeeBehaviors appropriately.
 * When a bee is created it asks the holder what the current behavior is, takes a copy of it
 * and then starts the behavior on itself.
 *
 * @author <Matt Fornaciari>
 **/

import java.awt.Color;
import java.awt.Point;

import com.mattforni.graphics.shape.Ellipse;

public class Bee extends Ellipse implements SwarmConstants {
	
    private BeeBehavior _behavior;
    private Holder _holder;
    private Direction _direction;
    private boolean _queen;
	
	public Bee(DrawingPanel dp, Holder holder, boolean queen, Point p) {
		super(dp, 0, 0, B_WIDTH, B_HEIGHT);
		setLocation(p.x, p.y);
		
		_queen = queen;
		_holder = holder;
		_direction = new Direction();
		
		if (_queen) {
			_behavior = new MoveRandomlyBehavior();
			setFillColor(Color.PINK);
			setLocation(DP_WIDTH/2, DP_HEIGHT/2);
		}
		else {
			_behavior = _holder.getBehavior().copy();
			setFillColor(Color.YELLOW);
		}
			
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
