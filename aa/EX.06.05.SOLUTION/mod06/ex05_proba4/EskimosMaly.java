package mod06.ex05_proba4;

import static mod06.ex05_proba4.Igloo.*;

import java.util.Random;

import mod06.ex01.Wazna;

public class EskimosMaly implements Runnable {
	private static Random spioch = new Random();

	private void sekcjaLokalna() throws InterruptedException {
		Thread.sleep(20);
	}

	private void sekcjaKrytyczna() throws InterruptedException {
//		assert (tablicaDuzego == WSTEP_WOLNY) : "tablicaDuzego="
//				+ tablicaDuzego + " tablicaMalego=" + tablicaMalego;
		Wazna.dana++;
		System.out.print("maly: teraz wazna dana = " + Wazna.dana);
		assert (Wazna.dana < 3): "Wazna dana = " + Wazna.dana;
		Thread.sleep(spioch.nextInt(10));
		Wazna.dana--;
		System.out.println(" i ponownie = " + Wazna.dana);
	}

	@Override
	public void run() {
		while (true) {
			try {
				tablicaMalego = ZAKAZ_WSTEPU;
				while (tablicaDuzego == ZAKAZ_WSTEPU) {
					tablicaMalego = WSTEP_WOLNY;
					Thread.sleep(spioch.nextInt(5));
					tablicaMalego = ZAKAZ_WSTEPU;
				}
				sekcjaKrytyczna();
				tablicaMalego = WSTEP_WOLNY;
				sekcjaLokalna();
			} catch (InterruptedException e) {
				System.out.println("maly zakonczyl dzialanie");
				return;
			}
		}
	}
}
