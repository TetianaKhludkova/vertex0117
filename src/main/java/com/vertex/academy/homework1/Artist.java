package com.vertex.academy.homework1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tanya on 25.01.2017.
 */
public class Artist implements ArtistInterface {
    public static Canvas canvas = new Canvas();
    private List<FigureInterface> initialFiguresArray = new ArrayList<FigureInterface>();
    private List<FigureInterface> figuresArray = new ArrayList<FigureInterface>();
    public static final int numberOfInitialFigures =20;

    public static int getCanvasHeight(){
        return canvas.getHeight();
    }

    public static int getCanvasWidth(){
        return canvas.getWidth();
    }

    public Artist(){
        this.makeInitialFiguresArray();
    }

    public List<FigureInterface> getInitialFiguresArray(){
        return initialFiguresArray;
    }

    public List<FigureInterface> getFiguresArray(){
        return figuresArray;
    }

    private   void makeInitialFiguresArray(){
        Factory factory = Factory.sharedInstance();
        for (int i = 0; i< numberOfInitialFigures; i++){
            this.getInitialFiguresArray().add(factory.getFigureInstance(FigureTypes.getEnumObject()));
        }
    }

    public List<FigureInterface> getFiguresArray(int number) {

        //todo: could you please set 100 as a constant with clear name?
        //todo: there is another bug - if you call method twice, it could appear that there would be not enough Figures in the initialFiguresArray
        if(number>numberOfInitialFigures) {
            while (number > numberOfInitialFigures) {
                for (int i = 0; i < numberOfInitialFigures; i++) {
                    this.getFiguresArray().add(this.getInitialFiguresArray().get(i));
                }
                //todo: please read java dic for remove method. It could not only delete, but return the element that was deleted. So you can combine first and second cycles.
                for (int i = 0; i < numberOfInitialFigures; i++) {
                    this.getInitialFiguresArray().remove(i);
                }
                this.makeInitialFiguresArray();
                number -= numberOfInitialFigures;
            }
        }else if (number < numberOfInitialFigures) {
         //todo: what would you do if number is 100?
                for (int i = 0; i < number; i++) {
                    this.getFiguresArray().add(this.getInitialFiguresArray().get(i));
                }
                for (int i = 0; i < number; i++) {
                    this.getInitialFiguresArray().remove(i);
                }
        } //todo: if you use getFiguresArray() in whole method, then this return could confuse.
        return figuresArray;
    }

    public void printFiguresArray(){
        for(FigureInterface figure : figuresArray){
            figure.draw();
        }
    }


    static class Canvas{
        private int width;
        private int height;

        public int getWidth() {
            return width;
        }


        public int getHeight() {
            return height;
        }

        Canvas(){
            this.setHeight((int)(Math.random()*50+300));
            this.setWidth((int)(Math.random()*50+300));
        }

        private void setWidth(int width) {
            this.width = width;
        }

        private void setHeight(int height) {
            this.height = height;
        }
    }


}