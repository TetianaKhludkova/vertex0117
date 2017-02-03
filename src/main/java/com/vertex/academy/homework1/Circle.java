package com.vertex.academy.homework1;

/**
 * Created by Tanya on 23.01.2017.
 */
public class Circle  implements FigureInterface {
    private int centerX;
    private int centerY;
    private  int width;
    private int height;

    protected Circle() {
    }

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


    public void draw() {
        System.out.println(this.toString());
    }

    @Override
    public String toString(){
        String className = this.getClass().toString();
        int index = className.trim().lastIndexOf(".");
        className = className.substring(index+1);
        return (className+" : center( "+ this.getCenterX()+", "+ this.getCenterY()+"), width: " +this.getWidth()+", height: "+ this.getHeight());
    }

    public static class Builder{
        Circle instance;

        public Builder() {
            instance = new Circle();
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
            return instance;
        }
    }


}
