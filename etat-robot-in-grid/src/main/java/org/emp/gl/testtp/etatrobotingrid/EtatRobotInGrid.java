package org.emp.gl.testtp.etatrobotingrid;
import org.emp.gl.testtp.etatrobot.EtatRobot;
import org.emp.gl.testtp.etatrobotlistener.EtatRobotListener;
import org.emp.gl.testtp.position.Position;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeSupport;

public class EtatRobotInGrid extends EtatRobot implements KeyListener {
    private Position p = new Position(0,0);

    public EtatRobotInGrid(Integer x, Integer y){
        this.p.setX(x);this.p.setX(y);
    }

    // In order to notify the grid
    PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    @Override
    public void changeEtat(){
        // TODO : in the function of pressed key
        Position old_pos = p;
        Position new_pos = new Position(8,8);

        notify("grid",old_pos,new_pos);
    }



    // TODO : add abstractions !
    public void notify(String destination, Position old_pos, Position new_pos) {
        pcs.firePropertyChange(destination, old_pos, new_pos);
    }

    public void subscribe(EtatRobotListener listener) {
        pcs.addPropertyChangeListener(listener.getName(), listener);
    }

    public void unsubscribe(EtatRobotListener listener) {
        pcs.removePropertyChangeListener(listener);
    }


    // ? Handle keyboard evt to change the robot state
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyChar()){
            case 'z':
                // go forward

                break;
            case 'q':
                // turn left
                break;
            case 'd':
                // turn right
                break;
        }


        System.out.println("Key pressed code=" + e.getKeyCode() + ", char=" + e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
