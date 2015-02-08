package com.mattforni.games.swarm;

import com.mattforni.graphics.Shape;

public abstract class BeeBehavior {
    public static final BehaviorController CONTROLLER = new BehaviorController();

    protected Shape target;

    public BeeBehavior(final Shape target) {
        this.target = target;
    }
    
    public final void setTarget(final Shape target) {
        this.target = target;
    }
    
    public final Shape getTarget() {
        return target;
    }
    
    public final void start() {
        BeeBehavior.CONTROLLER.addBehavior(this);
    }
    
    public final void stop() {
        BeeBehavior.CONTROLLER.removeBehavior(this);
    }

    public abstract BeeBehavior copy();
    public abstract void activate();
}
