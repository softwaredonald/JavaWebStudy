package beanUtils;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.junit.Test;

import sun.util.calendar.BaseCalendar.Date;

//ʹ��beanUtils ����bean�����ԣ���������
public class Demo1 {
	@Test
	public void test1() throws Exception, InvocationTargetException{
		Person p=new Person();
		BeanUtils.setProperty(p,"name","xcc");
		System.out.println(p.getName());
	}
	@Test
	public void test2() throws Exception, InvocationTargetException{
		/**
		 * ʵ��Ӧ��ʱ���û�ͨ������������Ӧ����Ϣ������������string
		 */
		
		String name = "aaaaa";
		String password = "123";
		String age = "34";
		String birthday = "1980-09-09";//��������ڣ����ǻ����������ͣ��ͻᱨ��
		//���ʱ�����Ҫע��ת�����Ϳ���
		
		/**
		 * BeanUtils ��һЩ����ת������Ӧ�����Ե��������͡�ֻ֧��8�л����������͡�
		 * �������ͣ�BeanUtils�����ת
		 */
				
		Person p=new Person();
		BeanUtils.setProperty(p,"name",name);
		BeanUtils.setProperty(p,"password",password);
		BeanUtils.setProperty(p,"age",age);
		System.out.println(p.getName());
		System.out.println(p.getPassword());
		System.out.println(p.getAge());
	}
	
	@Test
	/**
	 * Ϊ�����ռǸ�ֵ��Bean��birthday�����ϣ���BeanUtilsע��һ������ת����
	 * @throws Exception
	 * @throws InvocationTargetException
	 */
	public void test3() throws Exception, InvocationTargetException{
		/**
		 * ʵ��Ӧ��ʱ���û�ͨ������������Ӧ����Ϣ������������string
		 */
		
		String name = "aaaaa";
		String password = "123";
		String age = "34";
		String birthday = "1980-09-09";
		
		ConvertUtils.register(new Converter(){
			public Object convert(Class type, Object value) {
				if (value == null){
					return null;
				}
				if (!(value instanceof String)){
					throw new ConversionException("ֻ֧��String���͵�ת��");
				}
				//�����������أ�����string
				//���ǣ���֪�����Ǵ�����ʲôstring
				 
				String str = (String) value;
				if (str.trim().equals("")){
					return null;
				}
					
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				try{
					return df.parse(str);
				} catch (ParseException e){
					throw new RuntimeException(e); //�쳣�����ܶ� ���ܰ�����һ����ӡ����
				}
				
			}
		}, Date.class);
				
		Person p=new Person();
		BeanUtils.setProperty(p,"name",name);
		BeanUtils.setProperty(p,"password",password);
		BeanUtils.setProperty(p,"age",age);
		BeanUtils.setProperty(p,"birthday",birthday);
		
		
		System.out.println(p.getName());
		System.out.println(p.getPassword());
		System.out.println(p.getAge());		
		System.out.println(p.getBirthday());
	}
}
