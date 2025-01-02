package xml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MiControladoSax extends DefaultHandler {

	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		System.out.println("Iniciando el procesado del documento XML ...");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);

		switch (qName) {
		case "Tests":
			System.out.println("Listados de tests que se van a ejecutar : ");
			break;
		case "Test":
			String id = attributes.getValue("TestId");
			// String tipo=attributes.getValue("TestType");
			String tipo = attributes.getValue(1);
			System.out.println("\t Test (id):" + id + ", del tipo :" + tipo);
			// así vamos recuperando los atributos de la etiqueta e imprimimos

			break;
		case "Name":
			System.out.print("\t\t Nombre del test :\t");
			break;
		case "CommandLine":
			System.out.print("\t\t Comando del test a ejecutar :\t");
			break;
		case "Input":
			System.out.print("\t\t Datos de entrada del test a ejecutar :\t");
			break;
		case "Output":
			System.out.print("\t\t Datos de salida del test ejecutado :\t");
			break;

		}

	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {

		super.characters(ch, start, length);
		String texto = new String(ch, start, length).trim();
		if (texto.length() > 0) {
			System.out.println(texto);
		}

	}

}
