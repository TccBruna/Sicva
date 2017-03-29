/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sicva.converters;

import br.com.sicva.dao.FuncaoDao;
import br.com.sicva.model.Funcao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Rodrigo
 */
@FacesConverter(forClass = Funcao.class, value = "funcaoConverter")
public class FuncaoConverter implements Converter {

     private FuncaoDao funcaoDao = new FuncaoDao();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        Funcao funcao = funcaoDao.PesquisarPorDescricao(value);
        return funcao;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if (value != null) {
            Funcao funcao;
            funcao = (Funcao) value;
            return funcao.getFuncaoDescricao();
        }
        return null;
    }

}
