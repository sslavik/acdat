package ORM;
// Generated 6 feb. 2020 12:38:26 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Proyecto generated by hbm2java
 */
public class Proyecto  implements java.io.Serializable {


     private int idProy;
     private Date FInicio;
     private Date FFin;
     private String nomProy;
     private Set proyectoSedes = new HashSet(0);

    public Proyecto() {
    }

	
    public Proyecto(int idProy, Date FInicio, String nomProy) {
        this.idProy = idProy;
        this.FInicio = FInicio;
        this.nomProy = nomProy;
    }
    public Proyecto(int idProy, Date FInicio, Date FFin, String nomProy, Set proyectoSedes) {
       this.idProy = idProy;
       this.FInicio = FInicio;
       this.FFin = FFin;
       this.nomProy = nomProy;
       this.proyectoSedes = proyectoSedes;
    }
   
    public int getIdProy() {
        return this.idProy;
    }
    
    public void setIdProy(int idProy) {
        this.idProy = idProy;
    }
    public Date getFInicio() {
        return this.FInicio;
    }
    
    public void setFInicio(Date FInicio) {
        this.FInicio = FInicio;
    }
    public Date getFFin() {
        return this.FFin;
    }
    
    public void setFFin(Date FFin) {
        this.FFin = FFin;
    }
    public String getNomProy() {
        return this.nomProy;
    }
    
    public void setNomProy(String nomProy) {
        this.nomProy = nomProy;
    }
    public Set getProyectoSedes() {
        return this.proyectoSedes;
    }
    
    public void setProyectoSedes(Set proyectoSedes) {
        this.proyectoSedes = proyectoSedes;
    }




}


