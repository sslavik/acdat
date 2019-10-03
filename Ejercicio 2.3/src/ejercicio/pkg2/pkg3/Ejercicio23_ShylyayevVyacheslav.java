/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.pkg2.pkg3;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 2.3. Crea un programa que busque un texto dado en un fichero de texto, y que muestre para cada aparición 
 * la línea y la columna. Se recomienda leer el fichero línea a línea y, dentro de cada línea, buscar las 
 * apariciones del texto utilizando un método apropiado de la clase String. Se puede consultar la documentación 
 * de dicha clase en la API de Java (http://docs. oracle.com/javase/8/docs/api)
 * 
 * @author Vyacheslav Shylyayev
 * @version 1.0
 */

public class Ejercicio23 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean encontrado = false;
        if (args.length < 1) {
            System.out.println("Indicar por favor nombre de fichero");
            return;
        }
        String nomFich = args[0];
        String textoBuscado = "";
        if (args.length == 2){
            textoBuscado = args[1];
        } // El programa sin o le pasas un segundo parametro lo único que hace es imprimir las líneas del archivo pasado

        try (BufferedReader fbr = new BufferedReader(new FileReader(nomFich))) {
            int i = 0;
            int col = -1;
            int lin = -1;
            String linea = fbr.readLine();
            while (linea != null) {
                if(!encontrado){
                col = linea.indexOf(textoBuscado, 0); // obtenemos el índice
                }
                if(col != -1 && lin == -1){
                   encontrado = true; 
                   lin = i;
                }
                System.out.format("[%5d] %s", i++, linea);
                System.out.println();
                linea = fbr.readLine();
            }
            if(encontrado){
                System.out.println(String.format("Encontrado texto en la línea %d columna %d",lin,col));
            }
        } catch (FileNotFoundException e) {
            System.out.println("No existe fichero " + nomFich);
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
        
}
