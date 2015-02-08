package com.mattforni.games.swarm;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Vector;

import javax.swing.JPanel;

import com.mattforni.graphics.Shape;

public class GraphicsCollection
{
    private Vector<Shape> _graphics;
    
    public GraphicsCollection(final JPanel drawingPanel) {
        this._graphics = new Vector<Shape>();
        BeeBehavior.CONTROLLER.setDrawingPanel(drawingPanel);
    }
    
    public void addGraphic(final Shape shapeInterface) {
        synchronized (this._graphics) {
            this._graphics.add(shapeInterface);
        }
    }
    
    public synchronized void removeGraphic(final Shape shapeInterface) {
        synchronized (this._graphics) {
            if (this._graphics.contains(shapeInterface)) {
                this._graphics.remove(shapeInterface);
            }
        }
    }
    
    public synchronized void respondToMouseClick(final Point point) {
        for (int i = 0; i < this._graphics.size(); ++i) {
            final Shape shapeInterface;
            synchronized (this._graphics) {
                shapeInterface = this._graphics.get(i);
            }
            if (shapeInterface.contains(point)) {
                shapeInterface.react();
            }
        }
    }
    
    public synchronized void paintAllGraphics(final Graphics graphics) {
        for (int i = 0; i < this._graphics.size(); ++i) {
            final Shape shapeInterface;
            synchronized (this._graphics) {
                shapeInterface = this._graphics.get(i);
            }
            shapeInterface.paint((Graphics2D)graphics);
        }
    }
}
