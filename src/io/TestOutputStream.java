package io;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class TestOutputStream {
	public static void main(String[] args){
		
//		testByteArr();
		try {
			testFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void testByteArr(){
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			out.write("asgag".getBytes());
			out.write("����".getBytes());
			System.out.println(out.toString("gbk"));
			out.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void testFile() throws IOException{
		FileOutputStream fileOutputStream = new FileOutputStream("./src/demonfile/out");
//		fileOutputStream.write("��˧��".getBytes());
		
		PrintStream pt = new PrintStream(fileOutputStream);
		fileOutputStream.flush();
		pt.print("s�����¸�dfshd");
//		pt.
		pt.flush();
		fileOutputStream.close();
	}
	
	public static void testBuffer(){
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("./src/demonfile/out");
			BufferedOutputStream bo =new BufferedOutputStream(fileOutputStream);
			DataOutputStream dos = new DataOutputStream(bo);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
