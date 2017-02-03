package com.vertex.academy.homework1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tanya on 25.01.2017.
 */
public class Artist implements ArtistInterface {
    private List<FigureInterface> initialFiguresArray = new ArrayList<FigureInterface>();
    private List<FigureInterface> figuresArray = new ArrayList<FigureInterface>();

    public Artist(){
        this.makeInitialFiguresArray();
    }

    public List<FigureInterface> getInitialFiguresArray(){
        return initialFiguresArray;
    }

    public List<FigureInterface> getFiguresArray(){
        return figuresArray;
    }

    private   void makeInitialFiguresArray(){
        Factory factory = Factory.sharedInstance();
        for (int i=0; i<100; i++){
            this.getInitialFiguresArray().add(factory.getFigureInstance(FigureTypes.getEnumObject()));
        }
    }

    public List<FigureInterface> getFiguresArray(int number) {

        //todo: could you please set 100 as a constant with clear name?
        //todo: there is another bug - if you call method twice, it could appear that there would be not enough Figures in the initialFiguresArray
        if(number>100) {
            while (number > 100) {
                for (int i = 0; i < 100; i++) {
                    this.getFiguresArray().add(this.getInitialFiguresArray().get(i));
                }
                for (int i = 0; i < 100; i++) {
                    //todo: please read java dic for remove method. It could not only delete, but return the element that was deleted. So you can combine first and second cycles.
                    this.getInitialFiguresArray().remove(i);
                }
                this.makeInitialFiguresArray();
                number -= 100;
            }
        }else if (number < 100) { //todo: what would you do if number is 100?
                for (int i = 0; i < number; i++) {
                    this.getFiguresArray().add(this.getInitialFiguresArray().get(i));
                }
                for (int i = 0; i < number; i++) {
                    this.getInitialFiguresArray().remove(i);
                }
        } //todo: if you use getFiguresArray() in whole method, then this return could confuse.
        return figuresArray;
    }

    public void printFiguresArray(){
        for(FigureInterface figure : figuresArray){
            figure.draw();
        }
    }

}
