package myhomework;

/**
 * Created by Valery on 1/27/2017.
 */
//todo: proxy should implement the same interface!
//done
public class ArtistProxy implements ArtistInterface {

    private Artist artist;
    private int initQuantity;
    private int canvasWidth, canvasHeight;

    public ArtistProxy(int initQuantity, int canvasWidth, int canvasHeight) {
        this.initQuantity = initQuantity;
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
    }

    @Override
    public void paint(int quantity) {
        if (artist == null) {
            artist = new Artist(initQuantity, canvasWidth, canvasHeight);
        }
        artist.paint(quantity);
    }

}
