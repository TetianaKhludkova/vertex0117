package com.vertex.academy.homework1;


/**
 * Class is for drawing specific quantity of figures needed for client.
 * This proxy-class helps artist to draw exact number, which is made for resource economy.
 * Proxy-pattern realisation.
 */
public class ArtistProxy implements Artist {
    private Artist proxyArtist;
    private int quantityOfFigures;

    /**
     *
      * @param quantityOfFigures
     */
    public ArtistProxy(int quantityOfFigures) {
        this.quantityOfFigures = quantityOfFigures;
    }


     @Override
    public void drawFigure() {
// TODO: 05.02.17 why don't you check if it was created before? not to initialize twice?
        proxyArtist = new ConcreteArtist(quantityOfFigures);
        proxyArtist.drawFigure();


    }
}
