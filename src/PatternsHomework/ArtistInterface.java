package PatternsHomework;

import java.util.List;

/**
 * Created by Tanya on 27.01.2017.
 */
public interface ArtistInterface {
    List<FigureInterface> getInitialFiguresArray();

    List<FigureInterface> getFiguresArray();

    List<FigureInterface> getFiguresArray(int number);

    void printFiguresArray();
}
