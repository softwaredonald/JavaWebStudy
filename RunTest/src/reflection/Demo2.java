package reflection;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.Test;

/**
 * 
 * @author xu feng
 * 反射类的方法
 */
public class Demo2 {
	
	@Test
	public void test1() throws Exception{
		Person p = new Person();
		Class clazz = Class.forName("reflection.Person");
		Method method = clazz.getMethod("a", null); //假设 现在出现一个汽车，要一个人去开
		method.invoke(p, null);//第一个指定调用的对象， 从上面的例子来讲，要有个人去开
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
		Person p = new Person();//这个不是必须的
		Class clazz = Class.forName("reflection.Person");
		Method method = clazz.getMethod("e", int.class); 
		method.invoke(p, 28); //上下这两种方法都是可以的
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
