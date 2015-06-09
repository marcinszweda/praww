package com.mycompany.prawwn.zad61;

import static com.mycompany.prawwn.zad61.Igloo.MALY;
import java.util.Random;


public class EskimosDuzy implements Runnable {
	private static Random spioch = new Random();
    private int czyjaKolej;

	private void sekcjaLokalna() throws InterruptedException {
		Thread.sleep(1000);
	}

	private void sekcjaKrytyczna() throws InterruptedException {
		Wazna.dana++;
		System.out.print("DUZY: Teraz krytyczna dana = " + Wazna.dana);
		assert (Wazna.dana < 3) : "Wazna dana = " + Wazna.dana;
		Thread.sleep(spioch.nextInt(10));
		Wazna.dana--;
		System.out.println(" i ponownie = " + Wazna.dana);
	}

	@Override
	public void run() {
		while (true) {
			try {
				// protokol wstepny
				while (MALY == czyjaKolej) { /* trzeba czekac */ }
				sekcjaKrytyczna();
				// protokol koncowy
				Igloo.czyjaKolej = MALY; 
				sekcjaLokalna();
			} catch (InterruptedException e) {
				System.out.println("DUZY zakonczyl dzialanie");
				return;
			}
		}
	}
}
