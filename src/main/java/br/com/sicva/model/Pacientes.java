package br.com.sicva.model;
// Generated 16/03/2017 15:37:02 by Hibernate Tools 4.3.1


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
 * Pacientes generated by hbm2java
 */
@Entity
@Table(name="pacientes"
    ,catalog="sicva"
)
public class Pacientes  implements java.io.Serializable {


     private Integer pacientesNumeroRegistroNascimento;
     private Enderecos enderecos;
     private Usuarios usuarios;
     private String pacientesCpf;
     private String pacientesNome;
     private String pacientesDataNascimento;
     private String pacientesNomeResponsavel;
     private String pacientesFone1;
     private String pacientesFone2;
     

    public Pacientes() {
    }

	
    public Pacientes(String pacientesCpf) {
        this.pacientesCpf = pacientesCpf;
    }
    public Pacientes(Enderecos enderecos, Usuarios usuarios, String pacientesCpf, String pacientesNome, String pacientesDataNascimento, String pacientesNomeResponsavel, String pacientesFone1, String pacientesFone2) {
       this.enderecos = enderecos;
       this.usuarios = usuarios;
       this.pacientesCpf = pacientesCpf;
       this.pacientesNome = pacientesNome;
       this.pacientesDataNascimento = pacientesDataNascimento;
       this.pacientesNomeResponsavel = pacientesNomeResponsavel;
       this.pacientesFone1 = pacientesFone1;
       this.pacientesFone2 = pacientesFone2;
       
    }
   
    @Id @GeneratedValue(strategy=IDENTITY)    
    @Column(name="PACIENTES_NUMERO_REGISTRO_NASCIMENTO", unique=true, nullable=false)
    public Integer getPacientesNumeroRegistroNascimento() {
        return this.pacientesNumeroRegistroNascimento;
    }
    
    public void setPacientesNumeroRegistroNascimento(Integer pacientesNumeroRegistroNascimento) {
        this.pacientesNumeroRegistroNascimento = pacientesNumeroRegistroNascimento;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PACIENTES_ENDERECOS_ID")
    public Enderecos getEnderecos() {
        return this.enderecos;
    }
    
    public void setEnderecos(Enderecos enderecos) {
        this.enderecos = enderecos;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PACIENTES_USUARIO_CPF")
    public Usuarios getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    
    @Column(name="PACIENTES_CPF", nullable=false, length=14)
    public String getPacientesCpf() {
        return this.pacientesCpf;
    }
    
    public void setPacientesCpf(String pacientesCpf) {
        this.pacientesCpf = pacientesCpf;
    }

    
    @Column(name="PACIENTES_NOME", length=50)
    public String getPacientesNome() {
        return this.pacientesNome;
    }
    
    public void setPacientesNome(String pacientesNome) {
        this.pacientesNome = pacientesNome;
    }

    
    @Column(name="PACIENTES_DATA_NASCIMENTO", length=10)
    public String getPacientesDataNascimento() {
        return this.pacientesDataNascimento;
    }
    
    public void setPacientesDataNascimento(String pacientesDataNascimento) {
        this.pacientesDataNascimento = pacientesDataNascimento;
    }

    
    @Column(name="PACIENTES_NOME_RESPONSAVEL", length=60)
    public String getPacientesNomeResponsavel() {
        return this.pacientesNomeResponsavel;
    }
    
    public void setPacientesNomeResponsavel(String pacientesNomeResponsavel) {
        this.pacientesNomeResponsavel = pacientesNomeResponsavel;
    }

    
    @Column(name="PACIENTES_FONE1", length=11)
    public String getPacientesFone1() {
        return this.pacientesFone1;
    }
    
    public void setPacientesFone1(String pacientesFone1) {
        this.pacientesFone1 = pacientesFone1;
    }

    
    @Column(name="PACIENTES_FONE2", length=11)
    public String getPacientesFone2() {
        return this.pacientesFone2;
    }
    
    public void setPacientesFone2(String pacientesFone2) {
        this.pacientesFone2 = pacientesFone2;
    }


    



}


