/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sicva.dao;

import br.com.sicva.connection.HibernateUtil;
import br.com.sicva.model.ItensVacinas;
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
public class ItensVacinasDao {

    private Session session;
    private Transaction tx;
    List<ItensVacinas> listarItensVacina = new ArrayList<ItensVacinas>();

    public boolean salvarItensVacina(ItensVacinas itemVacina) {
        try {
            session = new HibernateUtil().getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(itemVacina);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro no Banco!" + e.getMessage());
            tx.rollback();
            return false;
        }
    }

    public boolean alterarItensVacina(ItensVacinas itemVacina) {
        try {
            session = new HibernateUtil().getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(itemVacina);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro no Banco!" + e.getMessage());
            tx.rollback();
            return false;
        }
    }

    public List<ItensVacinas> listarItensVacinaPorPacientes(int codigo) {
        session = new HibernateUtil().getSessionFactory().openSession();
        Query query = session.createSQLQuery("SELECT * FROM itens_vacinas inner join registros_vacinas\n"
                + "on Registros_id = ITENS_VACINAS_CARTEIRA_ID inner join vacinas\n"
                + "on ITENS_VACINAS_VACINAS_CODIGO = VACINAS_CODIGO  inner join pacientes\n"
                + "on PACIENTES_NUMERO_REGISTRO_NASCIMENTO = REGISTROS_PACIENTES_NUMERO_REGISTRO_NASCIMENTO\n"
                + "WHERE PACIENTES_NUMERO_REGISTRO_NASCIMENTO = :codigo  ").addEntity(ItensVacinas.class);
        query.setInteger("codigo", codigo);
        listarItensVacina = query.list();
        for (ItensVacinas it : listarItensVacina) {
            Hibernate.initialize(it.getVacinas());
            Hibernate.initialize(it.getRegistrosVacinas());
        }
        session.close();
        if (listarItensVacina.isEmpty()) {
            return null;
        } else {
            return listarItensVacina;
        }
    }
}
