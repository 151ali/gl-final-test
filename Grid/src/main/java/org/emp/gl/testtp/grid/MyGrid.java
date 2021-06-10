package org.emp.gl.testtp.grid;

import org.emp.gl.testtp.etatrobotlistener.EtatRobotListener;
import org.emp.gl.testtp.robot.Robot;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;

public class MyGrid extends javax.swing.JFrame implements EtatRobotListener {
    private Robot agent;

    private int contetnt[][] = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
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
        System.out.println("moving from " + evt.getOldValue() + " to " + evt.getNewValue());
        // TODO : update and show the grid, call show() func
        // show();
    }
}
