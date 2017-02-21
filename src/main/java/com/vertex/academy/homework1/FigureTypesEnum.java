package com.vertex.academy.homework1;

/**
 * Created by Tanya on 28.01.2017.
 */
enum FigureTypesEnum {
    Oval, Circle, Rectangular, Square;

    public static FigureTypesEnum getRandomEnumObject(){
        int i = (int)(Math.random()*4);
        switch (i){
            case 0: return FigureTypesEnum.Oval;
            case 1: return FigureTypesEnum.Circle;
            case 2: return FigureTypesEnum.Rectangular;
            case 3: return FigureTypesEnum.Square;
        }
        return null;
    }
}

