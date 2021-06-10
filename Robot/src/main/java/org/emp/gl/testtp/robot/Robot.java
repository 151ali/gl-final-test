package org.emp.gl.testtp.robot;


import org.emp.gl.testtp.etatrobot.EtatRobot;

public class Robot {
    private EtatRobot etat ;

    public Robot() {
        //
    }

    public EtatRobot getEtat() {
        return this.etat;
    }

    public void setEtat(EtatRobot etat) {
        this.etat = etat;
    }
}
