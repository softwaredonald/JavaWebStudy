package demo;

import org.junit.Test;

//ö��
//enum
public class Demo3 {
	//�ɼ���ֻ��5���ɼ��ȼ��ֱ���A,B,C,D,E
	
	
	@Test
	public void test(){
		print(Grade.A);
	}
	
	public void print(Grade g){
		String value= g.getValue();
		System.out.println(value);
	}
}


//class Grade{
//	private Grade(){}
//	public static final Grade A = new Grade();
//	public static final Grade B = new Grade();
//	public static final Grade C = new Grade();
//	public static final Grade D = new Grade();
//	public static final Grade E = new Grade();
//}

//��ζ���ö�ٵĹ��캯�����������ֶΣ���װ�������Ϣ
enum Grade{ //class  A 100-85, B 85-75, C 75-65, D 65-50, E 50-0 
	//A,B,C,D,E //object
	//���汨���ԭ����A,B,C,D,E���Ƕ��󣬶���������û�й�������
	A( "100-85"), B("85-75"), C("75-65"), D("65-50"), E("50-0");
	private String value;
	private Grade(String value){
		this.value= value;
	}
	public String getValue(){
		return this.value;
	}
	
}


//��ö���й��캯�����ֶκͷ���