/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sicva.dao;

import br.com.sicva.connection.HibernateUtil;
import br.com.sicva.model.Funcao;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Rodrigo
 */
public class FuncaoDao {
    private Session session;
    private Transaction tx;
    List<Funcao> listarFuncao = new ArrayList<>();
    
    public boolean salvarFuncao(Funcao funcao){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(funcao);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro no Banco!!!"+ e.getMessage());
            tx.rollback();
            
         return false;   
        }
    }
    
    public boolean alterarFuncao(Funcao funcao){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(funcao);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro no Banco!" + e.getMessage());
            tx.rollback();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                 "Ocorreu um erro","infelizmente o funcao não pode ser salvo."));
            return false;
        }
    }
    
    public List<Funcao> listarFuncao(){
        session = new HibernateUtil().getSessionFactory().openSession();
        listarFuncao = session.createCriteria(Funcao.class).list();
        session.close();
        return listarFuncao;
    }
    
    public Funcao PesquisarPorDescricao(String descricao) {
        try {
            session = new HibernateUtil().getSessionFactory().openSession();
            Query query = session.createSQLQuery("select * from funcao where funcao_descricao = :descricao").addEntity(Funcao.class);
            query.setString("descricao", descricao);
            listarFuncao = query.list();
            session.close();
            return listarFuncao.get(0);
        } catch (Exception e) {
            return null;
        }
    }
}
