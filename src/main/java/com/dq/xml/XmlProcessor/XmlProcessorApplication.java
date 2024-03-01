package com.dq.xml.XmlProcessor;

import org.dom4j.DocumentException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class XmlProcessorApplication {

	public static void main(String[] args) throws DocumentException {
		
		ReadXmlExample readXmlExample = new ReadXmlExample();
		readXmlExample.findId("01");
		
		XmlProcessorNoExternalLib.mainProcessor(args);
		
		SpringApplication.run(XmlProcessorApplication.class, args);
	}

}
