package org.emp.gl.testtp.launcher;

import org.emp.gl.testtp.etatrobotingrid.EtatRobotInGrid;
import org.emp.gl.testtp.grid.MyGrid;
import org.emp.gl.testtp.robot.Robot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class launcher {

    public static void main(String[] args) {

        // ? Initialisations
        //MyGrid g = new MyGrid();
        Robot r = new Robot();
        EtatRobotInGrid myState = new EtatRobotInGrid(r);
        r.setEtat(myState);


        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                new MyGrid(r);
            }
        };

        SwingUtilities.invokeLater(runnable);

    }
}