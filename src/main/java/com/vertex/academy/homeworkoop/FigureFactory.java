package com.vertex.academy.homeworkoop;

import com.vertex.academy.homeworkoop.forfigures.*;

/**
 * Created by Valery on 1/27/2017.
 */
public class FigureFactory {

    private static volatile FigureFactory instance;

    private FigureFactory(){

    }

    public static FigureFactory getInstance() {
        if (instance == null){
            synchronized (FigureFactory.class){
                if (instance == null){
                    instance = new FigureFactory();
                }
            }
        }
        return instance;
    }

    //todo: int[] is not so good as a holder for parameters.
    //done
    public Figure getFigure(String name, Point basePoint, int xDimension, int yDimension) {
        if ("Square".equalsIgnoreCase(name)){
            return new Square.Builder()
                    .setCorner(basePoint)
                    .setWidth(xDimension)
                    .Build();
        } else if ("Oval".equalsIgnoreCase(name)){
            return new Oval.Builder()
                    .setCenter(basePoint)
                    .setXRadius(xDimension)
                    .setYRadius(yDimension)
                    .Build();
        } else if ("Circle".equalsIgnoreCase(name)){
            return new Circle.Builder()
                    .setCenter(basePoint)
                    .setRadius(xDimension)
                    .Build();
        } else if ("Rectangular".equalsIgnoreCase(name)){
            return new Rectangular.Builder()
                    .setCorner(basePoint)
                    .setWidth(xDimension)
                    .setHeight(yDimension)
                    .Build();
        } else {
            throw  new IllegalArgumentException("Wrong class name or parameters quantity");
        }
    }

}
