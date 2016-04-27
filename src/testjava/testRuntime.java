package testjava;

public class testRuntime {
	public static void main(String[] args) {
		testRuntime t = new testRuntime();
		t.testMemory();
	}
	
	public void testMemory(){
		System.out.println(Runtime.getRuntime().totalMemory());
	}
}
