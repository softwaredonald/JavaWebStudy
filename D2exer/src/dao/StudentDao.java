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
			
			//��������װѧ����Ϣ�ı�ǩ
			Element student_tag = document.createElement("student");
			student_tag.setAttribute("idcard", s.getIdcard());
			student_tag.setAttribute("examid", s.getExmaid());
			
			//���� ���ڷ�װ��ѧ�����������ڵغͳɼ��ı�ǩ
			Element name = document.createElement("name");
			Element location = document.createElement("location");
			Element grade = document.createElement("grade");
			
			name.setTextContent(s.getName());
			location.setTextContent(s.getLocation());
			grade.setTextContent(s.getGrade()+"");
			
			student_tag.appendChild(name);
			student_tag.appendChild(location);
			student_tag.appendChild(grade);
			
			//��װ����Ϣѧ����ǩ���ҵ��ĵ���
			document.getElementsByTagName("exam").item(0).appendChild(student_tag);
			
			
			//���µ�Ӳ��
			XMLUtils.write2Xml(document);
			
					
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);//unchecked exception (����ʱ�쳣)
		}//����ʱ���쳣�������ײ��ܽ�����⣬����ֻ��ץ�������ܴ�ӡ������Ҫ֪ͨ��һ�㣬�����鷳��ת��һ���У�unchecked exception
		
		
	}

	public Student find (String examid){
		
		try {
			Document document = XMLUtils.getDocument();
			NodeList list = document.getElementsByTagName("student");
			for (int i= 0;i<list.getLength();i++){
				Element student_tag = (Element) list.item(i);
				if (student_tag.getAttribute("examid").equals(examid)){
					//�ҵ���examID��ƥ���ѧ����new��һ��student�����װ���ѧ���ķ�����Ϣ
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
	
	public boolean delete(String name){ //����Ҳ�������Ҫ֪ͨ������,�޸ķ���ǩ��
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
	public void delete2(String name) throws StudentNotExistException{ //�����޸ķ���ǩ��,���ʱ������ױ���ʱ���쳣���������˴�������������
		//��������Ҫ�����쳣�׳�����
		//�쳣����û���������
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
			throw new StudentNotExistException(name+"�����ڣ���");
		} catch (StudentNotExistException e) {
			throw e;
		}catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}
	



}
