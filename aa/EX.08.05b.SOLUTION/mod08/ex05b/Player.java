package mod08.ex05b;

import java.util.Random;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Semaphore;

public class Player implements Runnable {
	private Exchanger<Integer> comparator = new Exchanger<Integer>();
	private Random r = new Random();
	private static Semaphore lock = new Semaphore(1);

	public Player(Exchanger<Integer> comparator) {
		this.comparator = comparator;
	}

	@Override
	public void run() {
		int yourThrow = 0;
		int myThrow = 0;
		do {
			myThrow = r.nextInt(6) + 1;
			try {
				yourThrow = comparator.exchange(myThrow);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			lock.acquireUninterruptibly();
			System.out.print(Thread.currentThread().getName() + ": " + myThrow
					+ " vs " + yourThrow + " --> ");
			if (myThrow < yourThrow)
				System.out.println("you won!");
			else if (myThrow > yourThrow)
				System.out.println("I won!");
			else
				System.out.println("no winner! throwing once more...");
			lock.release();
		} while (myThrow == yourThrow);
	}
}
