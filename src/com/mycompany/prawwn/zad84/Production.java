package com.mycompany.prawwn.zad84;

import java.util.concurrent.SynchronousQueue;



public class Production {

	public static void main(String[] args) {
		SynchronousQueue exchanger = new SynchronousQueue();
		new Thread(new Producer(exchanger)).start();
		new Thread(new Assembler(exchanger)).start();
	}
}
