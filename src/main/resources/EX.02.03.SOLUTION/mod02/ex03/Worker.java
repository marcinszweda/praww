package mod02.ex03;

public class Worker implements Runnable {

	// wątek obserwowany
	@Override
	public void run() {
		// stan RUNNABLE
		// znaczace przetwarzanie
		for (int i = 0; i < 1000000; i++) {
			for (int j = 0; j < 300; j++) {
			}
		}
		
		// uśpienie wątku
		try {
			Thread.sleep(500);
			// stan TIMED_WAITING
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// stan RUNNABLE
		// znaczace przetwarzanie
		for (int i = 0; i < 1000000; i++) {
			for (int j = 0; j < 300; j++) {
			}
		}
	} // stan TERMINATED
}
