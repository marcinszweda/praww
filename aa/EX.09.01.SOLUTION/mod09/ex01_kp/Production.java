package mod09.ex01_kp;

public class Production {

	public static void main(String[] args) {
		final int PRODUCERS = 2;
		final int ASSEMBLERS = 5;
		Stock stock = new Stock();

		for (int i = 1; i <= PRODUCERS; i++) {
			new Thread(new Producer(stock), "" + i).start();
		}

		for (int i = 1; i <= ASSEMBLERS; i++) {
			new Thread(new Assembler(stock), "" + i).start();
		}
	}
}