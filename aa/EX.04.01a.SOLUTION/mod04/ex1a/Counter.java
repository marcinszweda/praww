package mod04.ex1a;

public class Counter {
	private volatile int counter = 0;

	public void increment() {
		counter++;
	}

	public void decrement() {
		counter--;
	}

	public int getCounter() {
		return counter;
	}
}