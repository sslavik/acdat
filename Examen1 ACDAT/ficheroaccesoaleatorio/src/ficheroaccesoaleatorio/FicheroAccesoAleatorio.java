/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficheroaccesoaleatorio;

import java.io.*;
import java.io.RandomAccessFile;

/**
 * Gestión por fichero de acceso aleatorio con Bytes
 * @author Vyacheslav Shylyayev
 */
public class FicheroAccesoAleatorio {
    
    
    static final int LONG_REG = 20;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        //COMPROBACIÓN
        if(args.length <= 0){
            System.out.println("El programa requiere un fichero como parametro");
            System.exit(0);
        }
        try{
            // CAMPOS
            File f = new File(args[0]);
            FicheroAleatorio fa = new FicheroAleatorio(f.getAbsolutePath(), LONG_REG);
            
            try(BufferedReader r = new BufferedReader( new InputStreamReader( new FileInputStream(f))); ){
                String linea = "";
                while ((linea = r.readLine()) != null){
                    String nombre = "";
                    int pos = 0;
                    String[] campos = linea.split(",");
                    if(campos.length == 2){
                        nombre = campos[0];
                        pos = Integer.parseInt(campos[1]);
                    }
                    if(pos >= 1)
                        fa.insertar(pos, nombre);
                }
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}

class FicheroAleatorio {

  String nomFich;
  int longReg;

  FicheroAleatorio(String nomFich, int longReg) {
    this.nomFich = nomFich;
    this.longReg = longReg;
  }

  void insertar(int pos, String nombre) throws IOException {

    try (RandomAccessFile raf = new RandomAccessFile(this.nomFich, "rw")) {
      raf.seek((pos - 1) * this.longReg);
      String n = nombre;
      for (int i = nombre.length(); i < this.longReg; i++) {
        n += " ";
      }
      byte[] buff = n.getBytes();
      raf.write(buff, 0, this.longReg);
    }

  }

}