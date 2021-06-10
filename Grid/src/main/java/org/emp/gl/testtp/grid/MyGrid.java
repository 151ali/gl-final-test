package org.emp.gl.testtp.grid;
import org.emp.gl.testtp.etatrobotlistener.EtatRobotListener;
import org.emp.gl.testtp.robot.Robot;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import org.emp.gl.testtp.etatrobotingrid.Position;

public class MyGrid extends javax.swing.JFrame implements EtatRobotListener {
    private Robot agent;
    private Integer MAX_X = 10;
    private Integer MAX_Y = 10;
    JLabel[][] grid= new JLabel[MAX_Y][MAX_Y];

    private int obstacles[][] = {
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
        /*
        frame.getContentPane().add(panel);

        agent.getEtat().subscribe(this);
        panel.addKeyListener(agent.getEtat());

        panel.setFocusable(true);
        panel.requestFocusInWindow();

        frame.setSize(new Dimension(500, 500));
        frame.setVisible(true);
*/
        frame.
        getContentPane().add(panel);

        int row = MAX_X;
        int col = MAX_Y;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500, 500));
        //setBounds(100, 100, 500, 500);
        panel.setLayout(new GridLayout(row, col));


        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                grid[i][j] = new JLabel();
                grid[i][j].setBorder(new LineBorder(Color.BLACK));
                if(obstacles[i][j] == 1){
                    // obstacle
                    grid[i][j].setBackground(Color.black);
                }
                grid[i][j].setOpaque(true);
                grid[i][j].setBackground(Color.green);


                panel.add(grid[i][j]);
            }
        }

        // init agent position
        Position ip = (Position) agent.getEtat().getPosition();
        grid[ip.getX()][ip.getY()].setBackground(Color.red);
        //

        agent.getEtat().subscribe(this);
        panel.addKeyListener(agent.getEtat());

        panel.setFocusable(true);
        panel.requestFocusInWindow();


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
        System.out.println("current position : " + o);

        // check if new_pos out of grid
        if(n.getX() < 0 || n.getX() >= MAX_X || n.getY() >= MAX_Y || n.getY() < 0){
            System.out.println("i cannot move from " + o + " to " + n);
        }else{
            // update
            System.out.println("moving from " + o + " to " + n );
            agent.getEtat().setPosition(
                    n.getX(), n.getY()
            );

            grid[n.getX()][n.getY()].setBackground(Color.red);
        }


        // show();
    }
}
