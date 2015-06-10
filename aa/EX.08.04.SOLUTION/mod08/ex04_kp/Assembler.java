package mod08.ex04_kp;

import java.util.Random;
import java.util.concurrent.SynchronousQueue;

public class Assembler implements Runnable {
	private SynchronousQueue<AssemblySet> queue;
	private Random r = new Random();
	private AssemblySet set = null;

	public Assembler(SynchronousQueue<AssemblySet> queue) {
		this.queue = queue;
	}

	private void assemble(AssemblySet set) {
		try {
			Thread.sleep(r.nextInt(150));
			System.out.println("Article assembled from " + set);
		} catch (InterruptedException e) {
			return;
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				set = queue.take();
				if (AssemblySet.empty == set) {
					return;
				}
				assemble(set);
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}
