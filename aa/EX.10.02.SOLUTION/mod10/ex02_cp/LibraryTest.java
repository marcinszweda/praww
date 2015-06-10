package mod10.ex02_cp;

public class LibraryTest {

	public static void main(String[] args) {
		Library library = new Library();
		final int READERS = 5;
		final int WRITERS = 2;

		for (int i = 1; i <= READERS; i++) {
			new Thread(new Reader(library), "R" + i).start();
		}
		for (int i = 1; i <= WRITERS; i++) {
			new Thread(new Writer(library), "W" + i).start();
		}
	}

}
