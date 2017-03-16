/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sicva.controller;

import br.com.sicva.dao.UsuariosDao;
import br.com.sicva.model.Usuarios;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Mauricio
 */
@ManagedBean
public class UsuarioController {
    private List<Usuarios> usuarios;
    private UsuariosDao usuariosDao;
    
    public UsuarioController(){
        usuariosDao = new UsuariosDao();
        usuarios = usuariosDao.listarUsuarios();       
    }

    public List<Usuarios> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuarios> usuarios) {
        this.usuarios = usuarios;
    }
    
    
    
}
