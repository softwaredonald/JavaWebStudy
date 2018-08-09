package demo;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

//可变参数
//就把他当成数组
public class Demo2 {
	@Test
	public void testSum(){
		//这里传的是数组也可以
		//int arr[]= {1,3,5,2,4,}
		// sum(arr)
		sum (1,2,3,4,5,6);
	}
	public void sum (int ...nums){
		//可变参数 就是可以改变的数组
		int sum=0;
		for (int i: nums){
			sum +=i;
		}
		System.out.println(sum);
	}
	public void aa (int ...num, int x){
		//这种写法不可以
	}
	public void aaa(int x, int ...num){
		//这种写法就是可以的
	}
	
	//aslist方法介绍
	//传进去的是对象，不是基本数据类型
	@Test
	public void bb(){
		List list = Arrays.asList("1","2","3");
		System.out.println(list);
		
		String arr[]={"1","2","3","4","5"};
		list = Arrays.asList(arr);
		System.out.println(list);
		
		int nums[]={9,2,3,4,5};
		list = Arrays.asList(nums);
		System.out.println(list);
		
		Integer inte[]={8,7,6,5,4};
		list= Arrays.asList(inte);
		System.out.println(list);
		
		
	}
}
