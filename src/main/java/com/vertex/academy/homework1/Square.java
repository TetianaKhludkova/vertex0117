package com.vertex.academy.homework1;


/**
 * Created by Tanya on 23.01.2017.
 */
public class Square implements FigureInterface {

    private int leftTopX;
    private int leftTopY;
    private  int width;
    private int height;

    Square setCenter(int leftTopX, int leftTopY) {
        this.leftTopX = leftTopX;
        this.leftTopY = leftTopY;
        return this;
    }

    Square setWidth(int width){
        this.width = width;
        return this;
    }

    Square setHeight(int height){
        this.height = height;
        return this;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getLeftTopX() {
        return leftTopX;
    }

    public int getLeftTopY() {
        return leftTopY;
    }

    protected Square() {
    }


    public void draw() {
        System.out.println(this.toString());
    }

    @Override
    public String toString(){
        String className = this.getClass().toString();
        int index = className.trim().lastIndexOf(".");
        className = className.substring(index+1);
        return (className+" : left top point( "+this.getLeftTopX()+", "+ getLeftTopY()+"), width: " +this.getWidth()+", height: "+ this.getHeight());
    }


    public static class Builder{
        Square instance;

        public Builder() {
            instance = new Square();
        }

        Builder setStartPoint(Point point) {
            instance.leftTopX = point.getX();
            instance.leftTopY = point.getY();
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
            if ((this.getLeftTopX()>0)&&(this.getLeftTopX()+this.getWidth()<Artist.getCanvasWidth())&&((this.getLeftTopX()>0)&&(this.getLeftTopY()+this.getHeight()<Artist.getCanvasHeight())) ) {
                isPlacedInCanvas=true;
            }else{
                this.setCenter(((int) (Math.random() * Artist.getCanvasWidth())+1), ((int) (Math.random() * Artist.getCanvasHeight())+1));
                if ((this.getLeftTopX()>0)&&(this.getLeftTopX()+this.getWidth()<Artist.getCanvasWidth())&&((this.getLeftTopX()>0)&&(this.getLeftTopY()+this.getHeight()<Artist.getCanvasHeight())) ) {
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
