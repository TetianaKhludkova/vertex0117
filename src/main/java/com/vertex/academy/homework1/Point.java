package com.vertex.academy.homework1;


public class Point implements FigureInterface {
    private  final int x;
    private final int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public void draw() {

    }
}
