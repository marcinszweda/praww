package mod10.ex01_kp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Stock {
	public static final int MAX_SIZE = 5;
	private List<AssemblySet> queue = new ArrayList<AssemblySet>();
	final Lock lock = new ReentrantLock();
	final Condition producers = lock.newCondition();
	final Condition assemblers = lock.newCondition();

	private boolean noProducers = false;

	public void store(AssemblySet set) {
		lock.lock();
		try {
			while (MAX_SIZE == queue.size())
				try {
					producers.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			assemblers.signal();
			queue.add(set);
		} finally {
			lock.unlock();
		}
	}

	public AssemblySet get() {
		lock.lock();
		try {
			while (0 == queue.size()) {
				if (noProducers)
					return null; // trzeba konczyc watek
				try {
					assemblers.await();
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
			producers.signal();
			return queue.remove(0);
		} finally {
			lock.unlock();
		}
	}

	public void setNoProducers() {
		lock.lock();
		try {
			this.noProducers = true;
			assemblers.signalAll(); // obudzenie wszystkich montazystow
		} finally {
			lock.unlock();
		}
	}

	public void left() {
		lock.lock();
		try {
			System.out.println("--------------------");
			if (0 == queue.size())
				System.out.println("no sets left");
			else {
				System.out.println("Sets left in queue:");
				for (AssemblySet a : queue)
					System.out.println(a);
			}
		} finally {
			lock.unlock();
		}
	}
}