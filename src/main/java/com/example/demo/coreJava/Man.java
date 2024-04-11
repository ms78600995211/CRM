package com.example.demo.coreJava;

public interface Man {

    public abstract void run();

    public default void talk() {

        System.out.println("man is talking....");
    }

    public static void move() {

        System.out.println("man is moving...");
    }

}
