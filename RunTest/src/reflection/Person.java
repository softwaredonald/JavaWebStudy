package reflection;

import java.io.InputStream;
import java.util.List;

/**
 * 
 * @author Xu Feng
 * 这个是用来写constructor
 */
public class Person {
	
	public String name = "aaa";
	private int password = 123;
	private static int age = 321;
	
	
	public Person(){
		System.out.println("Person");
	}
	public Person(String name){
		System.out.println("Person name");
		System.out.println(name);
	}
	public Person(String name, int password){
		System.out.println("Person name password");
		System.out.println(name + password);
	}
	private Person(List list){
		System.out.println(list);
	}
	
	/**
	 * 方法的反射
	 * 一般情况下，构造函数下的方法有下面这些类型
	 */
	public void a(){
		System.out.println("a");
	}
	public void b(String name, int num){
		System.out.println(name+"+"+num);
	}
	public Class[] c(String name, int[] num){
		return new Class[] {String.class};
	}
	private void d (InputStream in){
		System.out.println(in);
	}
	public static void e (int num){
		System.out.println(num);
	}
	public static void main (String[] args){
		System.out.println("Main !");
		System.out.println(args);
	}
	
}
