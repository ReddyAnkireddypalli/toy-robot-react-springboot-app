package com.toy.robot.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class State {

    @Id
    private Long id = 10L;
    private int fx;
    private int fy;
    private int lx;
    private int ly;
    private String result;
    private boolean placed;


    public State(){}

    public State(Long id, int fx, int fy, int lx, int ly, String result, boolean placed) {
        this.id = id;
        this.fx = fx;
        this.fy = fy;
        this.lx = lx;
        this.ly = ly;
        this.result = result;
        this.placed = placed;
    }

    public Long getId() {
        return id;
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
