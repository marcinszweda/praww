package mod08.ex04_kp;

import java.util.Random;
import java.util.concurrent.SynchronousQueue;

public class Producer implements Runnable {
	private SynchronousQueue<AssemblySet> queue;
	private Random r = new Random();

	public Producer(SynchronousQueue<AssemblySet> queue) {
		this.queue = queue;
	}

	private AssemblySet produce(int i) throws InterruptedException {
		AssemblySet set = new AssemblySet(new ComponentA(), new ComponentB(),
				new ComponentC(), "set" + i);
		Thread.sleep(r.nextInt(100));
		System.out.println("Components " + set + " ready");
		return set;
	}

	@Override
	public void run() {
		AssemblySet set;
		try {
			for (int i = 0; i < 10; i++) {
				set = produce(i);
				queue.put(set);
			}
			queue.put(AssemblySet.empty);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
