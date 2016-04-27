package testjava;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.LinkedList;  
  
public class TestIO {  
  
    public static void main(String[] args) throws IOException {  
        PrintStream console = System.out;  
        PrintStream fileout = new PrintStream("C://Users//hcj//Desktop//out1.txt");
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("C://Users//hcj//Desktop//aa.txt"));  
        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("C://Users//hcj//Desktop//out.txt")));  
          
          
        System.setIn(in);  
        System.setOut(out);  
        System.setErr(out);  
          
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        console.println("asdagsdg");
        String s;  
        while ((s = br.readLine()) != null) {  
            System.out.println(s);  
        }  
        out.close(); // Remember this!  
//        System.setOut(console);  
        fileout.println("asdgasdgasdgasdgasdgasdzxcbvasdgavag");
        fileout.close();
    }  
    
    
}  
