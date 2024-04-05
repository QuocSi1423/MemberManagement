package DAL;

import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.google.protobuf.LazyStringArrayList;

import DAL.IDAL.IObjectDAL;
import Entity.Equipment;

import  javax.persistence.criteria.Predicate;


public class EquipmentDAL implements IObjectDAL{
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
        	String query = "SELECT *\r\n"
        			+ "FROM thietbi\r\n"
        			+ "WHERE MaTB NOT IN (\r\n"
        			+ "    SELECT MaTB\r\n"
        			+ "    FROM thongtinsd\r\n"
        			+ "    WHERE TGMuon <= NOW() AND (TGTra > NOW() OR TGTra IS NULL)\r\n"
        			+ ")";
            return (ArrayList<Equipment>) session.createQuery("query").list();
        } finally {
            session.close();
        }
    }
    
    public ArrayList<Equipment> getAllEquipmentBorrowed() {
        Session session = sessionFactory.getSessionFactory().openSession();
        try {
        	String query = "SELECT thietbi.*\r\n"
        			+ "FROM thietbi\r\n"
        			+ "INNER JOIN thongtinsd ON thietbi.MaTB = thongtinsd.MaTB\r\n"
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
	
	public static void main(String[] args) {
		Equipment model = new Equipment(2, "Máy Chiếu", "Máy Chiếu mô tả");
		EquipmentDAL e = new EquipmentDAL();
		e.removeObject((long) 2);
		
	}

	
}
