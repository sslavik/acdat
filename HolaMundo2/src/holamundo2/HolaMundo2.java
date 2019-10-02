/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holamundo2;

import java.io.*;


/**
 *
 * @author usuario
 */
public class HolaMundo2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hola que tal");
        
        try {
            File holaMundo = new File("/home/usuario/Escritorio/holamundo.txt");
            FileWriter holaMundoFW = new FileWriter(holaMundo);
            
            holaMundoFW.write("Me cago en todo loco");

            holaMundoFW.write("Diablo señorita");
            holaMundoFW.close();

            
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
        
        
    }
    
}
