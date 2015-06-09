package mod02.ex03;

public class StateObservation {

	public static void main(String[] args) {
		Thread observed = new Thread(new Worker()); // stan NEW
		Thread observer = new Thread(new Observer(observed));
		observer.setDaemon(true);
		observer.start();
		try {
			Thread.sleep(200);
			observed.start(); // stan RUNNABLE
			while (observed.isAlive()) {
				// aktywna petla
			}
			Thread.sleep(200);
		} catch (InterruptedException e) {
			System.out.println("Wystapil wyjatek " + e.getClass().getName());
			return;
		}
	}

}
