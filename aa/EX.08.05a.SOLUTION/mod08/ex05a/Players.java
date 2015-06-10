package mod08.ex05a;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Players {

	public static void main(String[] args) {
		PipedInputStream in1 = new PipedInputStream();
		PipedInputStream in2 = new PipedInputStream();
		PipedOutputStream out1 = null;
		PipedOutputStream out2 = null;
		try {
			out1 = new PipedOutputStream(in2);
			out2 = new PipedOutputStream(in1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Player player1 = new Player(in1, out1);
		Player player2 = new Player(in2, out2);
		new Thread(player1, "player1").start();
		new Thread(player2, "player2").start();
	}
}
