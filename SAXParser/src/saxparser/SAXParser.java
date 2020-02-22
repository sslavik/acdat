package saxparser;

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
public class SAXParser {

    
    // CAMPOS ESTATICOS
    public static final String xmlDocFilePath = "clientes.xml";
    public static final String nodoBuscado = "cliente";
    
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
            
            // IMPRIMIMOS LOS DATOS PEDIDOS AQUÍ
            
            System.out.println("ENCONTRADO " + nodoBuscado + " : " + gestorEventos.conteoNodosEncontrados + " VECES ");
            
        } catch ( SAXException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    private static class GestorEventos extends DefaultHandler{

        // CAMPOS
        PrintStream ps;
        int conteoNodosEncontrados = 0;
        
        public GestorEventos(PrintStream printStream) {
            ps = printStream;
        }
        
        
        /**
         * Este método es llamado con el PrintStream pasado ( Que es todo el contenido XML ) para recorrerlo y gestionarlo con todos los parametros encontrados.
         * @param uri 
         * @param localName Nombre de cada elemento
         * @param qName Nombre cualificativo de cada elemento
         * @param attributes Todos los atributos encontrados en cada Elemento
         * @throws SAXException  Excepción en caso de que no tenga el formato correcto
         */
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            
            // RECORREMOS EL DOM Y BUSCAMOS POR el  LocalName o QualificativeName QUE SEA IGUAL AL QUE BUSCAMOS
            if(localName.equals(nodoBuscado))
                conteoNodosEncontrados++; // CADA VEZ QUE ENCUNTRA EL NODO BUSCADO AÑADE 1 AL CONTADOR
            
        }
        
        
        
    }
    
}
