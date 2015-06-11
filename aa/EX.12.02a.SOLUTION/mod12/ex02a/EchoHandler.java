package mod12.ex02a;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoHandler implements Runnable {
	private Socket socket;

	public EchoHandler(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		try {
			InputStream inStream = socket.getInputStream();
			OutputStream outStream = socket.getOutputStream();
			Scanner in = new Scanner(inStream);
			PrintWriter out = new PrintWriter(outStream, true);
			out.println("Hello! Enter empty line to end conversation.");
			String line = in.nextLine();
			while (!line.trim().equals("")) {
				out.println(line.toUpperCase() + " --> reply for client "
						+ Thread.currentThread().getName());
				line = in.nextLine();
			}
		} catch (IOException e) {
			System.out.println("Server threw IOException!");
		} finally {
			if (socket != null)
				try {
					socket.close();
				} catch (IOException e) {
					System.out.println("Socket cannot be closed!");
				}
		}
	}
}
