/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad35;

import java.sql.*;

/**
 *
 * @author usuario
 */
public class Actividad35 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // TODO code application logic here
        try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ad?useSSL=false", "ad", "123");
                PreparedStatement s = c.prepareStatement("SELECT * FROM CLIENTES WHERE DNI = ?");
                ){
            System.out.println("Conexión realizada");
            int posicion = 0;
            
            s.setString(1, "78901234X");
            
            ResultSet rs = s.executeQuery();
            rs.next();
            System.out.println("DNI : " + rs.getString("DNI"));
            System.out.println("APELLIDOS : " + rs.getString("APELLIDOS"));
            
            
            System.out.println("La tabla tiene " + posicion + " filas");
            rs.close();
            
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    
}
