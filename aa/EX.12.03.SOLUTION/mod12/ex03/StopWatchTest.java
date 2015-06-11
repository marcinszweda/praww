package mod12.ex03;

import static java.util.Calendar.*;
import java.util.Calendar;

public class StopWatchTest {

	public static void main(String[] args) {
		Calendar start = getInstance();
		start.add(MINUTE, 1);
		start.set(SECOND, 0);
		StopWatch sw = new StopWatch();
		sw.setStopWatch(start, 20, 2);
	}
}
