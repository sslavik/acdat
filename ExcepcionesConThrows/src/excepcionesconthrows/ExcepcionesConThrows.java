/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepcionesconthrows;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class ExcepcionesConThrows {

    public File creaFicheroTempConCar(String prefNomFich, char car, int numRep) throws IOException {
        // Cuando usamos un método que devuelve un objeto File el Runtime nos obliga a implementar el "throws IOException"
        File f = File.createTempFile(prefNomFich, "");
        try (FileWriter fw = new FileWriter(f);){ // Con el try aquí obligamos a cerrar todos los hilos usados en esta clase cuando termine el bloque
            for (int i = 0; i < numRep; i++) {
                fw.write(car);
            }
        }
        return f;

    }


    public static void main(String[] args) {

        try {
            File ft = new ExcepcionesConThrows().creaFicheroTempConCar("AAAA_", 'A', 20);
            System.out.println("Creado fichero: " + ft.getAbsolutePath());
            ft.delete(); // Se borra el archivo creado
            System.out.println("Borrado fichero: " + ft.getAbsolutePath());

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }

}
