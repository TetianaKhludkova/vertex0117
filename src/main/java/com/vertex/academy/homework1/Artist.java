package com.vertex.academy.homework1;

import java.util.ArrayList;
import java.util.Random;

/*
 * Created by Michael Rudyy on 23.01.2017.
 */

// TODO: 05.02.17 where is proxy? 
public class Artist
{
    // TODO: 05.02.17 fix as much warnings, as you can 
    int amount = 20;
    private ArrayList<Figure> figures = new ArrayList<Figure>();

    Random random = new Random();

    Artist() {
        this.createFigures();
    }

    public void paint() {
        for (int i = 0; i < figures.size(); i++) {
            Cloth.paintedFigures.add(figures.get(0));
            // TODO: 05.02.17 remove returns object also ;) there is no need to get(i) before.
            figures.remove(0);
            System.out.println("Paint " + Cloth.paintedFigures.get(i).getClass().getName() + " with point in x = " + Cloth.paintedFigures.get(i).getPoint().getX() + " and y = " + Cloth.paintedFigures.get(i).getPoint().getY() + " width = " + Cloth.paintedFigures.get(i).getW() + " height = " + Cloth.paintedFigures.get(i).getH());
        }
    }

    // TODO: 05.02.17 where is your factory? 
    public void createFigures() {
        for (int i = 0; i < amount; i++) {
            Point point = new Point();

            int randomNumber = random.nextInt(4);
            switch (randomNumber) {
                case 0: {
                    Rectangular rectangular = new Rectangular.Builder()
                            .setPoint(point)
                            // TODO: 05.02.17 why 10? Please get rid of magic numbers. 
                            .setH(random.nextInt(10)+1)
                            .setW(random.nextInt(10)+1)
                            .getInstance();
                    figures.add(rectangular);
                }
                case 1: {
                    Oval oval = new Oval.Builder().setPoint(point)
                            .setH(random.nextInt(10)+1)
                            .setW(random.nextInt(10)+1)
                            .getInstance();
                    figures.add(oval);
                }
                case 2: {
                    Circle circle = new Circle.Builder()
                            .setPoint(point)
                            .setH(random.nextInt(10)+1)
                            .getInstance();
                    figures.add(circle);
                }
                case 3: {
                    Square square = new Square.Builder()
                            .setPoint(point)
                            .setH(random.nextInt(10)+1)
                            .getInstance();
                    figures.add(square);
                }
            }
        }
    }
}
