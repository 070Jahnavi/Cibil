package com.jocata.cibil.cibil.Dao.Impl;

import com.jocata.cibil.cibil.Dao.CreditReportDao;
import com.jocata.cibil.cibil.entity.*;
import com.jocata.cibil.cibil.util.Hibernate;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class CreditReportDaoImpl implements CreditReportDao {


    public CreditReports saveCreditReport(CreditReports entity) {
        Transaction tx = null;
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

