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
	
	private String name;//�ֶΣ�
	private String password;
	private int age;
	private Date birthday;
	
	public String getName() {//ֻ���ֶγ�����get or set�ķ������Ż���bean������
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
	public String getAb(){//��ʹû���ֶΣ���Ҳ��һ������
		return null;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
}
