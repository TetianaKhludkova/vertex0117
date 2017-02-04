
//todo: read java name convention please. Because packages shouldn't contain capital letters.
//done
package com.vertex.academy.myhomework;

/**
 * Created by Aile (on Valery) on 1/29/2017.
 */
public class Canvas {

    private int width, height;

    //todo: if you don't use code, then it should be deleted, not commented
    //done

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
    }

    //todo: methods should be named starting with lowercase. Only constructors could be started with capital letter.
    //done
    private void fitToCanvasSize(Figure figure) {

        if ((figure.rightBorder() - figure.leftBorder()) >= width) {
            figure.resizeXDimension(width);
            figure.translateX(-figure.leftBorder());
        } else if (figure.leftBorder() < 0) {
            figure.translateX(-figure.leftBorder());
        } else if (figure.rightBorder() > width) {
            figure.translateX(width - figure.rightBorder());
        }

        if ((figure.topBorder() - figure.bottomBorder()) >= height) {
            figure.resizeYDimension(height);
            figure.translateY(-figure.bottomBorder());
        } else if (figure.bottomBorder() < 0) {
            figure.translateY(-figure.bottomBorder());
        } else if (figure.topBorder() > height) {
            figure.translateY(height - figure.topBorder());
        }
    }

    //todo: the same with methods. If it is unused, then delete it please.
    //done

    public void paint(Figure figure) {
        fitToCanvasSize(figure);
        System.out.println(figure.toString());
    }

}
