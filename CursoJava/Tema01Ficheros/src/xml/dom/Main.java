package xml.dom;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args) {

		leerXML();
		escribir();
	}

	private static void leerXML() {
		Path path = Path.of("fichero/ms.xml");
		File xml =path.toFile();
		//PASO 1 LEER DOM
		DocumentBuilder builder = createBuilder();
		//PASO 3 LEER EL DOM
		Document document = null;
		try {
			document = builder.parse(xml);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//PASO 4 LEER EL XML, ES ESPECIFICO EL FICHERO A TRATAR
		NodeList listaInicial=document.getElementsByTagName("Tests").item(0).getChildNodes();
		//PASO 5 PROCESAR NODO A NODO EN FUNCIÓN DE QUE NODO ESTÉ PROCESANDO
		switchNodos(listaInicial);
		
	}

	private static void switchNodos(NodeList listaInicial) {
		for(int i= 0; i<listaInicial.getLength();i++) {
			Node node = listaInicial.item(i);
			if(node.getNodeType()==Node.ELEMENT_NODE) {
				switch(node.getNodeName()){
					case "Test":
						String id = node.getAttributes().getNamedItem("TestId").getNodeValue();
						String type = node.getAttributes().getNamedItem("TestType").getNodeValue();
						System.out.println(node.getNodeName());
						break;
					case "":
						break;
				}
			}
		}
		
	}

	private static DocumentBuilder createBuilder() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder= null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return builder;
	}

	private static void escribir() {
		// TODO Auto-generated method stub
		
	}

}
