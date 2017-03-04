package com.vertex.academy.lessons;

import javax.xml.ws.Holder;

/**
 * Created by andrew_yashin on 3/4/17.
 */
public class OneLinkedList<T> {


    private class Node{
        private T instance;
        private Node next;

        public Node(T instance, Node next) {
            this.instance = instance;
            this.next = next;
        }

        public T getInstance() {
            return instance;
        }

        public void setInstance(T instance) {
            this.instance = instance;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
