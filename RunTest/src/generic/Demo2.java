package generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * 
 * @author xufen
 *
 */
public class Demo2 {
	//list中分泛型
	@Test
	public void test1(){
		List<String> list = new ArrayList<String>();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		list.add("dd");
		//传统方法，使用迭代器
		Iterator<String> it = list.iterator();
		while (it.hasNext()){
			String value = it.next();
			System.out.println(value);
		}
		//增强For循环
		for(String s :list){
			System.out.println(s);
		}
		
	}
	
	//map之中的泛型
	@Test
	public void test2(){
		Map<Integer,String> map= new LinkedHashMap();//如果使用HashMap()就会变成非原始顺序的文件
		map.put(1, "aa");
		map.put(2, "bb");
		map.put(3, "cc");
		map.put(4, "dd");
		
		//传统keyset, entryset 期中entryset是JavaEE的重点
		Set<Map.Entry<Integer, String>> set=map.entrySet();
		Iterator<Map.Entry<Integer, String>> it = set.iterator();
		while (it.hasNext()){
			Map.Entry<Integer, String> entry = it.next();
			int key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key+"="+value);
		}
		
		//使用增强for 循环
		Set<Map.Entry<Integer, String>> set1 = map.entrySet();
		for (Map.Entry<Integer, String> i: set1){//or for (Map.Entry<Integer, String> i : map.entrySet())
			int key = i.getKey();
			String value = i.getValue();
			System.out.println(key + "+" +value);
		}
	}
	
	/**
	 * 泛型主要需要注意的点
	 * 1.  使用泛型时，泛型类型须为引用类型，不能使基本数据类型
	 * 2.  使用泛型两边类型必须一样
	 * 3. ArrayList<String> list = new ArrayList();因为一个程序员的方法不一样，所以要允许
	 * 4. ArrayList list =  new ArrayList<String>(): jdk1.5之前的就没泛型，为了兼容
	 * 5. 泛型是给javac Java编译器使用的
	 * 6. 让编译器编译带有泛型的java程序后，生成的class文件中将不在带有泛型信息，一次是程序运行效率不受影响，这个过程称为“擦除”
	 * 7. 泛型的基本术语， ArrayList<E>,<>称为typeof
	 *    ArrayList<E> 中的E称为类型参数变量
	 *    ArrayList<Integer>中的Integer称为实际类型参数
	 *    整个称为ArrayList<E>泛型类型
	 *    这个ArrayList<Integer>称为参数化的类型ParameterizedType （学习反射泛型时就会使用上）
	 * 
	 */
	
}


