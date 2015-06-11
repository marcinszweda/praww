package mod12.ex02b;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

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
		EchoService es = new EchoService(8189, 1);
		new Thread(es).start();
		final ThreadPoolExecutor tpe = (ThreadPoolExecutor) es.pool;
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("core=" + tpe.getCorePoolSize()
						+ " largest=" + tpe.getLargestPoolSize() 
						+ " max=" + tpe.getMaximumPoolSize() 
						+ " size=" + tpe.getPoolSize() 
						+ " task count=" + tpe.getTaskCount() 
						+ " completed=" + tpe.getCompletedTaskCount());
			}
		}, new Date(), 1000);
	}
}
