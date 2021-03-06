package mod06.ex04_proba3;

import static mod06.ex04_proba3.Igloo.*;

import java.util.Random;

import mod06.ex01.Wazna;

public class EskimosDuzy implements Runnable {
	private static Random spioch = new Random();

	private void sekcjaLokalna() throws InterruptedException {
		Thread.sleep(10);
	}

	private void sekcjaKrytyczna() throws InterruptedException {
//		assert (WSTEP_WOLNY == tablicaMalego) : "tablicaDuzego="
//				+ tablicaDuzego + " tablicaMalego=" + tablicaMalego;
		Wazna.dana++;
		System.out.print("DUZY: teraz wazna dana = " + Wazna.dana);
		assert (Wazna.dana < 3): "Wazna dana = " + Wazna.dana;
		Thread.sleep(spioch.nextInt(10));
		Wazna.dana--;
		System.out.println(" i ponownie = " + Wazna.dana);
	}

	@Override
	public void run() {
		while (true) {
			tablicaDuzego = ZAKAZ_WSTEPU;
			while (ZAKAZ_WSTEPU == tablicaMalego) { /* trzeba czekać */ }
			try {
				sekcjaKrytyczna();
				tablicaDuzego = WSTEP_WOLNY;
				sekcjaLokalna();
			} catch (InterruptedException e) {
				System.out.println("DUZY zakonczyl dzialanie");
				return;
			}
		}
	}
}
