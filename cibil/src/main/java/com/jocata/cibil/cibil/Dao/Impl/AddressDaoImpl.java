package com.jocata.cibil.cibil.Dao.Impl;

import com.jocata.cibil.cibil.Dao.AddressDao;
import com.jocata.cibil.cibil.entity.Address;
import com.jocata.cibil.cibil.util.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import static com.jocata.cibil.cibil.util.Hibernate.sessionFactory;
@Repository
public class AddressDaoImpl implements AddressDao {

    @Override
    public Address findAddressByCustomerId(String customerId) {
        Session session = null;
        Transaction tx = null;
        Address address = null;

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            address = session.createQuery(
                            "FROM Address a WHERE a.customers.customerId = :customerId", Address.class)
                    .setParameter("customerId", Integer.parseInt(customerId))
                    .setMaxResults(1)
                    .uniqueResult();

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }

        return address;
    }



    public Address saveAddress(Address entity){
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
}
