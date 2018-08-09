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

//使用beanUtils 操作bean的属性（第三方）
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
		 * 实际应用时，用户通过表单传过来相应的信息，传过来的是string
		 */
		
		String name = "aaaaa";
		String password = "123";
		String age = "34";
		String birthday = "1980-09-09";//这个是日期，不是基本数据类型，就会报错
		//这个时候就需要注册转换器就可以
		
		/**
		 * BeanUtils 讲一些数据转化成相应的属性的数据类型。只支持8中基本数据类型。
		 * 复杂类型，BeanUtils不会给转
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
	 * 为了让日记赋值到Bean的birthday属性上，给BeanUtils注册一个日期转换器
	 * @throws Exception
	 * @throws InvocationTargetException
	 */
	public void test3() throws Exception, InvocationTargetException{
		/**
		 * 实际应用时，用户通过表单传过来相应的信息，传过来的是string
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
					throw new ConversionException("只支持String类型的转换");
				}
				//经过上面两关，就是string
				//但是，不知道他们传的是什么string
				 
				String str = (String) value;
				if (str.trim().equals("")){
					return null;
				}
					
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				try{
					return df.parse(str);
				} catch (ParseException e){
					throw new RuntimeException(e); //异常链不能断 ，能把所有一场打印出来
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
