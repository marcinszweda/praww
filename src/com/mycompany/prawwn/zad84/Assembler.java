package com.mycompany.prawwn.zad84;

import java.util.Random;
import java.util.concurrent.SynchronousQueue;

public class Assembler implements Runnable {
	private SynchronousQueue exchanger;
	private Random r = new Random();
	private AssemblySet set = null;

	public Assembler(SynchronousQueue exchanger) {
		this.exchanger = exchanger;
	}

	private void assemble(AssemblySet set) {
		try {
			Thread.sleep(r.nextInt(150));
			System.out.println("Article assembled from " + set);
		} catch (InterruptedException e) {
			return;
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				set = exchanger.exchange(set);
				if (null == set) {
					break;
				}
				assemble(set);
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}
