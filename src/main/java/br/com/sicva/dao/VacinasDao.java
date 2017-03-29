/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sicva.dao;

import br.com.sicva.connection.HibernateUtil;
import br.com.sicva.model.Vacinas;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Rodrigo
 */
public class VacinasDao {
    
    private Session session;
    private Transaction tx;
    List<Vacinas> listarVacinas = new ArrayList<Vacinas>();

    public boolean salvarVacinas(Vacinas vacina) {
        try {
            session = new HibernateUtil().getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(vacina);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro no Banco!" + e.getMessage());
            tx.rollback();
            return false;
        }
    }

    public boolean alterarVacinas(Vacinas vacina) {
        try {
            session = new HibernateUtil().getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(vacina);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro no Banco!" + e.getMessage());
            tx.rollback();
            return false;
        }
    }
    
    public List<Vacinas> listarVacinas() {
        session = new HibernateUtil().getSessionFactory().openSession();
        Query query = session.createSQLQuery("select*from vacinas ").addEntity(Vacinas.class);
        listarVacinas = query.list();
        listarVacinas = session.createCriteria(Vacinas.class).list();
        session.close();
        return listarVacinas;
    }

    public Vacinas consultarPorNome(String nome) {
        session = new HibernateUtil().getSessionFactory().openSession();
        Query query = session.createSQLQuery("SELECT * FROM vacinas"
                + " WHERE vacinas_descricao = :nome").addEntity(Vacinas.class);
        query.setString("nome", nome);
        listarVacinas = query.list();
        session.close();
        if(listarVacinas.isEmpty()){
           return null;
        }else{
           return listarVacinas.get(0);
        }
    }

    public Vacinas listarPorId(int codigo) {
        try {
            session = new HibernateUtil().getSessionFactory().openSession();
            Query query = session.createSQLQuery("select * from vacinas where vacinas_id = :registro").addEntity(Vacinas.class);
            query.setInteger("registro", codigo);
            listarVacinas = query.list();
            session.close();
            return listarVacinas.get(0);
        } catch (Exception e) {
            return null;
        }
    }
}
