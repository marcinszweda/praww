package mod08.ex05a;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Player implements Runnable {
	private PipedInputStream in;
	private PipedOutputStream out;
	private Random r = new Random();
	private static Semaphore lock = new Semaphore(1);

	public Player(PipedInputStream in, PipedOutputStream out) {
		this.in = in;
		this.out = out;
	}

	@Override
	public void run() {
		int yourThrow = 0;
		int myThrow = 0;
		try {
			do {
				myThrow = r.nextInt(6) + 1;
				out.write(myThrow);
				yourThrow = in.read();
				lock.acquireUninterruptibly();
				System.out.print(Thread.currentThread().getName() + ": "
						+ myThrow + " vs " + yourThrow + " --> ");
				if (myThrow < yourThrow)
					System.out.println("you won!");
				else if (myThrow > yourThrow)
					System.out.println("I won!");
				else
					System.out.println("no winner! throwing once more...");
				lock.release();
			} while (myThrow == yourThrow);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
				if (out != null)
					out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
