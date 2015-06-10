package mod09.ex02_kp;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Assembler implements Runnable {
	private Stock stock;
	private CountDownLatch assemblersLatch;
	private static Random r = new Random();

	public Assembler(Stock stock, CountDownLatch assemblersLatch) {
		this.stock = stock;
		this.assemblersLatch = assemblersLatch;
	}

	@Override
	public void run() {
		try {
			String assemberName = Thread.currentThread().getName();
			while (true) {
				AssemblySet set = stock.get();
				if (null == set) {
					return; // kończymy wątek
				}
				set.setAssembler(assemberName);
				try {
					Thread.sleep(r.nextInt(150));
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
				System.out.println(set);
			}
		} finally {
			assemblersLatch.countDown();
		}
	}
}