package DAL;

import DAL.IDAL.IEquipmentDAL;
import DAL.IDAL.IObjectDAL;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.google.protobuf.LazyStringArrayList;

import Entity.Equipment;

import javax.persistence.criteria.Predicate;

public class EquipmentDAL implements IObjectDAL, IEquipmentDAL {

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
        boolean rs = insertObject(obj, session);
        transaction.commit();
        return rs;
    }

    public boolean insertObject(Object obj, Session session) {
        try {
            Equipment equipment = (Equipment) obj;
            session.save(equipment);
        } catch (Exception e) {
            return false;
        } finally {
            return true;
        }
    }

    public boolean removeObject(Long objectID) {
        Session session = sessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Equipment objectDelete = session.get(Equipment.class, objectID);
            if (objectDelete != null) {
                session.delete(objectDelete);
            }
            transaction.commit();
        } catch (Exception e) {
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
        HirbernateUtils sessionFactory = new HirbernateUtils();
        Session session = sessionFactory.getSessionFactory().openSession();

        LocalDateTime thoiDiemHienTai = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(thoiDiemHienTai);
        Date date = new Date(timestamp.getTime());
        String hql = "SELECT tb FROM Equipment tb WHERE tb.maTB NOT IN "
                + "(SELECT tt.equipmentId FROM Usage tt "
                + "WHERE :thoiDiemHienTai BETWEEN tt.borrowingTime AND tt.returnTime)";
        Query query = session.createQuery(hql);
        query.setParameter("thoiDiemHienTai", date);
        return (ArrayList<Equipment>) query.list();
    }

    public ArrayList<Equipment> getAllEquipmentBorrowed() {

        Session session = sessionFactory.getSessionFactory().openSession();

        String hql = "SELECT tb FROM Equipment tb WHERE tb.maTB IN "
                + "(SELECT tt.equipmentId FROM Usage tt "
                + "WHERE :thoiDiemHienTai BETWEEN tt.borrowingTime AND tt.returnTime)";

        LocalDateTime thoiDiemHienTai = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(thoiDiemHienTai);
        Date date = new Date(timestamp.getTime());
        Query<Equipment> query = session.createQuery(hql, Equipment.class);
        query.setParameter("thoiDiemHienTai", date);

        return (ArrayList<Equipment>) query.list();

    }

    public boolean insertList(ArrayList<Equipment> list) {
        Session session = sessionFactory.getSessionFactory().openSession();
        EquipmentDAL equipmentDAL = new EquipmentDAL();
        Transaction transaction = session.beginTransaction();
        try {
            for (Equipment equipmentItem : list) {
                Equipment e = equipmentDAL.getAnObjectByID(equipmentItem.getMaTB());
                if (e == null) {
                    equipmentDAL.insertObject(equipmentItem, session);
                } else {
//                                        equipmentItem.getMaTB();

                    transaction.rollback();
                    throw new Exception("Khong the them thiet bi do danh sach co thiet bi co ma da duoc tao: " + equipmentItem.getMaTB().toString());
                }
            }

        } catch (Exception e) {
            transaction.rollback();
            return false;
            // TODO: handle exception
        }
        transaction.commit();
        session.close();
        return true;
    }
}
