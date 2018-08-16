package UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import dao.StudentDao;
import domain.Student;
import exception.StudentNotExistException;

public class Mian {

	public static void main(String[] args) {
		//只要不是界面层的，都可以抛，但是到了界面层，就必须通知用户，并记录错误
		
		// TODO Auto-generated method stub
		System.out.println("添加用户（a）,删除用户（b），查找用户（c）");
		System.out.println("请输入操作类型");
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		try {
			String type = br.readLine();
			if("a".equals(type)){
				System.out.println("请输入学生姓名：");
				String name = br.readLine();
				System.out.println("请输入学生准考证号");
				String examid = br.readLine();
				System.out.println("请输入学生身份证");
				String idcard = br.readLine();
				System.out.println("请输入学生所在地");
				String location = br.readLine();
				System.out.println("请输入学生成绩");
				String grade = br.readLine();
				Student s = new Student();
				s.setExmaid(examid);
				s.setGrade(Double.parseDouble(grade));
				s.setIdcard(idcard);
				s.setLocation(location);
				s.setName(name);
				
				StudentDao dao =new StudentDao();
				dao.add(s);
				System.out.println("添加完成");
				
			}else if("b".equals(type)){
				System.out.println("输入删除的用户姓名：");
				String name = br.readLine();
				StudentDao dao = new StudentDao();
				try {
					dao.delete2(name);
					System.out.println("删除成功");
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
			e.printStackTrace();//为了观察问题
			System.out.println("出错了");
		} 

	}
}