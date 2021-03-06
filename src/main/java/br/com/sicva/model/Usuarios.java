package br.com.sicva.model;
// Generated 28/03/2017 16:05:59 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Usuarios generated by hbm2java
 */
@Entity
@Table(name="usuarios"
    ,catalog="sicva"
)
public class Usuarios  implements java.io.Serializable {


     private String usuariosCpf;
     private Funcao funcao;
     private Boolean usuarioAtivo;
     private String usuarioSenha;
     private String usuariosNome;

    public Usuarios() {
    }

	
    public Usuarios(String usuariosCpf, Funcao funcao) {
        this.usuariosCpf = usuariosCpf;
        this.funcao = funcao;
    }
    public Usuarios(String usuariosCpf, Funcao funcao, Boolean usuarioAtivo, String usuarioSenha, String usuariosNome) {
       this.usuariosCpf = usuariosCpf;
       this.funcao = funcao;
       this.usuarioAtivo = usuarioAtivo;
       this.usuarioSenha = usuarioSenha;
       this.usuariosNome = usuariosNome;
    }
   
     @Id 

    
    @Column(name="USUARIOS_CPF", unique=true, nullable=false, length=14)
    public String getUsuariosCpf() {
        return this.usuariosCpf;
    }
    
    public void setUsuariosCpf(String usuariosCpf) {
        this.usuariosCpf = usuariosCpf;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="USUARIO_FUNCAO_ID", nullable=false)
    public Funcao getFuncao() {
        return this.funcao;
    }
    
    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    
    @Column(name="USUARIO_ATIVO")
    public Boolean getUsuarioAtivo() {
        return this.usuarioAtivo;
    }
    
    public void setUsuarioAtivo(Boolean usuarioAtivo) {
        this.usuarioAtivo = usuarioAtivo;
    }

    
    @Column(name="USUARIO_SENHA", length=60)
    public String getUsuarioSenha() {
        return this.usuarioSenha;
    }
    
    public void setUsuarioSenha(String usuarioSenha) {
        this.usuarioSenha = usuarioSenha;
    }

    
    @Column(name="USUARIOS_NOME", length=60)
    public String getUsuariosNome() {
        return this.usuariosNome;
    }
    
    public void setUsuariosNome(String usuariosNome) {
        this.usuariosNome = usuariosNome;
    }




}


