package com.jocata.cibil.cibil.Dao.Impl;

import com.jocata.cibil.cibil.Dao.EnquiryDao;
import com.jocata.cibil.cibil.entity.Enquries;
import com.jocata.cibil.cibil.util.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.jocata.cibil.cibil.util.Hibernate.sessionFactory;
@Repository
public class EnquiryDaoImpl implements EnquiryDao {

    public Enquries saveEnquiry(Enquries entity){
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

    public List<Enquries> findEnquiriesByReportId(String reportId) {
        Session session = null;
        Transaction tx = null;
        List<Enquries> enquiries = null;

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            enquiries = session.createQuery(
                            "FROM Enquries WHERE report.reportId = :reportId", Enquries.class)
                    .setParameter("reportId", Integer.parseInt(reportId))
                    .list();

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }

        return enquiries;
    }



}
