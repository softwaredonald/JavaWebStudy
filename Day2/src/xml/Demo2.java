package xml;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Demo2 {
	public static void main(String[] args) throws Exception, IOException{
		//��������
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//�õ�dom������
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		
		//����xml�ĵ� �õ��ĵ���document
		Document document = builder.parse("src/book.xml");
		
		
	}
}
