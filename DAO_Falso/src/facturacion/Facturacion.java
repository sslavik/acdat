/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacion;

import facturacion.DAO.DAO;
import facturacion.models.Cliente;
import facturacion.models.Factura;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Vyacheslav Shylyayev
 */
public class Facturacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        // INSTANCIAMOS EL DAO 
        DAO dao = new DAO();
        
        // CLIENTES
        Cliente c = new Cliente("asd223", "Marta");
        
        // FACTURAS
        Factura f = new Factura(1, new Date(2019,12,1));
        List<Factura> fs = new ArrayList<Factura>();
        fs.add(f);
        fs.add(f);
        
        // INSERTAMOS UN CLIENTE
        System.out.println("Se han introducido : " + dao.insertarCliente(c));
        System.out.println("CLIENTES");
        // OBTENEMOS LO CLIENTES
        List<String> clientes = dao.obtenerClientes();
        
        for(String tmp : clientes){
            System.out.println(tmp);
        }
        // OBTENEMOS EL ID DE UN CLIENTE
        System.out.println(dao.getIdCliente(c));
        // INSERTAMOS FACTURA
        // System.out.println(dao.insertarFactura(f));
        // INSERTAMOS FACTURAS
        // System.out.println(dao.insertarFacturas(fs));
        
        System.out.println(dao.closeConnection());
    }
    
}
