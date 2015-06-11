package mod12.ex02a;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoService implements Runnable {
	private final ExecutorService pool;
	private ServerSocket serverSocket;

	public EchoService(int port, int clients) {
		pool = Executors.newFixedThreadPool(clients);
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			while (true) {
				Socket socket = serverSocket.accept();
				pool.execute(new EchoHandler(socket));
			}
		} catch (IOException e) {
			System.out.println("I/O error while waiting for connection!");
		} finally {
			pool.shutdown();
		}
	}

	public static void main(String[] args) {
		new Thread(new EchoService(8189, 2)).start();
	}
}
