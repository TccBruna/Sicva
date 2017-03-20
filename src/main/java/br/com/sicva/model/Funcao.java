package br.com.sicva.model;
// Generated 16/03/2017 15:37:02 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Funcao generated by hbm2java
 */
@Entity
@Table(name="funcao"
    ,catalog="sicva"
)
public class Funcao  implements java.io.Serializable {


     private String funcaoDescricao;
     
    public Funcao() {
    }

	
    public Funcao(String funcaoDescricao) {
        this.funcaoDescricao = funcaoDescricao;
    }
    
   
     @Id
     @Column(name="FUNCAO_DESCRICAO", unique=true, nullable=false, length=20)
    public String getFuncaoDescricao() {
        return this.funcaoDescricao;
    }
    
    public void setFuncaoDescricao(String funcaoDescricao) {
        this.funcaoDescricao = funcaoDescricao;
    }


    

}


