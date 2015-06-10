package mod08.ex01_race;

import java.util.concurrent.CountDownLatch;

public class Race {

	public static void main(String[] args) {
		final int RUNNERS = 5;
		long[] results = new long[RUNNERS];
		CountDownLatch startSignal = new CountDownLatch(1);
		CountDownLatch readySignal = new CountDownLatch(RUNNERS);
		CountDownLatch stopSignal = new CountDownLatch(RUNNERS);
		System.out.println("Waiting for runners to be ready to start...\n");
		for (int i = 0; i < RUNNERS; i++) {
			new Thread(new Runner(i, results, readySignal, startSignal,
					stopSignal)).start();
		}
		try {
			readySignal.await(); // waiting for runners
			System.out.println("\nOK. Ready? Go!");
			startSignal.countDown(); // start of the race
			stopSignal.await(); // waiting for all runners to finish the race
		} catch (InterruptedException e) {
			return;
		}
		System.out.println("Race is over...\n");
		System.out.println("RACE RESULTS:");
		for (int i = 0; i < RUNNERS; i++) {
			System.out.println("Time of runner " + i + " = " + results[i]
					+ " ms");
		}
	}
}
