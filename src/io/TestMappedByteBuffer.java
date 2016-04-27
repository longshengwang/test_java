package io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import javax.sql.rowset.FilteredRowSet;

public class TestMappedByteBuffer {
	static int length = 0x8ffffff;

	public static void main(String[] args) {
		try {
			MappedByteBuffer map = new RandomAccessFile("test.txt", "rw").getChannel()
					.map(FileChannel.MapMode.READ_WRITE, 0, length);
			for (int i = 0; i < length; i++) {
				map.put((byte)'y');
			}
			for(int i = length/2; i < length/2 + 200 ;i++){
				System.out.print((char)map.get(i));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
