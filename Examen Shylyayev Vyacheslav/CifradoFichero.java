/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifradofichero;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Cifrado personalizado de fichero
 * @author Vyacheslav Shylyayev
 */
public class CifradoFichero {
    
    char[] caracterOrigen;
    char[] caracterDestino;
    
    public CifradoFichero(char[] carOrigen, char[] carDestino) {
        caracterOrigen = carOrigen;
        caracterDestino = carOrigen;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //COMPROBACIÓN
        if(args.length <= 0){
            System.out.println("El programa requiere un fichero como parametro para cifrar");
            System.exit(0);
        }
        try {
            //CAMPOS
            char[] or = {'a','b'};
            char[] des = {'z','w'};
            CifradoFichero cf = new CifradoFichero(or, des);
            String origen = args[0];
            String destino = args[1];
            
            cf.cifra(origen, destino, true);
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
       
    }
    
    public void cifra(String origen, String destino, boolean reemplaza) throws FileNotFoundException, IOException{
        if (reemplaza){
            destino = origen;
        }
        File resultado = new File(destino);
        File cifrar = new File(origen);
        List<String> contenido = new ArrayList<String>();
        
        try(BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(origen)));){
                String linea = "";
                while((linea = r.readLine()) != null){
                    for (int i = 0; i < caracterOrigen.length; i++) {
                        linea = linea.replace((char)caracterOrigen[i], (char)caracterDestino[i]);
                        System.out.println((caracterOrigen[i]) + caracterDestino[i]);
                    }
                    contenido.add(linea);
                }
                
            }
        try (BufferedWriter w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destino)));){
            for(String s : contenido){
                w.write(s);
                w.newLine();
            }
        }
    }
    
}
