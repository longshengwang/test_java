package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class TestZip {

	public static void main(String[] args) throws IOException {
		String[] names = {"tttt","TTas.java"};
		FileOutputStream out = new FileOutputStream("test.zip");
		CheckedOutputStream cho = new CheckedOutputStream(out,  new Adler32());
		ZipOutputStream zout = new ZipOutputStream(cho);
		BufferedOutputStream bout = new BufferedOutputStream(zout);
		zout.setComment("This is my first zip");
		for(String name:names){
			System.out.println("write file:" + name);
			BufferedReader bin = new BufferedReader(new FileReader(name));
			zout.putNextEntry(new ZipEntry(name+"zip"));
			int c;
			while((c =  bin.read()) != -1){
				bout.write(c);
			}
			bin.close();
			bout.flush();
		}
		bout.close();
		
		
		
		FileInputStream in = new  FileInputStream("test.zip");
		CheckedInputStream ci = new CheckedInputStream(in,  new Adler32());
		ZipInputStream zi = new ZipInputStream(ci);
		BufferedInputStream bi = new BufferedInputStream(zi);
		ZipEntry ze;
		while((ze = zi.getNextEntry()) !=null){
			System.out.println("ReadFile:" + ze);
			int x;
			while((x = bi.read())!=-1){
				System.out.write(x);
			}
			System.out.println();
		}
		bi.close();
		
		System.out.println(">>>>>>>>>>>>ZipFile:" + ze);
		ZipFile zf = new ZipFile("test.zip");
		Enumeration e = zf.entries();
		while(e.hasMoreElements()){
			ZipEntry ze2 = (ZipEntry)e.nextElement();
			BufferedInputStream bi1 = new BufferedInputStream(zf.getInputStream(ze2));
			int x;
			while((x = bi1.read())!=-1){
				System.out.write(x);
			}
		}
		
	}

}
