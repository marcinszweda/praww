package mod08.ex02_dice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

public class Dice {

	public static void main(String[] args) {
		final int PLAYERS = 5;
		final int MAX_SCORE = 50;
		final List<Player> players = new ArrayList<Player>();
		final ThreadGroup tg = new ThreadGroup("playersGroup");

		CyclicBarrier barrier = new CyclicBarrier(PLAYERS, new Runnable() {
			@Override
			public void run() {
				boolean over = false;
				int max = MAX_SCORE;
				for (Player p : players) {
					System.out.println(p.stringResult());
					int result = p.getResult();
					if (result >= MAX_SCORE) {
						over = true;
						if (result > max) {
							max = result;
						}
					}
				}
				if (over) {
					for (Player p : players) {
						if (p.getResult() == max) {
							System.out.println(p + " won!\n");
						}
					}
					tg.interrupt();
					return;
				}
				System.out.println();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		for (int i = 0; i < PLAYERS; i++) {
			Player p = new Player(i, barrier);
			players.add(p);
			new Thread(tg, p).start();
		}
	}
}
