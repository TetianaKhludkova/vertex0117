package com.vertex.academy.homework1;

/**
 * Created by Tanya on 24.01.2017.
 */
public class Factory {
    private static volatile Factory instance = null;

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

    public FigureInterface getFigureInstance(FigureTypes figureType) {
        switch (figureType){
            case Oval:{
                //todo: why 300? what does it mean? please get rid of magic numbers, keep them as a constants.
                Point point = new Point(((int)(Math.random()*300)+1), (int)(Math.random()*300)+1);
                return new Oval.Builder()
                        .setCenter(point)
                        .setWidth((int)(Math.random()*10)+1)
                        .setHeight((int)(Math.random()*10)+1)
                        .getInstance();
            }
            case Circle: {
                Point point = new Point(((int) (Math.random() * 300)+1), (int) (Math.random() * 300)+1);
                int radius = (int)(Math.random()*10)+1;
                return new Circle.Builder()
                        .setCenter(point)
                        .setWidth(radius)
                        .setHeight(radius)
                        .getInstance();
            }
            case Rectangular: {
                Point point = new Point(((int) (Math.random() * 300)+1), (int) (Math.random() * 300)+1);
                return new Rectangular.Builder()
                        .setStartPoint(point)
                        .setWidth((int)(Math.random()*10)+1)
                        .setHeight((int)(Math.random()*10)+1)
                        .getInstance();
            }
            case Square:{
                Point point = new Point(((int)(Math.random()*300)+1), (int)(Math.random()*300)+1);
                return new Square.Builder()
                        .setStartPoint(point)
                        .setWidth((int)(Math.random()*10)+1)
                        .setHeight((int)(Math.random()*10)+1)
                        .getInstance();
            }
            default:
                throw new IllegalArgumentException("Wrong class");
        }
    }

}
