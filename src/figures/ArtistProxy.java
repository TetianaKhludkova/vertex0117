package figures;

/**
 * Created by andrew_yashin on 1/22/17.
 */
public class ArtistProxy {
    Artist artist;

    public ArtistProxy(){
        artist = new Artist(100);
        System.out.println("**** Artist get 100 figures ****");
    }

    public ArtistProxy(int initFigures){
        artist = new Artist((initFigures));
        System.out.println("**** Artist get " + initFigures + " figures ****");
    }

    public void paintFigures(){
        System.out.println("**** Artist started painting 100 figures (as default) ****\n\n");
        artist.paintFigures(100);
        System.out.println("**** Artist finished painting 100 figures (as default) ****");
    }

    public void paintFigures(int total){
        System.out.println("**** Artist started painting " + total + " figures ****\n\n");
        artist.paintFigures(total);
        System.out.println("**** Artist finished painting " + total + " figures ****");
    }

    public static void main(String... args){
        ArtistProxy artist = new ArtistProxy();
        artist.paintFigures(250);
    }
}
