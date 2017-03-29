package br.com.sicva.model;
// Generated 28/03/2017 16:05:59 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Ubs generated by hbm2java
 */
@Entity
@Table(name="ubs"
    ,catalog="sicva"
)
public class Ubs  implements java.io.Serializable {


     private Integer ubsId;
     private String ubsDescricao;
     private Zona zona;

    public Ubs() {
    }

	
    public Ubs(Zona zona) {
        this.zona = zona;
    }
    public Ubs(String ubsDescricao, Zona zona) {
       this.ubsDescricao = ubsDescricao;
       this.zona = zona;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="UBS_ID", unique=true, nullable=false)
    public Integer getUbsId() {
        return this.ubsId;
    }
    
    public void setUbsId(Integer ubsId) {
        this.ubsId = ubsId;
    }

    
    @Column(name="UBS_DESCRICAO", length=30)
    public String getUbsDescricao() {
        return this.ubsDescricao;
    }
    
    public void setUbsDescricao(String ubsDescricao) {
        this.ubsDescricao = ubsDescricao;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="UBS_ZONA_CODIGO", nullable=false)
    public Zona getZona() {
        return this.zona;
    }
    
    public void setZona(Zona zona) {
        this.zona = zona;
    }




}


