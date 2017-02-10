package com.vertex.academy.homework2;


/**
 * Created by Tanya on 06.02.2017.
 */
class Man extends Human{
    private int lengthOfMustache;
    private int id;
    private static int ID = 0;
    private static final int maxLengthOfMustache = 10;

    Man(){
        this.setId(++ID);
        this.setLengthOfMustache( (int) (Math.random()* maxLengthOfMustache));
    }

    private void setId(int id) {
        this.id = id;
    }
    private void setLengthOfMustache(int lengthOfMustache) {
        this.lengthOfMustache = lengthOfMustache;
    }

    public int getId() {
        return id;
    }
    public int getRespect() {
        return lengthOfMustache;
    }

    @Override
    public String toString(){
        return this.getClass().getSimpleName()+" "+this.getId()+": length of mustache: "+this.getRespect()+"; ";
    }


    @Override
    public void buyTicket() {

    }


}
