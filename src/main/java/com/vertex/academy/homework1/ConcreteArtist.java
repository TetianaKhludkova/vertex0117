package com.vertex.academy.homework1;


import java.util.ArrayList;
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
        Random r = new Random();

        // TODO: 05.02.17 could be generated a separate method like "init()" 
        // TODO: 05.02.17 please use '<' instead of '<= * -1'  
        for (int i = 0; i <= numberOfFigures - 1; i++) {
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

    @Override
    public void drawFigure() {
        // TODO: 05.02.17 but if I'd like to draw more figures than we have? Artist should init again in this case 
        int number = Math.min(numberOfFigures, figureList.size());

        System.out.println("Drawing " + number + " figures...");
        for (int i = 0; i < number; i++) {

            figureList.get(i).draw();
            // TODO: 05.02.17 figure should be deleted from list after it was drawn 
        }
    }

}
