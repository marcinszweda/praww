package com.mycompany.prawwn.zad72;

import static com.mycompany.prawwn.zad72.Semafor.LICZBA_FILOZOFOW;
import static com.mycompany.prawwn.zad72.Semafor.widelec;


import java.util.Random;

public class Filozof implements Runnable {
	private int i;			// nr filozofa
	private final int LEWY;
	private final int PRAWY;
	private int obzarstwo;	// ile razy filozof jadł
	private Random r = new Random();

	public Filozof(int i) {
		this.i = i;
		LEWY = i;
		PRAWY = (i + 1) % LICZBA_FILOZOFOW;
	}

	@Override
	public String toString() {
		return "Filozof " + i;
	}

	private void mysli() throws InterruptedException {
		System.out.println(this + " myśli");
		Thread.sleep(30);
	}

	private void je() throws InterruptedException {
		System.out.println(this + " je");
		Thread.sleep(r.nextInt(1000));
		System.out.println(this + " skończył jeść po raz " + ++obzarstwo);
	}

	@Override
	public void run() {
		while (true) {
			try {
				mysli();
				widelec[LEWY].acquire();
				widelec[PRAWY].acquire();
				je();
				widelec[LEWY].release();
				widelec[PRAWY].release();
			} catch (InterruptedException e) {
				System.out.println("Wystąpił wyjątek " + e.getClass().getName());
				return;
			}
		}
	}
}
