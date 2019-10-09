/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.pkg2.pkg5;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author usuario
 */
public class Ejercicio25 {
    static int TAM_FILA = 32;
    static int MAX_BYTES = 2048;
    InputStream is = null;

    public Ejercicio25(InputStream is) {
        this.is = is;
    }

    public void volcar() throws IOException {
        byte buffer[] = new byte[TAM_FILA];
        int bytesLeidos;
        int offset = 0;
        FileOutputStream fos = new FileOutputStream("/home/usuario/Escritorio/z");
        try (OutputStream os = new FileOutputStream(File.createTempFile("volcadoBytes",".txt"));
            OutputStreamWriter w = new OutputStreamWriter(os, StandardCharsets.UTF_8);) {
            do {

                bytesLeidos = is.read(buffer);
                System.out.format("[%5d]", offset);
                for (int i = 0; i < bytesLeidos; i++) {
                    System.out.format(" %2x", buffer[i]);
                    fos.write((char)buffer[i]);
                }
                offset += bytesLeidos;
                System.out.println();
            } while (bytesLeidos == TAM_FILA && offset < MAX_BYTES);
        }
    }
    
    public static void PrintOutFile(char cont, File file, Charset encode) throws FileNotFoundException, IOException{
        
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("No se ha indicado ningún fichero");
            return;
        }

        String nomFich = args[0];

        try (FileInputStream fis = new FileInputStream(nomFich)) {
            Ejercicio25 vb = new Ejercicio25(fis);
            System.out.println("Volcado binario de " + nomFich);
            vb.volcar();
        } catch (FileNotFoundException e) {
            System.err.println("ERROR: no existe fichero " + nomFich);
        } catch (IOException e) {
            System.err.println("ERROR de E/S: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
