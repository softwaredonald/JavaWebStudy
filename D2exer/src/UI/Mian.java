package UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import dao.StudentDao;
import domain.Student;
import exception.StudentNotExistException;

public class Mian {

	public static void main(String[] args) {
		//ֻҪ���ǽ����ģ��������ף����ǵ��˽���㣬�ͱ���֪ͨ�û�������¼����
		
		// TODO Auto-generated method stub
		System.out.println("����û���a��,ɾ���û���b���������û���c��");
		System.out.println("�������������");
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		try {
			String type = br.readLine();
			if("a".equals(type)){
				System.out.println("������ѧ��������");
				String name = br.readLine();
				System.out.println("������ѧ��׼��֤��");
				String examid = br.readLine();
				System.out.println("������ѧ�����֤");
				String idcard = br.readLine();
				System.out.println("������ѧ�����ڵ�");
				String location = br.readLine();
				System.out.println("������ѧ���ɼ�");
				String grade = br.readLine();
				Student s = new Student();
				s.setExmaid(examid);
				s.setGrade(Double.parseDouble(grade));
				s.setIdcard(idcard);
				s.setLocation(location);
				s.setName(name);
				
				StudentDao dao =new StudentDao();
				dao.add(s);
				System.out.println("������");
				
			}else if("b".equals(type)){
				System.out.println("����ɾ�����û�������");
				String name = br.readLine();
				StudentDao dao = new StudentDao();
				try {
					dao.delete2(name);
					System.out.println("ɾ���ɹ�");
				} catch (StudentNotExistException e) {
					// TODO Auto-generated catch block
					System.out.println("not exist");
				}
				
				
			}else if("c".equals(type)){
				
			}else{
				System.out.println("Not right");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();//Ϊ�˹۲�����
			System.out.println("������");
		} 

	}
}