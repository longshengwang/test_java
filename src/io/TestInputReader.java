package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TestInputReader {
	public static void main(String[] args){
		testFileReader();
		try {
			Process p = new ProcessBuilder("".split("")).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void testFileReader(){
		BufferedReader br = null;
		try {
			FileReader fr = new FileReader(new File("./src/demonfile/192.168.117.20_2016-04-12_14-14-00.log"));
			br = new BufferedReader(fr);
			String t = null;
			while((t = br.readLine()) != null){
				System.out.println(t);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
