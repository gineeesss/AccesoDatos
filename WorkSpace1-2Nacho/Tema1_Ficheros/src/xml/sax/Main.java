package xml.sax;

import java.io.IOException;
import java.nio.file.Path;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class Main {

	public static void main(String[] args) {

		Path path = Path.of("ficheros/ms.xml");
		leerXML(path);

	}

	private static void leerXML(Path path) {
		// PASO 1
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// PASO 2
		SAXParser parser = null;

		try {
			parser = factory.newSAXParser();
		} catch (ParserConfigurationException e) {
			System.err.println("No se ha podido crear el nuevo SaxParser");
			System.err.println(e.getMessage());
			System.exit(-1);
		} catch (SAXException e) {
			System.err.println("No se ha podido crear el nuevo SaxParser SAXEception");
			System.err.println(e.getMessage());
			System.exit(-2);
		}
		// PASO 3 XMLReader
		XMLReader reader = null;

		try {
			reader = parser.getXMLReader();
		} catch (SAXException e) {
			System.err.println("No se ha podido crear XMLReader");
			System.err.println(e.getMessage());
			System.exit(-3);
		}
		// PASO 4 Default Handler

		reader.setContentHandler(new MiControladoSax());// depende del fichero XML en cuestión
		try { // PASO 5 Parsear el documento
			reader.parse(path.toString());
		} catch (IOException e) {
			System.err.println("Error al parsear el documento: " + path.toString());
			System.err.println(e.getMessage());
			System.exit(-4);
		} catch (SAXException e) {
			System.err.println("Error al parsear SAXEcxception el documento: " + path.toString());
			System.err.println(e.getMessage());
			System.exit(-5);
		}
	}

}
