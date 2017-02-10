package com.vertex.academy.homework2;


/**
 * Created by Tanya on 06.02.2017.
 */
public class Man implements HumanInterface, Comparable<Man>{
    private int lengthOfMustache;
    private int id;
    public static int ID = 0;
    private static final int maxLengthOfMustache = 10;

    public Man(){
        this.setId(++ID);
        this.setLengthOfMustache( (int) (Math.random()* maxLengthOfMustache));
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setLengthOfMustache(int lengthOfMustache) {
        this.lengthOfMustache = lengthOfMustache;
    }

    public int getId() {
        return id;
    }
    public int getLengthOfMustache() {
        return lengthOfMustache;
    }

    @Override
    public String toString(){
        return this.getClass().getSimpleName()+" "+this.getId()+": length of mustache: "+this.getLengthOfMustache()+"; ";
    }

    @Override
    public int compareTo(Man o) {
        if (this.getLengthOfMustache()>o.getLengthOfMustache()){
            return 1;
        } else if (this.getLengthOfMustache()==o.getLengthOfMustache()){
            return 0;
        } else if (this.getLengthOfMustache()<o.getLengthOfMustache()){
            return -1;
        }
        return 0;
    }

    @Override
    public void buyTicket() {

    }


}
