/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sicva.controller;

import br.com.sicva.dao.FuncaoDao;
import br.com.sicva.dao.UsuariosDao;
import br.com.sicva.model.Funcao;
import br.com.sicva.model.Usuarios;
import br.com.sicva.seguranca.GenerateMD5;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author Rodrigo
 */
@ManagedBean
@ViewScoped
public class UsuarioController {
    private List<Usuarios> usuarios;
    private Usuarios usuarioPesquisado;
    private Usuarios usuario;
    private UsuariosDao usuariosDao;      
    private boolean showMsgErros; 

    public void salvar() {
        try {            
            usuariosDao = new UsuariosDao();
            usuario.setUsuarioSenha(GenerateMD5.generate(usuario.getUsuarioSenha()));
            usuario.setUsuarioAtivo(true);    
            usuariosDao.salvarUsuarios(this.usuario);
            this.usuario = new Usuarios(); 
            this.showMsgErros = true;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                 "Usuario Salvo com sucesso",null));
   
        } catch (RuntimeException erro) {
            System.out.println(""+erro);            
            this.showMsgErros = true;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                 "Erro ao salvar",null));
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
    
    public void PesquisarUsuario(){
        try {
            usuario = new Usuarios();
            usuariosDao = new UsuariosDao();
            usuario = usuariosDao.PesquisarUsuario(usuarioPesquisado.getUsuariosCpf());
            this.showMsgErros = true;
            if(usuario == null){
                 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                 "Usuario não econtrado",null));
            }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                 "Usuario econtrado",null));
            }
        } catch (Exception e) {
            System.out.println(""+e.getCause().getMessage());
            this.showMsgErros = true;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                 "Erro ao pesquisar",null));
        }
    }

    public List<Usuarios> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuarios> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuarios getUsuario() {
        if(usuario == null){
           usuario = new Usuarios();
        }
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
    

    public boolean isShowMsgErros() {
        return showMsgErros;
    }

    public void setShowMsgErros(boolean showMsgErros) {
        this.showMsgErros = showMsgErros;
    }

    public Usuarios getUsuarioPesquisado() {
        if(usuarioPesquisado == null){
            usuarioPesquisado = new Usuarios();
        }
        return usuarioPesquisado;
    }

    public void setUsuarioPesquisado(Usuarios usuarioPesquisado) {
        this.usuarioPesquisado = usuarioPesquisado;
    }    
    
    public List<SelectItem> getTodasFuncoes() {   
        FuncaoDao funcaoDao = new FuncaoDao();
        List<Funcao> listaFuncoes = funcaoDao.listarFuncao();
        final List<SelectItem> itens = new ArrayList<>(listaFuncoes.size());
        for (Funcao funcao : listaFuncoes) {
            itens.add(new SelectItem(funcao, funcao.getFuncaoDescricao()));
        }
        return itens;
    }

}
