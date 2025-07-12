package com.jocata.cibil.cibil.Dao.Impl;

import com.jocata.cibil.cibil.Dao.CustomerDao;
import com.jocata.cibil.cibil.entity.Customers;
import com.jocata.cibil.cibil.util.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.jocata.cibil.cibil.util.Hibernate.sessionFactory;
@Repository
public class CustomerDaoImpl implements CustomerDao {

    public Customers saveCustomer(Customers entity){
        Transaction tx=null;
        try {
            Session session = Hibernate.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.persist(entity);
            tx.commit();
            return entity;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            return null;
        }

    }

    public Customers findCustomerByPan(String pan) {
        Session session = null;
        Transaction tx = null;
        Customers customer = null;

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            List<Customers> customers = session.createQuery(
                            "FROM Customers WHERE UPPER(TRIM(pan)) = :pan", Customers.class)
                    .setParameter("pan", pan.trim().toUpperCase())
                    .getResultList();

            tx.commit();

            if (!customers.isEmpty()) {
                customer = customers.get(0);  // pick the first if multiple exist
            }
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }

        return customer;
    }



}
