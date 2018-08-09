package generic;

import java.util.List;
import java.util.ArrayList;

/**
 * 泛型允许程序员在编写集合代码时，就限制结合的处理类型，从而把原来程序运行时可能发生问题，
 * 转变成为编译时的问题， 以此提高程序的可读性和稳定性（尤其在大型程序中更为突出）
 * 例如如果没有泛型
 * ArrayList list = new ArrayList();
 * list.add("abc");
 * Integer num = (Integer)list.get(0);运行时会出错，但是编码时发现不了
 * 
 * 
 * @author xufen
 *
 */

//下面的代码是错误的
public class demo1 {
	public static void main (String [] args) {
		List list = new ArrayList();
		list.add("aaa");
		Integer i = (Integer)list.get(0);
		
		
		//应该这样做
		//对比上下两种代码，区别部分就是泛型
		List<String> list1= new ArrayList<String>();
		list1.add("bbbbbb");
		String s= list1.get(0);
		
		
	}
}




