package com.example.myapplication;

import java.util.ArrayList;

public class Singleton {

    static Singleton instance;
    ArrayList<String> list = new ArrayList<>();
    public static Singleton getInstance(){
        synchronized (Singleton.instance){
        if(instance == null){
            instance = new Singleton();
            return instance;
        }
        }
        return instance;
    }
public static void main(String... s){
        Singleton gg=new Singleton();
        gg.addValues();
}
    public void addValues(){
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        short x=10;
        x= (short) (x*5);
        System.out.println(x);
    }
}

