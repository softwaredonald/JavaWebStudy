package demo;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

//�ɱ����
//�Ͱ�����������
public class Demo2 {
	@Test
	public void testSum(){
		//���ﴫ��������Ҳ����
		//int arr[]= {1,3,5,2,4,}
		// sum(arr)
		sum (1,2,3,4,5,6);
	}
	public void sum (int ...nums){
		//�ɱ���� ���ǿ��Ըı������
		int sum=0;
		for (int i: nums){
			sum +=i;
		}
		System.out.println(sum);
	}
	public void aa (int ...num, int x){
		//����д��������
	}
	public void aaa(int x, int ...num){
		//����д�����ǿ��Ե�
	}
	
	//aslist��������
	//����ȥ���Ƕ��󣬲��ǻ�����������
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
