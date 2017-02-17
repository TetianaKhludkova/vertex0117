package com.vertex.academy.homework1.Figures;


import com.vertex.academy.homework1.Artist;
import com.vertex.academy.homework1.FigureInterface;
import com.vertex.academy.homework1.Point;

/**
 * Created by Tanya on 23.01.2017.
 */

public class Oval implements FigureInterface {

    private  int width;
    private int height;
    private Point point = new Point(((int)(Math.random()* Artist.getCanvasWidth())+1), (int)(Math.random()*Artist.getCanvasHeight())+1);

    Oval(){}

    private FigureInterface setCenter(Point point) {
        this.point = point;
        return this;
    }

    private FigureInterface setWidth(int width){
        this.width = width;
        return this;
    }

    private FigureInterface setHeight(int height){
        this.height = height;
        return this;
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

        public Builder setCenter(Point point) {
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

        public FigureInterface getInstance(){
            if (instance.isPlacedInCanvas()){
                return instance;
            }else {
                System.out.println("It's unreal to place figure in canvas");
            }
            return null;
        }
    }

    boolean isPlacedInCanvas(){
        boolean isPlacedInCanvas=false;
        while (!isPlacedInCanvas){
            if ((this.point.getX()-this.getWidth()>0)&&(this.point.getX()+this.getWidth()<Artist.getCanvasWidth())&&((this.point.getY()-this.getHeight()>0)&&(this.point.getY()+this.getHeight()<Artist.getCanvasHeight())) ) {
                isPlacedInCanvas=true;
            }else{
                Point point = new Point(((int)(Math.random()*Artist.getCanvasWidth())+1), (int)(Math.random()*Artist.getCanvasHeight())+1);
                this.setCenter(point);
                if ((this.point.getX()-this.getWidth()>0)&&(this.point.getX()+this.getWidth()<Artist.getCanvasWidth())&&((this.point.getY()-this.getHeight()>0)&&(this.point.getY()+this.getHeight()<Artist.getCanvasHeight())) ) {
                    isPlacedInCanvas=true;
                }else{
                    this.setWidth(this.getWidth()/2);
                    this.setHeight(this.getHeight()/2);
                }
            }
        }
        return isPlacedInCanvas;
    }

    @Override
    public String toString(){
        return (this.getClass().getSimpleName()+" : center( "+ this.point.getX()+", "+ this.point.getY()+"), width: " +this.getWidth()+", height: "+ this.getHeight());
    }



}
