/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao_falso.DAO;

import com.mysql.jdbc.MySQLConnection;
import dao_falso.models.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vyacheslav Shylyayev
 */
public class DAO {
    
    String host = "remotemysql.com";
    String database = "np5tn1dien";
    String passwd = "v39eXDt1Z6";
    String user = "np5tn1dien";
    String port = "3306";
    String paramsAdd = "?useSSL=false";
    Connection c;
    
    String url = String.format("jdbc:mysql://%s:%s/%s%s",host,port,database,paramsAdd);

    public DAO() {
        
        try {
            this.c = DriverManager.getConnection(url, user, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int insertarCliente(Cliente cliente){

        try {
            PreparedStatement ps = c.prepareStatement("insert into cliente (dni, nom_cliente) values(?,?) on duplicate key update nom_cliente = ?");
            int i = 0;
            ps.setString(++i, cliente.getDni());
            ps.setString(++i, cliente.getNom_cliente());
            ps.setString(++i, cliente.getNom_cliente());
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
        
    }
    
    public List<String> obtenerClientes(){
        try{
            List<String> clientes = new ArrayList();
            PreparedStatement ps = c.prepareStatement("select * from cliente");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
                clientes.add("Cliente : " + rs.getString("id_cliente") + " : " + rs.getString("dni") + " : " + rs.getString("nom_cliente"));
            return clientes;
        }
        catch (Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    
    public boolean closeConnection(){
        try {
            if(!c.equals(null))
                c.close();
            return c.isClosed();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
}
