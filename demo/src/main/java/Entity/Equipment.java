package Entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "thietbi")
public class Equipment {
	@Id 
    @Column(name = "MaTB") 
	private Long maTB;
	

    @Column(name = "TenTB") 
	private String tenTB;
    
    @Column(name = "MoTaTB") 
	private String moTaTB;
    
    public Equipment() {}

	public Equipment(Long maTB, String tenTB, String moTaTB) {
		super();
		this.maTB = maTB;
		this.tenTB = tenTB;
		this.moTaTB = moTaTB;
	}

	public Long getMaTB() {
		return maTB;
	}

	public void setMaTB(Long maTB) {
		this.maTB = maTB;
	}

	public String getTenTB() {
		return tenTB;
	}

	public void setTenTB(String tenTB) {
		this.tenTB = tenTB;
	}

	public String getMoTaTB() {
		return moTaTB;
	}

	public void setMoTaTB(String moTaTB) {
		this.moTaTB = moTaTB;
	}
}