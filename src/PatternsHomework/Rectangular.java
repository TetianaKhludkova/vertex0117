package PatternsHomework;

/**
 * Created by Tanya on 23.01.2017.
 */
public class Rectangular extends Square implements FigureInterface {
    private int leftTopX;
    private int leftTopY;
    private  int width;
    private int height;

    protected Rectangular() {
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getLeftTopX() {
        return leftTopX;
    }

    public int getLeftTopY() {
        return leftTopY;
    }


    public static class Builder{
        Rectangular instance;

        public Builder() {
            instance = new Rectangular();
        }

        Builder setStartPoint(Point point) {
            instance.leftTopX = point.getX();
            instance.leftTopY = point.getY();
            return this;
        }

        Builder setWidth(int width){
            instance.width = width;
            return this;
        }

        Builder setHeight(int height){
            instance.height = height;
            return this;
        }

        public FigureInterface getInstance(){
            return instance;
        }
    }


}
