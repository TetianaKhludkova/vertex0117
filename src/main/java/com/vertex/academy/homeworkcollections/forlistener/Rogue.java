package com.vertex.academy.homeworkcollections.forlistener;

import com.vertex.academy.homeworkcollections.Gender;

/**
 * Created by Aile (on Valery) on 2/17/2017.
 */
public class Rogue extends Listener {

    @Override
    public String toString() {
        return "Rogue{ " + this.getGender() +
                ", esteem=" + this.getEsteem() +
                '}';
    }

    public Rogue(int esteem, Gender gender) {

        super.gender = gender;

        if (super.gender == Gender.GENTLEMAN) {
            super.pinCount = 0;
            super.mustacheLength = esteem;
        } else {
            super.pinCount = esteem;
            super.mustacheLength = 0;
        }

    }

    public void resetEsteem(int esteem) {

        if (super.gender == Gender.GENTLEMAN) {
            super.pinCount = 0;
            super.mustacheLength = esteem;
        } else {
            super.pinCount = esteem;
            super.mustacheLength = 0;
        }

    }

}
