package MyPackage;

/**
 * Created by Valery on 1/27/2017.
 */
public class FigureFactory {

    private static volatile FigureFactory instance;

    private FigureFactory(){

    }

    public static FigureFactory getInstance() {
        if (instance == null){
            synchronized (FigureFactory.class){
                if (instance == null){
                    instance = new FigureFactory();
                }
            }
        }
        return instance;
    }

    //todo: int[] is not so good as a holder for parameters.
    public Figure getFigure(String name, int[] parameters) {
        if ("Square".equalsIgnoreCase(name)  && (parameters.length >= 3)){
            return new Square.Builder()
                    .setCenterX(parameters[0])
                    .setCenterY(parameters[1])
                    .setWidth(parameters[2])
                    .Build();
        } else if ("Oval".equalsIgnoreCase(name) && (parameters.length >= 4)){
            return new Oval.Builder()
                    .setCenterX(parameters[0])
                    .setCenterY(parameters[1])
                    .setXRadius(parameters[2])
                    .setYRadius(parameters[3])
                    .Build();
        } else if ("Circle".equalsIgnoreCase(name)  && (parameters.length >= 3)){
            return new Circle.Builder()
                    .setCenterX(parameters[0])
                    .setCenterY(parameters[1])
                    .setRadius(parameters[2])
                    .Build();
        } else if ("Rectangular".equalsIgnoreCase(name)  && (parameters.length >= 4)){
            return new Rectangular.Builder()
                    .setCenterX(parameters[0])
                    .setCenterY(parameters[1])
                    .setWidth(parameters[2])
                    .setHeight(parameters[3])
                    .Build();
        } else {
            throw  new IllegalArgumentException("Wrong class name or parameters quantity");
        }
    }

}
