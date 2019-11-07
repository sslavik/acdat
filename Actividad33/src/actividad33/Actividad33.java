/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad33;

import java.sql.*;

/**
 *
 * @author usuario
 */
public class Actividad33 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ad?useSSL=false", "ad", "123");
                PreparedStatement ps = c.prepareStatement("SELECT * FROM CLIENTES", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CLOSE_CURSORS_AT_COMMIT);
                ResultSet rs = ps.executeQuery()){
            System.out.println("Conexión realizada");
            int i = 0;
            rs.afterLast();
            while (rs.previous()){
                System.err.println("_________ CLIENTE "+ i++ + "_________");
                System.out.println("DNI : " + rs.getString("DNI"));
                System.out.println("APELLIDOS : " + rs.getString("APELLIDOS"));
                System.out.println("CP : " + rs.getInt("CP")); // EN CASO DE QUE DEVUELVA NULL SERÁ 0
                
            }
            
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    
}
