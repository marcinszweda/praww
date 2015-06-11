package mod11.ex03;

public class Widelce {
	
	public static final int LICZBA_FILOZOFOW = 5;
	
	private static final int[] wolneWidelce = new int[LICZBA_FILOZOFOW];
	static {
		for (int i = 0; i < LICZBA_FILOZOFOW; i++) {
			wolneWidelce[i] = 2;
		}
	}

	public static synchronized void bierze(int i) {
		final int LEWY = i;
		final int PRAWY = (i + 1) % LICZBA_FILOZOFOW;
		if (wolneWidelce[i] != 2) {
			try {
				Widelce.class.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		wolneWidelce[LEWY]--;
		wolneWidelce[PRAWY]--;
	}

	public static synchronized void odklada(int i) {
		final int LEWY = i;
		final int PRAWY = (i + 1) % LICZBA_FILOZOFOW;
		wolneWidelce[LEWY]++;
		wolneWidelce[PRAWY]++;
		Widelce.class.notifyAll();
//		if (wolneWidelce[PRAWY] == 2) {
//			Widelce.class.notify();
//		}
//		if (wolneWidelce[LEWY] == 2) {
//			Widelce.class.notify();
//		}
	}
}
