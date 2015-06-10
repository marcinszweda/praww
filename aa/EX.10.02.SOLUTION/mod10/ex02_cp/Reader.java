package mod10.ex02_cp;

public class Reader implements Runnable {
	private Library library;

	public Reader(Library library) {
		this.library = library;
	}

	@Override
	public void run() {
		while (true) {
			library.read();
		}
	}
}
