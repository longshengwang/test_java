package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

public class TestRW_coding {
	
	static int numofints = 1000;
	public static void main(String[] args){
		testNio();
		testStream();
	}
	
	
	public static void testStream(){
		System.out.println("testStream:");
		long t1 = System.currentTimeMillis();
		try {
			FileOutputStream out1 = new FileOutputStream("tttt");
			BufferedOutputStream bout1 = new BufferedOutputStream(out1);
			for(int i = 1 ; i < numofints;  i++){
				bout1.write((i+"").getBytes());
				if(i%100 == 0){
					bout1.write('\n');
				}
			}
			bout1.flush();
			bout1.close();
		} catch (Exception e) {
			System.out.println("========");
			e.printStackTrace();
		}
		long t2 = System.currentTimeMillis();
		System.out.println("write time:"+ (t2-t1));
		BufferedInputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream("tttt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			FileOutputStream out = new FileOutputStream("zzzz");
			BufferedOutputStream bout = new BufferedOutputStream(out);
			int a ;
			while((a = in.read())!= -1){
				bout.write(a);
			}
			bout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		long t3 = System.currentTimeMillis();
		System.out.println("write time:"+ (t3-t2));
	}
	
	public static void testNio(){
		System.out.println("TestNio:");
		long t1 = System.currentTimeMillis();
		try {
			ByteBuffer bb = ByteBuffer.allocate(1024*1024);
			CharBuffer cb = bb.asCharBuffer();
//			StringBuffer sb = new StringBuffer();
			FileChannel fcout = new FileOutputStream("tttt1").getChannel();
			for(int i = 0;i<numofints;i++ ){
				try {
					cb.put((i+"").toCharArray());
				} catch (BufferOverflowException e) {
					bb.flip();
					fcout.write(bb);
					bb.clear();
					cb.put((i+"").toCharArray());
				}
//				sb = sb.append(i + "");
//				if(i %100 == 0){
//					sb = sb.append("\n");
//				}
//				fcout.write(ByteBuffer.wrap((1+"").getBytes()));
//				if(sb.length() > 1024*512){
//					fcout.write(ByteBuffer.wrap(sb.toString().getBytes()));
//					sb.setLength(0);
//				}
				
			}
			bb.flip();
			fcout.write(bb);
			bb.clear();
			fcout.close();
			
			long t2 = System.currentTimeMillis();
			System.out.println("write time:"+ (t2-t1));
//			FileChannel fcout1 = new FileOutputStream(new File("tttt1")).getChannel();
//			
//			FileChannel fcin = new FileInputStream("zzzz1").getChannel();
//			
//			ByteBuffer b = ByteBuffer.allocate(1024*1024);
//			while(fcin.read(b)!= -1 ){
//				b.flip();
//				fcout1.write(b);
//				b.clear();
//			}
//			long t3 = System.currentTimeMillis();
//			System.out.println("write time:"+ (t3-t2));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
