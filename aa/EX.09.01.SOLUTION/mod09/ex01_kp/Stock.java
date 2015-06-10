package mod09.ex01_kp;

import java.util.ArrayList;
import java.util.List;

public class Stock {
	public static final int MAX_SIZE = 5;
	private List<AssemblySet> queue = new ArrayList<AssemblySet>();

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
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		notify();
		return queue.remove(0);
	}
}