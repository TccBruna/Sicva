/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sicva.controller;

import br.com.sicva.dao.VacinasDao;
import br.com.sicva.model.Vacinas;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Rodrigo
 */
@ManagedBean
@ViewScoped
public class VacinaController {
    private Vacinas vacina;
    private Vacinas vacinaPesquisada;
    private VacinasDao vacinasDao;

    public Vacinas getVacina() {
        if(vacina == null){
            vacina = new Vacinas();
        }
        return vacina;
    }

    public void setVacina(Vacinas vacina) {
        this.vacina = vacina;
    }

    public Vacinas getVacinaPesquisada() {
        if(vacinaPesquisada == null){
            vacinaPesquisada = new Vacinas();
        }
        return vacinaPesquisada;
    }

    public void setVacinaPesquisada(Vacinas vacinaPesquisada) {
        this.vacinaPesquisada = vacinaPesquisada;
    }
    
    

   public  void Salvar(){
       try {      
       vacinasDao = new VacinasDao();
       if(vacinasDao.salvarVacinas(vacina)){
       FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Vacina salva com sucesso!", null));            
       vacina = new Vacinas();       
       }else{
           FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "A vacina não pode ser salva!", null));
       }
       } catch (Exception e) {
           System.out.println("Erro"+e);
           FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN, "Acontece um erro ao salvar!", null));
            
       }
   }
    
   public  void Alterar(){
       try {      
       vacinasDao = new VacinasDao();
       if(vacinasDao.alterarVacinas(vacina)){
       FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Vacina alterada com sucesso!", null));            
       vacina = new Vacinas();       
       }else{
           FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "A vacina não pode ser alterada!", null));
       }
       } catch (Exception e) {
           System.out.println("Erro"+e.getMessage()+""+e.getLocalizedMessage());
           FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN, "Acontece um erro ao alterar!", null));
            
       }
   }
   
   public  void PesquisarVacina(){
       try {      
       vacinasDao = new VacinasDao();
       vacina =  vacinasDao.consultarPorNome(vacinaPesquisada.getVacinasDescricao());
       if(vacina != null){
       FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Vacina encontrada!", null));             
       }else{
           FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "A vacina não cadastrada!", null));
       }
       } catch (Exception e) {
           System.out.println("Erro"+e);
           FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN, "Acontece um erro ao alterar!", null));
            
       }
   }
  
    
}
