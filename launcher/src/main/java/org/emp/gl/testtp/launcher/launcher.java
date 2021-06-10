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
        MyGrid g = new MyGrid();
        EtatRobotInGrid myState = new EtatRobotInGrid(5,5);
        Robot r = new Robot(myState);
        r.getEtat().subscribe(g);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                JPanel panel = new JPanel();

                frame.getContentPane().add(panel);

                panel.addKeyListener(myState);

                panel.setFocusable(true);
                panel.requestFocusInWindow();

                frame.setSize(new Dimension(300, 300));
                frame.setVisible(true);
            }

        };

        SwingUtilities.invokeLater(runnable);

    }
}