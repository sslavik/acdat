package ORM;
// Generated 6 feb. 2020 12:38:26 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Departamento generated by hbm2java
 */
public class Departamento  implements java.io.Serializable {


     private Integer idDepto;
     private Sede sede;
     private String nomDepto;
     private Set empleados = new HashSet(0);

    public Departamento() {
    }

	
    public Departamento(Sede sede, String nomDepto) {
        this.sede = sede;
        this.nomDepto = nomDepto;
    }
    public Departamento(Sede sede, String nomDepto, Set empleados) {
       this.sede = sede;
       this.nomDepto = nomDepto;
       this.empleados = empleados;
    }
   
    public Integer getIdDepto() {
        return this.idDepto;
    }
    
    public void setIdDepto(Integer idDepto) {
        this.idDepto = idDepto;
    }
    public Sede getSede() {
        return this.sede;
    }
    
    public void setSede(Sede sede) {
        this.sede = sede;
    }
    public String getNomDepto() {
        return this.nomDepto;
    }
    
    public void setNomDepto(String nomDepto) {
        this.nomDepto = nomDepto;
    }
    public Set getEmpleados() {
        return this.empleados;
    }
    
    public void setEmpleados(Set empleados) {
        this.empleados = empleados;
    }




}


