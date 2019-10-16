/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficheroaccesoaleatorio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.nio.file.Files;

/**
 * Probamos la clase RandomAccesFile
 * @author Vyacheslav Shylyayev
 */
public class FicheroAccesoAleatorio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        
        final int TAM_BYTE = 16;
        
        if(args.length == 0){
            System.out.print("No se ha encontrado fichero de salida");
            System.exit(0);
        }
        File f = new File(args[0]);
        String[] nombres = {"Juan", "Marta", "Manuel", "Luis", "Ana"};
        
        try (RandomAccessFile raf = new RandomAccessFile(f,"rw");) {

            int offset = 0;

            for(String nombre : nombres){
                byte[] b = nombre.getBytes("UTF-8");
                raf.seek(offset);
                raf.write(b);

                offset += TAM_BYTE;
            }
        }
        
        // PRUEBA DE CLASE FicheroAleatorio
        // Con estos métodos estamos sobre escribiendo lo anteriror Escrito
        FicheroAleatorio fa = new FicheroAleatorio(f);
        fa.insertar(3, "Pepito");
        fa.insertar(1, "Anita");
        fa.insertar(5, "áAnitañ");// Meter acentos o caracteres especiales no devuelve ERROR
        // Debido a que en el RandomAccessFile le digo que lo esciba en UTF-8
        
        System.out.println(fa.leer(5)); // PODEMOS LEER DE CUALQUIER POSICIÓN
        // Si nos pasamos del contenido existente en el FICHERO no lee nada.
        
    }
    
}
