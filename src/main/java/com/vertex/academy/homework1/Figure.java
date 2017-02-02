package com.vertex.academy.homework1;


/**
 * Main interface for all shapes
 */
public interface Figure {

    void draw();

    String toString();  //this is for Decorator ability to draw oval over the circle, changing its text

    void movePoint(int x, int y);

    void resizeFigure(double scale);
}
