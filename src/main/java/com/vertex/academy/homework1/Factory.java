package com.vertex.academy.homework1;

import com.vertex.academy.homework1.Figures.Circle;
import com.vertex.academy.homework1.Figures.Oval;
import com.vertex.academy.homework1.Figures.Rectangular;
import com.vertex.academy.homework1.Figures.Square;

/**
 * Created by Tanya on 24.01.2017.
 */
public class Factory {
    private static volatile Factory instance = null;
    public static final int MAXRADIUS = 50;

    private Factory() {
    }

    public static synchronized Factory sharedInstance() {
        if (instance == null) {
            synchronized (Factory.class) {
                if (instance == null) {
                    instance = new Factory();
                }
            }
        }
        return instance;
    }

    public FigureInterface getFigureInstance(FigureTypesEnum figureType) {
        switch (figureType){
            case Oval:{
                Point point = new Point(((int)(Math.random()*Artist.getCanvasWidth())+1), (int)(Math.random()*Artist.getCanvasHeight())+1);
                return new Oval.Builder()
                        .setCenter(point)
                        .setWidth((int)(Math.random()*MAXRADIUS)+1)
                        .setHeight((int)(Math.random()*MAXRADIUS)+1)
                        .getInstance();
            }
            case Circle: {
                Point point = new Point(((int) (Math.random() * Artist.getCanvasWidth())+1), (int) (Math.random() * Artist.getCanvasHeight())+1);
                int radius = (int)(Math.random()*MAXRADIUS)+1;
                return new Circle.Builder()
                        .setCenter(point)
                        .setWidth(radius)
                        .setHeight(radius)
                        .getInstance();
            }
            case Rectangular: {
                Point point = new Point(((int) (Math.random() * Artist.getCanvasWidth())+1), (int) (Math.random() * Artist.getCanvasWidth())+1);
                return new Rectangular.Builder()
                        .setStartPoint(point)
                        .setWidth((int)(Math.random()*MAXRADIUS)+1)
                        .setHeight((int)(Math.random()*MAXRADIUS)+1)
                        .getInstance();
            }
            case Square:{
                Point point = new Point(((int)(Math.random()*Artist.getCanvasWidth())+1), (int)(Math.random()*Artist.getCanvasWidth())+1);
                int side = (int)(Math.random()*MAXRADIUS)+1;
                return new Square.Builder()
                        .setStartPoint(point)
                        .setWidth(side)
                        .setHeight(side)
                        .getInstance();
            }
            default:
                throw new IllegalArgumentException("Wrong class");
        }
    }

}
