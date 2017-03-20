/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sicva.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "zona")
public class Zona implements Serializable {
    
    @Id
     @Column(name = "ZONA_CODIGO", length = 11)
    private Integer ZonaCodigo;
    @Column(name = "ZONA_DESCRICAO", length = 30)
    private String ZonaDescricao;

    public Zona() {
    }

    public Zona(Integer ZonaCodigo) {
        this.ZonaCodigo = ZonaCodigo;
    }
    
    public Zona(Integer ZonaCodigo, String ZonaDescricao) {
        this.ZonaCodigo = ZonaCodigo;
        this.ZonaDescricao = ZonaDescricao;
    }
    
    
    public Integer getZonaCodigo() {
        return ZonaCodigo;
    }

    public void setZonaCodigo(Integer ZonaCodigo) {
        this.ZonaCodigo = ZonaCodigo;
    }

    public String getZonaDescricao() {
        return ZonaDescricao;
    }

    public void setZonaDescricao(String ZonaDescricao) {
        this.ZonaDescricao = ZonaDescricao;
    }
    
    
}
