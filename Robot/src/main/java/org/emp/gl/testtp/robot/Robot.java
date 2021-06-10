package org.emp.gl.testtp.robot;

import org.emp.gl.testtp.etatrobotingrid.EtatRobotInGrid;

public class Robot {
    private EtatRobotInGrid e ;

    public Robot(EtatRobotInGrid e){
        this.e = e;
    }

    public EtatRobotInGrid getEtat() {
        return this.e;
    }
}
