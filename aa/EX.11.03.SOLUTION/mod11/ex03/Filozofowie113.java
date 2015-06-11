package mod11.ex03;

import static mod11.ex03.Widelce.*;

// rozwiązanie problemu 5 filozofów w oparciu o monitor

public class Filozofowie113 {

	public static void main(String[] args) {
		for (int i = 0; i < LICZBA_FILOZOFOW; i++) {
			new Thread(new Filozof(i)).start();
		}
	}
}
