/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sicva.controller;

import br.com.sicva.dao.UsuariosDao;
import br.com.sicva.model.Funcao;
import br.com.sicva.model.Usuarios;
import br.com.sicva.seguranca.GenerateMD5;
import br.com.sicva.util.Role;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

/**
 *
 * @author Rodrigo
 */
@ManagedBean
@RequestScoped
public class UsuarioController {

    private List<Usuarios> usuarios;
    private Usuarios usuario;
    private UsuariosDao usuariosDao;
    private Funcao funcao;
    private boolean showMsgErros;
    
    

    public UsuarioController() {
        funcao = new Funcao();
        this.usuario = new Usuarios();
        usuariosDao = new UsuariosDao();
        usuarios = usuariosDao.listarUsuarios();
    }

    public void salvar(ActionEvent event) {
        try {
            List<Funcao> funcoes = new ArrayList<>();
            funcoes.add(funcao);
            usuario.setUsuarioSenha(GenerateMD5.generate(usuario.getUsuarioSenha()));
            usuario.setUsuarioAtivo(true);            
            usuario.setFuncoes(funcoes);
            usuariosDao.salvarUsuarios(this.usuario);
            this.usuario = new Usuarios();
            funcao = new Funcao();            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                 "Salvo","Usuário salvo com sucesso."));
   
        } catch (RuntimeException erro) {
            erro.printStackTrace();
            this.showMsgErros = true;
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

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public boolean isShowMsgErros() {
        return showMsgErros;
    }

    public void setShowMsgErros(boolean showMsgErros) {
        this.showMsgErros = showMsgErros;
    }

    
    
    public List<SelectItem> getAllFuncoes() {
        final List<SelectItem> listaRole = new ArrayList<>();
        SelectItem item1 = new SelectItem();
        item1.setLabel("Administrador");
        item1.setValue(Role.ROLE_ADMIN.getValue());
        SelectItem item2 = new SelectItem();
        item2.setLabel("Atendente");
        item2.setValue(Role.ROLE_ATENDENTE.getValue()); 
        SelectItem item3 = new SelectItem();
        item3.setLabel("Enfermeiro");
        item3.setValue(Role.ROLE_ENFERMEIRO.getValue());   
        listaRole.add(item1);
        listaRole.add(item2);
        listaRole.add(item3);
        return listaRole;
    }

}
