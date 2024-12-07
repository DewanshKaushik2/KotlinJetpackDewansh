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

    public void addValues(){
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
    }
}

