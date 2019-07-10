package com.toy.robot.model;

import javax.persistence.*;

@Entity
@Table
public class Location {

    @Id
    @GeneratedValue
    private Long lId;
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
