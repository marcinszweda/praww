package mod02.ex02b;

import java.lang.Thread.UncaughtExceptionHandler;
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

	private static void logException(Thread t, Throwable e, String title) {
		String excName = e.getClass().getName();
		String message = e.getMessage();
		String threadName = t.getName();
		System.out.print("--- " + title + " ---> ");
		System.out.println("W watku: " + threadName + " wystapil wyjatek: "
				+ excName);
		System.out.println(message + "\n");
	}

	public static void main(String[] args) {
		System.setErr(System.out);
		Runnable task = new ThreadExceptions();

		// definicja grupy wraz z handlerem
		ThreadGroup group = new ThreadGroup("grupa") {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				logException(t, e, "Handler grupy");
			}
		};

		// rejestracja handlera domyslnego
		Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {

			@Override
			public void uncaughtException(Thread t, Throwable e) {
				logException(t, e, "Handler domyslny");
			}
		});

		Thread a = new Thread(group, task, "A");
		// rejestracja handlera dedykowanego dla watka A
		a.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {

			@Override
			public void uncaughtException(Thread t, Throwable e) {
				logException(t, e, "Handler dedykowany");
			}
		});

		// brak handlera dedykowanego
		// jest handler dla grupy
		Thread b = new Thread(group, task, "B");

		// brak handlera dedykowanego i handlera dla grupy
		// jest handler domyslny
		Thread c = new Thread(task, "C");

		a.start();
		b.start();
		c.start();
	}

}
