package io;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class TestNio {

	public static void main(String[] args) throws IOException{
//		testChar();
		testByteBufferChange();
//		FileInputStream fileOutputStream = new FileInputStream("./src/demonfile/192.168.117.20_2016-04-12_14-14-00.log");
//		FileChannel fc = fileOutputStream.getChannel();
//		ByteBuffer bb = ByteBuffer.allocate(1024);
//		while(fc.read(bb) != -1){
//			bb.flip();
//			while(bb.hasRemaining())
//				System.out.print((char)bb.get());
//			bb.clear();
//		}
		
	}
	
	
	public static void testChar() throws IOException{
//		String a = "asµÄ°¢¸Ê".getBytes();
		System.out.println("asµÄ°¢¸Ê".getBytes().length);
		
		FileChannel fc = new FileOutputStream("./src/demonfile/out").getChannel();
		fc.write(ByteBuffer.wrap("adgawsg".getBytes()));
		fc.close();
		
		fc = new FileInputStream("./src/demonfile/out").getChannel();
		ByteBuffer bb = ByteBuffer.allocate(1024);
		fc.read(bb);
		
		bb.flip();
		System.out.println(bb.asCharBuffer());
		
		bb.rewind();
		System.out.println(Charset.forName("UTF-8").decode(bb));
		
		bb.rewind();
//		System.out.println(System.getProperty("file.encoding"));
		System.out.println(Charset.forName("GBK").decode(bb));
		
		FileChannel fc1 = new FileOutputStream("./src/demonfile/out").getChannel();
		ByteBuffer bb1 = ByteBuffer.allocate(10);
		bb1.asCharBuffer().put("a1236");
		fc1.write(bb1);
		fc1.close();
		
		fc1 = new FileInputStream("./src/demonfile/out").getChannel();
		bb1.clear();
		fc1.read(bb1);
		bb1.flip();
		byte[] tt = bb1.array();
		System.out.println(tt.length);
		for(byte t : tt){
			System.out.print(t);
		}
		System.out.println();
//		char c;
		//Charset.forName("UTF-8").decode(bb)
		/*while( (c=bb1.getChar()) != 0){
			System.out.print(c);
		}*/
//		System.out.println(Charset.forName("UTF-8").decode(bb));
		
		char a = 'a';
		System.out.println((a));
		
		
//		char[]  a1 = {'a','b'};
//		CharBuffer 
		byte a1[] = {0,89};
//		char a = {0,11};
		
		ByteBuffer ooi = ByteBuffer.allocate(a1.length);
		ooi.clear();
		ooi.put(a1);
//		CharBuffer cb = ;
//		ooi.flip();
		System.out.println(ooi.asCharBuffer());
		
		String a11 = "woshi yige haoren ";
		ByteBuffer bbb = ByteBuffer.allocate(a11.length()*2);
		bbb.clear();
		bbb.asCharBuffer().put(a11);
//		bbb.flip();
//		System.out.println();
		byte[] bs = bbb.array();
		for(byte bbbbb: bs){
			System.out.print(bbbbb);
		}
		
	}
	
	
	public static void testByteBufferChange(){
		long t = System.nanoTime();
		char[] aaa = "woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1woshiyigehaoren1".toCharArray();
		ByteBuffer bb = ByteBuffer.allocate(aaa.length*2);
		CharBuffer cb = bb.asCharBuffer();
		cb.put(aaa);
		cb.rewind();
		while(cb.hasRemaining()){
			cb.mark();
			char c1 = cb.get();
			char c2 = cb.get();
			cb.reset();
			cb.put(c2).put(c1);
		}
		cb.rewind();
		while(cb.hasRemaining()){
			System.out.print(cb.get());
		}
		System.out.println();
		System.out.format("%.2f",(System.nanoTime() - t)/10e9);
		
		
		
	}
}
