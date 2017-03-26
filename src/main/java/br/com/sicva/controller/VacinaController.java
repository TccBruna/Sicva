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
import javax.faces.context.FacesContext;

/**
 *
 * @author Rodrigo
 */
@ManagedBean
public class VacinaController {
    private Vacinas vacina;
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

   public  void Salvar(){
       try {      
       vacinasDao = new VacinasDao();
       vacinasDao.salvarVacinas(vacina);
       FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Vacina salva com sucesso!", null));            
       vacina = new Vacinas();       
       } catch (Exception e) {
           System.out.println("Erro"+e);
           FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN, "Acontece um erro ao salvar!", null));
            
       }
   }
    
    
    
}
