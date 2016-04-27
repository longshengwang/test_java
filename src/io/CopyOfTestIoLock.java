package io;

import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

public class CopyOfTestIoLock {
	public static void main(String[] args){
//		MyThread my1 = new MyThread();
//		MyThread my2 = new MyThread();
//		my1.start();
//		my2.start();
		
		MyThread2 my1 = new MyThread2();
		my1.start();
	}
	
}


class MyThread2 extends Thread {  
	public void run() {  
		try {
			long nano= System.nanoTime();
			System.out.println("Thread:"+ nano);
			FileOutputStream out = new FileOutputStream("tmp_file/aa");
			FileChannel fChannel = out.getChannel();
			FileLock lock = fChannel.lock(0L, Long.MAX_VALUE, false);
			if(lock != null){
				System.out.println("come in, I lock it ==="+ nano);
//				out.write("testasa".getBytes());
				TimeUnit.SECONDS.sleep(5);
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
