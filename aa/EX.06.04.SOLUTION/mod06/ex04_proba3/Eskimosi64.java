package mod06.ex04_proba3;

import static utils.AssertTest.*;

public class Eskimosi64 {

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
