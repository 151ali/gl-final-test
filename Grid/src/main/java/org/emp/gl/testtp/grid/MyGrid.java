package org.emp.gl.testtp.grid;

import org.emp.gl.testtp.etatrobotlistener.EtatRobotListener;
import org.emp.gl.testtp.robot.Robot;

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


    public void show() {
        for (int i = 0; i < contetnt.length; i++){
            for (int j = 0; j < contetnt[i].length; j++){
                System.out.print(contetnt[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.println("===================");
    }

    public void setAgent(Robot r){
        this.agent = r;
    }

    @Override
    public String getName() {
        return "grid";
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("moving from " + evt.getOldValue() + " to " + evt.getNewValue());

        // TODO : update and show the grid, call show() func
        // show();
    }
}
