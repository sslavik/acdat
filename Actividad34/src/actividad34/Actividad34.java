/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad34;

import java.sql.*;

/**
 *
 * @author usuario
 */
public class Actividad34 {

    /**
     * @param args the command line arguments
     */
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ad?useSSL=false", "ad", "123");
                PreparedStatement s = c.prepareStatement("SELECT * FROM CLIENTES");
                ResultSet rs = s.executeQuery()){
            System.out.println("Conexión realizada");
            int posicion = 0;
            
            rs.last();
            
            posicion = rs.getRow();
            
            System.out.println("La tabla tiene " + posicion + " filas");
            
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    
}
