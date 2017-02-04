package com.vertex.academy.myhomework;

import java.util.*;

import static java.lang.String.format;

/**
 * Created by Valery on 1/27/2017.
 */
public class Artist implements ArtistInterface {

    private ArrayList<Figure> figures;
//    todo: should be also static to be written in this way
//    done
    private final int initQuantity;
    private Canvas canvas;

    public Artist(int quantity, int canvasWidth, int canvasHeight) {
        //todo: why don;t you init ArrayList with quantity instead of 0?
        //done
        figures = new ArrayList<Figure>(quantity);
        initQuantity = quantity;
        canvas = new Canvas(canvasWidth, canvasHeight);
        init();
    }

    private void init() {

        String figureName = "";
        Random randomizer = new Random();
        int xDimension, yDimension;
        Point basePoint;

        for (int number = 0; number < initQuantity; number++) {

            switch (randomizer.nextInt(4)) {
                case 0: figureName = "Square"; break;
                case 1: figureName = "Oval"; break;
                case 2: figureName = "Circle"; break;
                case 3: figureName = "Rectangular"; break;
            }
            basePoint = new Point(randomizer.nextInt(10000) - 5000
                                 ,randomizer.nextInt(10000) - 5000);
            xDimension = randomizer.nextInt(6000) + 1;
            yDimension = randomizer.nextInt(6000) + 1;
            figures.add(FigureFactory.getInstance().getFigure(figureName, basePoint, xDimension, yDimension));

        }

    }

    @Override
    public void paint(int quantity) {

        for (int number = 0; number < quantity; number++) {
            if (figures.isEmpty()) {
                init();
            }
            System.out.println(format("Painting figure #%1$s :", number + 1));
            canvas.paint(figures.remove(0));
        }

    }

}
