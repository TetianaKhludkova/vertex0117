package com.vertex.academy.homework1.Figures;


import com.vertex.academy.homework1.Artist;
import com.vertex.academy.homework1.FigureInterface;
import com.vertex.academy.homework1.Point;

/**
 * Created by Tanya on 23.01.2017.
 */
//todo: the same as for oval
public class Square implements FigureInterface {

    private  int width;
    private int height;
    private Point point = new Point(((int)(Math.random()* Artist.getCanvasWidth())+1), (int)(Math.random()*Artist.getCanvasHeight())+1);

    Square setCenter(Point point) {
        this.point = point;
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

    protected Square() {
    }

    public static class Builder{
        Square instance;

        public Builder() {
            instance = new Square();
        }

        public Builder setStartPoint(Point point) {
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

        public FigureInterface getInstance() {
            if (instance.isPlacedInCanvas()) {
                return instance;
            } else {
                System.out.println("It's unreal to place figure in canvas");
            }
            return null;
        }
    }

    public void draw() {
        System.out.println(this.toString());
    }

    public boolean isPlacedInCanvas(){
        boolean isPlacedInCanvas=false;
        while (isPlacedInCanvas==false){
            if ((this.point.getX()>0)&&(this.point.getX()+this.getWidth()<Artist.getCanvasWidth())&&((this.point.getY()>0)&&(this.point.getY()+this.getHeight()<Artist.getCanvasHeight())) ) {
                isPlacedInCanvas=true;
            }else{
                this.point = new Point(((int)(Math.random()*Artist.getCanvasWidth())+1), (int)(Math.random()*Artist.getCanvasHeight())+1);
                this.setCenter(this.point);
                if ((this.point.getX()>0)&&(this.point.getX()+this.getWidth()<Artist.getCanvasWidth())&&((this.point.getY()>0)&&(this.point.getY()+this.getHeight()<Artist.getCanvasHeight())) ) {
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
        return (this.getClass().getSimpleName()+" : left top point( "+this.point.getX()+", "+ this.point.getY()+"), width: " +this.getWidth()+", height: "+ this.getHeight());
    }

}
