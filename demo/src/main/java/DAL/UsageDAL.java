package DAL;

import DAL.IDAL.IUsageDAL;
import static DAL.IDAL.IUsageDAL.FILTER_NOT_YET_RETURNED;
import static DAL.IDAL.IUsageDAL.FILTER_RETURNED;
import Entity.Usage;
import Entity.Violation;

import java.sql.Date;
import java.util.List;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UsageDAL implements IUsageDAL {

    private SessionFactory sessionFactory;

    public UsageDAL() {
        try {
            this.sessionFactory = HirbernateUtils.getSessionFactory();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public UsageDAL(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void insertUsage(Usage usage) {
        Transaction transaction = null;
        try {
            Session session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(usage);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
    }

    @Override
    public void deleteUsage(Integer usageId) {
        Transaction transaction = null;
        try {
            Session session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(new Usage(usageId));
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
    }

    @Override
    public Usage getUsage(Integer usageId) {
        try {
            Session session = this.sessionFactory.openSession();
            Usage usage = session.byId(Usage.class).getReference(usageId);
            return usage;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Usage> getBorrowingListByFilter(Integer filter, Date startDate, Date endDate) {
        List<Usage> listBorrowing = null;
        try {
            Session session = this.sessionFactory.openSession();
            
            String extraHql = "(:true)";
            if (filter == FILTER_RETURNED) { extraHql = "(TGTra is not null)"; }
            else if (filter == FILTER_NOT_YET_RETURNED) { extraHql = "(TGTra is null)"; }

            String hql = "from Usage where (:startDate is null or TGMuon > :startDate) and (:endDate is null or TGMuon < :endDate) and " + extraHql;

            listBorrowing = session
                    .createQuery(hql, Usage.class)
                    .setParameter("startDate", startDate)
                    .setParameter("endDate", endDate)
                    .list();

            return listBorrowing;
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Override
    public List<Usage> getBorrowingListByMemberId(Integer id) {
        List<Usage> listBorrowing = null;
        try {
            Session session = this.sessionFactory.openSession();
            
            String hql = "from Usage where (MaTV = :memberId)";

            listBorrowing = session
                    .createQuery(hql, Usage.class)
                    .setParameter("memberId", id)
                    .list();

            return listBorrowing;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Usage> getEntryList(Date startDate, Date endDate) {
        List<Usage> listEntry= null;
        try {
            Session session = this.sessionFactory.openSession();
            
            String hql = "from Usage where (:startDate is null or TGVao > :startDate) and (:endDate is null or TGVao < :endDate)";

            listEntry = session
                    .createQuery(hql, Usage.class)
                    .setParameter("startDate", startDate)
                    .setParameter("endDate", endDate)
                    .list();

            return listEntry;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
  public void insertReturnTime(Integer usageId, Date returnTime) {
    Transaction transaction = null;
    try (Session session = this.sessionFactory.openSession()) {
        transaction = session.beginTransaction();

        Usage usage = session.get(Usage.class, usageId);
        usage.setReturnTime(returnTime);

        session.update(usage);
        transaction.commit();
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        throw e;
    }
}

    @Override
    public void deleteReturnTime(Integer usageId) {
        Transaction transaction = null;
        try {
            Session session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();
            Usage usage = getUsage(usageId);
            usage.setReturnTime(null);
            session.update(usage);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
    }

}