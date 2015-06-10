package mod09.ex02_kp;

import java.util.ArrayList;
import java.util.List;

public class Stock {
	public static final int MAX_SIZE = 5;
	private List<AssemblySet> queue = new ArrayList<AssemblySet>();
	private boolean noProducers = false;

	public synchronized void store(AssemblySet set) {
		while (MAX_SIZE == queue.size())
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		notify();
		queue.add(set);
	}

	public synchronized AssemblySet get() {
		while (0 == queue.size()) {
			if (noProducers)
				return null; // trzeba konczyc watek
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		notify();
		return queue.remove(0);
	}

	public synchronized void setNoProducers() {
		this.noProducers = true;
		notifyAll(); // obudzenie wszystkich montazystow
	}

	public synchronized void left() {
		System.out.println("--------------------");
		if (0 == queue.size())
			System.out.println("no sets left");
		else {
			System.out.println("Sets left in queue:");
			for (AssemblySet a : queue)
				System.out.println(a);
		}
	}
}