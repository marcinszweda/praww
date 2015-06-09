package mod02.ex03;

public class Observer implements Runnable {
	private Thread observed;

	public Observer(Thread observed) {
		this.observed = observed;
	}

	@Override
	public void run() {
		while (true) {
			System.out.println("watek obserwowany jest w stanie "
					+ observed.getState());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}