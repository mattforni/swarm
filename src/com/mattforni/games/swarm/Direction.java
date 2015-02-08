package com.mattforni.games.swarm;

import java.awt.*;

public class Direction
{
    private int _dx;
    private int _dy;
    private int _angle;
    private double _vel;
    
    public Direction() {
        this._angle = 0;
        this._vel = 0.0;
        this.setDeltas();
    }
    
    public Direction(final int angle, final double vel) {
        this._angle = angle;
        this._vel = vel;
        this.setDeltas();
    }
    
    public Direction add(final Direction direction) {
        this.setDeltas();
        final double velocity = direction.getVelocity();
        final double n = direction.getRotation();
        final double n2 = velocity * Math.cos(n * 3.141592653589793 / 180.0);
        final double n3 = velocity * Math.sin(n * 3.141592653589793 / 180.0);
        final double n4 = this._dx + n2;
        final double n5 = this._dy + n3;
        return new Direction((int)(Math.atan2(n5, n4) / 3.141592653589793 * 180.0), Math.sqrt(n4 * n4 + n5 * n5));
    }
    
    private void setDeltas() {
        this._dx = (int)(this._vel * Math.cos(this._angle * 3.141592653589793 / 180.0));
        this._dy = (int)(this._vel * Math.sin(this._angle * 3.141592653589793 / 180.0));
    }
    
    public Point movePositionAlong(final Point point) {
        return new Point(point.x + this._dx, point.y + this._dy);
    }
    
    private double limitChange(final double n, final double n2) {
        if (n < -n2) {
            return -n2;
        }
        if (n > n2) {
            return n2;
        }
        return n;
    }
    
    private double limitGreaterZero(final double n) {
        if (n < 0.0) {
            return 0.0;
        }
        return n;
    }
    
    public Direction createRandomlyConstrainedVector() {
        double n = Math.random() * 22.0;
        double n2 = Math.random() * 5.0;
        if ((int)(Math.random() * 2.0) == 1) {
            n = -n;
        }
        if ((int)(Math.random() * 2.0) == 1) {
            n2 = -n2;
        }
        return new Direction((int)(this._angle + this.limitChange(n, 22.0)), this.limitGreaterZero(this.limitChange(this._vel + n2, 15.0)));
    }
    
    public Direction createDirectionallyConstrainedVector(final Point point, final Point point2) {
        final double n = point2.x - point.x;
        final double n2 = point2.y - point.y;
        final double n3 = Math.atan2(n2, n) / 3.141592653589793 * 180.0;
        final double sqrt = Math.sqrt(n * n + n2 * n2);
        final double n4 = this._angle;
        double n5;
        if (Math.abs(n3 - n4) < Math.abs(n3 - n4 + 360.0)) {
            if (Math.abs(n3 - n4) < Math.abs(n3 - n4 - 360.0)) {
                n5 = n3 - n4;
            }
            else {
                n5 = n3 - n4 - 360.0;
            }
        }
        else if (Math.abs(n3 - n4 + 360.0) < Math.abs(n3 - n4 - 360.0)) {
            n5 = n3 - n4 + 360.0;
        }
        else {
            n5 = n3 - n4 - 360.0;
        }
        return new Direction((int)(this._angle + this.limitChange(n5, 22.0)) % 360, this.limitGreaterZero(this.limitChange(this._vel + this.limitChange(sqrt, 5.0), 10.0 + Math.random() * 10.0)));
    }
    
    public double getVelocity() {
        return this._vel;
    }
    
    public void setVelocity(final double vel) {
        this._vel = vel;
        this.setDeltas();
    }
    
    public int getRotation() {
        return this._angle;
    }
    
    public void setRotation(final int angle) {
        this._angle = angle;
        this.setDeltas();
    }
    
    public void rotate(final int n) {
        this.setRotation(this._angle + n);
    }
    
    public Direction copy() {
        return new Direction(this._angle, this._vel);
    }
}
