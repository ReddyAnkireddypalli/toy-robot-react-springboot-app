package com.toy.robot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class State {

    @Id
    @GeneratedValue
    private Long sId;
    private int fx;
    private int fy;
    private int lx;
    private int ly;
    private String result;
    private boolean placed;


    public State(){}

    public State(int fx, int fy, int lx, int ly, String result, boolean placed) {
        this.fx = fx;
        this.fy = fy;
        this.lx = lx;
        this.ly = ly;
        this.result = result;
        this.placed = placed;
    }


    public int getFx() {
        return fx;
    }

    public int getFy() {
        return fy;
    }

    public int getLx() {
        return lx;
    }

    public int getLy() {
        return ly;
    }

    public String getResult() {
        return result;
    }

    public boolean isPlaced() {
        return placed;
    }
}
