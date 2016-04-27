package testjava;

import java.util.Properties;
import java.util.Set;

import javax.lang.model.element.VariableElement;

public class TestSystem {
	public static void main(String[]  args){
		System.out.println(System.getenv());

		Properties ps = System.getProperties();
		Set<Object> keys = ps.keySet();
		for(Object key : keys){
			String key_s = (String)key;
			System.out.println(key_s + "="+ps.getProperty(key_s));
		}
		
	}
}
