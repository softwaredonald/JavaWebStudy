package Utils;

import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class XMLUtils {
	//工具类，通常是静态的
	private static String filename = "src/exam.xml";
	
	public static Document getDocument() throws Exception{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		return builder.parse(filename);
	}
	
	//thinking in java java spring：编译时异常， 运行时异常
	//特定场景想把异常当成返回值时，使用编译时异常
	
	public static void write2Xml(Document document) throws Exception{
		TransformerFactory factory =  TransformerFactory.newInstance();
		Transformer tf = factory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream(filename)));
	}
	
	
}
