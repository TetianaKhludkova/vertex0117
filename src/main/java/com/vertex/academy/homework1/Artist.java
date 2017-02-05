package com.vertex.academy.homework1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tanya on 25.01.2017.
 */
public class Artist implements ArtistInterface {
    public static Canvas canvas = new Canvas();
    private List<FigureInterface> initialFiguresArray = new ArrayList<>();
    private List<FigureInterface> figuresArray = new ArrayList<>();
    public static final int numberOfInitialFigures =100;

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
        for (int i = this.getInitialFiguresArray().size(); i< numberOfInitialFigures; i++){
            this.getInitialFiguresArray().add(factory.getFigureInstance(FigureTypesEnum.getRandomEnumObject()));
        }
    }

    public List<FigureInterface> getFiguresArray(int number) {

        if(number>= numberOfInitialFigures) {
            while (number >= numberOfInitialFigures) {
                for (int i = 0; i < this.getInitialFiguresArray().size(); i++) {
                    this.getFiguresArray().add(this.getInitialFiguresArray().remove(i));
                }
                this.makeInitialFiguresArray();
                number -= numberOfInitialFigures;
            }
        }
        if (number < numberOfInitialFigures) {
            for (int i = 0; i < number; i++) {
                this.getFiguresArray().add(this.getInitialFiguresArray().remove(i));
            }
        }
        return this.getFiguresArray();
    }

    public void printFiguresArray(){
        figuresArray.forEach(FigureInterface::draw);
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