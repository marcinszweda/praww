package mod11.ex01;

import utils.AssertTest;

public class Eskimosi {

	public static void main(String[] args) {
		AssertTest.checkAssertionsEnabled();
		EskimosDuzy eskimosDuzy = new EskimosDuzy();
		EskimosMaly eskimosMaly = new EskimosMaly();

		Thread watekEskimosaDuzego = new Thread(eskimosDuzy, "duzy");
		Thread watekEskimosaMalego = new Thread(eskimosMaly, "maly");

		System.out.println("GLOWNY: Aktualnie wazna dana = " + Wazna.odczytajDana());
		System.out.println("Startujemy eskimosow: malego i DUZEGO :-)");
		watekEskimosaDuzego.start();
		watekEskimosaMalego.start();

		System.out.println("GLOWNY: Koniec.");
	}
}
