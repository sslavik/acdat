/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eft_ad_ej1;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class ManojilloDeBoquerones {
    
    //CAMPOS
    String host = "remotemysql.com";
    String port = "3306";
    String database = "np5tn1dien";
    String user = "np5tn1dien";
    String passwd = "v39eXDt1Z6";
    String paramsAdd = "?useSSL=false";
       
    Connection c;

    String url = String.format("jdbc:mysql://%s:%s/%s%s",host,port,database,paramsAdd);

    // ____________________________________________ CONNECTION ________________________________________________________
    public ManojilloDeBoquerones() {
        try {
            this.c = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            Logger.getLogger(ManojilloDeBoquerones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void closeConnection() throws SQLException{
        c.close();
    }
    // ____________________________________________ CLIENTE ________________________________________________________
    
    
}
