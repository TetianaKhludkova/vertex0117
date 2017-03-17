package com.vertex.academy.homework2.human;


/**
 * Created by Tanya on 06.02.2017.
 */
public class Man extends Human {
    private int respect, id;
    private static int ID = 0;
    private static final int maxLengthOfMustache = 10;

    Man(){
        this.setId(++ID);
        this.setRespect( (int) (Math.random()* maxLengthOfMustache));
        this.setAmountOfTickets((int)(Math.random()* MAX_AMOUNT_OF_TICKETS));
    }


    @Override
    public String toString(){
        return this.getClass().getSimpleName()+" "+this.getId()+": length of mustache: "+this.getRespect()+" ";
    }
}
