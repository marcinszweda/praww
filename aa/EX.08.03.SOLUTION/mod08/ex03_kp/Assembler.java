package mod08.ex03_kp;

import java.util.Random;
import java.util.concurrent.Exchanger;

public class Assembler implements Runnable {
	private Exchanger<AssemblySet> exchanger;
	private Random r = new Random();
	private AssemblySet set = null;

	public Assembler(Exchanger<AssemblySet> exchanger) {
		this.exchanger = exchanger;
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
				set = exchanger.exchange(set);
				if (null == set) {
					break;
				}
				assemble(set);
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}
