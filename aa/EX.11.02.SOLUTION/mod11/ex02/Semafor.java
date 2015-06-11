package mod11.ex02;
// realizacja semafora za pomoca monitora

public class Semafor {
	private int permits;

	public Semafor(int permits) {
		this.permits = permits;
	}

	public synchronized void P() {
		while (0 == permits) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		permits--;
	}

	public synchronized void V() {
		notify();
		permits++;
	}
}
