package mod08.ex05b;

import java.util.concurrent.Exchanger;

public class Players {

	public static void main(String[] args) {
		Exchanger<Integer> comparator = new Exchanger<Integer>();
		Player dice = new Player(comparator);
		new Thread(dice, "player1").start();
		new Thread(dice, "player2").start();
	}
}
