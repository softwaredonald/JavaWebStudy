package reflection;

import java.lang.reflect.Field;

import org.junit.Test;

/**
 * 
 * @author xufen
 *
 * �����ֶ�
 */
public class Demo3 {
	
	@Test
	//�����ֶ� public String name = "aaa";
	public void test1() throws Exception{
		Person p = new Person();
		Class clazz = Class.forName("reflection.Person");
		Field f = clazz.getField("name");
		String name = (String) f.get(p);
	}
	
	//�����֪����ʲô���ͣ�Ӧ������д public String name = "aaa";
	@Test
	public void test2() throws Exception{
		Person p = new Person();
		Class clazz = Class.forName("reflection.Person");
		Field f = clazz.getField("name");
		//��ȡ�ֶε�ֵ
		Object obj = f.get(p);
		//��ȡ�ֶ�����
		Class type=f.getType();
		if (type.equals(String.class)){
			String svalue = (String) obj;
			System.out.println(svalue);
		}
		/**
		 * �����ֶ�ֵ
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
