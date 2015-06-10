package com.mycompany.prawwn.zad84;

import java.util.Random;
import java.util.concurrent.SynchronousQueue;

public class Producer implements Runnable {
	private SynchronousQueue exchanger;
	private Random r = new Random();
	private AssemblySet set;

	public Producer(SynchronousQueue exchanger) {
		this.exchanger = exchanger;
	}

	private AssemblySet produce(int i) throws InterruptedException {
		AssemblySet set = new AssemblySet(new ComponentA(), new ComponentB(),
				new ComponentC(), "set" + i);
		Thread.sleep(r.nextInt(100));
		System.out.println("Components " + set + " ready");
		return set;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				set = produce(i);
				exchanger.put(set);
			}
			exchanger.put(new AssemblySet(new ComponentA(), new ComponentB(),
				new ComponentC(), "set" + 11));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
