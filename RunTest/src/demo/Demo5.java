package demo;
//反射 reflection
/**
 * 反射用来做框架的，制作配置文件，读取配置文件，配置一个类，
 * cn.itcast.Person run()
 * 上面就是一个例子
 * 配一个类，让他运用这个person类的run方法，先加载类，然后找到run方法（解剖类的构造）
 * class 中有个forName 
*/
public class Demo5 {
	public static void main(String [] args) throws ClassNotFoundException{
		
		//方法一：
		/**
		 * String classname = "demo.Person";
		 * Class clazz1 = Class.forname(classname);
		 */
		Class clazz1 = Class.forName("demo.Person");
		
		//方法二：
		/** 缺点： 必须要创建该类对象，才可以调用getClass方法
		 * 应该这样写
		 * Object obj = new Person();
		 * Class clazz2 =obj.getClass();
		 */
		Class clazz2 = new Person().getClass();
		
		//方法三：
		/** 方法2,3 不利于程序的扩展
		 * 缺点：必须要先明确该类
		 */
		Class clazz3 = Person.class;
	}
}
/**
 * 
 */