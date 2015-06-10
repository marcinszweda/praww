package mod09.ex01_kp;

import java.util.Random;

public class Producer implements Runnable {
	private Stock stock;
	private Random r = new Random();

	public Producer(Stock stock) {
		this.stock = stock;
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
		}
	}
}