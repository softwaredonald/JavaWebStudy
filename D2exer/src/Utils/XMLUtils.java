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
	//�����࣬ͨ���Ǿ�̬��
	private static String filename = "src/exam.xml";
	
	public static Document getDocument() throws Exception{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		return builder.parse(filename);
	}
	
	//thinking in java java spring������ʱ�쳣�� ����ʱ�쳣
	//�ض���������쳣���ɷ���ֵʱ��ʹ�ñ���ʱ�쳣
	
	public static void write2Xml(Document document) throws Exception{
		TransformerFactory factory =  TransformerFactory.newInstance();
		Transformer tf = factory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream(filename)));
	}
	
	
}
