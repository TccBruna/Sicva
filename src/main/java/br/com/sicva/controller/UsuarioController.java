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
import javax.faces.bean.SessionScoped;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Rodrigo
 */
@ManagedBean
@SessionScoped
public class UsuarioController {
    private List<Usuarios> usuarios;
    private Usuarios usuario;
    private UsuariosDao usuariosDao;
    
    public UsuarioController(){        
        this.usuario = new Usuarios();
        usuariosDao = new UsuariosDao();
        usuarios = usuariosDao.listarUsuarios();
    }
    
    
    public void salvar() {
		try {	
                        this.usuariosDao = new UsuariosDao();
			this.usuariosDao.salvarUsuarios(this.usuario);
		} catch (RuntimeException erro) {
			
			erro.printStackTrace();
		}
	}
     public void alterar() {
		try {	
                        this.usuariosDao = new UsuariosDao();		
			this.usuariosDao.alterarUsuarios(this.usuario);						
		} catch (RuntimeException erro) {
			
			erro.printStackTrace();
		}
	}
    

    public List<Usuarios> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuarios> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
    
    
    
}
