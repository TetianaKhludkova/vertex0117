//package com.vertex.academy.lessons;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//
//
///**
// * Created by andrew_yashin on 3/4/17.
// */
//public class OneLinkedList<T> {
//    Node head;
//
//    @Data
//    @AllArgsConstructor
//    @Getter
//    @Setter
//    private class Node{
//        private T instance;
//        private Node next;
//    }
//
//    public void add(T element){
//        Node node = new Node(element, head);
//        head = node;
//    }
//
//    public T get(){
//        T element = head.getInstance();
//        head = head.next;
//
//        return element;
//    }
//
//    public static void main(String[] args) {
//        OneLinkedList<List> list = new OneLinkedList<>();
//
//        list.add(new ArrayList());
//        list.add(new LinkedList());
//
//        System.out.println(list.get());
//        System.out.println(list.get());
//    }
//
//
//    class A{}
//    class B extends A{}
//    class C extends A{}
//    class D extends B{}
//}
