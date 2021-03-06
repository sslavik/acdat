/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacion.DAO;

import facturacion.models.Cliente;
import facturacion.models.Factura;
import facturacion.models.Linea_Factura;
import facturacion.models.Producto;
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
    // CAMPOS
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
    // _______________________________________________ CLIENTES ____________________________________________

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
    
    
    
    
    public int getIdCliente(Cliente cliente) throws SQLException{
        
        PreparedStatement ps = c.prepareStatement("select id_cliente from cliente where dni = ?;");
        int i = 0;
        ps.setString(++i, cliente.getDni());
        ResultSet rs = ps.executeQuery();
        rs.next();
                
        return rs.getInt("id_cliente");
    }
    // _______________________________________________ FACTURAS ____________________________________________
    public int insertarFactura(Factura factura) throws SQLException{
        
        PreparedStatement ps = c.prepareStatement("insert into factura (id_cliente, fecha_factura) values (?,?);");
        
        int i = 0;
        ps.setInt(++i, factura.getId_cliente());
        ps.setDate(++i, factura.getFecha_factura());
        
        return ps.executeUpdate();
    }
    
    public int insertarFacturas(List<Factura> facturas) throws SQLException{
        
        int rowsAffected = 0;
        
        for(Factura f : facturas){
            PreparedStatement ps = c.prepareStatement("insert into factura (id_cliente, fecha_factura) values (?,?);");
            
            int i = 0;
            ps.setInt(++i, f.getId_cliente());
            ps.setDate(++i, f.getFecha_factura());
            
            rowsAffected += ps.executeUpdate();
        }
        
        return rowsAffected;
    }
    public Factura obtenerFactura(int num_factura) throws SQLException{
        
        PreparedStatement ps = c.prepareStatement("select * from factura where num_factura = ?");
        
        int i = 0;
        
        ps.setInt(++i, num_factura);
        
        ResultSet rs = ps.executeQuery();
        
        rs.next();
        
        return new Factura(rs.getInt("id_cliente"),rs.getDate("fecha_factura"));
    }
    // _______________________________________________ PRODUCTOS _________________________________________________
    public int insertarProducto(Producto producto) throws SQLException{
        
        PreparedStatement ps = c.prepareStatement("insert into producto (ean, nom_producto) values (?,?);");
        
        int i = 0;
        ps.setString(++i, producto.getEan());
        ps.setString(++i, producto.getNom_producto());
        
        return ps.executeUpdate();
    }
    public List<Producto> obtenerProductos() throws SQLException{
        List<Producto> productos = new ArrayList<Producto>();
        
        PreparedStatement ps = c.prepareStatement("select * from producto");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Producto tmp = new Producto(rs.getString("ean"), rs.getString("nom_producto"));
            productos.add(tmp);
        }
        
        return productos;
    }
    public Producto obtenerProducto(int id_producto) throws SQLException{
        
        PreparedStatement ps = c.prepareStatement("select * from producto");
        
        ResultSet rs = ps.executeQuery();
        
        rs.next();
        
        return new Producto(rs.getString("ean"),rs.getString("nom_producto"));
    }
    // _______________________________________________ LINEA_FACTURA _________________________________________________
    public int insertarLineaFactura(Linea_Factura linea_Factura) throws SQLException{
        
        PreparedStatement ps = c.prepareStatement("insert into linea_factura (num_factura, num_linea_factura, id_producto, cantidad) values (?,?,?,?);");
        
        int i = 0;
        
        ps.setInt(++i, linea_Factura.getNum_factura());
        ps.setInt(++i, linea_Factura.getNum_linea_factura());
        ps.setInt(++i, linea_Factura.getId_producto());
        ps.setInt(++i, linea_Factura.getCantidad());
        
        
        return ps.executeUpdate();
    }
    
    public int insertarLineaFacturas(List<Linea_Factura> linea_Facturas) throws SQLException{
        
        int rowsAffected = 0;
        
        for(Linea_Factura lf : linea_Facturas){
            PreparedStatement ps = c.prepareStatement("insert into linea_factura (num_factura, num_linea_factura, id_producto, cantidad) values (?,?,?,?);");
        
            int i = 0;

            ps.setInt(++i, lf.getNum_factura());
            ps.setInt(++i, lf.getNum_linea_factura());
            ps.setInt(++i, lf.getId_producto());
            ps.setInt(++i, lf.getCantidad());
            
            rowsAffected += ps.executeUpdate();
        }
        
        return rowsAffected;
    }
    
    public List<Linea_Factura> obtenerLinea_Facturas() throws SQLException{
        List<Linea_Factura> lineas = new ArrayList<Linea_Factura>();
        
        PreparedStatement ps = c.prepareStatement("select * from linea_factura");
        
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            Linea_Factura tmp = new Linea_Factura(
                    obtenerFactura(rs.getInt("num_factura")),
                    rs.getInt("num_linea_factura"),
                    obtenerProducto(rs.getInt("id_producto")),
                    rs.getInt("cantidad"));
        }
        
        return lineas;
    }
}
