package mod06.ex06_dekker;

import static mod06.ex06_dekker.Arbiter.*;
import static mod06.ex06_dekker.Igloo.*;

import java.util.Random;


public class EskimosMaly implements Runnable {
	private static Random spioch = new Random();

	private void sekcjaLokalna() throws InterruptedException {
		Thread.sleep(40);
	}

	private void sekcjaKrytyczna() throws InterruptedException {
		Wazna.dana++;
		System.out.print("maly: teraz wazna dana = " + Wazna.dana);
		assert (Wazna.dana < 3) : "Wazna dana = " + Wazna.dana;
		Thread.sleep(spioch.nextInt(10));
		Wazna.dana--;
		System.out.println(" i ponownie = " + Wazna.dana);
	}

	@Override
	public void run() {
		while (true) {
			try {
				tablicaMalego = ZAKAZ_WSTEPU;
				while (ZAKAZ_WSTEPU == tablicaDuzego)
					if (DUZY == czyjaKolej) {
						tablicaMalego = WSTEP_WOLNY;
						while (DUZY == czyjaKolej) {
							Thread.yield(); // sleep(0);
						}
						tablicaMalego = ZAKAZ_WSTEPU;
					}
				sekcjaKrytyczna();
				czyjaKolej = DUZY;
				tablicaMalego = WSTEP_WOLNY;
				sekcjaLokalna();
			} catch (InterruptedException e) {
				System.out.println("maly zakonczyl dzialanie");
				return;
			}
		}
	}
}
