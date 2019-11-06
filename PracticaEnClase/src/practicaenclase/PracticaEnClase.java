/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaenclase;

import java.io.*;
import java.util.ArrayList;
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
        RenameRefactor(new File(args[1]), "No" , "NO TO TUE MUERTO");
        ConsoleRead(new File(args[2]));
        cambiarCR_LF(new File(args[3]));
    }
    
    /**
     * Genera fichero binario a partir de fichero de texto
     * Leyendo Caracter a Caracter
     * @param f Archivo pasado
     */
    static void TextToBinary(File f) throws FileNotFoundException, IOException{
        
        String linea = "";
        File salida = new File("/home/hacka/Escritorio/a.txt");
        
        
        try (BufferedReader br = new BufferedReader(new FileReader(f)); 
                FileOutputStream fos = new FileOutputStream(salida);
                BufferedReader br2 = new BufferedReader(new FileReader(salida))){
            while ((linea = br.readLine()) != null){
                byte[] binario = linea.getBytes();
                fos.write(binario);
                // Comprobamos el resultado
                System.out.println("Binario : " + (linea.getBytes()));
                fos.write((int)'\n');
            }
        }
    }

    /**
     * Reemplaza en el fichero de texto las ocurrecias de una palabra
     * @params f Fichero a remplazar
     */
    static void RenameRefactor(File f,  String palabraBuscada, String sustituto) throws IOException{
        List<String> contenido = new ArrayList<String>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(f));){
            String linea = new String();
            
            String[] filtro;
            int contador = 0;
            
            while ((linea = reader.readLine()) != null){
                filtro = linea.split(" ");
                String resultadoLinea = new String();
                for (int i = 0; i < filtro.length; i++){
                    if (filtro[i].matches(palabraBuscada)){
                        filtro[i] = sustituto;
                        contador++;
                        System.out.print(contador);
                    }
                }
                for (String string : filtro) {
                    resultadoLinea += " " + string;
                    
                }
                resultadoLinea = resultadoLinea.trim();
                contenido.add(resultadoLinea);
                
                System.out.println("Antes : " + linea);
                System.out.println("Después : " + resultadoLinea);
            }
            
        }
        try (FileOutputStream fos = new FileOutputStream(f);){
            while (contenido.size() > 0){
                fos.write(contenido.remove(0).getBytes("UTF-8"));
                fos.write("\n".getBytes("UTF-8"));
            }
        }
    }
    /**
     * Leer línea a línea y generar fichero de texto, termina de leer con linea vacia
     * @param f Fichero donde se escribe el contenido
     */
    static void ConsoleRead(File f) throws IOException{
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                FileOutputStream fos = new FileOutputStream(f,true)){
            String linea;
            while((linea = reader.readLine()).length() != 0){
                fos.write(linea.getBytes("UTF-8"));
                fos.write("\n".getBytes("UTF-8"));
            }
        }
    }

    /**
     * Cambiar CR-LF por LF y viceversa
     */
    static void cambiarCR_LF(File f) throws IOException{
        List<String> contenido = new ArrayList<String>();
        
        try(BufferedReader reader = new BufferedReader(new FileReader(f))){
            String linea = new String();
            String filtro = new String();
            String resultado = new String();
            
            while ((linea = reader.readLine()) != null) {
                linea = linea.replaceAll("\r", "");
                contenido.add(linea);
            }
        }
        
        try(OutputStreamWriter os = new OutputStreamWriter(new FileOutputStream(f), "UTF-8")){
            while(contenido.size() != 0){
                os.write(contenido.remove(0));
                os.write("\n");
            }
        }
    }

    
}


