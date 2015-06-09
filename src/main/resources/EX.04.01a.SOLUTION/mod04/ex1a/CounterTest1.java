package mod04.ex1a;

public class CounterTest1 {

	public static void main(String[] args) {

		final int REPEATS = 1000000; // liczba inkr. i dekr.
		int loop = 0;

		while (true) {
			Counter counter = new Counter();
			Thread plus = new Thread(new Plus(counter, REPEATS));
			Thread minus = new Thread(new Minus(counter, REPEATS));
			plus.start();
			minus.start();
			while (plus.isAlive() || minus.isAlive()) {
			} // aktywna petla - czekamy na koniec obliczeń
			if (counter.getCounter() != 0)
				System.out.println("przebieg #" + loop + ": licznik = "
						+ counter.getCounter());
			else
				System.out.println("przebieg #" + loop + " OK");
			loop++;
		}
	}
}
