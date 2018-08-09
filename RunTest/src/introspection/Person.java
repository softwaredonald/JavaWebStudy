package introspection;
/**
 * 
 * @author xufen
 * 1.这个类就是一个Java Bean
 * 2.用户提交一个数据，数据会被这些Bean封装起来
 * 3.bean有5个属性，默认从Object继承过来的，所以由于有个getClass属性，
 * 	  所以一共有五个属性（getName，getPassword，getAge，getAb）
 *   set和get默认一个
 * 4.类型：入口类
 *   getBeanInfo了解其所有属性
 *   getPropertyDescription（）属性描述器，getReadMethod（）--> get()-->getWriteMethod()-->
 * 
 * 
 */
public class Person {
	private String name;//字段，
	private String password;
	private int age;
	public String getName() {//只有字段出现了get or set的方法，才会有bean的属性
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAb(){//即使没有字段，他也是一个属性
		return null;
	}
	
	
	
}
