package demo;

import org.junit.Test;

//���󷽷���ö��
//Ӧ�ó������й��ĳɼ��У��ţ������У��������
//����ö�ٶ���ķ���������һ���й��ɼ�
/**
 * 1.ö������һ��������ʽ��Java��
 * 2.ö�����е�������ÿһ��ö��ֵ����ö�����һ��ʵ������
 * 3.��Java�е���ͨ��һ����������ö����ʱ��Ҳ�����������ԡ������͹��캯������ö����Ĺ��캯������Ϊ˽�е�
 * 4.ö����Ҳ����ʵ�ֽӿڡ���̳г�����
 * 5.switch��䣬���˿��Խ���int, byte, char,short�⣬�����Խ���ö������
 * 6.��ö����ֻ��һ��ö��ֵ�����Ӧ������̬���ģʽʹ��
*/
public class Demo4 {
	@Test
	public void test(){
		print(Grade2.A);
	}
	
	public void print(Grade2 a){
		String value= a.getValue();
		System.out.println(value);
	}
}
enum Grade2{ //class  A 100-85, B 85-75, C 75-65, D 65-50, E 50-0 
	//A,B,C,D,E //object
	//���汨���ԭ����A,B,C,D,E���Ƕ��󣬶���������û�й�������
	A("100-84"){public String localValue(){
		return "��";
	}} ,
	B("84-75"){public String localValue(){
		return "��";
	}}, 
	C("74-65"){public String localValue(){
		return "��";
	}}, 
	D("64-50"){public String localValue(){
		return "��";
	}}, 
	E("49-0"){public String localValue(){
		return "������";
	}};
	private String value;
	private Grade2(String value){
		this.value= value;
	}//�������ö�ٵĹ��캯��
	public String getValue(){
		return this.value;
	};
	
}


//�õ�̬���ģʽ�����һ����
enum A{//class
	A;//object
}






