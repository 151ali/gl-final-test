package org.emp.gl.testtp.etatrobotingrid;
import org.emp.gl.testtp.etatrobot.EtatRobot;
import org.emp.gl.testtp.etatrobotlistener.EtatRobotListener;
import org.emp.gl.testtp.robot.Robot;


import java.awt.event.KeyEvent;
import java.beans.PropertyChangeSupport;

public class EtatRobotInGrid extends EtatRobot {
    private Robot robot;

    private Position last_pos = new Position();


    public EtatRobotInGrid(Robot robot){
        this.robot = robot;
        initPosition();
    }

    public void initPosition(){
        this.last_pos.setX(5);
        this.last_pos.setY(5);
    }

    // In order to notify the grid
    PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    @Override
    public void up(){
        Position new_pos = new Position(last_pos.getX() - 1 , last_pos.getY());
        notify("my-grid",last_pos,new_pos);
    }
    @Override
    public void left(){
        Position new_pos = new Position();

        notify("my-grid",last_pos,new_pos);
    }
    @Override
    public void right(){
        Position new_pos = new Position();

        notify("my-grid",last_pos,new_pos);
    }


    // TODO : add abstractions !
    public void notify(String destination, Position old_pos, Position new_pos) {
        pcs.firePropertyChange(destination, old_pos, new_pos);
    }

    @Override
    public void subscribe(EtatRobotListener listener) {
        pcs.addPropertyChangeListener(listener.getName(), listener);
    }
    @Override
    public void unsubscribe(EtatRobotListener listener) {
        pcs.removePropertyChangeListener(listener);
    }


    // ? Handle keyboard evt to change the robot state
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // System.out.println("Key pressed code=" + e.getKeyCode() + ", char=" + e.getKeyChar());
        switch(e.getKeyChar()){
            case 'z':
                System.out.println("go forward");
                up();
                break;
            case 'q':
                System.out.println("turn left");
                left();
                break;
            case 'd':
                System.out.println("turn right");
                right();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
