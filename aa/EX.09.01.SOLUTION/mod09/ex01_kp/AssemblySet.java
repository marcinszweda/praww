package mod09.ex01_kp;

public class AssemblySet {
	private ComponentA a;
	private ComponentB b;
	private ComponentC c;
	private int number;
	private String producer;
	private String assembler;

	public AssemblySet(ComponentA a, ComponentB b, ComponentC c, int number) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.number = number;
	}

	public ComponentA getA() {
		return a;
	}

	public ComponentB getB() {
		return b;
	}

	public ComponentC getC() {
		return c;
	}

	public void setAssembler(String assembler) {
		this.assembler = assembler;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	@Override
	public String toString() {
		return "set#" + number + "  P" + producer + " --> A" + assembler;
	}
}

class ComponentA{}

class ComponentB{}

class ComponentC{}

