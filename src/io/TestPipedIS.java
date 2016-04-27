package io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class TestPipedIS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Sender t1 = new Sender();

		Receiver t2 = new Receiver();

		PipedOutputStream out = t1.getOutputStream();

		PipedInputStream in = t2.getInputStream();

		try {
			// 管道链接
			out.connect(in);

			/**
			 * Thread类的START方法： 使该线程开始执行；Java 虚拟机调用该线程的 run 方法。
			 * 结果是两个线程并发地运行；当前线程（从调用返回给 start 方法）和另一个线程（执行其 run 方法）。
			 * 多次启动一个线程是非法的。特别是当线程已经结束执行后，不能再重新启动。
			 */
			t1.start();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			byte[] buf = new byte[1024];
			try {
				int len = in.read(buf);
				System.out.println(new String(buf, 0, len));
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
//			t2.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

class Sender extends Thread {

	/*
	 * PipedOutputStream类： 可以将管道输出流连接到管道输入流来创建通信管道。管道输出流是管道的发送端。 通常，数据由某个线程写入
	 * PipedOutputStream 对象， 并由其他线程从连接的 PipedInputStream 读取。
	 * 不建议对这两个对象尝试使用单个线程，因为这样可能会造成该线程死锁。 如果某个线程正从连接的管道输入流中读取数据字节，
	 * 但该线程不再处于活动状态，则该管道被视为处于 毁坏 状态。
	 */
	private PipedOutputStream out = new PipedOutputStream();

	public PipedOutputStream getOutputStream() {
		return out;
	}

	/**
	 * 因为这里继承了Thread类！所以必须从写run方法 如果该线程是使用独立的 Runnable 运行对象构造的， 则调用该 Runnable
	 * 对象的 run 方法；否则，该方法不执行任何操作并返回。
	 * 
	 */
	public void run() {
		String strInfo = "hello my Hzw";
		try {
			out.write(strInfo.getBytes());
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class Receiver extends Thread {

	/*
	 * PipedInputStream类: 管道输入流应该连接到管道输出流；管道输入流提供要写入管道输出流的所有数据字节。 通常，数据由某个线程从
	 * PipedInputStream 对象读取， 并由其他线程将其写入到相应的 PipedOutputStream。
	 * 不建议对这两个对象尝试使用单个线程，因为这样可能死锁线程。 管道输入流包含一个缓冲区，可在缓冲区限定的范围内将读操作和写操作分离开。
	 * 如果向连接管道输出流提供数据字节的线程不再存在，则认为该管道已损坏。
	 */
	private PipedInputStream in = new PipedInputStream();

	/*
	 * 获得实例方法
	 */
	public PipedInputStream getInputStream() {
		return in;
	}

	public void run() {
		byte[] buf = new byte[1024];
		try {
			int len = in.read(buf);
			System.out.println(new String(buf, 0, len));
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
