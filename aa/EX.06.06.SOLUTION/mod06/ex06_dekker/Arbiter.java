package mod06.ex06_dekker;

public class Arbiter {

	public final static int MALY = 1;
	public final static int DUZY = 2;
	volatile public static int czyjaKolej = MALY;

}
