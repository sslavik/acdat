
package conexionbd;

import java.sql.*;

/**
 *
 * @author usuario
 */
public class ConexionBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ad?useSSL=false", "ad", "123");){
            System.out.println("Conexión realizada");
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
        
    }
    
}
