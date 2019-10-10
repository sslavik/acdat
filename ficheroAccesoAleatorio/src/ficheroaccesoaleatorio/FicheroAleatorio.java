/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficheroaccesoaleatorio;

import java.io.File;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.RandomAccess;
/**
 *
 * @author usuario
 */
public class FicheroAleatorio {
    
    File file;
    int offset = 1;
    final int TAM_NOMBRE = 16;
    
    public FicheroAleatorio(File file){
        this.file = file;
    }
    public void insertar(int pos, String nombre) throws FileNotFoundException, IOException{
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw");){
            offset = TAM_NOMBRE * (pos-1);
            raf.seek(offset);
            raf.write(nombre.getBytes("UTF-8"));
            
        }
    }
    public String leer(int pos) throws FileNotFoundException, IOException{
        try (RandomAccessFile raf = new RandomAccessFile(file, "r");){
            offset = TAM_NOMBRE * (pos-1);
            byte[] b = new byte[TAM_NOMBRE];
            
            raf.seek(offset);
            
            raf.read(b);
            
            return new String(b, "UTF-8");
        }
    }
}
