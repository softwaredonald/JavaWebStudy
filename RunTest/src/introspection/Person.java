package introspection;
/**
 * 
 * @author xufen
 * 1.��������һ��Java Bean
 * 2.�û��ύһ�����ݣ����ݻᱻ��ЩBean��װ����
 * 3.bean��5�����ԣ�Ĭ�ϴ�Object�̳й����ģ����������и�getClass���ԣ�
 * 	  ����һ����������ԣ�getName��getPassword��getAge��getAb��
 *   set��getĬ��һ��
 * 4.���ͣ������
 *   getBeanInfo�˽�����������
 *   getPropertyDescription����������������getReadMethod����--> get()-->getWriteMethod()-->
 * 
 * 
 */
public class Person {
	private String name;//�ֶΣ�
	private String password;
	private int age;
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
	
	
	
}
