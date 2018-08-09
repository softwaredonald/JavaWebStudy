package introspection;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.junit.Test;

public class Demo1 {
	
	@Test
	/**
	 * 这里获得的属性是从全部的属性，包括继承过来的
	 * @throws Exception
	 */
	public void test1() throws Exception{
		BeanInfo info = Introspector.getBeanInfo(Person.class);
		PropertyDescriptor[] pds = info.getPropertyDescriptors();
		for (PropertyDescriptor pd: pds){
			System.out.println(pd.getName());
		}
	}
	@Test
	/**
	 * @throws Exception
	 * 这里只获得来自于bean他自己的属性
	 */
	public void test2() throws Exception{
		BeanInfo info = Introspector.getBeanInfo(Person.class,Object.class);
		PropertyDescriptor[] pds = info.getPropertyDescriptors();
		for (PropertyDescriptor pd: pds){
			System.out.println(pd.getName());
		}
	}
	@Test
	/**
	 * 操作Bean的一个特定属性：aga
	 */
	
	public void test3() throws Exception{
		Person p = new Person();
		PropertyDescriptor pd = new PropertyDescriptor("age",Person.class);
		
		//得到属性的写方法，为属性赋值
		Method method = pd.getWriteMethod(); //public void setAge(int age)
		method.invoke(p, 45);
//		System.out.println(p.getAge());
		//获取属性的值
		method = pd.getReadMethod(); //public int getAge(){}
		System.out.println(method.invoke(p, null));
	}
	
		
		/**稍微高级点的内容
		 * 获取当前操作的属性的类型
		 */
	@Test
	public void test4() throws Exception{
		Person p = new Person();
		PropertyDescriptor pd = new PropertyDescriptor("age",Person.class); //得到了一个属性的描述器。现在不知道age 是什么
		System.out.println(pd.getPropertyType());//返回 int
	}
	
}
