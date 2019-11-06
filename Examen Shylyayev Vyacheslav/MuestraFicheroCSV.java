/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muestraficherocsv;

import java.io.*;

/**
 *
 * @author Vyacheslav Shylyayev
 */
public class MuestraFicheroCSV {

    /**
     * @param args Le pasamos el fichero CSV por parametros
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // COMPROBAMOS
        if(args.length <= 0){
            System.out.println("El programa requiere un fichero CSV como parametro");
            System.exit(0);
        }
        try {
            // CAMPOS
            File csv = new File(args[0]);
            
            try(BufferedReader r = new BufferedReader( new InputStreamReader( new FileInputStream(csv))); ){
                String linea = "";
                int contador = 1;
                int numCampo = 1;
                while ((linea = r.readLine()) != null){
                    String[] campos = linea.split(",");
                    System.out.print("Línea"+contador + "=>");
                    for (String campo : campos) {
                        System.out.print("Campo "+ numCampo+ ": " + campo + ", ");
                        numCampo++;
                    }
                    numCampo = 1;
                    contador++;
                    System.out.println("");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
    }
    
}
