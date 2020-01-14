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


/**
 *
 * @author Vyacheslav Shylyayev
 */
public class ORM_Provincias {

  
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        try {
            Transaction t = null;
            
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("localidades.csv"))))
            
            s.close();
            
        } catch (Exception e){
            
        }
    }
    
}
