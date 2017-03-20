package br.com.sicva.model;
// Generated 16/03/2017 13:54:36 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Usuarios generated by hbm2java
 */
@Entity
@Table(name = "usuarios")
public class Usuarios  implements java.io.Serializable {

     @Id
     @Column(name = "USUARIOS_CPF", length = 14)
     private String usuariosCpf;
     @Column(name = "USUARIOS_NOME", length = 60)
     private String usuariosNome;
     @Column(name = "USUARIO_SENHA", length = 60)
     private String usuarioSenha;
     @Column(name = "USUARIO_ATIVO", columnDefinition = "BOOLEAN")
     private Boolean usuarioAtivo;
     @ManyToMany
     @JoinTable(name = "usuarios_funcao", joinColumns = @JoinColumn(name = "USUARIOS_FUNCAO_USUARIOS_CPF"), inverseJoinColumns = @JoinColumn(name = "USUARIOS_FUNCAO_DESCRICAO"))
     private List<Funcao> funcoes;
     
     

    public Usuarios() {
    }

	
    public Usuarios(String usuariosCpf) {
        this.usuariosCpf = usuariosCpf;
    }
    public Usuarios(String usuariosCpf, String usuariosNome, String usuarioSenha, Boolean usuarioAtivo) {
       this.usuariosCpf = usuariosCpf;
       this.usuariosNome = usuariosNome;
       this.usuarioSenha = usuarioSenha;
       this.usuarioAtivo = usuarioAtivo;
       
    }
   
    public String getUsuariosCpf() {
        return this.usuariosCpf;
    }
    
    public void setUsuariosCpf(String usuariosCpf) {
        this.usuariosCpf = usuariosCpf;
    }
    public String getUsuariosNome() {
        return this.usuariosNome;
    }
    
    public void setUsuariosNome(String usuariosNome) {
        this.usuariosNome = usuariosNome;
    }
    public String getUsuarioSenha() {
        return this.usuarioSenha;
    }
    
    public void setUsuarioSenha(String usuarioSenha) {
        this.usuarioSenha = usuarioSenha;
    }
    public Boolean getUsuarioAtivo() {
        return this.usuarioAtivo;
    }
    
    public void setUsuarioAtivo(Boolean usuarioAtivo) {
        this.usuarioAtivo = usuarioAtivo;
    }
    
    public List<Funcao> getFuncoes() {
        return funcoes;
    }

    public void setFuncoes(List<Funcao> funcoes) {
        this.funcoes = funcoes;
    }
        
    
   

}


