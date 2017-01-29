package MyPackage;

/**
 * Created by Valery on 1/27/2017.
 */
public class ArtistProxy {

    private Artist artist;
    private int initQuantity;
    private int canvasWidth, canvasHeight;

    public ArtistProxy(int initQuantity, int canvasWidth, int canvasHeight) {
        this.initQuantity = initQuantity;
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
    }

    public void Paint(int quantity) {
        if (artist == null) {
            artist = new Artist(initQuantity, canvasWidth, canvasHeight);
        }
        artist.Paint(quantity);
    }

}
