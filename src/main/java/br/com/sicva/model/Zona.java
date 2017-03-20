package br.com.sicva.model;
// Generated 19/03/2017 21:26:58 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Zona generated by hbm2java
 */
@Entity
@Table(name="zona"
    ,catalog="sicva"
)
public class Zona  implements java.io.Serializable {


     private Integer zonaCodigo;
     private String zonaDescricao;
     

    public Zona() {
    }

	
    public Zona(String zonaDescricao) {
        this.zonaDescricao = zonaDescricao;
    }
    
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="ZONA_CODIGO", unique=true, nullable=false)
    public Integer getZonaCodigo() {
        return this.zonaCodigo;
    }
    
    public void setZonaCodigo(Integer zonaCodigo) {
        this.zonaCodigo = zonaCodigo;
    }

    
    @Column(name="ZONA_DESCRICAO", nullable=false, length=30)
    public String getZonaDescricao() {
        return this.zonaDescricao;
    }
    
    public void setZonaDescricao(String zonaDescricao) {
        this.zonaDescricao = zonaDescricao;
    }




}


