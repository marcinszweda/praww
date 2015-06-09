package mod07.ex04_ogolny;

import java.util.concurrent.Semaphore;

// symulacja semafora ogólnego za pomocą semaforów binarnych

public class SemaforOgolny {

	private int permits; // liczba przepustek
	// semafor chroniacy wspolbiezne modyfikacje liczby zezwolen
	private final Semaphore update = new Semaphore(1);
	// semafor decydujacy o przepuszczeniu/wstrzymaniu
	private final Semaphore gate = new Semaphore(1);

	public SemaforOgolny(int permits) {
		this.permits = permits;
	}

	public void P() {
		gate.acquireUninterruptibly();
		update.acquireUninterruptibly();
		permits--;
		if (permits > 0)
			gate.release();
		update.release();
	}

	public void V() {
		update.acquireUninterruptibly();
		permits++;
		if (1 == permits)
			gate.release();
		update.release();
	}

	public int availablePermits() {
		update.acquireUninterruptibly();
		int p = permits;
		update.release();
		return p;
	}
}
