package ORM;
// Generated 11 dic. 2019 12:38:48 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Proyecto generated by hbm2java
 */
@Entity
@Table(name="proyecto"
    ,catalog="Xy2tHnTzxO"
)
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
   
     @Id 

    
    @Column(name="id_proy", unique=true, nullable=false)
    public int getIdProy() {
        return this.idProy;
    }
    
    public void setIdProy(int idProy) {
        this.idProy = idProy;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="f_inicio", nullable=false, length=10)
    public Date getFInicio() {
        return this.FInicio;
    }
    
    public void setFInicio(Date FInicio) {
        this.FInicio = FInicio;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="f_fin", length=10)
    public Date getFFin() {
        return this.FFin;
    }
    
    public void setFFin(Date FFin) {
        this.FFin = FFin;
    }

    
    @Column(name="nom_proy", nullable=false, length=20)
    public String getNomProy() {
        return this.nomProy;
    }
    
    public void setNomProy(String nomProy) {
        this.nomProy = nomProy;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="proyecto")
    public Set getProyectoSedes() {
        return this.proyectoSedes;
    }
    
    public void setProyectoSedes(Set proyectoSedes) {
        this.proyectoSedes = proyectoSedes;
    }




}


