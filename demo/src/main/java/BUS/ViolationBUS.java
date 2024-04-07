package BUS;

import java.sql.Date;

import java.util.List;

import DAL.IViolationDAL;
import DAL.ViolationDAL;
import Entity.Violation;

public class ViolationBUS{
  private IViolationDAL store;
  public ViolationBUS(){
    this.store = new ViolationDAL();
  }

  public ViolationBUS(IViolationDAL store){
    this.store = store;
  }

  public void CreateViolation(Violation violation){
    try {

      store.insertViolation(violation);
    } catch (Exception e) {
      throw e;
    }
  }

  public void ChangeStatusOfViolation(Violation violation) throws Exception{
    try {
      if(!(violation.getStatus() == 0 || violation.getStatus() == 1)){
        throw new Exception("invalid status");
      }
      store.changeStatus(violation);
    } catch (Exception e) {
      throw e;
    }
  }

  public void RemoveViolation(Integer id){
    try {
      store.deleteViolation(id);
    } catch (Exception e) {
      throw e;
    }
  }

  public List<Violation> GetViolationListByFilter(Integer memberId, Integer status, Date startDate, Date endDate){
    try {
      return store.getViolationListByFilter(memberId, status, startDate, endDate);
    } catch (Exception e) {
      throw e;
    }
  }

  public Violation getViolation(Integer id){
    return store.getViolation(id);
  }


}