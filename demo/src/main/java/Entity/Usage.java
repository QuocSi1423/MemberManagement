package Entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "thongtinsd")

public class Usage {

    @Id
    @Column(name = "MaTT")
    private Integer usageId;

    @Column(name = "MaTV", insertable = false, updatable = false)
    private Integer memberId;

    @Column(name = "MaTB")
    private Integer equipmentId;

    @Column(name = "TGVao")
    private Date entryTime;

    @Column(name = "TGMuon")
    private Date borrowingTime;

    @Column(name = "TGTra")
    private Date returnTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MaTV",  referencedColumnName = "MaTV") 
    private Member member;


    public Usage() {}

    public Usage(Integer usageId) {
        this.usageId = usageId;
    }

    public Usage(Integer usageId, Integer memberId, Integer equipmentId, Date entryTime, Date borrowingTime,
            Date returnTime) {
        this.usageId = usageId;
        this.memberId = memberId;
        this.equipmentId = equipmentId;
        this.entryTime = entryTime;
        this.borrowingTime = borrowingTime;
        this.returnTime = returnTime;
    }

    public Integer getUsageId() {
        return usageId;
    }

    public void setUsageId(Integer usageId) {
        this.usageId = usageId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Date getBorrowingTime() {
        return borrowingTime;
    }

    public void setBorrowingTime(Date borrowingTime) {
        this.borrowingTime = borrowingTime;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returningTime) {
        this.returnTime = returningTime;
    }

}
