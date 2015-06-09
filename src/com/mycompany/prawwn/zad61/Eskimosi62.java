package com.mycompany.prawwn.zad61;


import static com.mycompany.prawwn.zad61.AssertTest.*;


public class Eskimosi62 {

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
