package com.vertex.academy.homework1.Figures;

import com.vertex.academy.homework1.Artist;
import com.vertex.academy.homework1.FigureInterface;
import com.vertex.academy.homework1.Point;

/**
 * Created by Tanya on 23.01.2017.
 */
public class Rectangular extends Square implements FigureInterface {

    private  int width;
    private int height;
    private Point point = new Point(((int)(Math.random()* Artist.getCanvasWidth())+1), (int)(Math.random()*Artist.getCanvasHeight())+1);

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public static class Builder{
        Rectangular instance;

        public Builder() {
            instance = new Rectangular();
        }

        public Builder setStartPoint(Point point) {
            instance.point = point;
            return this;
        }

        public Builder setWidth(int width){
            instance.width = width;
            return this;
        }

        public Builder setHeight(int height){
            instance.height = height;
            return this;
        }

        public FigureInterface getInstance() {
            if (instance.isPlacedInCanvas()) {
                return instance;
            } else {
                System.out.println("It's unreal to place figure in canvas");
            }
            return null;
        }
    }


}
