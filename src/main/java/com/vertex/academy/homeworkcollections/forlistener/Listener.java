package com.vertex.academy.homeworkcollections.forlistener;

import com.vertex.academy.homeworkcollections.Gender;

/**
 * Created by Aile (on Valery) on 2/10/2017.
 */
public class Listener implements Comparable<Listener> {

    protected Gender gender;
    protected int mustacheLength, pinCount;

    protected Listener() {}

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Listener{ " + this.getGender() +
                ", esteem=" + this.getEsteem() +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Listener)) return false;

        Listener listener = (Listener) o;

        if (gender != listener.getGender()) return false;
        return this.getEsteem() == listener.getEsteem();

    }

    @Override
    public int hashCode() {

        int result = gender != null ? gender.hashCode() : 0;
        result = 31 * result + getEsteem();
        return result;

    }

    @Override
    public int compareTo(Listener listener) {

        int esteem = this.getEsteem();
        int result = 1;

        if (listener == null) {
            result = -3;
        } else {

            Gender listenerGender = listener.getGender();
            int listenerEsteem = listener.getEsteem();

            if ((this.gender == Gender.GENTLEMAN) && (listenerGender == Gender.LADY)) {
                result = 2;
            } else if ((this.gender == Gender.LADY) && (listenerGender == Gender.GENTLEMAN)) {
                result = -2;
            } else if (esteem == listenerEsteem) {
                result = 0;
            } else if (esteem > listenerEsteem) {
                result = -1;
            }

        }

        return result;
    }

    public int getEsteem() {

        if (this.gender == Gender.GENTLEMAN) {
            return this.mustacheLength;
        } else {
            return this.pinCount;
        }

    }

    public static class Builder {

        private Listener instance;

        public Builder() {

            instance = new Listener();
            instance.gender = Gender.GENTLEMAN;
            instance.mustacheLength = 0;
            instance.pinCount = 0;

        }

        public Listener Build() {
            return instance;
        }

        public Builder setGender(Gender gender) {

            int esteem = instance.getEsteem();
            instance.gender = gender;
            if (esteem != 0) {
                setEsteem(esteem);
            }
            return this;

        }

        public Builder setEsteem(int esteem) {

            if (instance.gender == Gender.GENTLEMAN) {
                instance.pinCount = 0;
                instance.mustacheLength = esteem;
            } else {
                instance.pinCount = esteem;
                instance.mustacheLength = 0;
            }

            return this;

        }

    }

}
