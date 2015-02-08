package com.mattforni.games.swarm;

import com.mattforni.graphics.Shape;

public class MoveRandomlyBehavior extends MoveBehavior {
    public MoveRandomlyBehavior() {
        this(null);
    }

    public MoveRandomlyBehavior(final Shape shape) {
        super(shape);
    }

    @Override
    public void activate() {
        if (target != null) {
            direction = direction.createRandomlyConstrainedVector();
            super.activate();
        }
    }

    @Override
    public BeeBehavior copy() {
        return new MoveRandomlyBehavior();
    }
}
