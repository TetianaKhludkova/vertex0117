package com.vertex.academy.homework1;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Creates factory, list of shapes with init. capacity 100, draws figures
 * using Artist implementation
 */
public class ConcreteArtist implements Artist {
    private SingletonFactory factory = SingletonFactory.getInstance();
    private List<Figure> figureList = new ArrayList<>(100);
    private int numberOfFigures;

    public ConcreteArtist(int numberOfFigures) {
        this.numberOfFigures = numberOfFigures;


    }

    public void init() {
        Random r = new Random();


        for (int i = 0; i < numberOfFigures; i++) {
            switch (r.nextInt(4)) {
                case 0:
                    figureList.add(factory.getFigure(SingletonFactory.FigureName.CIRCLE));
                    break;
                case 1:
                    figureList.add(factory.getFigure(SingletonFactory.FigureName.RECTANGULAR));
                    break;
                case 2:
                    figureList.add(factory.getFigure(SingletonFactory.FigureName.OVAL));
                    break;
                case 3:
                    figureList.add(factory.getFigure(SingletonFactory.FigureName.SQUARE));
                    break;
            }

        }
    }

/*    public List<FigureInterface> getFiguresArray(int number) {

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
    }*/

    @Override
    public void drawFigure() {

        System.out.println("Drawing " + numberOfFigures + " figures...");
        Iterator<Figure> iterator = figureList.iterator();
        for (int i = 0; i < numberOfFigures && iterator.hasNext(); i++) {

            iterator.next().draw();


            iterator.remove();


        }
    }

}
