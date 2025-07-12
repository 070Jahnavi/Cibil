package com.jocata.cibil.cibil.Dao.Impl;

import com.jocata.cibil.cibil.Dao.RemarkDao;
import com.jocata.cibil.cibil.entity.Remarks;
import com.jocata.cibil.cibil.util.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.jocata.cibil.cibil.util.Hibernate.sessionFactory;
@Repository
public class RemarkDaoImpl implements RemarkDao {

    public Remarks saveRemark(Remarks entity){
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

    public List<Remarks> findRemarksByReportId(String reportId) {
        Session session = null;
        Transaction tx = null;
        List<Remarks> remarks = null;

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            remarks = session.createQuery(
                            "FROM Remarks WHERE report.reportId = :reportId", Remarks.class)
                    .setParameter("reportId", Integer.parseInt(reportId))
                    .list();

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }

        return remarks;
    }

}
