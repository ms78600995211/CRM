package com.example.demo.coreJava;

public interface Animal {

    public abstract void eat();

    public default void talk() {

        System.out.println("animal is talking....");
    }

    public static void move() {

        System.out.println("animal is moving...");
    }

}