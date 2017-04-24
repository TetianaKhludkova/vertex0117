package com.vertex.academy.homework1;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by andrew_yashin on 1/22/17.
 */
public class Artist {
    private Random random;
    private LinkedList<Figure> figureList;
    private int initFigures;
    private FiguresFactory figuresFactory;

    public Artist(int initFigures){
        random = new Random();
        figureList = new LinkedList<Figure>();
        this.initFigures = initFigures;
        figuresFactory = FiguresFactory.getInstance();

        for(int i = 0; i < initFigures; i++){
            figureList.push(figuresFactory.getFigure(random.nextInt(4)));
        }
    }

    public void paintFigures(int totalFigures){//, double lengthHolst, double heightHolst){
        for (int i = 0; i < totalFigures; i++){
            if(figureList.isEmpty()){
                for(int j = 0; j < initFigures; j++){
                    figureList.push(figuresFactory.getFigure(random.nextInt(4)));
                }
            }

            System.out.println("#"+ (i+1) + ": " + figureList.pop());
            // TODO: 05.02.17 why is it commented? - Because i used pop
            // TODO: 24.04.17 then delete it =)
//            figureList.removeFirst();
        }
    }
}
