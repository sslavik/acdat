/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orm_conexion_1;

import net.sf.ehcache.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ORM.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.hql.internal.ast.util.SessionFactoryHelper;
import org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.MetadataSources;
import org.hibernate.mapping.MetadataSource;
import org.hibernate.metamodel.Metadata;

/**
 *
 * @author Vyacheslav Shylyayev
 */

class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

public class ORM_Conexion_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        // VAMOS A CREAR OBJETOS DE LAS TABLAS
        // SEDE
        Sede sede_1 = new Sede(0,"sede_1");
        // DEPARTAMENTOS
        Departamento dpto_1 = new Departamento(0, sede_1, "Recursos Humanos");
        Departamento dpto_2 = new Departamento(0, sede_1, "Marketing");
        // EMPLEADOS
        Empleado e1 = new Empleado("X214512A", dpto_1, "Pablo Torres");
        Empleado e2 = new Empleado("12412523D", dpto_1, "Alfonso Gil");
        Empleado e3 = new Empleado("Y1950929S", dpto_2, "Martin Martinez");
        Empleado e4 = new Empleado("X546554D", dpto_2, "Arthur Shelby");
        
        // Creamos un Servicio De Registro Seguro
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            Transaction t = null;

            try {
                t = s.beginTransaction();

                ORM.Sede sede = new ORM.Sede();
                sede.setNomSede("MÁLAGA");
                s.save(sede);

                ORM.Departamento depto = new ORM.Departamento();
                depto.setNomDepto("INVESTIGACIÓN Y DESARROLLO");
                depto.setSede(sede);
                s.save(depto);

                ORM.Empleado emp = new ORM.Empleado();
                emp.setDni("56789012B");
                emp.setNomEmp("SAMPER");
                emp.setDepartamento(depto);
                s.save(emp);

                t.commit();

            } catch (Exception e) {
                e.printStackTrace(System.err);
                if (t != null) {
                    t.rollback();
                }
            }

        }
        
        
      
        
    }
    
}
