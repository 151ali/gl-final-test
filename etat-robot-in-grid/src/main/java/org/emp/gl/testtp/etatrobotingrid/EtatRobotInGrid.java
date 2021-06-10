package org.emp.gl.testtp.etatrobotingrid;
import org.emp.gl.testtp.etatrobot.EtatRobot;
import org.emp.gl.testtp.etatrobotlistener.EtatRobotListener;
import org.emp.gl.testtp.robot.Robot;


import java.awt.event.KeyEvent;
import java.beans.PropertyChangeSupport;

public class EtatRobotInGrid extends EtatRobot {
    private Robot robot;
    private Direction direction = Direction.NORTH;


    private Position last_pos = new Position();


    public EtatRobotInGrid(Robot robot){
        this.robot = robot;
        initPosition();
    }

    public void initPosition(){
        this.last_pos.setX(5);
        this.last_pos.setY(5);
    }

    public Direction getDirection(){
        return this.direction;
    }

    public Position getLast_pos() {
        return last_pos;
    }

    // In order to notify the grid
    PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    @Override
    public void up(){
        Position new_pos = new Position(last_pos.getX() - 1 , last_pos.getY());
        notify("my-grid",last_pos,new_pos);
    }

    @Override
    public void down() {
        Position new_pos = new Position(last_pos.getX() + 1 , last_pos.getY());
        notify("my-grid",last_pos,new_pos);
    }
    @Override
    public void left(){
        Position new_pos = new Position(last_pos.getX() , last_pos.getY() - 1);
        notify("my-grid",last_pos,new_pos);
    }
    @Override
    public void right(){
        Position new_pos = new Position(last_pos.getX() , last_pos.getY() + 1);
        notify("my-grid",last_pos,new_pos);
    }

    @Override
    public void setPosition(Integer x, Integer y){
        this.last_pos.setX(x);this.last_pos.setY(y);
    }

    // TODO : add abstractions !
    public void notify(String destination, Position old_pos, Position new_pos) {
        pcs.firePropertyChange(destination, old_pos, new_pos);
    }

    @Override
    public void subscribe(EtatRobotListener listener) {
        System.out.println(listener);
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
                // System.out.println("go forward");
                if(direction == Direction.NORTH){
                    up();
                }
                if(direction == Direction.WEST || direction == Direction.EAST){
                    direction = Direction.NORTH;
                }
                break;
            case 'q':
                // System.out.println("turn left");
                if(direction == Direction.WEST){
                    left();
                }
                if(direction == Direction.NORTH){
                    direction = Direction.WEST;
                }
                if(direction == Direction.SOUTH){
                    direction = Direction.EAST;
                }
                break;
            case 'd':
                // System.out.println("turn right");
                if(direction == Direction.EAST){
                    right();
                }
                if(direction == Direction.SOUTH){
                    direction = Direction.WEST;
                }
                if(direction == Direction.NORTH){
                    direction = Direction.EAST;
                }
                break;
            case 's':
                if(direction == Direction.SOUTH){
                    down();
                }
                if(direction == Direction.EAST){
                    direction = Direction.SOUTH;
                }
                if(direction == Direction.WEST){
                    direction = Direction.NORTH;
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
