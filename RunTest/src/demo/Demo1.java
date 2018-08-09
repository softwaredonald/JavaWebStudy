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
 * ��ǿfor
 * 
 */
public class Demo1 {
//�����ڻ������͡�������ʹ��
	@Test
	public void test1() {
		int arr[] = { 1, 2, 3 };
		for (int num : arr) {
			int i = (Integer) num;
			System.out.println(i);
		}
	}
	
	//������map��ֱ��ʹ�ã�����ת��֮��Ϳ�����
	@Test
	public void test3() {
		Map map = new HashMap();
		map.put("0","a");
		map.put("1","b");
		map.put("2","c");
		//��ͳ����ȡֵ
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
		//��ͳ����2 mayentry ����
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
		//ʹ����ǿfor�ĵ�һ�ַ���
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
		//ʹ����ǿfor�ĵڶ��ַ���
		for (Object obj:map.entrySet()){
			Map.Entry entry = (Entry) obj;
			String key = (String) entry.getKey();
			String value=  (String) entry.getValue();
			System.out.println(key+"="+value);
		}
	}
	
	@Test
	//��ǿforѭ��ֻ�ʺ�ȡ���ݣ������ʺ�д��
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
		//���ݶ���������ʼ��ʱ����ָ��1��������ָ��10�� array������û�б䡣
		//�����ı䣬ֻ��ʹ�ô�ͳ��for
		for (int i =0;i<arr.length;i++){
			arr[i]=1;
		}
	}
}
