/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sicva.util;

/**
 *
 * @author Mauricio
 */
public enum Role {
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_ATENDENTE("ROLE_ATENDENTE"),
    ROLE_ENFERMEIRO("ROLE_ENFERMEIRO");
  
    private final String value;
      
    private Role(String value){
        this.value = value;
    }
  
    public String getValue() {
        return value;
    }    
}
