package io;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringBufferInputStream;



public class TestFile {
	public static void main(String[] args) throws IOException {
		System.out.println("hello word");
		
		PrintWriter pw = new PrintWriter(System.out,true);
		pw.println("aaa");
		
		PrintWriter pw1 = new PrintWriter("C:\\Users\\hcj\\Desktop\\aaa1.txt");
		pw1.println();
		pw1.close();
		
	}

}
