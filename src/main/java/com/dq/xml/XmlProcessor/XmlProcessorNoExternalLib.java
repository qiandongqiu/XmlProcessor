package com.dq.xml.XmlProcessor;
import java.net.URL;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;




public class XmlProcessorNoExternalLib {
	public static void mainProcessor(String[] args) {
	try {
        File inputFile = new File("sample.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
        NodeList nList = doc.getElementsByTagName("tutorial");
        System.out.println("----------------------------");
        
        for (int temp = 0; temp < nList.getLength(); temp++) {
           Node nNode = nList.item(temp);
           System.out.println("\nCurrent Element :" + nNode.getNodeName());
           
           if (nNode.getNodeType() == Node.ELEMENT_NODE) {
              Element eElement = (Element) nNode;
              System.out.println("type : " 
                 + eElement.getAttribute("type"));
              System.out.println("author : " 
                 + eElement
                 .getElementsByTagName("author")
                 .item(0)
                 .getTextContent());
              
           }
        }
           
           // try to do some update
        //  see ref: https://www.tutorialspoint.com/java_xml/java_dom_modify_document.htm
           Element anotherTutorial = doc.createElement("tutorial");
           Element anotherAuthor = doc.createElement("author");
           anotherAuthor.appendChild(doc.createTextNode("dq test author one"));
           anotherTutorial.appendChild(anotherAuthor);
           
           doc.getDocumentElement().appendChild(anotherTutorial);
           
           // write the content into xml file
           TransformerFactory transformerFactory = TransformerFactory.newInstance();
           Transformer transformer = transformerFactory.newTransformer();
           DOMSource source = new DOMSource(doc);
           StreamResult result = new StreamResult(new File("sample_added_newnode.xml"));
           transformer.transform(source, result);
           
           // Output to console for testing
           StreamResult consoleResult = new StreamResult(System.out);
           transformer.transform(source, consoleResult);
           
           
        
     } catch (Exception e) {
        e.printStackTrace();
     }
  }
}
