package DAL.IDAL;

import java.util.ArrayList;

import Entity.Equipment;

public interface IEquipmentDAL {
    public ArrayList<Equipment> getAllEquipmentNotBorrowed();
    public ArrayList<Equipment> getAllEquipmentBorrowed();
    public void removeEquipmentByFilter(int type);
}
