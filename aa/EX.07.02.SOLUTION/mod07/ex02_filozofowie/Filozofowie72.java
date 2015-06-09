package mod07.ex02_filozofowie;

import static mod07.ex02_filozofowie.Semafor.*;

public class Filozofowie72 {

	public static void main(String[] args) {
		for (int i = 0; i < LICZBA_FILOZOFOW; i++) {
			new Thread(new Filozof(i)).start();
		}
	}
}
