package com.vertex.academy.homework2.human;

/**
 * Created by Tanya on 06.02.2017.
 */

public class Lady extends Human {
    private int respect, id;
    private static int ID = 0;
    private static final int MAX_AMOUNT_OF_BROOCH = 8;


    Lady(){
        this.setRespect((int)(Math.random()* MAX_AMOUNT_OF_BROOCH));
        this.setId(++ID);
        this.setAmountOfTickets((int)(Math.random()* MAX_AMOUNT_OF_TICKETS));
    }

    @Override
    public String toString(){
        return this.getClass().getSimpleName()+" "+this.getId()+": amount of brooch: "+this.getRespect()+"  ";
    }


}
