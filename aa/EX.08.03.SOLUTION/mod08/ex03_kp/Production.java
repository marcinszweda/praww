package mod08.ex03_kp;

import java.util.concurrent.Exchanger;

public class Production {

	public static void main(String[] args) {
		Exchanger<AssemblySet> exchanger = new Exchanger<AssemblySet>();
		new Thread(new Producer(exchanger)).start();
		new Thread(new Assembler(exchanger)).start();
	}
}
