package mod07.ex01_eskimosi;

import java.util.Random;


public class EskimosDuzy implements Runnable {
	private static Random spioch = new Random();
	private int licznik = 0;

	private void sekcjaLokalna() throws InterruptedException {
		Thread.sleep(10);
	}

	private void sekcjaKrytyczna() throws InterruptedException {
		Wazna.dana++;
		licznik++;
		if (100 == licznik) {
			System.out.println("DUZY: teraz wazna dana = " + Wazna.dana);
			licznik = 0;
		}
		assert (2 == Wazna.dana) : "Wazna dana = " + Wazna.dana;
		Thread.sleep(spioch.nextInt(10));
		Wazna.dana--;
		assert (1 == Wazna.dana) : "Wazna dana = " + Wazna.dana;
	}

	@Override
	public void run() {
		while (true) {
			try {
				sekcjaLokalna();
				// oczekiwanie i opuszczenie szlabana
				Semafor.szlaban.acquireUninterruptibly(); 
                                sekcjaKrytyczna();
				Semafor.szlaban.release(); // podniesienie szlabana
			} catch (InterruptedException e) {
				System.out.println("DUZY zakonczyl dzialanie");
				return;
			}
		}
	}
}
