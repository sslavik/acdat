/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lanzaproceso;

import java.io.IOException;
import java.util.Arrays;

public class LanzaProceso {

    public static void main(String[] args) {
        if (args.length <= 0) {
            System.out.println("Debe indicarse comando a ejecutar.");
            System.exit(0);
        }
        ProcessBuilder pb = new ProcessBuilder(args);

        try {
            Process p = pb.start();
            int codRet = p.waitFor();
            System.out.println("La ejecución de " + Arrays.toString(args)
                    + " devuelve " + codRet + " " + (codRet == 0 ? "(ejecución correcta)" : "(ERROR)")
            );

        } catch (IOException e) {
            System.err.println("Error durante ejecución del proceso");
            System.err.println("Información detallada");
            System.err.println("---------------------");
            e.printStackTrace();
            System.err.println("---------------------");
            System.exit(-1);
        } catch (InterruptedException ex) {
            System.err.println("Proceso interrumpido");
            System.exit(-2);
        }

    }
}
