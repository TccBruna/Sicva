/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sicva.dao;

import br.com.sicva.connection.HibernateUtil;
import br.com.sicva.model.Usuarios;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Rodrigo
 */
public class UsuariosDao {
    private Session session;
    private Transaction tx;
    List<Usuarios> listarUsuarios = new ArrayList<>();
    
    public boolean salvarUsuarios(Usuarios usuario){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(usuario);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro no Banco!!!"+ e.getMessage());
            tx.rollback();
            
         return false;   
        }
    }
    
    public boolean alterarUsuarios(Usuarios usuario){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(usuario);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro no Banco!" + e.getMessage());
            tx.rollback();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                 "Ocorreu um erro","infelizmente o usuario não pode ser salvo."));
            return false;
        }
    }
    
    public List<Usuarios> listarUsuarios(){
        session = new HibernateUtil().getSessionFactory().openSession();
        listarUsuarios = session.createCriteria(Usuarios.class).list();
        session.close();
        return listarUsuarios;
    }
    
}
