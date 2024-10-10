package xml.dom.sax;

import java.io.IOException;
import java.nio.file.Path;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class Main {

	public static void main(String[] args) {

		Path path = Path.of("fichero/ms.xml");
		leer(path);
	}

	private static void leer(Path path) {
	//1 CREAR SAXPARSERFACTORY
		SAXParserFactory factory = SAXParserFactory.newInstance();
	//2 
		SAXParser parser = null;
		try {
			parser= factory.newSAXParser();
		} catch (ParserConfigurationException e) {
			System.err.println("Error: al configurar el parser");
			System.err.println(e.getMessage());
			System.exit(-1);
		} catch (SAXException e) {
			System.err.println("Error: al crear el parser");
			System.err.println(e.getMessage());
			System.exit(-2);
		}
	//3 CREAR xmlREADER
		XMLReader reader = null;
		try {
			reader = parser.getXMLReader();
		} catch (SAXException e) {
			System.err.println("Error: al crear el reader");
			System.err.println(e.getMessage());
			System.exit(-3);
		}
	//4 DEFAULT HANDLER
		reader.setContentHandler(new MiControladorSax()); //depende del ficheri xml en cuestión
		try {
			reader.parse(path.toString());
		} catch (IOException e) {
			System.err.println("Error: al parsear el documento");
			System.err.println(e.getMessage());
			System.exit(-4);
		} catch (SAXException e) {
			System.err.println("Error: al parsear SAXException el documento");
			System.err.println(e.getMessage());
			System.exit(-5);
		}
	}

}
