/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sicva.controller;

import br.com.sicva.dao.EnderecosDao;
import br.com.sicva.dao.PacientesDao;
import br.com.sicva.model.Enderecos;
import br.com.sicva.model.Pacientes;
import br.com.sicva.model.Usuarios;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Rodrigo
 */
@ManagedBean
@SessionScoped
public class PacienteController {

    private Pacientes pacienteDigitado;
    private Pacientes paciente;
    private PacientesDao pacientesDao;
    private Enderecos endereco;
    private EnderecosDao enderecosDao;
    private boolean renderSalvar ;
    private boolean renderAlterar ;
    

    public Pacientes getPaciente() {
        if (this.paciente == null) {
            this.paciente = new Pacientes();
        }
        return paciente;
    }

    public void setPaciente(Pacientes paciente) {       
            this.paciente = paciente;        
    }

    public Pacientes getPacienteDigitado() {
        if (pacienteDigitado == null) {
            this.pacienteDigitado = new Pacientes();
        }
        return pacienteDigitado;
    }

    public void setPacienteDigitado(Pacientes pacienteDigitado) {         
            this.pacienteDigitado = pacienteDigitado;
      
    }

    public boolean isRenderSalvar() {
        return renderSalvar;
    }

    public void setRenderSalvar(boolean renderSalvar) {
        this.renderSalvar = renderSalvar;
    }

    public boolean isRenderAlterar() {
        return renderAlterar;
    }

    public void setRenderAlterar(boolean renderAlterar) {
        this.renderAlterar = renderAlterar;
    }

    

    public Enderecos getEndereco() {
        if(endereco == null){
            endereco = new Enderecos();
        }
        return endereco;
    }

    public void setEndereco(Enderecos endereco) {
        this.endereco = endereco;
    }

    public void consultarPacientes() {
        try {
            pacientesDao = new PacientesDao();
            enderecosDao = new EnderecosDao();
            paciente = pacientesDao.listarPorRegistro(this.pacienteDigitado.getPacientesNumeroRegistroNascimento());                           
            if (paciente == null) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN, "Registro não cadastrado!", null));
                renderSalvar = true;
                renderAlterar = false;
                endereco = null;                
            } else {
                endereco = enderecosDao.consultarPorParciente(pacienteDigitado.getPacientesNumeroRegistroNascimento());          
                renderAlterar = true;
                renderSalvar = false; 
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Este Registro já esta cadastrado", null));
            }
        } catch (Exception e) {
             System.out.println(e);
        }
    }

    public void Salvar(ActionEvent event) {
        try {
            pacientesDao = new PacientesDao();
            enderecosDao = new EnderecosDao();
            enderecosDao.salvarEnderecos(endereco);    
            this.paciente.setEnderecos(endereco);
            pacientesDao.salvarPacientes(paciente);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo com sucesso", null));
        } catch (RuntimeException e) {
            System.err.println("erro ao salvar" + e);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aconteceu um erro ao salvar", null));
        }

    }
    public void Alterar(){
        try {
            pacientesDao = new PacientesDao();
            enderecosDao = new EnderecosDao();
            enderecosDao.salvarEnderecos(endereco);    
            this.paciente.setEnderecos(endereco);
            pacientesDao.alterarPacientes(paciente);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "alterdado com sucesso", null));
        } catch (RuntimeException e) {
            System.err.println("erro ao alterar" + e);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aconteceu um erro ao alterar", null));
        }
    }
}
