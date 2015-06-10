package mod10.ex02_cp;

public class Writer implements Runnable {
	private Library library;

	public Writer(Library library) {
		this.library = library;
	}

	@Override
	public void run() {
		while (true) {
			library.write();
		}
	}
}
