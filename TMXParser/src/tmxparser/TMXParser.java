package tmxparser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import org.xml.sax.Attributes;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author Vyacheslav Shylyayev
 */
public class TMXParser {

    // CAMPOS ESTATICOS
    public static final String xmlDocFilePath = "en-es.tmx";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //File fileXML = new File(xmlDocFilePath);

        try {

            XMLReader parserSAX = XMLReaderFactory.createXMLReader(); // SE CREA UN XMLReader EL CUAL SERÁ NUESTRO LECTOR Con el Método Estatico XMLReaderFactorycreateXMLReader()
            // ESTE ULTIMO ES EQUIVALENTE AL DocumentBuilderFactory. Gestiona la configuración de la lectura del XML
            GestorEventos gestorEventos = new GestorEventos(System.out); // LA CLASE QUE GESTIONARÁ EL CONTENIDO PASADO
            parserSAX.setContentHandler(gestorEventos); // EL LECTOR O PARSERSAX LE DECIMOS CUAL ES EL GESTOR UTILIZADO
            parserSAX.parse(xmlDocFilePath); // LE PASAMO EL CONTENIDO QUE TIENE QUE PARSEAR MEDIANTE UNA RUTA ABSOLUTA

        } catch (SAXException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static class GestorEventos extends DefaultHandler {

        // CAMPOS
        PrintStream ps;
        int contador = 1;
        int maxContador = 501;

        // ELEMENTOS Y ATTOS FILTRO APLICADO A NUESTRO ARCHIVO
        String elmCabecera = "header";
        String attIdomaOriginal = "srclang";
        String elmTraduccion = "seg";
        String elmIdioma = "tuv";
        String attTraduccion = "xml:lang";
        String elmContenido = "seg";
        // CONDICIONES A IMPRIMIR
        boolean elementoTraduccion = false;

        public GestorEventos(PrintStream printStream) {
            ps = printStream;
        }

        /**
         * Recorre el contenido de nuestro elemento, tendremos que filtrarlo
         * manualmente para poder saber que contenido escribir y que contenido
         * pasar
         *
         * @param ch Caracter a imprimir
         * @param start
         * @param length
         * @throws SAXException
         */
        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (elementoTraduccion) {
                System.out.print(new String(ch, start, length).trim());
            }
        }

        /**
         * Este método es llamado con el PrintStream pasado ( Que es todo el
         * contenido XML ) para recorrerlo y gestionarlo con todos los
         * parametros encontrados.
         *
         * @param uri
         * @param localName Nombre de cada elemento
         * @param qName Nombre cualificativo de cada elemento
         * @param attributes Todos los atributos encontrados en cada Elemento
         * @throws SAXException Excepción en caso de que no tenga el formato
         * correcto
         */
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

            // IMPRIMIMOS LOS 500 PRIMEROS
            if (contador <= maxContador) {

                // RECORREMOS EL DOM Y BUSCAMOS POR el  LocalName o QualificativeName QUE SEA IGUAL AL QUE BUSCAMOS
                // IMPRIMIMOS EL LENGUAJE ORIGINAL
                if (localName.equals(elmCabecera)) {
                    System.out.println("Lengua original: " + attributes.getValue(attIdomaOriginal) + "\n");
                }

                // IMPRIMIMOS EL CONTADOR
                if (localName.equals("tu")) {
                    System.out.println("[" + contador++ + "]");
                }

                // IMPRIMIMOS TRADUCCION
                if (localName.equals(elmIdioma)) {
                    System.out.print(attributes.getValue(attTraduccion) + "=>");
                }

                // COMPROBAR SI ES EL CONTENIDO A ESCRIBIR
                if (localName.equals(elmContenido)) {
                    elementoTraduccion = true;
                }
            }

        }

        /**
         * Compromabos que tipo de elemento esta terminando para escribir una
         * linea al final
         *
         * @param uri
         * @param localName
         * @param qName
         * @throws SAXException
         */
        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // SALTO DE LINEA DESPUÉS DE CONTENIDO DE TRADUCCION

            if (contador <= maxContador) {
                // LINEA DESPUES DE CADA TRADUCCION
                if (localName.equals("tu")) {
                    System.out.println("______");
                }

                // TERMINAMOS DE ESCRIBIR EL CONTENIDO
                if (localName.equals(elmContenido)) {
                    elementoTraduccion = false;
                    System.out.println("");
                }
            }

        }

    }

}
