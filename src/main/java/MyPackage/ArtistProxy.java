package MyPackage;

/**
 * Created by Valery on 1/27/2017.
 */
public class ArtistProxy {

    private Artist artist;

    public ArtistProxy() {
    }

    public void Paint(int quantity) {
        artist = new Artist();
        artist.Paint(quantity);
    }

}
