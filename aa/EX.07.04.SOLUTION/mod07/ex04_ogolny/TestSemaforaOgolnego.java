package mod07.ex04_ogolny;

import java.util.Random;

public class TestSemaforaOgolnego implements Runnable {

	private SemaforOgolny sem;
	private static Random r = new Random();

	public TestSemaforaOgolnego(SemaforOgolny sem) {
		this.sem = sem;
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		sem.P();
		System.out.println(name + " is working...  permits = "
				+ sem.availablePermits());
		try {
			Thread.sleep(3000 + r.nextInt(5000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name + " finished work");
		sem.V();
	}

	public static void main(String[] args) {
		SemaforOgolny s = new SemaforOgolny(3);
		TestSemaforaOgolnego tso = new TestSemaforaOgolnego(s);
		System.out.println("Available permits = " + s.availablePermits());
		for (int i = 0; i < 5; i++) {
			new Thread(tso, "t" + i).start();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}