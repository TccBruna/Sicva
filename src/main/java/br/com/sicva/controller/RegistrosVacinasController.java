/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sicva.controller;

import br.com.sicva.dao.ItensVacinasDao;
import br.com.sicva.dao.PacientesDao;
import br.com.sicva.dao.RegistroVacinaDao;
import br.com.sicva.model.ItensVacinas;
import br.com.sicva.model.Pacientes;
import br.com.sicva.model.RegistrosVacinas;
import br.com.sicva.model.Usuarios;
import br.com.sicva.model.Vacinas;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Rodrigo
 */
@ManagedBean
@SessionScoped
public class RegistrosVacinasController {

    private RegistrosVacinas registroVacina;
    private List<RegistrosVacinas> todosRegistros;
    private RegistroVacinaDao registroVacinaDao;
    private ItensVacinas itenVacina;
    private List<ItensVacinas> itensVacinas;
    private ItensVacinasDao itensVacinasDao;
    private Pacientes pacienteDigitado;
    private Pacientes paciente;
    private PacientesDao pacientesDao;

    public void PesquisarPaciente() {
        try {
            pacientesDao = new PacientesDao();
            paciente = pacientesDao.listarPorRegistro(pacienteDigitado.getPacientesNumeroRegistroNascimento());
            if (paciente == null) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN, "Paciente não Encontrado!", null));
            } else {
                try {
                    atualizarItens();
                    FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO, "Paciente Encontrado!", null));
                } catch (Exception e) {
                    System.out.println("" + e);
                }
            }
        } catch (Exception e) {
            System.out.println("teste" + e);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao Procurar Paciente!", null));
        }
    }

    public void InserirVacina() {
        try {
            registroVacina.setPacientes(paciente);
            itenVacina = new ItensVacinas();
            itensVacinasDao = new ItensVacinasDao();
            registroVacinaDao = new RegistroVacinaDao();
            Usuarios usuarios = new Usuarios();
            usuarios.setUsuariosCpf("007.234.567-54");
            registroVacina.setUsuarios(usuarios);
            registroVacina.setRegistrosDataAplicacaoVacina(new Date());
            registroVacinaDao.salvarRegistros(registroVacina);
            itenVacina.setRegistrosVacinas(registroVacina);
            Vacinas v = new Vacinas();
            v.setVacinasCodigo(1);
            itenVacina.setVacinas(v);
            itensVacinasDao.salvarItensVacina(itenVacina);
            atualizarItens();
        } catch (Exception e) {
            System.out.println("" + e);
        }

    }
    
    public void atualizarItens() {
        itensVacinasDao = new ItensVacinasDao();
        itensVacinas = itensVacinasDao.listarItensVacinaPorPacientes(paciente.
                getPacientesNumeroRegistroNascimento());
    }

    public RegistrosVacinas getRegistrosVacina() {
        if (registroVacina == null) {
            registroVacina = new RegistrosVacinas();
        }
        return registroVacina;
    }

    public void setRegistrosVacina(RegistrosVacinas registroVacina) {
        this.registroVacina = registroVacina;
    }

    public List<RegistrosVacinas> getTodosRegistros() {
        return todosRegistros;
    }

    public void setTodosRegistros(List<RegistrosVacinas> todosRegistros) {
        this.todosRegistros = todosRegistros;
    }

    public Pacientes getPacienteDigitado() {
        if (pacienteDigitado == null) {
            pacienteDigitado = new Pacientes();
        }
        return pacienteDigitado;
    }

    public void setPacienteDigitado(Pacientes pacienteDigitado) {
        this.pacienteDigitado = pacienteDigitado;
    }

    public Pacientes getPaciente() {
        return paciente;
    }

    public void setPaciente(Pacientes paciente) {
        this.paciente = paciente;
    }

    public ItensVacinas getItenVacina() {
        return itenVacina;
    }

    public void setItenVacina(ItensVacinas itenVacina) {
        this.itenVacina = itenVacina;
    }

    public List<ItensVacinas> getItensVacinas() {
        return itensVacinas;
    }

    public void setItensVacinas(List<ItensVacinas> itensVacinas) {
        this.itensVacinas = itensVacinas;
    }

    

}
