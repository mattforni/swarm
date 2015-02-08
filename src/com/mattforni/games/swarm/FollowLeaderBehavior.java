package com.mattforni.games.swarm;

import java.awt.Point;

import com.mattforni.graphics.Shape;

public class FollowLeaderBehavior extends MoveBehavior {
    private Shape _leader;

    public FollowLeaderBehavior(final Shape shape) {
        this(null, shape);
    }

    public FollowLeaderBehavior(final Shape shape, final Shape leader) {
        super(shape);
        this._leader = leader;
    }

    @Override
    public void activate() {
        if (target != null) {
            direction = direction.createDirectionallyConstrainedVector(new Point((int)target.getX(), (int)target.getY()), new Point((int)this._leader.getX(), (int)this._leader.getY()));
            super.activate();
        }
    }

    @Override
    public BeeBehavior copy() {
        return new FollowLeaderBehavior(this._leader);
    }
}
