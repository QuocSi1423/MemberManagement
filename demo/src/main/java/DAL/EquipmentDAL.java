
package DAL;

import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.google.protobuf.LazyStringArrayList;

import Entity.Equipment;

import  javax.persistence.criteria.Predicate;
import DAL.IDAL.*;

public class EquipmentDAL implements IObjectDAL, IEquipmentDAL{
	 private HirbernateUtils sessionFactory;
	 
	 public EquipmentDAL() {
		 sessionFactory = new HirbernateUtils();
	 }

	public <T> boolean updateObject(T object) {
		  Equipment equipmentUpdate = (Equipment) object;
		  Session session = sessionFactory.getSessionFactory().openSession();
		  Transaction transaction = session.beginTransaction();
	        try {
	        	Equipment equipmentOrig = session.get(Equipment.class, equipmentUpdate.getMaTB());

	        	if (equipmentOrig != null) {
	        		equipmentOrig.setTenTB(equipmentUpdate.getTenTB());
	        		equipmentOrig.setMoTaTB(equipmentUpdate.getMoTaTB());
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
	
	public boolean insertObject(Object obj) {
        Session session = sessionFactory.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
        try {
        	Equipment equipment = (Equipment) obj;
        	session.save(equipment);
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
	

    public boolean removeObject(Long objectID) {
        Session session = sessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Equipment objectDelete = session.get(Equipment.class,  objectID);
            if (objectDelete != null) {
                session.delete(objectDelete);
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

    public void removeEquipmentByFilter(int type){
        Transaction transaction = null;
        try (Session session = sessionFactory.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaDelete<Equipment> criteriaDelete = builder.createCriteriaDelete(Equipment.class);
            Root<Equipment> root = criteriaDelete.from(Equipment.class);

            criteriaDelete.where(builder.like(root.get("maTB").as(String.class), type + "%"));

            // Thực hiện xóa
            int deletedCount = session.createQuery(criteriaDelete).executeUpdate();

            transaction.commit();

        } catch (Exception e) {
            throw e;
        }
    }
    
    public Equipment getAnObjectByID(Long objectID) {
    	   Session session = sessionFactory.getSessionFactory().openSession();
           try {
               return session.get(Equipment.class, objectID);
           } finally {
               session.close();
           }
	}
    
    public ArrayList<Equipment> getAllEquipmentNotBorrowed() {
        Session session = sessionFactory.getSessionFactory().openSession();
        try {
        	String query = "SELECT"
        			+ "FROM thietbi"
        			+ "WHERE MaTB NOT IN ("
        			+ "    SELECT MaTB"
        			+ "    FROM thongtinsd"
        			+ "    WHERE TGMuon <= NOW() AND (TGTra > NOW() OR TGTra IS NULL)"
        			+ ")";
            return (ArrayList<Equipment>) session.createQuery("query").list();
        } finally {
            session.close();
        }
    }
    
    public ArrayList<Equipment> getAllEquipmentBorrowed() {
        Session session = sessionFactory.getSessionFactory().openSession();
        try {
        	String query = "SELECT thietbi.*"
        			+ "FROM thietbi"
        			+ "INNER JOIN thongtinsd ON thietbi.MaTB = thongtinsd.MaTB"
        			+ "WHERE thongtinsd.TGMuon <= NOW() AND (thongtinsd.TGTra > NOW()"
        			+ "OR thongtinsd.TGTra IS NULL)";
            return (ArrayList<Equipment>) session.createQuery("query").list();
        } finally {
            session.close();
        }
    }
    
    public boolean insertList(ArrayList<Equipment> list) {
		for (Equipment equipmentItem : list) {
    		new EquipmentDAL().insertObject(equipmentItem);
		}
		return true;
    }
	
	
}
