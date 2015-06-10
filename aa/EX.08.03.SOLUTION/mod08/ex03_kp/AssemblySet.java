package mod08.ex03_kp;

public class AssemblySet {
	private ComponentA a;
	private ComponentB b;
	private ComponentC c;
	private String partNo;

	public AssemblySet(ComponentA a, ComponentB b, ComponentC c, String partNo) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.partNo = partNo;
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

	@Override
	public String toString() {
		return partNo;
	}
}

class ComponentA {}

class ComponentB {}

class ComponentC {}