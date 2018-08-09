package beanUtils;

import java.util.Date;

/**
 * 
 * @author xufen
 * beanUtils
 * 
 * 
 */
public class Person {
	
	private String name;//字段，
	private String password;
	private int age;
	private Date birthday;
	
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
}
