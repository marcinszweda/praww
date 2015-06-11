package mod12.ex03;

import static java.util.Calendar.*;
import static java.util.concurrent.Executors.*;
import java.util.Calendar;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class StopWatch {
	private long stopTimeInMs;
	private final ScheduledExecutorService scheduler = newScheduledThreadPool(1);

	private long timeLeftInS() {
		return Math.round((stopTimeInMs - System.currentTimeMillis()) / 1000f);
	}

	public void setStopWatch(Calendar startTime, int workTimeInS, int periodInS) {
		long startTimeInMs = startTime.getTimeInMillis();
		System.out.printf("Start at: %02d:%02d:%02d%n", startTime.get(HOUR),
				startTime.get(MINUTE), startTime.get(SECOND));
		System.out.println("Work time: " + workTimeInS + " s");
		System.out.println("You will be informed every: " + periodInS + " s\n");
		long workTimeInMs = workTimeInS * 1000;
		long periodInMs = periodInS * 1000;
		long delayInMs = startTimeInMs - System.currentTimeMillis();
		stopTimeInMs = workTimeInMs + startTimeInMs;
		
		// jednorazowe zadanie wypisujace komunikat startu
		scheduler.schedule(new Runnable() {
			public void run() {
				System.out.println("Go...");
			}
		}, delayInMs, TimeUnit.MILLISECONDS);

		// zadanie cykliczne podajace czas do zakonczenia odliczania
		scheduler.scheduleAtFixedRate(new Runnable() {
			public void run() {
				System.out.printf("Time left: %2d s%n", timeLeftInS());
			}
		}, delayInMs, periodInMs, TimeUnit.MILLISECONDS);

		// jednorazowe zadanie informujace o uplynieciu czasu
		scheduler.schedule(new Runnable() {
			public void run() {
				scheduler.shutdown();
				System.out.println("Time is over...");
			}
		}, delayInMs + workTimeInMs, TimeUnit.MILLISECONDS);
	}
}
