package mod02.ex02a;

import java.util.Random;

public class ThreadExceptions implements Runnable {
	private static final int MAX = 20;

	@Override
	public void run() {
		Random r = new Random();
		int wrong = r.nextInt(MAX);
		for (int i = 0; i < MAX; i++) {
			System.out.println(Thread.currentThread().getName() + ": " + i);
			if (i == wrong)
				throw new RuntimeException("Osiagnieto wartosc krytyczna: "
						+ wrong);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				return;
			}
		}
	}

	public static void main(String[] args) {
		System.setErr(System.out);
		
		Runnable task = new ThreadExceptions();
		
		Thread a = new Thread(task, "A");
		Thread b = new Thread(task, "B");
		Thread c = new Thread(task, "C");
		a.start();
		b.start();
		c.start();
	}

}
