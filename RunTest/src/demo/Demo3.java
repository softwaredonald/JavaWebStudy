package demo;

import org.junit.Test;

//枚举
//enum
public class Demo3 {
	//成绩中只有5个成绩等级分别是A,B,C,D,E
	
	
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

//如何定义枚举的构造函数，方法和字段，封装更多的信息
enum Grade{ //class  A 100-85, B 85-75, C 75-65, D 65-50, E 50-0 
	//A,B,C,D,E //object
	//上面报错的原因是A,B,C,D,E都是对象，而各个对象没有构造内容
	A( "100-85"), B("85-75"), C("75-65"), D("65-50"), E("50-0");
	private String value;
	private Grade(String value){
		this.value= value;
	}
	public String getValue(){
		return this.value;
	}
	
}


//让枚举有构造函数，字段和方法