/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sicva.dao;

import br.com.sicva.connection.HibernateUtil;
import br.com.sicva.model.Enderecos;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Rodrigo
 */
public class EnderecosDao {
    private Session session;
    private Transaction tx;
    List<Enderecos> listarEnderecos = new ArrayList<Enderecos>();

    public boolean salvarEnderecos(Enderecos endereco) {
        try {
            session = new HibernateUtil().getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(endereco);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro no Banco!" + e.getMessage());
            tx.rollback();
            return false;
        }
    }

    public boolean alterarEnderecos(Enderecos endereco) {
        try {
            session = new HibernateUtil().getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(endereco);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro no Banco!" + e.getMessage());
            tx.rollback();
            return false;
        }
    }

    public Enderecos consultarPorParciente(int codigo) {

        session = new HibernateUtil().getSessionFactory().openSession();

        Query query = session.createSQLQuery("select * from enderecos inner join pacientes "
                + "on PACIENTES_ENDERECOS_ID = ENDERECOS_ID "
                + "where PACIENTES_NUMERO_REGISTRO_NASCIMENTO = :paciente").addEntity(Enderecos.class);
        query.setInteger("paciente", codigo);
        listarEnderecos = query.list();

        session.close();

        return listarEnderecos.get(0);

    }

    public List<Enderecos> listarEnderecos() {
        session = new HibernateUtil().getSessionFactory().openSession();
        Query query = session.createSQLQuery("select*from enderecos").addEntity(Enderecos.class);
        listarEnderecos = query.list();
        listarEnderecos = session.createCriteria(Enderecos.class).list();
        session.close();
        return listarEnderecos;
    }
   
}
