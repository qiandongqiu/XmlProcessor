package com.dq.xml.XmlProcessor;

import java.util.Iterator;
import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class ReadXmlExample {
	//this one uses DOM4J, I prefer to use the one inside java
	public void findId(String id) throws DocumentException {
		File file = new File("sample.xml");
		SAXReader reader = new SAXReader();
		Document document = reader.read(file);
		List<Node> elements = document.selectNodes("//*[@tutId='" + id + "']");
		//return elements.get(0);
		System.out.println(elements.get(0));
		
		
		// make change, and write out
		for (Node node : elements) {
		    Element element = (Element)node;
		    Iterator<Element> iterator = element.elementIterator("title");
		    while (iterator.hasNext()) {
		        Element title =(Element)iterator.next();
		        title.setText(title.getText() + " updated");
		    }
		}
		try {
		XMLWriter writer = new XMLWriter(
		  new FileWriter(new File("example_updated.xml")));
		writer.write(document);
		writer.close();
		} catch(IOException e) {
			System.out.println("ERROR:"+e.getMessage());
		}
	}

}
