package junit.test;

import org.junit.Test;

import dao.StudentDao;
import domain.Student;
import exception.StudentNotExistException;

public class StudentDaoTest {
	
	
	@Test
	public void testAdd() {
		// TODO Auto-generated constructor stub
		StudentDao dao = new StudentDao();
		Student s = new Student();
		s.setExmaid("110");
		s.setGrade(89);
		s.setIdcard("110");
		s.setLocation("±±¾©");
		s.setName("bb");
		dao.add(s);
	}
	
	@Test
	public void testfind(){
		/**
		 * using break point.othervise print all the information from the file.
		 */
		StudentDao dao = new StudentDao();
		dao.find("121");}
	
	@Test
	public void testDelete() throws StudentNotExistException{

		StudentDao dao = new StudentDao();
		dao.delete2("sdfasd:sdfat");
	}
		
		
	}

