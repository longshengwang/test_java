package testjava;
import java.lang.ProcessBuilder;
public class Test {
	public static void main(String[] args){
		ProcessBuilder pb = new ProcessBuilder();
		myT m = new myT();
		m.start();
		myT m1 = new myT();
		m1.start();
		myT m2 = new myT();
		m2.start();
	}
}

class myT extends Thread{

	@Override
	public void run() {
		while(true){
			int a = 1;
		}
	}
	
}
