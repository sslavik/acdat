/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cambiarae;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author hacka
 */
public class CambiarAE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        if(args.length == 0){
            System.out.println("Necesita un archivo para leer");
            System.exit(0);
        }
        Charset encoding = Charset.forName("UTF-8");
        try {
            for (String fileName : args) {
                File file = new File(fileName);
                // Obtenemos la del antiguo archivo y la modificamos a nuestro nuevo archivo
                File AeFile = new File(file.getAbsolutePath().replaceAll(file.getName(), "") + file.getName().replaceAll("\\..*", "") + "_AE." + file.getName().replaceAll(".*\\.", ""));
                System.out.println(AeFile.getAbsolutePath());
                escribirArchivo(controladorFile(file, encoding), AeFile, encoding); // Le pasamos el archivo y la codificación del archivo
            }
        } catch (Exception x) {
            System.out.print(x.getMessage());
        }
    }
    
    public static String controladorFile(File file, Charset codif) throws FileNotFoundException, IOException{
        try (InputStream in = new FileInputStream(file); Reader r = new InputStreamReader(in, codif); Reader buffer = new BufferedReader(r) ){
            return controlarCaracteres(buffer);
        }
    }
    /**
     * Método para controlar la salida de los caracteres. En este caso Pasar de A -> E y viceversa
     * @param buffer Es el Reader que se pasa para poder leer el archivo caracter a caracter
     * @return Devvuelve una ristra de caracteres que es el contenido resultante
     * @throws IOException 
     */
    private static String controlarCaracteres(Reader buffer) throws IOException {
        int caracter;
        String contenido = "";
        while((caracter = buffer.read())!= -1){
            if((char)caracter == 'a'){
                contenido += 'e';
            }
            else if((char)caracter == 'e'){
                contenido += 'a';
            } else {
                contenido += (char)caracter;
            }
        }
        return contenido;
    }
    /**
     * Escribe en el archivo con la codificación y el contenido pasado
     * @param contenido String para escribir en el archivo
     * @param file La ruta del archivo  donde se escribirá
     * @param codif Codificación pasada
     * @throws FileNotFoundException
     * @throws IOException 
     */
    private static void escribirArchivo(String contenido, File file, Charset codif) throws FileNotFoundException, IOException{
        try(OutputStream os = new FileOutputStream(file); Writer w = new OutputStreamWriter(os, codif);){
            System.out.print(file.getAbsolutePath());
            w.write(contenido);
        }
    }
    
}
