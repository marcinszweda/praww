package mod11.ex01;

public final class Wazna {
	private static int dana = 1;

	public synchronized static void zwiekszDana() {
		dana++;
	}

	public synchronized static void zmniejszDana() {
		dana--;
	}

	public synchronized static int odczytajDana() {
		return dana;
	}
}