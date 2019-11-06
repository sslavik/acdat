/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad32;

import java.sql.*;

/**
 *El código postal (columna CP) está definido con tipo CHAR(5) en la tabla CLIENTES, pero es siem-
pre un número entero. ¿Se podría utilizar getInt() en lugar de getString() para recuperar
su valor? Cambia el programa y verifica tu hipótesis, o justifica los resultados si no son los que
esperabas.
* 
 * @author Vyacheslav Shylyayev
 */
public class Actividad32 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ad?useSSL=false", "ad", "123");
                Statement s = c.createStatement();
                ResultSet rs = s.executeQuery("SELECT * FROM CLIENTES")){
            System.out.println("Conexión realizada");
            int i = 0;
            while (rs.next()) {
                
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
