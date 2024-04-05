package DAL;

import java.sql.Date;
import java.util.List;
import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Entity.Violation;

public class ViolationDAL implements IViolationDAL {

  private SessionFactory sessionFactory;

  public ViolationDAL() {
    try {

      this.sessionFactory = HirbernateUtils.getSessionFactory();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public ViolationDAL(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public void insertViolation(Violation violation) {
    Transaction transaction = null;
    try {
      Session session = this.sessionFactory.openSession();
      transaction = session.beginTransaction();
      session.save(violation);
      transaction.commit();
    } catch (Exception e) {
      transaction.rollback();
      throw e;
    }
  }

  @Override
  public void deleteViolation(Integer id) {
    Transaction transaction = null;
    try {
      Session session = this.sessionFactory.openSession();
      transaction = session.beginTransaction();
      session.delete(new Violation(id));
      transaction.commit();
    } catch (Exception e) {
      transaction.rollback();
      throw e;
    }
  }

  @Override
  public void changeStatus(Violation violation) {
    Transaction transaction = null;
    try {
      Session session = this.sessionFactory.openSession();
      transaction = session.beginTransaction();
      session.update(violation);
      transaction.commit();
    } catch (Exception e) {
      transaction.rollback();
      throw e;
    }
  }

  @Override
  public List<Violation> getViolationListByFilter(Integer status, Date startDate, Date endDate) {
    
    List<Violation> listViolations = null;
    try {
      Session session = this.sessionFactory.openSession();
      String hql = "SELECT v FROM Violation v JOIN FETCH v.member WHERE (:status is null or v.status = :status) and (:startDate is null or :endDate is null or (v.handlingDate < :endDate and v.handlingDate > :startDate))";
      listViolations = session.createQuery(hql, Violation.class).setParameter("status", status).setParameter("startDate", startDate).setParameter("endDate", endDate).list();
      return listViolations;
    } catch (Exception e) {
      throw e;
    }
  }

  @Override
  public Violation getViolation(Integer id){
    try {
      Session session = this.sessionFactory.openSession();
      Violation violation = session.byId(Violation.class).getReference(id);
      return violation;
    } catch (Exception e) {
      throw e;
    }
  }

}