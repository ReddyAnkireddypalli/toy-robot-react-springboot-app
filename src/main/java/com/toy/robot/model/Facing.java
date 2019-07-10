package com.toy.robot.model;

import javax.persistence.*;

@Entity
@Table
public class Facing {

    @Id
    private Long fId = 200L;
    private int x;
    private int y;

    public Facing() {
    }

    public Facing(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
