package mod08.ex01_race;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Runner implements Runnable {
	private static Random r = new Random();
	private int name;
	private long[] results;
	private CountDownLatch readySignal;
	private CountDownLatch startSignal;
	private CountDownLatch stopSignal;

	public Runner(int name, long[] results, CountDownLatch readySignal,
			CountDownLatch startSignal, CountDownLatch stopSignal) {
		this.name = name;
		this.results = results;
		this.readySignal = readySignal;
		this.startSignal = startSignal;
		this.stopSignal = stopSignal;
	}

	@Override
	public String toString() {
		return "Runner " + name;
	}

	@Override
	public void run() {
		System.out.println(this + " waiting at start and is ready to go");
		readySignal.countDown();
		try {
			startSignal.await();
		} catch (InterruptedException e1) {
			System.out.println(this + " has not started!");
			System.out.println("Quiting the race...");
			System.exit(0);
		}
		long start = System.currentTimeMillis();
		try {
			Thread.sleep(r.nextInt(1000) + 2000);
		} catch (InterruptedException e) {
			System.out.println(this + " has not finished the race...");
			System.out.println("Quiting the race...");
			System.exit(0);
		}
		long stop = System.currentTimeMillis();
		results[name] = stop - start;
		stopSignal.countDown();
	}

}
