package demo;
//���� reflection
/**
 * ������������ܵģ����������ļ�����ȡ�����ļ�������һ���࣬
 * cn.itcast.Person run()
 * �������һ������
 * ��һ���࣬�����������person���run�������ȼ����࣬Ȼ���ҵ�run������������Ĺ��죩
 * class ���и�forName 
*/
public class Demo5 {
	public static void main(String [] args) throws ClassNotFoundException{
		
		//����һ��
		/**
		 * String classname = "demo.Person";
		 * Class clazz1 = Class.forname(classname);
		 */
		Class clazz1 = Class.forName("demo.Person");
		
		//��������
		/** ȱ�㣺 ����Ҫ����������󣬲ſ��Ե���getClass����
		 * Ӧ������д
		 * Object obj = new Person();
		 * Class clazz2 =obj.getClass();
		 */
		Class clazz2 = new Person().getClass();
		
		//��������
		/** ����2,3 �����ڳ������չ
		 * ȱ�㣺����Ҫ����ȷ����
		 */
		Class clazz3 = Person.class;
	}
}
/**
 * 
 */