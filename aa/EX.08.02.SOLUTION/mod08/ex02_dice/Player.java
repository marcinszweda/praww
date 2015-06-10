package mod08.ex02_dice;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Player implements Runnable {
	private int id;
	private CyclicBarrier barrier;

	private static Random r = new Random();
	private int result = 0;

	public Player(int id, CyclicBarrier barrier) {
		this.id = id;
		this.barrier = barrier;
	}

	public int getResult() {
		return result;
	}

	public String stringResult() {
		StringBuilder s = new StringBuilder();
		s.append(id);
		int r = getResult();
		for (int i = 0; i < r; i++)
			s.append("*");
		s.append(" (").append(r).append(")");
		return s.toString();
	}

	@Override
	public String toString() {
		return "Player " + id;
	}

	@Override
	public void run() {
		try {
			while (!Thread.currentThread().isInterrupted()) {
				result += r.nextInt(6) + 1;
				barrier.await();
			}
		} catch (InterruptedException e) {
			return;
		} catch (BrokenBarrierException e) {
			return;
		} finally {
			System.out.println(this + " stopped");
		}
	}
}
