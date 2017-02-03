package com.vertex.academy.homework1;

/**
 * Created by Tanya on 28.01.2017.
 */
public enum FigureTypes {
    Oval, Circle, Rectangular, Square;

    public static FigureTypes getEnumObject(){
        int i = (int)(Math.random()*4);
        switch (i){
            case 0: return FigureTypes.Oval;
            case 1: return FigureTypes.Circle;
            case 2: return FigureTypes.Rectangular;
            case 3: return FigureTypes.Square;
        }
        return null;
    }
}
