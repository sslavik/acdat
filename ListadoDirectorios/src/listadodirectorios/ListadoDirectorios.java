// Uso de la clase File para mostrar información de ficheros y directorios
package listadodirectorios;

import java.io.File;
import java.math.MathContext;
import java.util.Date;

public class ListadoDirectorios {
    public static void main(String[] args) {
        String ruta=".";
        if(args.length>=1) ruta=args[0];
            
        File fich = new File(ruta);
        if(!fich.exists()) {
            System.out.println("No existe el fichero o directorio ("+ruta+").");
        }
        else {
            if(fich.isFile()) {
                System.out.println(ruta+" es un fichero.");
            }
            else {
                System.out.println(ruta+" es un directorio. Contenidos: ");
                File[] ficheros=fich.listFiles(); // Ojo, ficheros o directorios
                for(File f: ficheros) {
                    String textoDescr=f.isDirectory() ? "/" : f.isFile() ? "_": "?";
                    System.out.print("("+textoDescr+") "+f.getName()+ " " );
                    if(f.isFile())
                        System.out.print(" | ocupa : " + (float)f.length()/1000 + " kb ");
                    else
                    {
                        char execute = f.canExecute()? 'x' : '-';
                        char write = f.canWrite()? 'w' : '-';
                        char read = f.canRead()? 'r' : '-';
                        System.out.print(" | permisos : " + read + write + execute);
                    }
                    
                    System.out.println(" | ultima modificación : " + new Date(f.lastModified()));
                        
                }
            }
        }
    }
}