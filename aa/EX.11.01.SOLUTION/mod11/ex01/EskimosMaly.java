package mod11.ex01;

import java.util.Random;

public class EskimosMaly implements Runnable {
	private static Random spioch = new Random();
	private int licznik = 0;

	private void sekcjaLokalna() throws InterruptedException {
		Thread.sleep(20);
	}

	public void sekcjaKrytyczna() throws InterruptedException {
		synchronized (Wazna.class) {
			Wazna.zwiekszDana();
			licznik++;
			if (100 == licznik) {
				System.out.println("maly: teraz wazna dana = "
						+ Wazna.odczytajDana());
				licznik = 0;
			}
			assert (2 == Wazna.odczytajDana());
			Thread.sleep(spioch.nextInt(10));
			Wazna.zmniejszDana();
			assert (1 == Wazna.odczytajDana());
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				sekcjaLokalna();
				sekcjaKrytyczna();
			} catch (InterruptedException e) {
				System.out.println("maly zakonczyl dzialanie");
				return;
			}
		}
	}
}
