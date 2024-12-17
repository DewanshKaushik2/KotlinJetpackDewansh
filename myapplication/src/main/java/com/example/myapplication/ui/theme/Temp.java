package com.example.myapplication.ui.theme;

import java.util.ArrayList;

public class Temp {
    static class Node {
        public int data;
        public Node next;

        Node(int data2) {
            data = data2;
            next = null;
        }
    }

    public void addonFront(Node head) {
        Thread thread1= new Thread(){
            @Override
            public void run(){
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(1);
                list.add(2);
                list.add(3);
                list.add(4);
                list.add(5);
                list.add(6);
                for(int i=0;i<=list.size();i++){
                    list.get(i);
                    if(list.get(i)%2 == 0){
                        System.out.println(list.get(i));
                    }
                }
            }
        };
        thread1.start();
    }

    public void print(Node head) {
        Node temp = head;
        if (head == null) {
            return;
        }
        while (temp != null && temp.next != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String... s) {
        System.out.println("hi");
        Temp ll = new Temp();
        //create list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        ll.addonFront(head);
        ll.print(head);
    }
}
