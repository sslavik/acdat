package ORM;
// Generated 6 feb. 2020 13:29:03 by Hibernate Tools 4.3.1



/**
 * Empleado generated by hbm2java
 */
public class Empleado  implements java.io.Serializable {


     private String dni;
     private String nomEmp;

    public Empleado() {
    }

    public Empleado(String dni, String nomEmp) {
       this.dni = dni;
       this.nomEmp = nomEmp;
    }
   
    public String getDni() {
        return this.dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getNomEmp() {
        return this.nomEmp;
    }
    
    public void setNomEmp(String nomEmp) {
        this.nomEmp = nomEmp;
    }
}

