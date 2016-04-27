package io;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class TestGzip {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader("tttt"));
		BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("tt.gz")));

		int c;
		while ((c = reader.read()) != -1) {
			out.write(c);
		}
		reader.close();
		out.close();
		System.out.println("GZIP file finished");

		BufferedReader in = new BufferedReader(
				new InputStreamReader(new GZIPInputStream(new FileInputStream("tt.gz"))));
		String ss ;
		while((ss =in.readLine()) != null){
			System.out.println(ss);
		}
	}

}
