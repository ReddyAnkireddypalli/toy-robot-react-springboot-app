package com.toy.robot.model;

import javax.persistence.*;

@Entity
@Table
public class Location {

    @Id
    private Long lId = 100L;
    private int x;
    private int y;

    public Location() {
    }

    public Location(int x, int y) {
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
