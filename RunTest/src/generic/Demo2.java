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
	//list�зַ���
	@Test
	public void test1(){
		List<String> list = new ArrayList<String>();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		list.add("dd");
		//��ͳ������ʹ�õ�����
		Iterator<String> it = list.iterator();
		while (it.hasNext()){
			String value = it.next();
			System.out.println(value);
		}
		//��ǿForѭ��
		for(String s :list){
			System.out.println(s);
		}
		
	}
	
	//map֮�еķ���
	@Test
	public void test2(){
		Map<Integer,String> map= new LinkedHashMap();//���ʹ��HashMap()�ͻ��ɷ�ԭʼ˳����ļ�
		map.put(1, "aa");
		map.put(2, "bb");
		map.put(3, "cc");
		map.put(4, "dd");
		
		//��ͳkeyset, entryset ����entryset��JavaEE���ص�
		Set<Map.Entry<Integer, String>> set=map.entrySet();
		Iterator<Map.Entry<Integer, String>> it = set.iterator();
		while (it.hasNext()){
			Map.Entry<Integer, String> entry = it.next();
			int key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key+"="+value);
		}
		
		//ʹ����ǿfor ѭ��
		Set<Map.Entry<Integer, String>> set1 = map.entrySet();
		for (Map.Entry<Integer, String> i: set1){//or for (Map.Entry<Integer, String> i : map.entrySet())
			int key = i.getKey();
			String value = i.getValue();
			System.out.println(key + "+" +value);
		}
	}
	
	/**
	 * ������Ҫ��Ҫע��ĵ�
	 * 1.  ʹ�÷���ʱ������������Ϊ�������ͣ�����ʹ������������
	 * 2.  ʹ�÷����������ͱ���һ��
	 * 3. ArrayList<String> list = new ArrayList();��Ϊһ������Ա�ķ�����һ��������Ҫ����
	 * 4. ArrayList list =  new ArrayList<String>(): jdk1.5֮ǰ�ľ�û���ͣ�Ϊ�˼���
	 * 5. �����Ǹ�javac Java������ʹ�õ�
	 * 6. �ñ�����������з��͵�java��������ɵ�class�ļ��н����ڴ��з�����Ϣ��һ���ǳ�������Ч�ʲ���Ӱ�죬������̳�Ϊ��������
	 * 7. ���͵Ļ������ ArrayList<E>,<>��Ϊtypeof
	 *    ArrayList<E> �е�E��Ϊ���Ͳ�������
	 *    ArrayList<Integer>�е�Integer��Ϊʵ�����Ͳ���
	 *    ������ΪArrayList<E>��������
	 *    ���ArrayList<Integer>��Ϊ������������ParameterizedType ��ѧϰ���䷺��ʱ�ͻ�ʹ���ϣ�
	 * 
	 */
	
}


