package generic;

import java.util.List;
import java.util.ArrayList;

/**
 * �����������Ա�ڱ�д���ϴ���ʱ�������ƽ�ϵĴ������ͣ��Ӷ���ԭ����������ʱ���ܷ������⣬
 * ת���Ϊ����ʱ�����⣬ �Դ���߳���Ŀɶ��Ժ��ȶ��ԣ������ڴ��ͳ����и�Ϊͻ����
 * �������û�з���
 * ArrayList list = new ArrayList();
 * list.add("abc");
 * Integer num = (Integer)list.get(0);����ʱ��������Ǳ���ʱ���ֲ���
 * 
 * 
 * @author xufen
 *
 */

//����Ĵ����Ǵ����
public class demo1 {
	public static void main (String [] args) {
		List list = new ArrayList();
		list.add("aaa");
		Integer i = (Integer)list.get(0);
		
		
		//Ӧ��������
		//�Ա��������ִ��룬���𲿷־��Ƿ���
		List<String> list1= new ArrayList<String>();
		list1.add("bbbbbb");
		String s= list1.get(0);
		
		
	}
}




