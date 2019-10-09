/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.pkg2.pkg4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

/**
 *
 * @author Vyacheslav Shylyayev
 */
public class Ejercicio24 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        if(args.length == 0){
            System.out.println("Necesito un archivo con el que trabajar");
            System.exit(0);
        }
        try{
            File archivo = new File(args[0]);
            Charset encoding16 = Charset.forName("UTF-16");
            Charset encodingISO = Charset.forName("ISO-8859-1");
            String ruta16 = archivo.getAbsolutePath().replaceAll(archivo.getName(), "") +
                    archivo.getName().replaceAll("\\..*", "") +
                    "_UTF16." +
                    archivo.getName().replaceAll(".*\\.", "");
            String rutaISO = archivo.getAbsolutePath().replaceAll(archivo.getName(), "") +
                    archivo.getName().replaceAll("\\..*", "") +
                    "_ISO-8859-1." +
                    archivo.getName().replaceAll(".*\\.", "");
            String contenido = "";
            String linea;
            
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(archivo)));){
                while((linea = reader.readLine()) != null){
                    contenido += linea;
                }
            }
            cambiarCodificacion(contenido, new File(ruta16), encoding16);
            cambiarCodificacion(contenido, new File(rutaISO), encodingISO);
           
            
        } catch (Exception x){
            System.out.println(x.getMessage());
        }
    }
    
    public static void cambiarCodificacion(String contenido, File file, Charset encoding) throws FileNotFoundException, IOException{
        try (OutputStreamWriter w = new OutputStreamWriter(new FileOutputStream(file), encoding);){
            w.write(contenido);
        }

        Process p = Runtime.getRuntime().exec("file -i " + file.getAbsolutePath());
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));){
            System.out.println(reader.readLine());
        }
    }
}
