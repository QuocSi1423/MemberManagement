package BUS;
import java.util.ArrayList;

import DAL.EquipmentDAL;
import Entity.Equipment;

public class EquitmentBUS {
	private EquipmentDAL equipmentDAL;
	
	public EquitmentBUS(EquipmentDAL equipmentDAL) {
		this.equipmentDAL = equipmentDAL;
	}
	
 	// public boolean insertObject(Equipment object) {
 	// 	if(this.equipmentDAL.getAnObjectByID(object.getMaTB()) == null) {
 	// 		return this.equipmentDAL.insertObject(object);
 	// 	}
 	// 	return false;
 	// }     
 	
  //   public boolean updateObject(Equipment object) {
  //   	if(this.equipmentDAL.getAnObjectByID(object.getMaTB()) != null) {
 	// 		return this.equipmentDAL.updateObject(object);
 	// 	}
 	// 	return false;
  //   }
    
    public boolean removeObject(Long objectID) {
    	if(this.equipmentDAL.getAnObjectByID(objectID) != null) {
 			return this.equipmentDAL.removeObject(objectID);
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
    	return equipmentDAL.getAnObjectByID(objectID);
    }
}
