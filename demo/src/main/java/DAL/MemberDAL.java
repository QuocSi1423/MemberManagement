package DAL;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import  javax.persistence.criteria.Predicate;


import DAL.IDAL.IMemberDAL;
import DAL.IDAL.IObjectDAL;
import Entity.Member;

public class MemberDAL implements IObjectDAL, IMemberDAL {

    private HirbernateUtils sessionFactory;

    public MemberDAL() {
        this.sessionFactory = new HirbernateUtils();
    }

    // Add a member with full information => test done
    @SuppressWarnings("finally")
    public boolean insertObject(Object obj) {
        Member member = (Member) obj;
        Session session = sessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(member);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            transaction.rollback();
            session.close();
            return false;
        } finally {
            session.close();
            return true;
        }
    }

    // Update member information with maTV => test done
    @SuppressWarnings("finally")
    public boolean updateObject(Object obj) {
        Member updatedMember = (Member) obj;
        Session session = sessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Member memberToUpdate = session.get(Member.class, updatedMember.getMaTV());
            if (memberToUpdate != null) {
                memberToUpdate.setHoTen(updatedMember.getHoTen());
                memberToUpdate.setKhoa(updatedMember.getKhoa());
                memberToUpdate.setNganh(updatedMember.getNganh());
                memberToUpdate.setSdt(updatedMember.getSdt());
                session.update(memberToUpdate);
            }
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            transaction.rollback();
            session.close();
            return false;
        } finally {
            session.close();
            return true;
        }
    }

    // Delete member with maTV => test done
    @SuppressWarnings("finally")
    public boolean removeObject(Long maTV) {
        Session session = sessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Member memberToDelete = session.get(Member.class, maTV);
            if (memberToDelete != null) {
                session.delete(memberToDelete);
            }
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            transaction.rollback();
            session.close();
            return false;
        } finally {
            session.close();
            return true;
        }
    }

    // Get member by maTV => test done
    public Member getAnObjectByID(Long maTV) {
        Session session = sessionFactory.getSessionFactory().openSession();
        try {
            return session.get(Member.class, maTV);
        } finally {
            session.close();
        }
    }

    // Get all members => test done
    @SuppressWarnings("unchecked")
    public List<Member> getAllMembers() {
        Session session = sessionFactory.getSessionFactory().openSession();
        try {
            return session.createQuery("from Member").list();
        } finally {
            session.close();
        }
    }

    @SuppressWarnings("finally")
    public boolean deleteMembersByConditions(String khoa, String nganh, String maTVSubstring) {
        Session session = sessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaDelete<Member> deleteCriteria = criteriaBuilder.createCriteriaDelete(Member.class);
            Root<Member> memberRoot = deleteCriteria.from(Member.class);

            Predicate conditions = criteriaBuilder.conjunction();

            if (khoa != null && !khoa.isEmpty()) {
                conditions = criteriaBuilder.and(conditions, criteriaBuilder.equal(memberRoot.get("khoa"), khoa));
            }

            if (nganh != null && !nganh.isEmpty()) {
                conditions = criteriaBuilder.and(conditions, criteriaBuilder.equal(memberRoot.get("nganh"), nganh));
            }

            if (maTVSubstring != null && !maTVSubstring.isEmpty()) {
                conditions = criteriaBuilder.and(conditions, criteriaBuilder.equal(
                    criteriaBuilder.substring(memberRoot.get("maTV").as(String.class), 3, 2), maTVSubstring));
            }

            System.err.println(conditions.toString());

            deleteCriteria.where(conditions);
            session.createQuery(deleteCriteria).executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            System.out.println(e.getLocalizedMessage());
            return false;
        } finally {
            session.close();
            return true;
        }
    }

    public static void main(String[] args) {
        
    }
}
