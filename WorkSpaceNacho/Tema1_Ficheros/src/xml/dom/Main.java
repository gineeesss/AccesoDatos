package xml.dom;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args) {
		// leerXml();
		escribirXML();

	}

	private static void escribirXML() {
		/*
		 * <alumnos> <alumno nombre="Alvaro" edad="28"> <direccion>C/Falsa
		 * 1234</direccion> <telefono>987654321</telefono> </alumno> </alumnos>
		 */
		DocumentBuilder builder = createBuilder();
		DOMImplementation implementation = builder.getDOMImplementation();
		Document document = implementation.createDocument(null, null, null);
		// paso 5
		document.setXmlVersion("1.0");
		document.setXmlStandalone(true);
		// Alumnos
		Element alumnos = document.createElement("Alumnos");
		document.appendChild(alumnos);
		// alumno
		Element alumno = document.createElement("Alumno");
		alumno.setAttribute("nombre", "Pablo Motos");
		alumno.setAttribute("edad", "48");

		// direccion
		Element direccion = document.createElement("Direccion");
		direccion.setTextContent("C/ El Hormigero,109");

		// telefono
		Element telefono = document.createElement("Telefono");
		telefono.setTextContent("656769889");
		// acabamos de crear el alumno con sus hijos(dir,tlfn)
		alumno.appendChild(direccion);
		alumno.appendChild(telefono);
		// creamos el alumno dentro de la etiqueta alumnos
		alumnos.appendChild(alumno);
		// PASO 6 es transformar lo que hay en la RAM al fichero
		// PASO 6.1 origen (RAM) y destino (Disco)
		Source origen = new DOMSource(document);
		Result result = new StreamResult(new File("ficheros/alumnos.xml"));
		// PASO 6.2 Transformar
		Transformer transf = null;

		try {
			transf = TransformerFactory.newInstance().newTransformer();
		} catch (TransformerConfigurationException e) {
			System.err.println("Error al crear el Transfomer");
			System.out.println(e.getMessage());
			System.exit(-4);
		} catch (TransformerFactoryConfigurationError e) {
			System.err.println("Error al configurar el Transfomer");
			System.out.println(e.getMessage());
			System.exit(-5);
		}
		try {
			transf.transform(origen, result);
		} catch (TransformerException e) {
			System.err.println("Error al transformar el origen en el destino");
			System.out.println(e.getMessage());
			System.exit(-6);
		}

	}

	private static void leerXml() {
		// PASOS PREVIOS

		Path path = Path.of("ficheros/ms.xml");
		File xml = path.toFile();
		// PRIMER PASO LEER DOM
		DocumentBuilder builder = createBuilder();
		// TERCER PASO DE LEER EL DOM
		Document document = null;

		try {
			document = builder.parse(xml);
		} catch (SAXException e) {
			System.err.println("Error al crear el Document");
			System.err.println(e.getMessage());
			System.exit(-2);
		} catch (IOException e) {
			System.err.println("Error al cargar el fichero en la RAM");
			System.err.println(e.getMessage());
			System.exit(-3);
		}
		// PASO 4 DE LEER EL XML, ES ESPECIFICO DEL FICHERO A TRATAR
		NodeList listaInicial = document.getElementsByTagName("Tests").item(0).getChildNodes();
		// PASO 5: procesar nodo a nodo en función de que nodo esté procesando
		switchNodos(listaInicial);
	}

	private static void switchNodos(NodeList lista) {
		for (int i = 0; i < lista.getLength(); i++) {
			Node node = lista.item(i);

			if (node.getNodeType() == Node.ELEMENT_NODE) {
				switch (node.getNodeName()) {
				case "Test":
					String id = node.getAttributes().getNamedItem("TestId").getNodeValue();
					String type = node.getAttributes().getNamedItem("TestType").getNodeValue();
					System.out.print(node.getNodeName() + "\t-\t" + id + "\t-\t" + type);
					System.out.println();
					NodeList listaHijos = node.getChildNodes();
					switchNodos(listaHijos);
					break;
				default:
					System.out.println("\t" + node.getNodeName() + " --> " + node.getTextContent());
					break;
				}

			}

		}

	}

	private static DocumentBuilder createBuilder() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		// SEGUNDO PASO DE LEER EN EL DOM
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			System.err.println("Error al crear el DocumentBuilder");
			System.err.println(e.getMessage());
			System.exit(-1);
		}

		return builder;
	}

}
