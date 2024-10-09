package xml.dom;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;


import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args) {

		leerXML();
		escribirXML();
	}

	private static void escribirXML() {
		DocumentBuilder builder = createBuilder();
		DOMImplementation implementation = builder.getDOMImplementation();
		Document document = implementation.createDocument(null, null, null);
		document.setXmlVersion("1.0");
		document.setXmlStandalone(true);
		Element alumnos = document.createElement("Alumnos");
		document.appendChild(alumnos);
		
		Element alumno = document.createElement("Alumno");
		alumno.setAttribute("nombre", "Pepito Perez");
		alumno.setAttribute("edad", "2");
		
		Element direccion = document.createElement("Carcel");
		direccion.setTextContent("Soto del Real");
		
		Element telefono = document.createElement("Telefono");
		telefono.setTextContent("666666666");
		
		//ACABAMOS DE CRREAR EL ALUMNO CON SUS HIJOS
		alumno.appendChild(telefono);
		alumno.appendChild(telefono);
		
		//CREAMOS EL ALUMNO DENTRO DE LA ETIQUETA ALUMNOS
		alumnos.appendChild(alumno);
		
	//PASO 6 ES TRASNFORMAR LO QUE HAY EN LA RAM AL FICHERO
		Source origen = new DOMSource(document);
		
		Result result = new StreamResult(new File("fichero/alumnos.xml"));
		
		//PASO 6.2 TRANSFORMAR
		Transformer transf = null;
		try {
			transf = TransformerFactory.newInstance().newTransformer();
		} catch (TransformerConfigurationException e) {
			System.err.println("Error: error al crear el Transformer");
			System.err.println(e.getMessage());
			System.exit(-4);
		} catch (TransformerFactoryConfigurationError e) {
			System.err.println("Error: error al configurar el Transformer");
			System.err.println(e.getMessage());
			System.exit(-5);
		}
		try {
			transf.transform(origen, result);
		} catch (TransformerException e) {
			System.err.println("Error a transformar origne result");
			System.err.println(e.getMessage());
			System.exit(-6);
		}
		
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
