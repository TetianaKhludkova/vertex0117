package com.vertex.academy.homework1;


/**
 * Created by Tanya on 23.01.2017.
 */
//todo: isn't an oval should be a wrapper for a circle?
public class Oval extends Circle implements FigureInterface{
    //todo: why don;t you keep point as an object? why have you created it if you don't use it?
    private int centerX;
    private int centerY;
    private  int width;
    private int height;

    private Oval(){}

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public static class Builder{
        Oval instance;

        public Builder() {
            instance = new Oval();
        }

        Builder setCenter(Point point) {
            instance.centerX = point.getX();
            instance.centerY = point.getY();
            return this;
        }

        Builder setWidth(int width){
            instance.width = width;
            return this;
        }

        Builder setHeight(int height){
            instance.height = height;
            return this;
        }

        public FigureInterface getInstance(){
            if (instance.isPlacedInCanvas()){
                return instance;
            }else {
                System.out.println("It's unreal to place figure in canvas");
            }
            return null;
        }
    }

    //todo: what are they for?
    Oval setCenter(int centerX, int centerY) {
        this.centerX = centerX;
        this.centerY = centerY;
        return this;
    }

    Oval setWidth(int width){
        this.width = width;
        return this;
    }

    Oval setHeight(int height){
        this.height = height;
        return this;
    }

}
