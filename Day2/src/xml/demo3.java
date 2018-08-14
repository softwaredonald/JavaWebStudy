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

//使用DOM方式对xml进行crud
//JAXP技术

public class demo3 {

	@Test
	
	/**
	 * 读取XML文档中，<书名>JavaScript网页技术开发</书名> 节点中的值
	 * @throws Exception
	 */
	public void read1() throws Exception{
		DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
		DocumentBuilder builder =  factory.newDocumentBuilder();
		Document document = builder.parse("src/xml/book.xml");
		
		NodeList list = document.getElementsByTagName("书名");
		Node node = list.item(1);
		
		
		String content = node.getTextContent();
		System.out.println(content);
		
	}
	
	/**
	 * 遍历出这个节点中全部的标签
	 * @throws Exception
	 * 这个案例证明了空格在文档中是有使用的 
	 */
	
	@Test
	public void read2() throws Exception{
		DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
		DocumentBuilder builder =  factory.newDocumentBuilder();
		Document document = builder.parse("src/xml/book.xml");
		
		//递归得到程序的根节点
		Node root = document.getElementsByTagName("书架").item(0);
		list(root);
	}
	private void list(Node node){
		if (node instanceof Element){//加了这个就可以省去其他的text
			System.out.println(node.getNodeName());
		}
		NodeList list = node.getChildNodes();
		for (int i= 0; i<list.getLength();i++){
			Node child = list.item(i);
			list(child);
		}
	}
	
	/**
	 * 得到XML文档中标签属性的值
	 * @throws Exception
	 * 
	 */
	
	@Test
	public void read3() throws Exception{
		DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
		DocumentBuilder builder =  factory.newDocumentBuilder();
		Document document = builder.parse("src/xml/book.xml");
		
		//Node bookname = document.getElementsByTagName("书名").item(0);
		//bookname.getAttributes();//一个集合，如果使用需要再次遍历出来
		
		Element bookname = (Element)document.getElementsByTagName("书名").item(1);
		String name = bookname.getAttribute("name");
		System.out.println(name);
	}
	
	@Test
	//读取出全部属性
	public void read4() throws Exception{
		DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
		DocumentBuilder builder =  factory.newDocumentBuilder();
		Document document = builder.parse("src/xml/book.xml");
		
		//Node bookname = document.getElementsByTagName("书名").item(0);
		//bookname.getAttributes();//一个集合，如果使用需要再次遍历出来
		
		NodeList list = document.getElementsByTagName("书名");
		for (int i = 0;i<list.getLength();i++){
			Element bookname = (Element)document.getElementsByTagName("书名").item(i);
			String name = bookname.getAttribute("name");
			System.out.println(name);
		}
		
		
	}
	
	@Test
	//向xml中增加个节点
	
	public void add1() throws Exception{
		DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
		DocumentBuilder builder =  factory.newDocumentBuilder();
		Document document = builder.parse("src/xml/book.xml");
		
		//创建节点
		Element price = document.createElement("售价");
		price.setTextContent("59.00元");
				
		//把创建的节点挂到第一本书上,只更新内存中的xml
		Element book = (Element)document.getElementsByTagName("书").item(0);
		book.appendChild(price);
		
		
		//把更新完的xml文档写到硬盘的xml文档
		/**
		 * 使用javax中的transformer
		 */
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/xml/book.xml")));
		
	}
	@Test
	/**
	 * 从node中继承过来的，参考节点之前插入标签
	 * @throws Exception
	 */
	public void add2() throws Exception{
		DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
		DocumentBuilder builder =  factory.newDocumentBuilder();
		Document document = builder.parse("src/xml/book.xml");
		
		//创建节点
		Element price = document.createElement("售价");
		price.setTextContent("59.00元");
		
		//得到参考节点
		Element refnod = (Element)document.getElementsByTagName("售价").item(0);
		
		//得到要挂载的节点
		Element book = (Element) document.getElementsByTagName("书").item(0);
		
		//往book节点的指定位置插入
		book.insertBefore(price, refnod);
				
		//把更新完的xml文档写到硬盘的xml文档
		/**
		 * 使用javax中的transformer
		 */
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/xml/book.xml")));
		
	}
	
	
	@Test
	/*
	 * xml 文档中加入属性 <书名 name = "xxxxx">Java就业培训教程</书名>
	 */
	public void add3() throws Exception{
		DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
		DocumentBuilder builder =  factory.newDocumentBuilder();
		Document document = builder.parse("src/xml/book.xml");
		
		Element bookname = (Element)document.getElementsByTagName("书").item(0);
		bookname.setAttribute("name", "aaaaa");
		
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/xml/book.xml")));
	}
	
	
	@Test
	/*
	 * xml 文档中删除“售价”这个属性
	 */
	public void delete1() throws Exception{
		DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
		DocumentBuilder builder =  factory.newDocumentBuilder();
		Document document = builder.parse("src/xml/book.xml");
		
		//得到要删除的节点
		
		Element bookprice = (Element)document.getElementsByTagName("售价").item(0);
		
		//得到要删除的节点的父系
		
		Element book = (Element)document.getElementsByTagName("书").item(0);
		
		
		//由父系删子系
		book.removeChild(bookprice);
		
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/xml/book.xml")));
	}
	
	@Test
	/*
	 * xml 文档中删除“售价”这个标签,简化版本的
	 */
	public void delete2() throws Exception{
		DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
		DocumentBuilder builder =  factory.newDocumentBuilder();
		Document document = builder.parse("src/xml/book.xml");
		
		
		Element bookprice = (Element)document.getElementsByTagName("售价").item(0);
		bookprice.getParentNode().removeChild(bookprice);
		//还可以删除他的父系,整个文档就删干净了。
		//bookprice.getParentNode().getParentNode().getParentNode().removeChild(bookprice.getParentNode().getParentNode())
		
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/xml/book.xml")));
	}
	
	
	@Test
	/*
	 * xml 文档中删除“售价”这个属性,简化版本的
	 */
	public void delete3() throws Exception{
		DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
		DocumentBuilder builder =  factory.newDocumentBuilder();
		Document document = builder.parse("src/xml/book.xml");
		
		
		Element bookprice = (Element)document.getElementsByTagName("售价").item(0);
		bookprice.removeAttribute("售价");
		
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/xml/book.xml")));
	}
	
	@Test
	/*
	 * xml 文档中删除“售价”这个属性,简化版本的
	 */
	public void update1() throws Exception{
		DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
		DocumentBuilder builder =  factory.newDocumentBuilder();
		Document document = builder.parse("src/xml/book.xml");
		
		
		Element bookprice = (Element)document.getElementsByTagName("售价").item(0);
		bookprice.setTextContent("109");
		
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/xml/book.xml")));
	}
	
	
	
	}
	
