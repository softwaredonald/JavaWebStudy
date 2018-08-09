package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 
 * @author xufen
 *
 */
//反射类的构造函数，创建类的对象
public class Demo1 {
	
	
	//反射构造函数： public person()
	@Test
	public void test1() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Class clazz = Class.forName("reflection.Person");
		Constructor c = clazz.getConstructor(null);
		Person p = (Person) c.newInstance(null);
		System.out.println(p.name);
	}
	
	//反射构造函数： public person(String name)
	@Test
	public void test2() throws Exception{
		Class clazz = Class.forName("reflection.Person");
		Constructor c = clazz.getConstructor(String.class);
		Person p = (Person) c.newInstance("xxxx");
		System.out.println("aaaa");
	}
	
	//反射构造函数： public person(String name)
	@Test
	public void test3() throws Exception{
		Class clazz = Class.forName("reflection.Person");
		Constructor c = clazz.getConstructor(String.class, int.class);
		Person p = (Person) c.newInstance("abcd", 1234);
		System.out.println("aaaa");
	}
	
	//private Person(List list)
	@Test
	public void test4() throws Exception{
		Class clazz = Class.forName("reflection.Person");
		Constructor c = clazz.getDeclaredConstructor(List.class);
		c.setAccessible(true);//暴力反射 private 的只能在反射中
		Person p = (Person) c.newInstance(new ArrayList());
		System.out.println("aaaa");
	}
	@Test
	
	//如果想让她工作，必须要有个无参的函数 与test1等效
	public void test5() throws Exception{
		Class clazz = Class.forName("reflection.Person");
		Person p = (Person)clazz.newInstance();
		System.out.println(p);
	}
}
