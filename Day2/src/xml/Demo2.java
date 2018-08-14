package xml;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Demo2 {
	public static void main(String[] args) throws Exception, IOException{
		//创建工厂
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//得到dom解析器
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		
		//解析xml文档 得到文档的document
		Document document = builder.parse("src/book.xml");
		
		
	}
}
