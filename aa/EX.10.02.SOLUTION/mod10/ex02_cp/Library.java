package mod10.ex02_cp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Library {
	// bez uczciwosci
	private final ReadWriteLock lock = new ReentrantReadWriteLock();
	// z uczciwoscia
    // private final ReadWriteLock lock = new ReentrantReadWriteLock(true);
	private final Lock readLock = lock.readLock();
	private final Lock writeLock = lock.writeLock();
	private static Random rnd = new Random();
	private List<String> list = new ArrayList<String>();

	public void read() {
		String readerName = Thread.currentThread().getName();
		readLock.lock();
		synchronized (this) {
			list.add(readerName);
			System.out.println(list);
		}
		try {
			Thread.sleep(rnd.nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			synchronized (this) {
				list.remove(readerName);
				System.out.println(list);
			}
			readLock.unlock();
		}
	}

	public void write() {
		String writerName = Thread.currentThread().getName();
		try {
			writeLock.lock();
			synchronized (this) {
				list.add(writerName);
				System.out.println(list);
			}
			try {
				Thread.sleep(rnd.nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} finally {
			synchronized (this) {
				list.remove(writerName);
				System.out.println(list);
			}
			writeLock.unlock();
		}
	}
}
