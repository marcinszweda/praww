package mod08.ex04_kp;

import java.util.concurrent.SynchronousQueue;

public class Production {

	public static void main(String[] args) {
		SynchronousQueue<AssemblySet> queue = new SynchronousQueue<AssemblySet>();
		new Thread(new Producer(queue)).start();
		new Thread(new Assembler(queue)).start();
	}
}