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
    public static final int NUMBER_OF_INITIAL_FIGURES =100;

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
        for (int i = this.getInitialFiguresArray().size(); i< NUMBER_OF_INITIAL_FIGURES; i++){
            this.getInitialFiguresArray().add(factory.getFigureInstance(FigureTypesEnum.getRandomEnumObject()));
        }
    }

    public List<FigureInterface> getFiguresArray(int number) {
        List<FigureInterface> figuresArray = this.getFiguresArray();

        if(number>= NUMBER_OF_INITIAL_FIGURES) {
            FigureInterface figure;
            while (number >= NUMBER_OF_INITIAL_FIGURES) {
                for (int i = 0; i < this.getInitialFiguresArray().size(); i++) {
                    figure = this.getInitialFiguresArray().remove(i);
                    figuresArray.add(figure);
                }
                this.makeInitialFiguresArray();
                number -= NUMBER_OF_INITIAL_FIGURES;
            }
        }
        if (number < NUMBER_OF_INITIAL_FIGURES) {
            FigureInterface figure;
            for (int i = 0; i < number; i++) {
                figure = this.getInitialFiguresArray().remove(i);
                figuresArray.add(figure);
            }
        }
        return figuresArray;
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