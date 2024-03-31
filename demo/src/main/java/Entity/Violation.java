package Entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "xuly")

public class Violation {
  
@Id
@Column(name = "MaXL")
 private Integer violationId;

 @Column(name = "MaTV")
 private Integer memberId;
 
 @Column(name = "HinhThucXL")
 private String hadlingType;
 
 @Column(name = "SoTien")
 private Integer fine;
 
 @Column(name = "NgayXL")
 private Date handlingDate;
 
 @Column(name = "TrangThaiXL") 
 private Integer status;

 public Violation(){

 } 

 public Violation(Integer violationId, Integer memberId, String hadlingType, Integer fine, Date handlingDate,
    Integer status) {
  this.violationId = violationId;
  this.memberId = memberId;
  this.hadlingType = hadlingType;
  this.fine = fine;
  this.handlingDate = handlingDate;
  this.status = status;
}

public Violation(Integer violationId){
  this.violationId = violationId;
}


public Integer getViolationId() {
  return violationId;
}
public void setViolationId(Integer violationId) {
  this.violationId = violationId;
}
public Integer getMemberId() {
  return memberId;
}
public void setMemberId(Integer memberId) {
  this.memberId = memberId;
}
public String getHadlingType() {
  return hadlingType;
}
public void setHadlingType(String hadlingType) {
  this.hadlingType = hadlingType;
}
public Integer getFine() {
  return fine;
}
public void setFine(Integer fine) {
  this.fine = fine;
}
public Date getHandlingDate() {
  return handlingDate;
}
public void setHandlingDate(Date handlingDate) {
  this.handlingDate = handlingDate;
}
public Integer getStatus() {
  return status;
}
public void setStatus(Integer status) {
  this.status = status;
}


}
