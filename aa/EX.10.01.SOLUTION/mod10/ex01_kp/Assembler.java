package mod10.ex01_kp;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Assembler implements Runnable {
	private Stock stock;
	private CountDownLatch assemblersLatch;
	private Random r = new Random();

	public Assembler(Stock stock, CountDownLatch assemblersLatch) {
		this.stock = stock;
		this.assemblersLatch = assemblersLatch;
	}

	@Override
	public void run() {
		try {
			while (true) {
				AssemblySet set = stock.get();
				if (null == set)
					return; // konczymy watek
				set.setAssembler(Thread.currentThread().getName());
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