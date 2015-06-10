package mod08.ex03_kp;

import java.util.Random;
import java.util.concurrent.Exchanger;

public class Producer implements Runnable {
	private Exchanger<AssemblySet> exchanger;
	private Random r = new Random();
	private AssemblySet set;

	public Producer(Exchanger<AssemblySet> exchanger) {
		this.exchanger = exchanger;
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
		try {
			for (int i = 0; i < 10; i++) {
				set = produce(i);
				exchanger.exchange(set);
			}
			exchanger.exchange(null);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
