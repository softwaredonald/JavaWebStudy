package demo;

import org.junit.Test;

//抽象方法的枚举
//应用场景：中国的成绩叫：优，良，中，差，不及格
//调用枚举对象的方法，返回一个中国成绩
/**
 * 1.枚举类是一种特殊形式的Java类
 * 2.枚举类中的声明的每一个枚举值代表枚举类的一个实例对象
 * 3.与Java中的普通类一样，在声明枚举类时，也可以声明属性、方法和构造函数，但枚举类的构造函数必须为私有的
 * 4.枚举类也可以实现接口、或继承抽象类
 * 5.switch语句，除了可以接收int, byte, char,short外，还可以接收枚举类型
 * 6.若枚举类只有一个枚举值，则可应答做单态设计模式使用
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
	//上面报错的原因是A,B,C,D,E都是对象，而各个对象没有构造内容
	A("100-84"){public String localValue(){
		return "优";
	}} ,
	B("84-75"){public String localValue(){
		return "良";
	}}, 
	C("74-65"){public String localValue(){
		return "中";
	}}, 
	D("64-50"){public String localValue(){
		return "差";
	}}, 
	E("49-0"){public String localValue(){
		return "不及格";
	}};
	private String value;
	private Grade2(String value){
		this.value= value;
	}//这个就是枚举的构造函数
	public String getValue(){
		return this.value;
	};
	
}


//用单态设计模式定义出一个类
enum A{//class
	A;//object
}






