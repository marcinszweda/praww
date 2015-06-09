package mod04.ex1c;

import static utils.AssertTest.*;

public class CounterTest3 {

	public static void main(String[] args) {
		checkAssertionsEnabled();

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
			assert (counter.getCounter() == 0) : "\nprzebieg #" + loop
					+ ": licznik = " + counter.getCounter();
			System.out.println("przebieg #" + loop + " OK");
			loop++;
		}
	}
}
