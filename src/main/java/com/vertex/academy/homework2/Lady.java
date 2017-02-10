package com.vertex.academy.homework2;

/**
 * Created by Tanya on 06.02.2017.
 */
class Lady extends Human{
    private int amountOfBrooch;
    private int id;
    private static int ID = 0;
    private static final int MAX_AMOUNT_OF_BROOCH = 10;

    Lady(){
        this.setAmountOfBrooch((int)(Math.random()* MAX_AMOUNT_OF_BROOCH));
        this.setId(++ID);
    }

    private void setId(int id) {
        this.id = id;
    }
    private void setAmountOfBrooch(int amountOfBrooch) {
        this.amountOfBrooch = amountOfBrooch;
    }

    public int getId() {
        return id;
    }
    public int getRespect() {
        return amountOfBrooch;
    }


    @Override
    public String toString(){
        return this.getClass().getSimpleName()+" "+this.getId()+": amount of brooch: "+this.getRespect()+"; ";
    }


    @Override
    public void buyTicket() {

    }


}
