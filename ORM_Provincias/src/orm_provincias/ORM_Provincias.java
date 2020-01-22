/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orm_provincias;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ORM.*;


/**
 *
 * @author Vyacheslav Shylyayev
 */
public class ORM_Provincias {

  
    public static void main(String[] args) {
        // TODO code application logic here
        
        // LECTURA COMPARTIDA DE ARCHIVOS
        String linea;
        String[] campos;
        
        try(Session s = HibernateUtil.getSessionFactory().openSession()){
            Transaction t = null;
            
            try {
                t = s.beginTransaction();

                try (BufferedReader comunidadesCsv = new BufferedReader(new InputStreamReader(new FileInputStream("comunidades.csv")));
                        BufferedReader localidadesCsv = new BufferedReader(new InputStreamReader(new FileInputStream("localidades.csv")));
                        BufferedReader provinciasCsv = new BufferedReader(new InputStreamReader(new FileInputStream("provincias.csv")))){
                    // IDS
                    int idComunidad = 1;
                    int idLocalidad = 1;
                    while((linea = comunidadesCsv.readLine())!=null){
                        Comunidad comunidad = new Comunidad(idComunidad++, linea);
                        System.out.printf("Comunidad : %d %s \n",comunidad.getIdCom(), comunidad.getNomCom());
                        s.saveOrUpdate(comunidad);
                    }
                    while((linea = provinciasCsv.readLine())!=null){
                        campos = linea.split("[,\"]");
                        if(campos.length >= 3){
                            Provincia provincia = new Provincia(Integer.parseInt(campos[1]),s.get(Comunidad.class, Integer.parseInt(campos[0])), campos[2]);
                            System.out.printf("Provincia : %d %s %s \n",provincia.getIdProv(), provincia.getComunidad().getNomCom(), provincia.getNomProv());
                            s.saveOrUpdate(provincia);
                        }
                    }
                    while((linea = localidadesCsv.readLine())!=null){
                        campos = linea.split("[,\"]");
                        Localidad localidad = new Localidad(idLocalidad++,s.get(Provincia.class, Integer.parseInt(campos[0])),campos[1]);
                        System.out.printf("Localidad : %d %s %s \n",localidad.getIdLoc(), localidad.getProvincia().getNomProv(), localidad.getNomLocalidad());
                        s.saveOrUpdate(localidad);
                    }

                }

                t.commit();
            } catch (Exception e){
                e.printStackTrace();
                System.err.println("ERROR : " + e.getMessage());
                t.rollback();
             }
        } 
    }
    
}
