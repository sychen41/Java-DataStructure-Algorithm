package default1;
public class BTest {
	private ATest at;
	public BTest(int n) {
		//at = new ATest(n);
		at = new ATest();
		//at.a = n;
	}
	public ATest getValue() {
		return this.at;
	}
	public static void main(String[] args) {
		BTest bt = new BTest(101);
		System.out.println(bt.getValue().getValue());
	}
}
