package br.com.sicva.model;
// Generated 16/03/2017 13:54:36 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Enderecos generated by hbm2java
 */
public class Enderecos  implements java.io.Serializable {


     private Integer enderecosId;
     private String enderecoRua;
     private Integer enderecoCep;
     private String enderecoNumero;
     private Set pacienteses = new HashSet(0);

    public Enderecos() {
    }

    public Enderecos(String enderecoRua, Integer enderecoCep, String enderecoNumero, Set pacienteses) {
       this.enderecoRua = enderecoRua;
       this.enderecoCep = enderecoCep;
       this.enderecoNumero = enderecoNumero;
       this.pacienteses = pacienteses;
    }
   
    public Integer getEnderecosId() {
        return this.enderecosId;
    }
    
    public void setEnderecosId(Integer enderecosId) {
        this.enderecosId = enderecosId;
    }
    public String getEnderecoRua() {
        return this.enderecoRua;
    }
    
    public void setEnderecoRua(String enderecoRua) {
        this.enderecoRua = enderecoRua;
    }
    public Integer getEnderecoCep() {
        return this.enderecoCep;
    }
    
    public void setEnderecoCep(Integer enderecoCep) {
        this.enderecoCep = enderecoCep;
    }
    public String getEnderecoNumero() {
        return this.enderecoNumero;
    }
    
    public void setEnderecoNumero(String enderecoNumero) {
        this.enderecoNumero = enderecoNumero;
    }
    public Set getPacienteses() {
        return this.pacienteses;
    }
    
    public void setPacienteses(Set pacienteses) {
        this.pacienteses = pacienteses;
    }




}


