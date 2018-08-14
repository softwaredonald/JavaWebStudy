package xml;

import java.io.FileOutputStream;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

//ʹ��DOM��ʽ��xml����crud
//JAXP����

public class demo3 {

	@Test
	
	/**
	 * ��ȡXML�ĵ��У�<����>JavaScript��ҳ��������</����> �ڵ��е�ֵ
	 * @throws Exception
	 */
	public void read1() throws Exception{
		DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
		DocumentBuilder builder =  factory.newDocumentBuilder();
		Document document = builder.parse("src/xml/book.xml");
		
		NodeList list = document.getElementsByTagName("����");
		Node node = list.item(1);
		
		
		String content = node.getTextContent();
		System.out.println(content);
		
	}
	
	/**
	 * ����������ڵ���ȫ���ı�ǩ
	 * @throws Exception
	 * �������֤���˿ո����ĵ�������ʹ�õ� 
	 */
	
	@Test
	public void read2() throws Exception{
		DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
		DocumentBuilder builder =  factory.newDocumentBuilder();
		Document document = builder.parse("src/xml/book.xml");
		
		//�ݹ�õ�����ĸ��ڵ�
		Node root = document.getElementsByTagName("���").item(0);
		list(root);
	}
	private void list(Node node){
		if (node instanceof Element){//��������Ϳ���ʡȥ������text
			System.out.println(node.getNodeName());
		}
		NodeList list = node.getChildNodes();
		for (int i= 0; i<list.getLength();i++){
			Node child = list.item(i);
			list(child);
		}
	}
	
	/**
	 * �õ�XML�ĵ��б�ǩ���Ե�ֵ
	 * @throws Exception
	 * 
	 */
	
	@Test
	public void read3() throws Exception{
		DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
		DocumentBuilder builder =  factory.newDocumentBuilder();
		Document document = builder.parse("src/xml/book.xml");
		
		//Node bookname = document.getElementsByTagName("����").item(0);
		//bookname.getAttributes();//һ�����ϣ����ʹ����Ҫ�ٴα�������
		
		Element bookname = (Element)document.getElementsByTagName("����").item(1);
		String name = bookname.getAttribute("name");
		System.out.println(name);
	}
	
	@Test
	//��ȡ��ȫ������
	public void read4() throws Exception{
		DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
		DocumentBuilder builder =  factory.newDocumentBuilder();
		Document document = builder.parse("src/xml/book.xml");
		
		//Node bookname = document.getElementsByTagName("����").item(0);
		//bookname.getAttributes();//һ�����ϣ����ʹ����Ҫ�ٴα�������
		
		NodeList list = document.getElementsByTagName("����");
		for (int i = 0;i<list.getLength();i++){
			Element bookname = (Element)document.getElementsByTagName("����").item(i);
			String name = bookname.getAttribute("name");
			System.out.println(name);
		}
		
		
	}
	
	@Test
	//��xml�����Ӹ��ڵ�
	
	public void add1() throws Exception{
		DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
		DocumentBuilder builder =  factory.newDocumentBuilder();
		Document document = builder.parse("src/xml/book.xml");
		
		//�����ڵ�
		Element price = document.createElement("�ۼ�");
		price.setTextContent("59.00Ԫ");
				
		//�Ѵ����Ľڵ�ҵ���һ������,ֻ�����ڴ��е�xml
		Element book = (Element)document.getElementsByTagName("��").item(0);
		book.appendChild(price);
		
		
		//�Ѹ������xml�ĵ�д��Ӳ�̵�xml�ĵ�
		/**
		 * ʹ��javax�е�transformer
		 */
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/xml/book.xml")));
		
	}
	@Test
	/**
	 * ��node�м̳й����ģ��ο��ڵ�֮ǰ�����ǩ
	 * @throws Exception
	 */
	public void add2() throws Exception{
		DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
		DocumentBuilder builder =  factory.newDocumentBuilder();
		Document document = builder.parse("src/xml/book.xml");
		
		//�����ڵ�
		Element price = document.createElement("�ۼ�");
		price.setTextContent("59.00Ԫ");
		
		//�õ��ο��ڵ�
		Element refnod = (Element)document.getElementsByTagName("�ۼ�").item(0);
		
		//�õ�Ҫ���صĽڵ�
		Element book = (Element) document.getElementsByTagName("��").item(0);
		
		//��book�ڵ��ָ��λ�ò���
		book.insertBefore(price, refnod);
				
		//�Ѹ������xml�ĵ�д��Ӳ�̵�xml�ĵ�
		/**
		 * ʹ��javax�е�transformer
		 */
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/xml/book.xml")));
		
	}
	
	
	@Test
	/*
	 * xml �ĵ��м������� <���� name = "xxxxx">Java��ҵ��ѵ�̳�</����>
	 */
	public void add3() throws Exception{
		DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
		DocumentBuilder builder =  factory.newDocumentBuilder();
		Document document = builder.parse("src/xml/book.xml");
		
		Element bookname = (Element)document.getElementsByTagName("��").item(0);
		bookname.setAttribute("name", "aaaaa");
		
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/xml/book.xml")));
	}
	
	
	@Test
	/*
	 * xml �ĵ���ɾ�����ۼۡ��������
	 */
	public void delete1() throws Exception{
		DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
		DocumentBuilder builder =  factory.newDocumentBuilder();
		Document document = builder.parse("src/xml/book.xml");
		
		//�õ�Ҫɾ���Ľڵ�
		
		Element bookprice = (Element)document.getElementsByTagName("�ۼ�").item(0);
		
		//�õ�Ҫɾ���Ľڵ�ĸ�ϵ
		
		Element book = (Element)document.getElementsByTagName("��").item(0);
		
		
		//�ɸ�ϵɾ��ϵ
		book.removeChild(bookprice);
		
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/xml/book.xml")));
	}
	
	@Test
	/*
	 * xml �ĵ���ɾ�����ۼۡ������ǩ,�򻯰汾��
	 */
	public void delete2() throws Exception{
		DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
		DocumentBuilder builder =  factory.newDocumentBuilder();
		Document document = builder.parse("src/xml/book.xml");
		
		
		Element bookprice = (Element)document.getElementsByTagName("�ۼ�").item(0);
		bookprice.getParentNode().removeChild(bookprice);
		//������ɾ�����ĸ�ϵ,�����ĵ���ɾ�ɾ��ˡ�
		//bookprice.getParentNode().getParentNode().getParentNode().removeChild(bookprice.getParentNode().getParentNode())
		
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/xml/book.xml")));
	}
	
	
	@Test
	/*
	 * xml �ĵ���ɾ�����ۼۡ��������,�򻯰汾��
	 */
	public void delete3() throws Exception{
		DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
		DocumentBuilder builder =  factory.newDocumentBuilder();
		Document document = builder.parse("src/xml/book.xml");
		
		
		Element bookprice = (Element)document.getElementsByTagName("�ۼ�").item(0);
		bookprice.removeAttribute("�ۼ�");
		
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/xml/book.xml")));
	}
	
	@Test
	/*
	 * xml �ĵ���ɾ�����ۼۡ��������,�򻯰汾��
	 */
	public void update1() throws Exception{
		DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
		DocumentBuilder builder =  factory.newDocumentBuilder();
		Document document = builder.parse("src/xml/book.xml");
		
		
		Element bookprice = (Element)document.getElementsByTagName("�ۼ�").item(0);
		bookprice.setTextContent("109");
		
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/xml/book.xml")));
	}
	
	
	
	}
	
