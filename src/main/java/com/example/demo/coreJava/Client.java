package com.example.demo.coreJava;

public class Client implements Animal, Man {

	@Override
	public void run() {

		System.out.println("Man is running.");

	}

	@Override
	public void eat() {

		System.out.println("Animal is eating.");

	}

	@Override
	public void talk() {
		// TODO Auto-generated method stub
		Man.super.talk();
	}

	/*
	 * public void talk() {
	 * 
	 * System.out.println("man is talking...."); }
	 */
	public static void main(String[] args) {

		Client client = new Client();
		client.eat();
		client.run();
		client.talk();

	}

}
