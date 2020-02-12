/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orm_jerarquias;

import ORM.*;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 *
 * @author Vyacheslav Shylyayev
 */
public class ORM_Jerarquias {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try (Session s = HibernateUtil.getSessionFactory().openSession()){
            Transaction t = s.beginTransaction();
            try {
                Empleado emp = new Empleado("PILOTES", "MEENCANTAN");
                s.saveOrUpdate(emp);
                EmpPlantilla empPlantilla = new EmpPlantilla();
                s.saveOrUpdate(empPlantilla);
                t.commit();
            } catch (Exception e){
                e.printStackTrace();
                t.rollback();
            }
        }
        
    }
    
}
