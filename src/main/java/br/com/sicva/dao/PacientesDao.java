/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sicva.dao;

import br.com.sicva.connection.HibernateUtil;
import br.com.sicva.model.Pacientes;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Rodrigo
 */
public class PacientesDao {

    private Session session;
    private Transaction tx;
    List<Pacientes> listarPacientes = new ArrayList<Pacientes>();

    public boolean salvarPacientes(Pacientes paciente) {
        try {
            session = new HibernateUtil().getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(paciente);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro no Banco!" + e.getMessage());
            tx.rollback();
            return false;
        }
    }

    public boolean alterarPacientes(Pacientes paciente) {
        try {
            session = new HibernateUtil().getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(paciente);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro no Banco!" + e.getMessage());
            tx.rollback();
            return false;
        }
    }

    public Pacientes consultarPorCpf(String cpf) {

        session = new HibernateUtil().getSessionFactory().openSession();

        Query query = session.createSQLQuery("select * from paciente where clicpf='" + cpf + "'").addEntity(Pacientes.class);

        listarPacientes = query.list();

        session.close();

        return listarPacientes.get(0);

    }

    public List<Pacientes> listarPacientes() {
        session = new HibernateUtil().getSessionFactory().openSession();
        Query query = session.createSQLQuery("select*from pacientes ").addEntity(Pacientes.class);
        listarPacientes = query.list();        
        session.close();
        return listarPacientes;
    }

    public Pacientes listarPorNome(String nome) {
        session = new HibernateUtil().getSessionFactory().openSession();
        Query query = session.createSQLQuery("select*from paciente where clinome='" + nome + "'").addEntity(Pacientes.class);
        listarPacientes = query.list();
        session.close();
        return listarPacientes.get(0);
    }

    public Pacientes listarPorRegistro(int codigo) {
        try {
            session = new HibernateUtil().getSessionFactory().openSession();
            Query query = session.createSQLQuery("select * from pacientes where PACIENTES_NUMERO_REGISTRO_NASCIMENTO = :registro").addEntity(Pacientes.class);
            query.setInteger("registro", codigo);
            listarPacientes = query.list();
            session.close();
            return listarPacientes.get(0);
        } catch (Exception e) {
            return null;
        }
    }

}
