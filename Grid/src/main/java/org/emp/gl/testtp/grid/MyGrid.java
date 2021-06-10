package org.emp.gl.testtp.grid;
import org.emp.gl.testtp.etatrobotlistener.EtatRobotListener;
import org.emp.gl.testtp.robot.Robot;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import org.emp.gl.testtp.etatrobotingrid.Position;

public class MyGrid extends javax.swing.JFrame implements EtatRobotListener {
    private Robot agent;
    private Integer MAX_X = 10;
    private Integer MAX_Y = 10;


    private int contetnt[][] = {
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }};


    public MyGrid(Robot agent){
        this.agent = agent;
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        frame.getContentPane().add(panel);


        agent.getEtat().subscribe(this);

        panel.addKeyListener(agent.getEtat());

        panel.setFocusable(true);
        panel.requestFocusInWindow();

        frame.setSize(new Dimension(500, 500));
        frame.setVisible(true);

    }

    @Override
    public String getName() {
        return "my-grid";
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        Position o = (Position) evt.getOldValue();
        Position n = (Position) evt.getNewValue();

        // check if new_pos out of grid

        if(n.getX() < 0 || n.getX() > MAX_X || n.getY() > MAX_Y || n.getY() < 0){
            System.out.println("i cannot move from " + o + " to " + n);
        }else{
            // update
            System.out.println(n);
            System.out.println("moving from " + o + " to " + n);
            System.out.println(n);
            agent.getEtat().setPosition(
                    n.getX(), n.getY()
            );
        }

        // TODO : update and show the grid, call show() func
        // show();
    }
}
