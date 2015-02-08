package com.mattforni.games.swarm;

import java.awt.Point;

import com.mattforni.graphics.Shape;

public abstract class MoveBehavior extends BeeBehavior {
    protected Direction direction;

    public MoveBehavior() {
        this(null);
    }

    public MoveBehavior(final Shape shape) {
        super(shape);
        this.direction = new Direction();
    }

    @Override
    public void activate() {
        final Point movePositionAlong = direction.movePositionAlong(new Point((int)target.getX(), (int)target.getY()));
        target.setLocation(movePositionAlong.x, movePositionAlong.y);
        target.setRotation(direction.getRotation());
    }
}
