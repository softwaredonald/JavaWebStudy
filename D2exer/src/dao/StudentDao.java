package dao;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.sun.corba.se.impl.naming.pcosnaming.NameServer;

import Utils.XMLUtils;
import domain.Student;
import exception.StudentNotExistException;

public class StudentDao {
	
	
	
	public void add(Student s) {
		
		try {
			Document document = XMLUtils.getDocument();
			
			//创建出封装学生信息的标签
			Element student_tag = document.createElement("student");
			student_tag.setAttribute("idcard", s.getIdcard());
			student_tag.setAttribute("examid", s.getExmaid());
			
			//创建 用于封装：学生姓名、所在地和成绩的标签
			Element name = document.createElement("name");
			Element location = document.createElement("location");
			Element grade = document.createElement("grade");
			
			name.setTextContent(s.getName());
			location.setTextContent(s.getLocation());
			grade.setTextContent(s.getGrade()+"");
			
			student_tag.appendChild(name);
			student_tag.appendChild(location);
			student_tag.appendChild(grade);
			
			//封装了信息学生标签，挂到文档上
			document.getElementsByTagName("exam").item(0).appendChild(student_tag);
			
			
			//更新到硬盘
			XMLUtils.write2Xml(document);
			
					
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);//unchecked exception (运行时异常)
		}//编译时的异常，向上抛不能解决问题，所以只能抓，还不能打印。还是要通知上一层，减少麻烦，转型一个叫：unchecked exception
		
		
	}

	public Student find (String examid){
		
		try {
			Document document = XMLUtils.getDocument();
			NodeList list = document.getElementsByTagName("student");
			for (int i= 0;i<list.getLength();i++){
				Element student_tag = (Element) list.item(i);
				if (student_tag.getAttribute("examid").equals(examid)){
					//找到与examID相匹配的学生，new出一个student对象封装这个学生的返回信息
					Student s = new Student();
					s.setExmaid(examid);
					s.setIdcard(student_tag.getAttribute("idcard"));
					s.setName(student_tag.getElementsByTagName("name").item(0).getTextContent());
					s.setLocation(student_tag.getElementsByTagName("location").item(0).getTextContent());
					s.setGrade(Double.parseDouble(student_tag.getElementsByTagName("location").item(0).getTextContent()));
					return s;
				}
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
			
		}
		
		
		return null;
	}
	
	public boolean delete(String name){ //如果找不到，还要通知调用者,修改方法签名
		try {
			Document document = XMLUtils.getDocument();
			
			NodeList list = document.getElementsByTagName("name");
			for (int i =0;i<list.getLength();i++){
				if (list.item(i).getTextContent().equals(name)){
					list.item(i).getParentNode().getParentNode().removeChild(list.item(i).getParentNode());
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
		
	}
	public void delete2(String name) throws StudentNotExistException{ //不让修改方法签名,这个时候必须抛编译时的异常，必须有人处理，否则不能跳过
		//这里最重要的是异常抛出方法
		//异常就是没有这个人名
		try {
			Document document = XMLUtils.getDocument();
			
			NodeList list = document.getElementsByTagName("name");
			for (int i =0;i<list.getLength();i++){
				if (list.item(i).getTextContent().equals(name)){
					list.item(i).getParentNode().getParentNode().removeChild(list.item(i).getParentNode());
					XMLUtils.write2Xml(document);
					return;
				}
			}
			throw new StudentNotExistException(name+"不存在！！");
		} catch (StudentNotExistException e) {
			throw e;
		}catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}
	



}
