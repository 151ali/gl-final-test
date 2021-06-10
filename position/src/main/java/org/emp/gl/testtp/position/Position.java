package org.emp.gl.testtp.position;

public class Position{

    private Integer x;
    private Integer y;

    public Position(Integer x, Integer y){
        this.x = x ; this.y = y;
    }

    public void setX(Integer x){ this.x = x;}
    public void setY(Integer y){ this.y = y;}

    public Integer getX(){ return x;}
    public Integer getY(){ return y;}

    @Override
    public String toString(){
        return "("+ x +", "+y+")";
    }
}