package BUS;

import java.util.ArrayList;

import DAL.EquipmentDAL;
import DAL.IDAL.IEquipmentDAL;
import Entity.Equipment;

public class EquipmentBUS {

    private IEquipmentDAL equipmentDAL;

    public EquipmentBUS(IEquipmentDAL equipmentDAL) {
        this.equipmentDAL = equipmentDAL;
    }

    public boolean insertObject(Equipment object) {
        if (((EquipmentDAL) equipmentDAL).getAnObjectByID(object.getMaTB()) == null) {
            return ((EquipmentDAL) equipmentDAL).insertObject(object);
        }
        return false;
    }

    public boolean updateObject(Equipment object) {
        if (((EquipmentDAL) equipmentDAL).getAnObjectByID(object.getMaTB()) != null) {
            return ((EquipmentDAL) equipmentDAL).updateObject(object);
        }
        return false;
    }

    public boolean removeObject(Long objectID) {
        if (((EquipmentDAL) equipmentDAL).getAnObjectByID(objectID) != null) {
            return ((EquipmentDAL) equipmentDAL).removeObject(objectID);
        }
        return false;
    }

    public ArrayList<Equipment> getAllEquipmentBorrowed() {
        return equipmentDAL.getAllEquipmentBorrowed();
    }

    public ArrayList<Equipment> getAllEquipmentNotBorrowed() {
        return equipmentDAL.getAllEquipmentNotBorrowed();
    }

    public Equipment getAnObjectByID(Long objectID) {
        return ((EquipmentDAL) equipmentDAL).getAnObjectByID(objectID);
    }

    public boolean insertList(ArrayList<Equipment> list) {
        return ((EquipmentDAL) equipmentDAL).insertList(list);
    }
}