/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad31;

import java.sql.*;

/**
 *Haz un programa que haga los cambios necesarios para que los contenidos de la tabla CLIEN-
TES sean los siguientes: ('78901234X', 'NADALES', '44126'), ('89012345E', 'ROJAS', null),
('56789012B', 'SAMPER', '29730'), partiendo de los contenidos de la tabla resultantes de la
ejecución del programa anterior. El programa debe utilizar sentencias UPDATE y DELETE.
 * 
 * @author Vyacheslav Shylyayev
 */
public class Actividad31 {

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
