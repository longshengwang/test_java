package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestChannelEncode {
	public static void main(String[] args){
		try {
			char[] caa = "aaa".toCharArray();
			byte[] bba = "aaa".getBytes();
			for(char in : caa){
				System.out.println((byte)(in));
			}
			for(byte in : bba){
				System.out.println(in);
			}
			
			
			char[] caa1 = "我的".toCharArray();
			byte[] bba1 = "我的".getBytes("gbk");
			for(char in : caa1){
				System.out.println(in);
			}
			for(byte in : bba1){
				System.out.println(in);
			}
			
			System.out.println();
			System.out.println("aaa".getBytes().length);
			FileChannel in = new FileInputStream("src/demonfile/tt").getChannel();
			FileChannel out = new FileOutputStream("src/demonfile/tt1").getChannel();
			
			ByteBuffer bb = ByteBuffer.allocate(10);
			out.write(ByteBuffer.wrap("aaa".getBytes()));
			
			while(in.read(bb) != -1){
				bb.flip();
				for(int i = 0;i < 10; i++){
					System.out.print((char)bb.get(i));
				}
				out.write(bb);
				
				bb.clear();
			}
			System.out.println();
			ByteBuffer bb1= ByteBuffer.allocate(10);
			bb1.asCharBuffer().put('暗').put('我').put('他').put('e');
			for(int i = 0;i < 5; i++){
				System.out.print(bb1.asCharBuffer().get(i));
			}
			out.write(bb1);
			System.out.println();
			/*
			 * 中间会有空格，因为char有2个字节，其中第一个一般都是0，第二个才是字节
			 * 所以直接用charbuffer put的时候 存的应该是‘00000000a(2jinzhi)’
			 */
			ByteBuffer bb2= ByteBuffer.allocate(10);
			bb2.asCharBuffer().put('a').put('b').put('c').put('e');
			for(int i = 0;i < 5; i++){
				System.out.print(bb2.asCharBuffer().get(i));
			}
			out.write(bb2);
			System.out.println();
			
			/*
			 * 以下两种方式可以把字符正确写入文件，写文件时不要用charbuffer等其他buffer
			 * 只能用bytebuffer
			 */
			ByteBuffer bb3= ByteBuffer.allocate(10);
			bb3.put("afcedasdg".getBytes());
			for(int i = 0;i < 10; i++){
				System.out.print((char)bb3.get(i));
			}
			bb3.flip();
			out.write(bb3);
			
			System.out.println();
			ByteBuffer bb4= ByteBuffer.allocate(10);
			bb4.put("我的asgasg".getBytes());
			for(int i = 0;i < 10; i++){
				System.out.print((char)bb4.get(i));
			}
			bb4.flip();
			out.write(bb4);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
