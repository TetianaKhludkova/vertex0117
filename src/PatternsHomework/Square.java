package PatternsHomework;


/**
 * Created by Tanya on 23.01.2017.
 */
public class Square implements FigureInterface {

    private int leftTopX;
    private int leftTopY;
    private  int width;
    private int height;

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

    protected Square() {
    }

    @Override
    public void draw() {
        System.out.println(this.toString());
    }

    @Override
    public String toString(){
        String className = this.getClass().toString();
        int index = className.trim().lastIndexOf(".");
        className = className.substring(index+1);
        return (className+" : left top point( "+this.getLeftTopX()+", "+ getLeftTopY()+"), width: " +this.getWidth()+", height: "+ this.getHeight());
    }


    public static class Builder{
        Square instance;

        public Builder() {
            instance = new Square();
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
