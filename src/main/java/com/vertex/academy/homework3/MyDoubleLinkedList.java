//package com.vertex.academy.homework3;
//
//import com.vertex.academy.homework2.people.Human;
//import com.vertex.academy.homework2.people.Man;
//import com.vertex.academy.homework2.people.Woman;
//import com.vertex.academy.homework3.exceptions.LackOfBroochesException;
//import com.vertex.academy.homework3.exceptions.TooShortMustashesException;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.naming.ldap.PagedResultsControl;
//import java.util.Random;
//
//
///**
// * Created by andrew_yashin on 3/9/17.
// */
//public class MyDoubleLinkedList<T extends Human>  {
//    private Node prev;
//    private Node head;
//    private Node first;
//    private int size = 0;
//
//    private static int minimalLength, minimalCount;
//
//    static {
//        minimalCount = 2;
//        minimalLength = 3;
//    }
//
//
//    @Data
//    @AllArgsConstructor
//    @Getter
//    @Setter
//    private class Node {
//        Node next;
//        T instance;
//        Node prev;
//    }
//
//    public void add(T element) throws TooShortMustashesException, LackOfBroochesException{
//
//        Class clazz = element.getClass();
//
//        if(clazz == Man.class) {
//            if (element.getNumber() < minimalLength) {
//                throw new TooShortMustashesException();
//            }
//        } else {
//            if (element.getNumber() < minimalCount){
//                throw new LackOfBroochesException();
//            }
//        }
//        size++;
//        Node node = new Node(head, element, prev);
//
//        if(first == null){
//            first = node;
//        }
//
//        if(head != null) {
//            head.prev = node;
//        }
//
//        head = node;
//        prev = node.next;
//        head = node;
//    }
//
//    public T popLast(){
//        T element = head.getInstance();
//        head = head.next;
//
//        return element;
//    }
//
//    public T popFirst(){
//        T element = first.getInstance();
//        first = first.prev;
//
//        return element;
//    }
//
//
//    public int size(){
//        return size;
//    }
//
//
//    public static void main(String[] args) {
//        MyDoubleLinkedList<Human> list =
//                new MyDoubleLinkedList<>();
//
//        for(int i = 0; i < 10; i++){
//            try{
//                list.add(getHuman());
//            } catch (TooShortMustashesException e){
//                System.err.println(e.getMessage() + " in " + i);
//            } catch (LackOfBroochesException e){
//                System.err.println(e.getMessage() + " in " + i);
//            }
//        }
//
//        for(int i = 0; i < list.size(); i++){
//            System.out.println(list.popFirst());
//        }
//    }
//
//    private static Human getHuman(){
//        Random random = new Random();
//
//        switch (random.nextInt(2)){
//            case 0: return new Man();
//            default: return new Woman();
//        }
//    }
//
//
//}
