package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

public class TestNioPerformance {
	private static int numofints = 0x8FFFFFF;
	private static int numofbuffint = 0x8FFFF;
	private abstract static class Tester {
		private String name;

		public Tester(String name) {
			this.name = name;
		}

		public abstract void test() throws IOException;

		public void runTest() {
			System.out.println(name + ":");
			try {
				long start = System.nanoTime();
				test();
				long end = System.nanoTime();
				long du = end - start;
				System.out.format("%.2f\n", du / 1.0e9);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	private static Tester[] tests = { new Tester("Stream write") {
		public void test() throws IOException {
			DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("tmp.tmp")));
			for(int i = 0; i < numofints;i++){
				out.writeInt(i);
			}
			out.close();
		}

	},new Tester("Mapped write") {
		public void test() throws IOException {
			FileChannel fc = new RandomAccessFile("tmp1.tmp","rw").getChannel();
			IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
			for(int i = 0; i < numofints; i ++){
				ib.put(i);
			}
			fc.close();
		}

	}, new Tester("Stream Read") {
		public void test() throws IOException {
			DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream("tmp.tmp")));
			for(int i = 0; i < numofints;i++){
				dis.readInt();
			}
			dis.close();
		}

	}, new Tester("Mapped Read") {
		public void test() throws IOException {
			FileChannel fc = new FileInputStream("tmp1.tmp").getChannel();
			IntBuffer ib = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size()).asIntBuffer();
			while(ib.hasRemaining())
				ib.get();
			fc.close();
		}

	}, /*new Tester("Mapped Read11") {
		public void test() throws IOException {
			FileChannel fc = new FileInputStream("tmp.tmp").getChannel();
			IntBuffer ib = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size()).asIntBuffer();
			for(int i = 0; i < fc.size()/4; i++)
				ib.get(i);
//			while(ib.hasRemaining())
//				ib.get();
			fc.close();
		}

	},*/ new Tester("Stream Read/Write") {
		public void test() throws IOException {
			RandomAccessFile ra = new RandomAccessFile("tmp1.tmp","rw");
			for(int i =0 ; i < numofbuffint;i++){
				int tmp = ra.readInt();
				ra.seek(i * 4);
				ra.writeInt(tmp);
			}
			ra.close();
		}

	}, new Tester("Mapped Read/Write") {
		public void test() throws IOException {
			FileChannel fc = new FileInputStream("tmp1.tmp").getChannel();
			IntBuffer ib = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size()).asIntBuffer();
			while(ib.hasRemaining())
				ib.get();
			fc.close();
		}

	}

	};
	public static void main(String[] args){
		for(Tester t : tests)
			t.runTest();
	}
}
