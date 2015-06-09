package mod06.ex06_dekker;

import static mod06.ex06_dekker.Arbiter.*;
import static mod06.ex06_dekker.Igloo.*;

import java.util.Random;



public class EskimosDuzy implements Runnable {
	private static Random spioch = new Random();

	private void sekcjaLokalna() throws InterruptedException {
		Thread.sleep(20);
	}

	private void sekcjaKrytyczna() throws InterruptedException {
		Wazna.dana++;
		System.out.print("DUZY: teraz wazna dana = " + Wazna.dana);
		assert (Wazna.dana < 3) : "Wazna dana = " + Wazna.dana;
		Thread.sleep(spioch.nextInt(10));
		Wazna.dana--;
		System.out.println(" i ponownie = " + Wazna.dana);
	}

	@Override
	public void run() {
		while (true) {
			try {
				tablicaDuzego = ZAKAZ_WSTEPU;
				while (ZAKAZ_WSTEPU == tablicaMalego)
					if (MALY == czyjaKolej) {
						tablicaDuzego = WSTEP_WOLNY;
						while (MALY == czyjaKolej) {
							Thread.yield(); // sleep(0)
						}
						tablicaDuzego = ZAKAZ_WSTEPU;
					}
				sekcjaKrytyczna();
				czyjaKolej = MALY;
				tablicaDuzego = WSTEP_WOLNY;
				sekcjaLokalna();
			} catch (InterruptedException e) {
				System.out.println("DUZY zakonczyl dzialanie");
				return;
			}
		}
	}
}
