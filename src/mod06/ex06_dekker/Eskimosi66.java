package mod06.ex06_dekker;

import static mod06.ex06_dekker.AssertTest.*;

public class Eskimosi66 {

	public static void main(String[] args) {
		checkAssertionsEnabled();
		EskimosDuzy eskimosDuzy = new EskimosDuzy();
		EskimosMaly eskimosMaly = new EskimosMaly();

		Thread watekEskimosaDuzego = new Thread(eskimosDuzy);
		Thread watekEskimosaMalego = new Thread(eskimosMaly);

		System.out.println("GLOWNY: Aktualnie wazna dana = " + Wazna.dana);
		System.out.println("Startujemy eskimosow: malego i DUZEGO :-)");
		watekEskimosaDuzego.start();
		watekEskimosaMalego.start();

		System.out.println("GLOWNY: Koniec.");
	}
}
