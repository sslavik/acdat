
package xpathbuscacliente;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 *
 * @author Vyacheslav Shylyayev
 */
public class XpathBuscaCliente {

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
            Document docXML = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(clientesFilePath);
            XPathExpression expression = XPathFactory.newInstance().newXPath().compile("//"+nodoBuscado+"[@DNI='"+dniBuscado+"']");
            
            System.out.println("RESULTADO : ");
            
            // GUARDAMOS EL RESULTADO DEL XPATHEVALUATE EN UN NodeList
            NodeList nodeList = (NodeList) expression.evaluate(docXML, XPathConstants.NODESET);
            
            if(nodeList.getLength() < 1){
                System.out.println("NO EXISTE EL CLIENTE CON EL DNI PASADO");
            }
            else {
                for (int i = 0; i < nodeList.getLength(); i++) {
                    NodeList datosCliente = nodeList.item(i).getChildNodes();
                    for (int j = 0; j < datosCliente.getLength(); j++) {
                        if(datosCliente.item(j).getNodeName().equals("apellidos"))
                            System.out.println("-- NOMBRE : " + datosCliente.item(j).getTextContent());
                        if(datosCliente.item(j).getNodeName().equals("CP"))
                            System.out.println("-- CODIGO POSTAL : " + datosCliente.item(j).getTextContent());
                          
                    }
                }
            }
           
        } catch (Exception e){
            e.printStackTrace();
        }
            
    }
    
}
