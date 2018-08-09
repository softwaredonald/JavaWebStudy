package reflection;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.Test;

/**
 * 
 * @author xu feng
 * ������ķ���
 */
public class Demo2 {
	
	@Test
	public void test1() throws Exception{
		Person p = new Person();
		Class clazz = Class.forName("reflection.Person");
		Method method = clazz.getMethod("a", null); //���� ���ڳ���һ��������Ҫһ����ȥ��
		method.invoke(p, null);//��һ��ָ�����õĶ��� �����������������Ҫ�и���ȥ��
	}
	@Test
	//public void b(String name, int num)
	public void test2() throws Exception{
		Person p = new Person();
		Class clazz = Class.forName("reflection.Person");
		Method method = clazz.getMethod("b", String.class,int.class); 
		method.invoke(p, "zhang",28);
	}
	@Test
	//public Class[] c(String name, int[] num)
	public void test3() throws Exception{
		Person p = new Person();
		Class clazz = Class.forName("reflection.Person");
		Method method = clazz.getMethod("c", String.class, int[].class); 
		Class cs[] = (Class[]) method.invoke(p, "zhang",new int[]{1,2,3,4});
		System.out.println(cs[0]);
	}
	@Test
	//public void b(String name, int num)
	public void test4() throws Exception{
		Person p = new Person();
		Class clazz = Class.forName("reflection.Person");
		Method method = clazz.getDeclaredMethod("d",InputStream.class);
		method.setAccessible(true);
		method.invoke(p, new FileInputStream("C:\\Users\\xufen\\Desktop\\1.txt"));
	}
	//public static void e (int num)
	@Test
	public void test5() throws Exception{
		Person p = new Person();//������Ǳ����
		Class clazz = Class.forName("reflection.Person");
		Method method = clazz.getMethod("e", int.class); 
		method.invoke(p, 28); //���������ַ������ǿ��Ե�
		method.invoke(null,28);
	}
	@Test
	public void test6() throws Exception{
		Person p = new Person();
		Class clazz = Class.forName("reflection.Person");
		Method method = clazz.getMethod("main", String[].class);
		method.invoke(null, new Object[]{new String[]{"aa","bb"}});
		method.invoke(null, (Object) new String[]{"cc","dd"});
	}
}
