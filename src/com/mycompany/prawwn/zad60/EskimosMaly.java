package com.mycompany.prawwn.zad60;

import java.util.Random;

public class EskimosMaly implements Runnable {
	private static Random spioch = new Random();

	private void sekcjaLokalna() throws InterruptedException {
		Thread.sleep(100);
	}

	private void sekcjaKrytyczna() throws InterruptedException {
		Wazna.dana++;
		System.out.println("maly: Teraz krytyczna dana = " + Wazna.dana);
		assert (Wazna.dana < 3) : "Wazna dana = " + Wazna.dana;
		Thread.sleep(spioch.nextInt(10));
		Wazna.dana--;
	}

	@Override
	public void run() {
		while (true) {
			try {
				sekcjaKrytyczna();
				sekcjaLokalna();
			} catch (InterruptedException e) {
				System.out.println("maly zakonczyl dzialanie");
				return;
			}
		}
	}
}
