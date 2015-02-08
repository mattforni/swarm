package com.mattforni.games.swarm;

import com.mattforni.graphics.Shape;

public class DoNothingBehavior extends BeeBehavior
{
    public DoNothingBehavior() {
        this(null);
    }
    
    public DoNothingBehavior(final Shape shape) {
        super(shape);
    }
    
    @Override
    public void activate() {
    }
    
    @Override
    public BeeBehavior copy() {
        return new DoNothingBehavior();
    }
}
