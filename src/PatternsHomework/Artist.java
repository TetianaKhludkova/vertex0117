package PatternsHomework;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tanya on 25.01.2017.
 */
public class Artist implements ArtistInterface {
    private List<FigureInterface> initialFiguresArray = new ArrayList<>();
    private List<FigureInterface> figuresArray = new ArrayList<>();

    public Artist(){
        this.makeInitialFiguresArray();
    }

    @Override
    public List<FigureInterface> getInitialFiguresArray(){
        return initialFiguresArray;
    }
    @Override
    public List<FigureInterface> getFiguresArray(){
        return figuresArray;
    }

    private   void makeInitialFiguresArray(){
        Factory factory = Factory.sharedFactoryInstance();
        for (int i=0; i<100; i++){
            this.getInitialFiguresArray().add(factory.getFigureInstance(factory.getEnumObject()));
        }
    }

    public List<FigureInterface> getFiguresArray(int number) {

        if(number>100) {
            while (number > 100) {
                for (int i = 0; i < 100; i++) {
                    this.getFiguresArray().add(this.getInitialFiguresArray().get(i));
                }
                for (int i = 0; i < 100; i++) {
                    this.getInitialFiguresArray().remove(i);
                }
                this.makeInitialFiguresArray();
                number -= 100;
            }
        }else if (number < 100) {
                for (int i = 0; i < number; i++) {
                    this.getFiguresArray().add(this.getInitialFiguresArray().get(i));
                }
                for (int i = 0; i < number; i++) {
                    this.getInitialFiguresArray().remove(i);
                }
        }
        return figuresArray;
    }

    public void printFiguresArray(){
        for(FigureInterface figure : figuresArray){
            figure.draw();
        }
    }

}
