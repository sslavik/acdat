/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copiadirectorio;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Copia el contenido de un directorio a otro no existente pasado por parametros
 * @author Vyacheslav Shylyayev
 */
public class CopiaDirectorio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        
        //CAMPOS
        List<File> files = new ArrayList<File>();
        List<File> filesDestino = new ArrayList<File>();
        File f;
        try {
        
            // COMPROBACIÓN
            if(args.length != 2){
                System.err.print("El programa necesita 2 parametros para ejecutarse (pathOrigen, pathDestino)");
                System.exit(0);
            }
            if (!new File(args[0]).exists()) {
                throw new Exception("El directorio origen no existe");
            }
            if(new File(args[1]).exists()){
                throw new Exception("El directorio destino ya existe");
            }

            File origen = new File(args[0]);
            File destino = new File(args[1]);
            // Creamos el destino
            if(destino.mkdir()){
                System.out.println("Directorio destino creado con éxito");
            }
            // pasado a una Lista
            for (File file : origen.listFiles()){
                if(!file.isDirectory()){
                    files.add(file);
                }
                filesDestino.add(new File(destino.getAbsolutePath().toString() + "/" + file.getName().toString()));
            }


            while (!files.isEmpty() && !filesDestino.isEmpty()){
                try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(files.remove(0)));
                        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filesDestino.remove(0)));){
                    byte[] contenido = bis.readAllBytes();
                    bos.write(contenido);
                }
            }
                
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.getStackTrace();
        }
        
    }
    
}
