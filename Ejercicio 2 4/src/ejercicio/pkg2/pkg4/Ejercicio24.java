/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.pkg2.pkg4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

/**
 *2.4. Crea un programa que, a partir de un fichero de texto codificado en UTF-8, genere un
fichero de texto codificado en ISO-8859-1 y otro en UTF-16. El fichero codificado en
UTF-8 debe crearse con un editor de texto, y debe incluir al menos vocales acentuadas.
Puedes leer el fichero línea a línea con readLine(). Para generar el fichero de salida,
puedes utilizar un BufferedWriter (para escribir línea a línea) construido sobre un Ou-
tputS treamWriter (para recodificar el texto) construido sobre un FileOutputS-
tream (para escribir a un fichero). Busca una manera de verificar la codificación de los ficheros
ficheros de texto en el sistema operativo que estés utilizando mediante algún comando del sis-
tema operativo o algún programa de utilidad. Puedes utilizar los programas de ejemplo para
volcado binario para verificar qué caracteres se codifican de manera distinta. Puedes crear otro
programa que haga la conversión inversa, para comprobar que se vuelve a obtener un fichero
igual al inicial, utilizando las clases InputStreamReader y FileInputStream.
 * @author Vyacheslav Shylyayev
 * @version 1.0
 */
public class Ejercicio24 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String ficheroUtf8 = "";
        if(args.length < 1){
            System.out.println("No existe ruta del archivo");
        }
        try (BufferedReader reader = new BufferedReader (new FileReader(ficheroUtf8));){
            String linea = reader.readLine();
            
            while(linea != null){
                try(BufferedWriter writer = new BufferedWriter(new FileOutputStream("HOla que tal"));){
                    
                }
                linea = reader.readLine();
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
        
        
    }
    
}
