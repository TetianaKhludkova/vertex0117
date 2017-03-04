package com.vertex.academy.generics;

import java.util.List;
import java.util.Optional;

/**
 * Created by vertex0007 on 04.03.2017.
 */
public class MyLinkedList<T> {

    private Holder head;
    private Holder current;

    private class Holder {
        private T instance;
        private Holder next;

        public Holder(T instance, Holder next) {
            this.instance = instance;
            this.next = next;
        }

        public T getInstance() {
            return instance;
        }

        public void setInstance(T instance) {
            this.instance = instance;
        }

        public Holder getNext() {
            return next;
        }

        public void setNext(Holder next) {
            this.next = next;
        }

        public boolean myMethod(Class<T> clazz) {
            return clazz.isInstance(instance);
        }

        public void superMethod(List<? super T> toConsume, List<? extends T> toProduce) {
            toConsume.add(instance);
        //    toProduce.add(instance); ERROR

          //  instance = toConsume.get(0); ERROR
            instance = toProduce.get(0);
        }
    }

    public void add(T newElement) {
        head = new Holder(newElement, head);
    }

    public Optional<T> get() {
        Optional<Holder> holderOptional = Optional.of(head);

        head = holderOptional.map(Holder::getNext).orElse(null);

        return holderOptional.map(Holder::getInstance);
    }


    public static void main(String[] args) {
        MyLinkedList<Integer> numbers = new MyLinkedList<>();
        numbers.add(2);
        System.out.println(numbers.get());
    }


}
