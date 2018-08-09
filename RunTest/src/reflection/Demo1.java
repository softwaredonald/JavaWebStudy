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
//������Ĺ��캯����������Ķ���
public class Demo1 {
	
	
	//���乹�캯���� public person()
	@Test
	public void test1() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Class clazz = Class.forName("reflection.Person");
		Constructor c = clazz.getConstructor(null);
		Person p = (Person) c.newInstance(null);
		System.out.println(p.name);
	}
	
	//���乹�캯���� public person(String name)
	@Test
	public void test2() throws Exception{
		Class clazz = Class.forName("reflection.Person");
		Constructor c = clazz.getConstructor(String.class);
		Person p = (Person) c.newInstance("xxxx");
		System.out.println("aaaa");
	}
	
	//���乹�캯���� public person(String name)
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
		c.setAccessible(true);//�������� private ��ֻ���ڷ�����
		Person p = (Person) c.newInstance(new ArrayList());
		System.out.println("aaaa");
	}
	@Test
	
	//�������������������Ҫ�и��޲εĺ��� ��test1��Ч
	public void test5() throws Exception{
		Class clazz = Class.forName("reflection.Person");
		Person p = (Person)clazz.newInstance();
		System.out.println(p);
	}
}
