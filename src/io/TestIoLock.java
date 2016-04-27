package io;

import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

public class TestIoLock {
	public static void main(String[] args){
//		MyThread my1 = new MyThread();
//		MyThread my2 = new MyThread();
//		my1.start();
//		my2.start();
		
		MyThread1 my1 = new MyThread1();
//		MyThread1 my2 = new MyThread1();
//		MyThread1 my3 = new MyThread1();
		my1.start();
//		my2.start();
		/*try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			System.out.println("asdgasgd");
			e.printStackTrace();
		}
		my3.start();*/
	}
	
}

class MyThread extends Thread {  
	public void run() {  
		try {
			long aa = System.nanoTime();
			System.out.println(aa);
			System.out.println("input");
			FileOutputStream out = new FileOutputStream("tmp_file/aa");
			
			out.write(("agasdg"+ aa).getBytes());
			TimeUnit.SECONDS.sleep(5);
			out.close();
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
	}
}  

class MyThread1 extends Thread {  
	public void run() {  
		try {
			long nano= System.nanoTime();
			System.out.println("Thread:"+ nano);
			FileOutputStream out = new FileOutputStream("tmp_file/aa");
			FileChannel fChannel = out.getChannel();
			FileLock lock = fChannel.tryLock(0L, Long.MAX_VALUE, false);
			if(lock != null){
				System.out.println("come in, I lock it ==="+ nano);
//				out.write("testasa".getBytes());
				TimeUnit.SECONDS.sleep(10);
				lock.release();
			} else {
				System.out.println("sorry , file is locked by others"+ nano);
			}
			out.close();
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
	}
}  
