package org.emp.gl.testtp.etatrobot;

import org.emp.gl.testtp.etatrobotlistener.EtatRobotListener;

import java.awt.event.KeyListener;

public abstract class EtatRobot implements KeyListener {

    public abstract void subscribe(EtatRobotListener listener);
    public abstract void unsubscribe(EtatRobotListener listener);
    public abstract void setPosition(Integer x, Integer y);
    public abstract Object getPosition();
    public abstract void down();
    public abstract void up();
    public abstract void right();
    public abstract void left
            ();
}
