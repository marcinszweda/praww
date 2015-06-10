package mod09.ex01_kp;

import java.util.Random;

public class Assembler implements Runnable {
	private Stock stock;
	private Random r = new Random();

	public Assembler(Stock stock) {
		this.stock = stock;
	}

	@Override
	public void run() {
		String assemblerName = Thread.currentThread().getName();
		while (true) {
			AssemblySet set = stock.get();
			set.setAssembler(assemblerName);
			try {
				Thread.sleep(r.nextInt(150));
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			System.out.println(set);
		}
	}
}