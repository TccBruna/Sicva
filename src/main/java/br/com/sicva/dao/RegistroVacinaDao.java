/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sicva.dao;

import br.com.sicva.connection.HibernateUtil;
import br.com.sicva.model.RegistrosVacinas;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Rodrigo
 */
public class RegistroVacinaDao {
    private Session session;
    private Transaction tx;
    List<RegistrosVacinas> listarItensVacina = new ArrayList<RegistrosVacinas>();

    public boolean salvarRegistros(RegistrosVacinas RegistroVacina) {
        try {
            session = new HibernateUtil().getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(RegistroVacina);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro no Banco!" + e.getMessage());
            tx.rollback();
            return false;
        }
    }

    public boolean alterarRegistros(RegistrosVacinas RegistroVacina) {
        try {
            session = new HibernateUtil().getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(RegistroVacina);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro no Banco!" + e.getMessage());
            tx.rollback();
            return false;
        }
    }

    

    public RegistrosVacinas PesquisarRegistroPorPacientes(int codigo) {
        session = new HibernateUtil().getSessionFactory().openSession();
        Query query = session.createSQLQuery("SELECT * FROM registros_vacinas inner join pacientes on\n" +
"PACIENTES_NUMERO_REGISTRO_NASCIMENTO = REGISTROS_PACIENTES_NUMERO_REGISTRO_NASCIMENTO\n" +
"where PACIENTES_NUMERO_REGISTRO_NASCIMENTO = :codigo  ").addEntity(RegistrosVacinas.class);
        query.setInteger("codigo", codigo);
        listarItensVacina = query.list();         
        session.close();
        if(listarItensVacina.isEmpty()){
            return null;
        }else{
        return listarItensVacina.get(0);
        }
    }
}
