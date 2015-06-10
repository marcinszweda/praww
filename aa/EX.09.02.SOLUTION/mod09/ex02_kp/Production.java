package mod09.ex02_kp;

import java.util.concurrent.CountDownLatch;

public class Production {

	public static void main(String[] args) {
		final int PRODUCERS = 5;
		final int ASSEMBLERS = 2;
		CountDownLatch producersLatch = new CountDownLatch(PRODUCERS);
		CountDownLatch assemblersLatch = new CountDownLatch(ASSEMBLERS);
		Stock stock = new Stock();

		for (int i = 1; i <= PRODUCERS; i++) {
			new Thread(new Producer(stock, producersLatch), "" + i).start();
		}

		for (int i = 1; i <= ASSEMBLERS; i++) {
			new Thread(new Assembler(stock, assemblersLatch), "" + i).start();
		}

		try {
			// czekamy na zakonczenie watkow producentow
			producersLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		stock.setNoProducers();

		try {
			// czekamy na zakonczenie watkow montazystow
			assemblersLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		stock.left();
	}
}