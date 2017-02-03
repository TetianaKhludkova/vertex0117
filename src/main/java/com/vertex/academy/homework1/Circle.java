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

    Circle setCenter(int centerX, int centerY) {
        this.centerX = centerX;
        this.centerY = centerY;
        return this;
    }

    Circle setWidth(int width){
        this.width = width;
        return this;
    }

    Circle setHeight(int height){
        this.height = height;
        return this;
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
            instance.height = instance.width;
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

    public boolean isPlacedInCanvas(){
        boolean isPlacedInCanvas=false;
        while (isPlacedInCanvas==false){
            if ((this.getCenterX()-this.getWidth()>0)&&(this.getCenterX()+this.getWidth()<Artist.getCanvasWidth())&&((this.getCenterY()-this.getHeight()>0)&&(this.getCenterY()+this.getHeight()<Artist.getCanvasHeight())) ) {
                isPlacedInCanvas=true;
            }else{
                this.setCenter(((int) (Math.random() * Artist.getCanvasWidth())+1), ((int) (Math.random() * Artist.getCanvasHeight())+1));
                if ((this.getCenterX()-this.getWidth()>0)&&(this.getCenterX()+this.getWidth()<Artist.getCanvasWidth())&&((this.getCenterY()-this.getHeight()>0)&&(this.getCenterY()+this.getHeight()<Artist.getCanvasHeight())) ) {
                    isPlacedInCanvas=true;
                }else{
                    this.setWidth(this.getWidth()/2);
                    this.setHeight(this.getHeight()/2);
                }
            }
        }
        return isPlacedInCanvas;
    }

}
