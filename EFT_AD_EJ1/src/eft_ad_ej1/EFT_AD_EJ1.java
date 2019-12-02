/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eft_ad_ej1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

/**
 *Haz un programa que permita navegar de forma interactiva por los contenidos de la tabla CLIENTES creada con un programa de ejemplo anterior.
 * Primero el programa debe realizar una consulta para obtener los contenidos de la tabla, y debe mostrar el mensaje “fila 1” y el contenido de la fila,
 * indicando para cada columna el nombre de la columna y su valor. Después se deben ejecutar los comandos que se vayan introduciendo por teclado. 
 * Si el comando es ‘.’ debe terminar, por supuesto liberando todos los recursos. Si es ‘k’ debe ir a la siguiente fila, 
 * indicando el número de la fila y mostrando sus contenidos, como al principio para la primera fila. El comando para ir a la fila anterior será ‘d’. 
 * Si se introduce un número, se debe mostrar la fila en la posición indicada por el número. 
 * El programa debe mostrar mensajes apropiados en caso de que el comando que se ha introducido no se pueda realizar 
 * (por ejemplo, estando en la última fila se pide ir a la siguiente, o se introduce el número de una fila que no existe).
 * La clase Integer tiene métodos que permiten determinar si un String representa un número entero.

[Pista: Se puede leer una cadena de caracteres desde el teclado de la siguiente forma:

BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); String comando=br.readLine();]


 * @author Vyacheslav Shylyayev
 */
public class EFT_AD_EJ1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, IOException {
        // TODO code application logic here
        
        String host = "remotemysql.com";
        String port = "3306";
        String database = "np5tn1dien";
        String addParams = "useSSL=false";
        String user = "np5tn1dien";
        String passwd = "v39eXDt1Z6";
        
        String url = String.format("jdbc:mysql://%s:%s/%s?%s", host,port,database,addParams);
        
        Connection c = DriverManager.getConnection(url,user,passwd);
        
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            
            System.out.println("OPCIONES");
            System.out.println("'.' SALIR");
            System.out.println("'k' SIGUIENTE LINEA");
            System.out.println("'d' ANTERIOR LINEA");
            System.out.println("'0-9' SALTO A NUM LINEA");
            
            String opcion = ""; 
            int posicion = 0;
            int limite = 0;
            System.out.println("MYSQL >>> Introduce una opción");

            do{
                try{
                    opcion = br.readLine();
                    
                    int i = 0;
                    PreparedStatement ps0 = c.prepareStatement("select count(*) as total from CLIENTES");
                    PreparedStatement ps = c.prepareStatement("select * from CLIENTES limit ?,?;");
                    
                    ResultSet rsCount = ps0.executeQuery();
                    
                    rsCount.next();
                    
                    limite = rsCount.getInt("total");
                    
                    
                    switch(opcion){
                    case "k" : 
                        if(posicion < limite){
                            ps.setInt(++i, posicion++);
                            ps.setInt(++i, posicion);
                        }
                        else {
                            System.out.println("No existen más registros");
                        }
                        break;
                    case "d" : 
                        if(posicion > 1){
                            ps.setInt(++i, posicion -= 2); 
                            ps.setInt(++i, ++posicion); 
                        } else {
                            System.out.println("No existen más registros");
                        }
                        break;
                    case "." : 
                        break;
                    default :
                        int salto = Integer.parseInt(opcion);
                        break;
                    }
                    ResultSet rs = ps.executeQuery();
                        
                        rs.next();
                        
                        String dni = rs.getString("DNI");                        
                        String ape = rs.getString("APELLIDOS");
                        String cp = rs.getString("CP");
                        
                        System.out.println("Fila " + posicion + " | DNI : " + dni + " APELLIDOS : "+ ape + " CP : " + cp );
                }
                catch (Exception e) {
                    System.err.println(e.getMessage());
                }
                System.out.println("MYSQL >>> Introduce una opción");

                
            } while(opcion.charAt(0) != '.');
                
        }
        
    }
    
}
