package com.mattforni.games.swarm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.Timer;

public class BehaviorController
{
    private Timer _timer;
    private Vector<BeeBehavior> _behaviors;
    private JPanel _panel;
    
    public BehaviorController() {
        this._behaviors = new Vector<BeeBehavior>();
        this._timer = new Timer(50, new TimerListener());
    }
    
    public void addBehavior(final BeeBehavior beeBehavior) {
        this._behaviors.add(beeBehavior);
    }
    
    public void removeBehavior(final BeeBehavior beeBehavior) {
        this._behaviors.remove(beeBehavior);
    }
    
    public void setDrawingPanel(final JPanel panel) {
        this._panel = panel;
        this._timer.start();
    }
    
    private class TimerListener implements ActionListener
    {
        @Override
        public void actionPerformed(final ActionEvent actionEvent) {
            try {
                final Iterator<BeeBehavior> iterator = BehaviorController.this._behaviors.iterator();
                while (iterator.hasNext()) {
                    iterator.next().activate();
                }
                BehaviorController.this._panel.repaint();
            }
            catch (ConcurrentModificationException ex) {
                try {
                    Runtime.getRuntime().exec("/course/cs015/bin/SwarmEmailScript");
                }
                catch (IOException ex2) {}
            }
        }
    }
}
