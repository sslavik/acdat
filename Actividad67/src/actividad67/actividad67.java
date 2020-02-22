
package actividad67;

import java.io.PrintStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Vyacheslav Shylyayev
 */
public class actividad67 {
    
    private static final String INDENT_NIVEL = "  ";  // Para indentación
    
    public static void muestraNodo(Node nodo, int nivel, PrintStream ps) {
        if (nodo.getNodeType() == Node.TEXT_NODE) { // Ignora textos vacíos
            String text = nodo.getNodeValue();
            if (text.trim().length() == 0) {
                return;
            }
        }
        for (int i = 0; i < nivel; i++) {    // Indentación
            ps.print(INDENT_NIVEL);
        }
        switch (nodo.getNodeType()) {  // Escribe información de nodo según tipo
            case Node.DOCUMENT_NODE:  // Documento
                Document doc = (Document) nodo;
                ps.println("Documento DOM, versión: " + doc.getXmlVersion()
                        + ", codificación: " + doc.getXmlEncoding());
                break;
            case Node.ELEMENT_NODE:    // Elemento
                ps.print("<" + nodo.getNodeName());
                NamedNodeMap listaAtr = nodo.getAttributes();  // Lista atributos
                for (int i = 0; i < listaAtr.getLength(); i++) {
                    Node atr = listaAtr.item(i);
                    ps.print(" @" + atr.getNodeName() + "[" + atr.getNodeValue() + "]");
                }
                ps.println(">");
                break;
            case Node.TEXT_NODE:    // Texto
                ps.println(nodo.getNodeName() + "[" + nodo.getNodeValue() + "]");
                break;
            default:    // Otro tipo de nodo
                ps.println("(nodo de tipo: " + nodo.getNodeType() + ")");
        }
        NodeList nodosHijos = nodo.getChildNodes();    // Muestra nodos hijos
        for (int i = 0; i < nodosHijos.getLength(); i++) {
            muestraNodo(nodosHijos.item(i), nivel + 1, ps);
        }
    }
    

    // CAMPOS
    public static final String clientesFilePath = "clientes.xml";
    public static final String nodoBuscado = "cliente";

    
    public static void main(String[] args) {
        
        String dniBuscado = "";
        
        if(args.length != 1){
            System.out.println("ERROR : Los parametros pasados no son los correctos");
            System.out.println("ESPERADO : DNI de cliente buscado");
            System.exit(0);
        }
        
        if(args.length == 1){
            dniBuscado = args[0];
        }
        try{
            //  PARA QUE FUNCIONE CORRECTAMENTE TENDREMOS QUE CONFIGURAR EL DocumentBuilder PARA QUE IGNORE COMENTARIOS Y ESPACIOS EN BLANCO
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setIgnoringComments(true);
            dbf.setIgnoringElementContentWhitespace(true);
            
            Document docXML = dbf.newDocumentBuilder().parse(clientesFilePath);
            XPathExpression expression = XPathFactory.newInstance().newXPath().compile("//"+nodoBuscado+"[@DNI='"+dniBuscado+"']");
            
            System.out.println("RESULTADO : ");
            
            // USAMOS EL METODO AQUI
            int nivel = 0;
            
            // OBTENEMOS EL NIVEL A MOSTRAR
            muestraNodo((Node)expression.evaluate(docXML, XPathConstants.NODE), 0, System.out);
            
           
        } catch (Exception e){
            e.printStackTrace();
        }
            
    }
    
}
