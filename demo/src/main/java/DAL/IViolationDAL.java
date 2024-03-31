package DAL;

import java.sql.Date;
import java.util.List;

import javax.sound.midi.VoiceStatus;

import Entity.Violation;

public interface IViolationDAL {
  public void insertViolation(Violation violation);
  public void deleteViolation(Integer id);
  public void changeStatus(Violation violation);
  public Violation getViolation(Integer id);
  public List<Violation> getViolationListByFilter(Integer status, Date startDate, Date endDate);

}
