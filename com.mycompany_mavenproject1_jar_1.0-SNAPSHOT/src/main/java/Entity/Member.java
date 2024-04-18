package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // This annotation marks the class as a Hibernate entity
@Table(name = "thanhvien") // This annotation specifies the mapped table name
public class Member {

    @Id // This annotation marks the property as the primary key
    @Column(name = "MaTV") // This annotation specifies the mapped column name
    private Long maTV;

    @Column(name = "HoTen") // This annotation specifies the mapped column name
    private String hoTen;

    @Column(name = "Khoa") // This annotation specifies the mapped column name
    private String khoa;

    @Column(name = "Nganh") // This annotation specifies the mapped column name
    private String nganh;

    @Column(name = "SDT") // This annotation specifies the mapped column name
    private int sdt;

    public Member() {}

    // Constructor (optional but can improve readability)
    public Member(Long maTV, String hoTen, String khoa, String nganh, int sdt) {
        this.maTV = maTV;
        this.hoTen = hoTen;
        this.khoa = khoa;
        this.nganh = nganh;
        this.sdt = sdt;
    }

    public Member(String hoTen, String khoa, String nganh, int sdt) {
        // this.maTV = maTV; // This constructor can be used if maTV is auto-generated
        this.hoTen = hoTen;
        this.khoa = khoa;
        this.nganh = nganh;
        this.sdt = sdt;
    }

    // Getters and setters
    public Long getMaTV() {
        return maTV;
    }

    public void setMaTV(Long maTV) {
        this.maTV = maTV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    void setMaTV(Integer memberId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
