import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.w3c.dom.Document;

public class ReadandTransform {

	public org.w3c.dom.Document readXML(String XMLfilePath) {
		org.w3c.dom.Document document = null;
		try {
			java.io.File inputXMLFile = new java.io.File(XMLfilePath);
			javax.xml.parsers.DocumentBuilderFactory documentBuilderFactory = javax.xml.parsers.DocumentBuilderFactory
					.newInstance();
			javax.xml.parsers.DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			document = documentBuilder.parse(inputXMLFile);		
		} catch (javax.xml.parsers.ParserConfigurationException parserConfigurationException) {
			System.out.println("ParserConfigurationException");
			parserConfigurationException.printStackTrace();
		} catch (org.xml.sax.SAXException saxException) {
			System.out.println("SAXException");
			saxException.printStackTrace();
		} catch (java.io.IOException e) {
			System.out.println("IOException");
			e.printStackTrace();
		}
		return document;
	}
	public Document readXml(Document document, String fileName) throws IOException {
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(fileName));
	    StringBuilder sb = new StringBuilder();
	    String line = br.readLine();
	    
	    while (line != null) {
	        sb.append(line);
	        sb.append("\n");
	        line = br.readLine();
	    }
		
		return document;
	}
	public void transformXML(org.w3c.dom.Document document, String inputXMLFile) {
		try {
			javax.xml.transform.TransformerFactory transformerFactory = javax.xml.transform.TransformerFactory
					.newInstance();
			javax.xml.transform.Transformer transformer = transformerFactory.newTransformer();
			javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(document);
			javax.xml.transform.stream.StreamResult result = new javax.xml.transform.stream.StreamResult(inputXMLFile);
			transformer.transform(source, result);
		} catch (javax.xml.transform.TransformerConfigurationException transformerConfigurationException) {
			System.out.println("TransformerConfigurationException");
			transformerConfigurationException.printStackTrace();
		} catch (javax.xml.transform.TransformerException transformerException) {
			System.out.println("TransformerException");
			transformerException.printStackTrace();
		}

	}
}
