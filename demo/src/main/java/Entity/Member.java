package Entity;

public class Member {

    private Long maTV;
    private String hoTen;
    private String khoa;
    private String nganh;
    private int sdt;

    public Member(){};

    // Constructor (optional but can improve readability)
    public Member(Long maTV, String hoTen, String khoa, String nganh, int sdt) {
        this.maTV = maTV;
        this.hoTen = hoTen;
        this.khoa = khoa;
        this.nganh = nganh;
        this.sdt = sdt;
    }

    public Member(String hoTen, String khoa, String nganh, int sdt) {
        // this.maTV = maTV;
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
}
