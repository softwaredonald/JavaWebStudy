package demo;

import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 增强for
 * 
 */
public class Demo1 {
//可以在基本类型、对象中使用
	@Test
	public void test1() {
		int arr[] = { 1, 2, 3 };
		for (int num : arr) {
			int i = (Integer) num;
			System.out.println(i);
		}
	}
	
	//不能在map中直接使用，但是转换之后就可以了
	@Test
	public void test3() {
		Map map = new HashMap();
		map.put("0","a");
		map.put("1","b");
		map.put("2","c");
		//传统方法取值
		Set set = map.keySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			String key = (String) it.next();
			String value =(String) map.get(key);
			System.out.println(key + "=" + value);
		}
	}
	
	@Test
	public void test4() {
		Map map = new HashMap();
		map.put("0","a");
		map.put("1","b");
		map.put("2","c");
		//传统方法2 mayentry 方法
		Set set = map.entrySet();
		Iterator it =  set.iterator();
		while (it.hasNext()) {
			Map.Entry entry= (Entry) it.next();
			String value = (String) entry.getValue();
			String key = (String) entry.getKey();
			System.out.println(key+"="+value);
		}
	}
	
	@Test
	public void test5() {
		Map map = new HashMap();
		map.put("0","a");
		map.put("1","b");
		map.put("2","c");
		//使用增强for的第一种方法
		for (Object obj:map.keySet()){
			String key  = (String) obj;
			String value = (String) map.get(key);
			System.out.println(key+"="+value);
		}
	}
	@Test
	public void test6() {
		Map map = new HashMap();
		map.put("0","a");
		map.put("1","b");
		map.put("2","c");
		//使用增强for的第二种方法
		for (Object obj:map.entrySet()){
			Map.Entry entry = (Entry) obj;
			String key = (String) entry.getKey();
			String value=  (String) entry.getValue();
			System.out.println(key+"="+value);
		}
	}
	
	@Test
	//增强for循环只适合取数据，而不适合写入
	public void test7(){
		int arr[] = {1,2,3};
		for (int i: arr){
			i = 10;
		}
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		
		List list = new ArrayList();
		list.add("1");
		for (Object obj:list){
			obj = "10";
		}
		System.out.println(list.get(0));
		//数据读出来，开始的时将其指向1，后来又指向10， array的数据没有变。
		//如果想改变，只能使用传统的for
		for (int i =0;i<arr.length;i++){
			arr[i]=1;
		}
	}
}
