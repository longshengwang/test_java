package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class TestDir {
	public static void main(String[] args){
		File f = new File(".");
		System.out.println(f.getAbsoluteFile());
		String[] list;
		if(args.length == 0){
			list=f.list();
		} else {
			list = f.list(new DirFilter(args[0]));
		}
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for(String file :list){
			System.out.println(file);
		}
	}
	
	
	
}

class DirFilter implements FilenameFilter{
	private Pattern pattern;
	public DirFilter(String regex) {
		pattern = Pattern.compile(regex);
	}

	@Override
	public boolean accept(File dir, String name) {
		return pattern.matcher(name).matches();
	}
	
}