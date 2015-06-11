package com.mycompany.prawwn.zad111;

import static utils.AssertTest.*;

public class Eskimosi61 {

	public static void main(String[] args) {
		checkAssertionsEnabled();
                Wazna wazna= new Wazna();
                
		EskimosDuzy eskimosDuzy = new EskimosDuzy(wazna);
		EskimosMaly eskimosMaly = new EskimosMaly(wazna);
                

		Thread watekEskimosaDuzego = new Thread(eskimosDuzy);
		Thread watekEskimosaMalego = new Thread(eskimosMaly);

		System.out.println("GLOWNY: Aktualnie wazna dana = " + wazna.getDana());
		System.out.println("Startujemy eskimosow: malego i DUZEGO :-)");
		watekEskimosaDuzego.start();
		watekEskimosaMalego.start();

		System.out.println("GLOWNY: Koniec.");
	}
}
