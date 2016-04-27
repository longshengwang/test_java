package io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class TestBytebuffer {

	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer.allocate(4);
		System.out.println(bb.asCharBuffer().get(0));
		System.out.println(bb.asCharBuffer().get(1));
		CharBuffer cb = bb.asCharBuffer();
		try {
			cb.put("ab".toCharArray());
			cb.put("a".toCharArray());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		cb.rewind();
		System.out.println(cb.get());
		System.out.println(cb.get());
		
		System.out.println(bb.asCharBuffer().get());
		
		cb.clear();
		cb.rewind();
		System.out.println(cb.get());
		
		System.out.println(bb.asCharBuffer().get());
	}

}
