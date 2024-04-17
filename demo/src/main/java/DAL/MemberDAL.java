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
import java.util.ArrayList;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;

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
        boolean result = true;
        try {
            session.save(member);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            transaction.rollback();
            result = false;
        } finally {
            session.close();
            return result;
        }
    }

    public String addMultipleMembers(List<Member> members) {
        List<Long> addedMemberIds = new ArrayList<Long>(); // in case any issue happens, remove previous records;
        boolean flag = true;
        String result = "";
        for (Member mem : members) {
            if (!insertObject(mem)) {
                flag = false;
                result = mem.getMaTV().toString();
                break;
            }
            addedMemberIds.add(mem.getMaTV());
        }
        if (flag == false && addedMemberIds.size() > 0) {
            for (Long id : addedMemberIds) {
                removeObject(id);
            }
        }
        return result;
    }

    // Update member information with maTV => test done
    @SuppressWarnings("finally")
    public boolean updateObject(Object obj) {
        Member updatedMember = (Member) obj;
        Session session = sessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        boolean result = true;
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
            result = false;
        } finally {
            session.close();
            return result;
        }
    }

    @SuppressWarnings("finally")
    public boolean updateMemberMaTV(Long oldMaTV, Long newMaTV) {
        Session session = sessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        boolean result = true;
        try {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaUpdate<Member> updateCriteria = criteriaBuilder.createCriteriaUpdate(Member.class);
            Root<Member> memberRoot = updateCriteria.from(Member.class);

            updateCriteria.set("maTV", newMaTV); // Set the new maTV value
            updateCriteria.where(criteriaBuilder.equal(memberRoot.get("maTV"), oldMaTV)); // Update where maTV matches oldMaTV

            session.createQuery(updateCriteria).executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            transaction.rollback();
            result = false;
        } finally {
            session.close();
            return result;
        }
    }

    // Delete member with maTV => test done
    @SuppressWarnings("finally")
    public boolean removeObject(Long maTV) {
        Session session = sessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        boolean result = true;
        try {
            Member memberToDelete = session.get(Member.class, maTV);
            if (memberToDelete != null) {
                session.delete(memberToDelete);
            }
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            transaction.rollback();
            result = false;
        } finally {
            session.close();
            return result;
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
        boolean result = true;
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
            System.out.println(e.getLocalizedMessage());
            result = false;
        } finally {
            session.close();
            return result;
        }
    }

    public List<Member> searchMembersByName(String name) {
        Session session = sessionFactory.getSessionFactory().openSession();
        try {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Member> query = criteriaBuilder.createQuery(Member.class);
            Root<Member> memberRoot = query.from(Member.class);
    
            query.select(memberRoot)
                .where(criteriaBuilder.like(memberRoot.get("hoTen").as(String.class), "%" + name + "%"));
    
            return session.createQuery(query).getResultList();
        } finally {
            session.close();
        }
    }

    public static void main(String[] args) {
        
    }
}
