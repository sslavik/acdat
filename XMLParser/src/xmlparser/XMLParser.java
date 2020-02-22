package xmlparser;

import java.io.File;
import java.io.FileNotFoundException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;


/**
 *
 * @author Vyacheslav Shylyayev
 */
public class XMLParser {

    
    // CAMPOS ESTATICOS
    public static final String xmlDocFilePath = "clientes.xml";
    public static final String nodoBuscado = "cliente";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File fileXML = new File(xmlDocFilePath);
        
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); // CREAMOS UN DocumentBuilderFactory PARA CONFIGURAR LA LECTURA DE NUESTRO ARCHIVO
        dbf.setIgnoringComments(true); // IGNORAMOS LOS NODOS COMENTARIOS
        dbf.setIgnoringElementContentWhitespace(true); // IGNORAMOS LOS ESPACIOS EN BLANCO

        try {
            DocumentBuilder db = dbf.newDocumentBuilder(); // CREAMOS UN DocumentBuilder CON LA CONFIG PASADA
            Document domDoc = db.parse(fileXML); // PARSEAMOS EL File a un org.w3c.dom.Document EL CUAL PODRÁ RECORRER EL DOM 
            
            // IMPRIMOS LOS DATOS PEDIDOS
            
            System.out.println("El archivo : " + xmlDocFilePath);
            System.out.println("El nodo : " + nodoBuscado + " Esta : " + domDoc.getElementsByTagName(nodoBuscado).getLength());
            
        } catch (FileNotFoundException | ParserConfigurationException
                | SAXException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
