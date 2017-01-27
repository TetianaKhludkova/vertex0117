package PatternsHomework;

import java.util.List;

/**
 * Created by Tanya on 27.01.2017.
 */
public class ArtistProxy implements ArtistInterface{
    Artist instance;

    @Override
    public List<FigureInterface> getInitialFiguresArray(){
        if (instance == null){
            instance = getArtist();
        }
        return instance.getInitialFiguresArray();
    }
    @Override
    public List<FigureInterface> getFiguresArray(){
        if (instance == null){
            instance = getArtist();
        }
        return instance.getFiguresArray();
    }

    @Override
    public List<FigureInterface> getFiguresArray(int number) {
        if (instance == null){
            instance = getArtist();
        }
        return instance.getFiguresArray(number);
    }

    public void printFiguresArray(){
        if (instance == null){
            instance = getArtist();
        }
        instance.printFiguresArray();
    }

    private Artist getArtist() {
        return new Artist();
    }

}
