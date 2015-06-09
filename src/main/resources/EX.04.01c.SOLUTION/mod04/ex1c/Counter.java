package mod04.ex1c;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
	private AtomicInteger counter = new AtomicInteger(0);

	public void increment() {
		counter.getAndIncrement();
	}

	public void decrement() {
		counter.getAndDecrement();
	}

	public int getCounter() {
		return counter.get();
	}
}