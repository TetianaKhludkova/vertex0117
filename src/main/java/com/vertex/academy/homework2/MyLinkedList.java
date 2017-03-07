package com.vertex.academy.homework2;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;


public class MyLinkedList<T> {

    private Holder head;
    private Holder current;

    @Data
    @AllArgsConstructor
    private class Holder {
        private Holder previous;
        private T instance;
        private Holder next;


//        public boolean myMethod(Class<T> clazz) {
//            return clazz.isInstance(instance);
//        }
//
//        public void superMethod(List<? super T> toConsume, List<? extends T> toProduce) {
//            toConsume.add(instance);
//            //    toProduce.add(instance); ERROR
//
//            //  instance = toConsume.get(0); ERROR
//            instance = toProduce.get(0);
//        }
    }

    public void add(T newElement) {
        if (head==null) {
            head = new Holder(null, newElement, null);
        }else{
            current = new Holder(head, newElement, null);
            head = current;
        }
    }

    public Optional<T> get() {
        Optional<Holder> holderOptional = Optional.of(head);

        head = holderOptional.map(Holder::getNext).orElse(null);

        return holderOptional.map(Holder::getInstance);
    }

    @Override
    public String toString() {
        return "previous=" + current.getPrevious().getInstance() +
                "current=" + current.getInstance() +
                '}';
    }


}