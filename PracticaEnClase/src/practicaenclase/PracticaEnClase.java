/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaenclase;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * Practica en Clase
 * @author Vyacheslav Shylyayev
 */
public class PracticaEnClase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        if(args.length == 0){
            System.out.println("Necesita al menos 1 argumento");
            System.exit(0);
        }
        TextToBinary(new File(args[0]));
    }
    
    /**
     * Genera fichero binario a partir de fichero de texto
     * Leyendo Caracter a Caracter
     * @param f Archivo pasado
     */
    static void TextToBinary(File f) throws FileNotFoundException, IOException{
        
        String linea;
        File salida = new File("/home/usuario/Escritorio/a.txt");
        
        
        try (BufferedReader br = new BufferedReader(new FileReader(f)); 
                FileOutputStream fos = new FileOutputStream(salida)){
            while ((linea = br.readLine()) != null){
                byte[] binario = linea.getBytes();
                fos.write(binario);
                System.out.println((linea.getBytes()));
                fos.write((int)'\n');
            }
        }
    }

    /**
     * Reemplaza en el fichero de texto las ocurrecias de una palabra
     */

    /**
     * Leer línea a línea y generar fichero de texto, termina de leer con linea vacia
     * 
     */

    /**
     * Cambiar CR-LF por LF y viceversa
     */

    
}


