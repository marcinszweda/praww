package mod11.ex03;

import java.util.Random;

public class Filozof implements Runnable {
	private int i; 			// nr filozofa
	private int obzarstwo;	// ile razy filozof jadł
	private Random r = new Random();

	public Filozof(int i) {
		this.i = i;
	}

	@Override
	public String toString() {
		return "Filozof " + i;
	}

	private void mysli() throws InterruptedException {
		System.out.println(this + " myśli");
		Thread.sleep(30);
	}

	private void je() throws InterruptedException {
		System.out.println(this + " je");
		Thread.sleep(r.nextInt(1000));
		System.out.println(this + " skonczył jeść po raz " + ++obzarstwo);
	}

	@Override
	public void run() {
		while (true) {
			try {
				mysli();
				Widelce.bierze(i);
				je();
				Widelce.odklada(i);
			} catch (InterruptedException e) {
				System.out.println("Wystąpił wyjątek " + e.getClass().getName());
				return;
			}
		}
	}
}
