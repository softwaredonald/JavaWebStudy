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
	 * �����õ������Ǵ�ȫ�������ԣ������̳й�����
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
	 * ����ֻ���������bean���Լ�������
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
	 * ����Bean��һ���ض����ԣ�aga
	 */
	
	public void test3() throws Exception{
		Person p = new Person();
		PropertyDescriptor pd = new PropertyDescriptor("age",Person.class);
		
		//�õ����Ե�д������Ϊ���Ը�ֵ
		Method method = pd.getWriteMethod(); //public void setAge(int age)
		method.invoke(p, 45);
//		System.out.println(p.getAge());
		//��ȡ���Ե�ֵ
		method = pd.getReadMethod(); //public int getAge(){}
		System.out.println(method.invoke(p, null));
	}
	
		
		/**��΢�߼��������
		 * ��ȡ��ǰ���������Ե�����
		 */
	@Test
	public void test4() throws Exception{
		Person p = new Person();
		PropertyDescriptor pd = new PropertyDescriptor("age",Person.class); //�õ���һ�����Ե������������ڲ�֪��age ��ʲô
		System.out.println(pd.getPropertyType());//���� int
	}
	
}
