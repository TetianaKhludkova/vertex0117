package com.vertex.academy.homework2;

/**
 * Created by Tanya on 06.02.2017.
 */
public class Lady implements HumanInterface, Comparable<Lady>{
    private int amountOfBrooch;
    private int id;
    public static int ID = 0;
    private static final int MAX_AMOUNT_OF_BROOCH = 10;

    public Lady(){
        this.setAmountOfBrooch((int)(Math.random()* MAX_AMOUNT_OF_BROOCH));
        this.setId(++ID);
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setAmountOfBrooch(int amountOfBrooch) {
        this.amountOfBrooch = amountOfBrooch;
    }

    public int getId() {
        return id;
    }
    public int getAmountOfBrooch() {
        return amountOfBrooch;
    }


    @Override
    public String toString(){
        return this.getClass().getSimpleName()+" "+this.getId()+": amount of brooch: "+this.getAmountOfBrooch()+"; ";
    }

    @Override
    public int compareTo(Lady o) {
        if (this.getAmountOfBrooch()>o.getAmountOfBrooch()){
            return 1;
        } else if (this.getAmountOfBrooch()==o.getAmountOfBrooch()){
            return 0;
        } else if (this.getAmountOfBrooch()<o.getAmountOfBrooch()){
            return -1;
        }
        return 0;

    }

    @Override
    public void buyTicket() {

    }


}
