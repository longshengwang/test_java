package io;
//import 

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.StringBufferInputStream;

import org.w3c.dom.css.ElementCSSInlineStyle;

public class TestByteInputStream{
	public static void main(String[] args){
		TestByteInputStream t = new TestByteInputStream();
		t.testByteInputStream();
//		t.testFileIS(false);
//		t.testFileIS(true);
	}
	
	public void testStringIS(){
		StringBuffer sb = new StringBuffer();
		for(int i = 0;i < 1000000; i++){
			sb.append(String.valueOf(i));
		}
		String testS = sb.toString();
		StringBufferInputStream sis = new StringBufferInputStream(testS);
		
	}
	public void testFileIS(boolean isUseBuffer){
		long t1 = System.currentTimeMillis();
		DataInputStream di = null ;
		try {
			File f = new File("./src/demonfile/192.168.117.20_2016-04-12_14-14-00.log");
			System.out.println(f.getAbsolutePath());
			FileInputStream fis = new FileInputStream(f);
			if(isUseBuffer)
				di = new DataInputStream(new BufferedInputStream(fis));
			else
				di = new DataInputStream(fis);
			
			while(di.available() != 0)
//				System.out.print((char)di.readByte());
				di.readByte();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				if(di != null){
					di.close();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		long t2 = System.currentTimeMillis();
		System.out.println(t2-t1);
		
		
		
	}
	
	public void testByteInputStream(){
		StringBuffer sb = new StringBuffer();
		for(int i = 0;i < 10; i++){
			sb.append(String.valueOf(i));
		}
		String testS = sb.toString();
		
		long t1 = System.currentTimeMillis();
		ByteArrayInputStream bis = new ByteArrayInputStream(testS.getBytes());
		
//		BufferedInputStream buffer = new BufferedInputStream(bis);
		DataInputStream di = new DataInputStream(bis);
//		StringBuffer sbtest = new StringBuffer();
		try {
			while(true)
				System.out.println((char)di.readByte());
//				di.readByte();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		System.out.println(sbtest.toString());
		long t2 = System.currentTimeMillis();
		System.out.println(t2-t1);
	}

}
