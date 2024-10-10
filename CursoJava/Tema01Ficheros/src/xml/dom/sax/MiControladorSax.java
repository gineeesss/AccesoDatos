package xml.dom.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MiControladorSax extends DefaultHandler {

	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		System.out.print("Iniciando el procesado del documento XML...");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		switch(qName){
		case "Tests":
			System.out.print("Listados de tests que se van a ejecutar");
			break;
		case "Test":
			String id = attributes.getValue("TestId");
			String tipo = attributes.getValue(1);
			System.out.print("\tTest (id):"+id+", del tipo :"+tipo);
			//ASI VAMOS RECUPERANDO LOS ATRIBUTOS DE LA ETIQUETA E IMPRIMIMOS
			break;
		case "Name":
			System.out.print("Nombre del test :  ");
			break;
		case "Commandline":
			System.out.print("Nombre del test a ejecutar:  ");
			break;
		case "Input":
			System.out.print("Nombre del test ejecutado :  ");
			break;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
		String texto = new String(ch,start,length);
		if(texto.length()>0) {
			System.out.print(texto);
		}
	}



}
