/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao_falso;

import dao_falso.DAO.DAO;
import dao_falso.models.Cliente;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Vyacheslav Shylyayev
 */
public class DAO_Falso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Cliente c = new Cliente("asd223", "Marta");
        DAO D_cliete = new DAO();
        System.out.println("Se han introducido : " + D_cliete.insertarCliente(c));
        System.out.println("CLIENTES");
        List<String> clientes = D_cliete.obtenerClientes();
        
        for(String tmp : clientes){
            System.out.println(tmp);
        }
        
        System.out.println(D_cliete.closeConnection());
    }
    
}
