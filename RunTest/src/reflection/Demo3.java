package reflection;

import java.lang.reflect.Field;

import org.junit.Test;

/**
 * 
 * @author xufen
 *
 * 反射字段
 */
public class Demo3 {
	
	@Test
	//反射字段 public String name = "aaa";
	public void test1() throws Exception{
		Person p = new Person();
		Class clazz = Class.forName("reflection.Person");
		Field f = clazz.getField("name");
		String name = (String) f.get(p);
	}
	
	//如果不知道是什么类型，应该这样写 public String name = "aaa";
	@Test
	public void test2() throws Exception{
		Person p = new Person();
		Class clazz = Class.forName("reflection.Person");
		Field f = clazz.getField("name");
		//获取字段的值
		Object obj = f.get(p);
		//获取字段类型
		Class type=f.getType();
		if (type.equals(String.class)){
			String svalue = (String) obj;
			System.out.println(svalue);
		}
		/**
		 * 设置字段值
		 */
		f.set(p,"xxxxxxxx");
		System.out.println(p.name);
	}
	
	//private int password = 123;
	@Test
	public void test3() throws Exception{
		Person p = new Person();
		Class clazz = Class.forName("reflection.Person");
		Field f = clazz.getDeclaredField("password");
		f.setAccessible(true);
		System.out.println(f.get(p));
			
//		Object obj = f.get(p);
//		Class type = f.getType();
//		if (type.equals(int.class)){
//			int ivalue = (int) obj;
//			System.out.println(ivalue);
//		}
			
			
	}
	@Test
	public void test4() throws Exception{
		Person p = new Person();
		Class clazz = Class.forName("reflection.Person");
		Field f = clazz.getDeclaredField("age");
		f.setAccessible(true);
		System.out.println(f.get(p));
			
	}
	
}
