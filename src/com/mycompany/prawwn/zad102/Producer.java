package mod10.ex01_kp;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Producer implements Runnable {
	private Stock stock;
	private CountDownLatch producersLatch;
	private Random r = new Random();

	public Producer(Stock stock, CountDownLatch producersLatch) {
		this.stock = stock;
		this.producersLatch = producersLatch;
	}

	@Override
	public void run() {
		try {
			String producerName = Thread.currentThread().getName();
			for (int i = 0; i < 10; i++) {
				AssemblySet set = new AssemblySet(new ComponentA(),
						new ComponentB(), new ComponentC(), i);
				set.setProducer(producerName);
				Thread.sleep(r.nextInt(100));
				stock.store(set);
			}
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		} finally {
			producersLatch.countDown();
		}
	}
}