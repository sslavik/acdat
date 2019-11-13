/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad.pkg36;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Actividad36 {

    public static void muestraErrorSQL(SQLException e) {
        System.err.println("SQL ERROR mensaje: " + e.getMessage());
        System.err.println("SQL Estado: " + e.getSQLState());
        System.err.println("SQL código específico: " + e.getErrorCode());
    }

    public static void main(String[] args) {

        String basedatos = "np5tn1dien";
        String host = "remotemysql.com";
        String port = "3306";
        String parAdic = "?useUnicode=true&useSSL=false";
        String urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + basedatos + parAdic;
        String user = "np5tn1dien";
        String pwd = "v39eXDt1Z6";

        try (
                Connection c = DriverManager.getConnection(urlConnection, user, pwd)) {
            try (
                    PreparedStatement sInsert = c.prepareStatement("INSERT INTO CLIENTES1(DNI,APELLIDOS,CP) VALUES (?,?,?);")) {


                int i = 0;
                sInsert.setString(++i, "54320198V");
                sInsert.setString(++i, "CARVAJAL");
                sInsert.setString(++i, "10109");
                sInsert.executeUpdate();

                sInsert.setString(i = 1, "76543210S");
                sInsert.setString(++i, "MARQUEZ");
                sInsert.setString(++i, "46987");
                sInsert.executeUpdate();

                sInsert.setString(i = 1, "90123456A");
                sInsert.setString(++i, "MOLINA");
                sInsert.setString(++i, "35153");
                sInsert.executeUpdate();


            } catch (SQLException e) {
                muestraErrorSQL(e);
                try {
                } catch (Exception er) {
                    System.err.println("ERROR haciendo ROLLBACK");
                    er.printStackTrace(System.err);
                }
            }
        } catch (Exception e) {
            System.err.println("ERROR de conexión");
            e.printStackTrace(System.err);
        }
    }

}
