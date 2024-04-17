package GUI;

import BUS.MemberBUS;
import Entity.Member;
import static GUI.add_member.isValidVietnamesePhoneNumber;
import enums.Department;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class modify_info_mem extends javax.swing.JFrame {
    Department department = new Department();
    member_layout member_layout = new member_layout();
    // các đối tượng tương tác dữ liệu 
    private MemberBUS memberBUS = new MemberBUS();
    private ArrayList<Member> memberList = new ArrayList<>();

    public modify_info_mem() {
        initComponents();
    }

    public modify_info_mem(Member member, JPanel jPanel) {
        initComponents();
        this.member_layout = (GUI.member_layout) jPanel;
        this.memberList = (ArrayList<Member>) this.memberBUS.getAllMembers();
        removeMemberByCode(member.getMaTV());
        System.out.println(this.memberList.size());
        this.setLocationRelativeTo(null);
        setupPage(member);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        idMemberJTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nameOfMemJTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        phoneOfMemJTF = new javax.swing.JTextField();
        saveJButton = new javax.swing.JButton();
        refeshPageJButton = new javax.swing.JButton();
        facultyOfMemJCB = new javax.swing.JComboBox<>();
        majorOfMemJCB = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 20)); // NOI18N
        jLabel1.setText("Chỉnh sửa thông tin thành viên");

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel2.setText("Mã thành viên: ");

        idMemberJTF.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel3.setText("Họ và tên:");

        nameOfMemJTF.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel4.setText("Khoa:");

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel5.setText("Ngành:");

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel6.setText("Số điện thoại:");

        phoneOfMemJTF.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        saveJButton.setBackground(new java.awt.Color(0, 18, 239));
        saveJButton.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        saveJButton.setForeground(new java.awt.Color(255, 255, 255));
        saveJButton.setText("Lưu");
        saveJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveJButton(evt);
            }
        });

        refeshPageJButton.setBackground(new java.awt.Color(233, 233, 233));
        refeshPageJButton.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        refeshPageJButton.setText("Làm sạch");
        refeshPageJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refeshPageJButton(evt);
            }
        });

        facultyOfMemJCB.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        facultyOfMemJCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeFacultyJCB(evt);
            }
        });

        majorOfMemJCB.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(refeshPageJButton)
                        .addGap(18, 18, 18)
                        .addComponent(saveJButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(88, 88, 88)
                                .addComponent(majorOfMemJCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(31, 31, 31)
                                .addComponent(phoneOfMemJTF))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(16, 16, 16)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nameOfMemJTF)
                                    .addComponent(idMemberJTF)
                                    .addComponent(facultyOfMemJCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 82, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(77, 77, 77))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(idMemberJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nameOfMemJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(facultyOfMemJCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(majorOfMemJCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(phoneOfMemJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveJButton)
                    .addComponent(refeshPageJButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveJButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveJButton
        if (checkValueInput()) {
            long MaTV = Long.parseLong(this.idMemberJTF.getText());
            String HoTen = this.nameOfMemJTF.getText();
            String Khoa = (String) this.facultyOfMemJCB.getSelectedItem();
            String Nganh = (String) this.majorOfMemJCB.getSelectedItem();
            String SDT = this.phoneOfMemJTF.getText();
            Member member = new Member(MaTV, HoTen, Khoa, Nganh, SDT);
            if (memberBUS.updateMember(member)) {
                JOptionPane.showMessageDialog(null, "Cập nhật thông tin thành viên thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                this.member_layout.loadDataToTable();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi cập nhật thông tin thành viên!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_saveJButton

    private void refeshPageJButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refeshPageJButton
        this.idMemberJTF.setText("");
        this.nameOfMemJTF.setText("");
        this.facultyOfMemJCB.setSelectedIndex(0);
        this.majorOfMemJCB.setSelectedIndex(0);
        this.phoneOfMemJTF.setText("");
    }//GEN-LAST:event_refeshPageJButton

    private void changeFacultyJCB(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeFacultyJCB
        changeFaculty();
    }//GEN-LAST:event_changeFacultyJCB

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new modify_info_mem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> facultyOfMemJCB;
    private javax.swing.JTextField idMemberJTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> majorOfMemJCB;
    private javax.swing.JTextField nameOfMemJTF;
    private javax.swing.JTextField phoneOfMemJTF;
    private javax.swing.JButton refeshPageJButton;
    private javax.swing.JButton saveJButton;
    // End of variables declaration//GEN-END:variables

    public void setupPage(Member member) {
        this.idMemberJTF.setText(member.getMaTV() + "");
        this.nameOfMemJTF.setText(member.getHoTen());
        //
        int flag = 0;
        HashMap<String, ArrayList<String>> map = this.department.getDepartment();
        ArrayList<String> value = new ArrayList<>();
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            this.facultyOfMemJCB.addItem(key);
            if (flag == 0) {
                value = map.get(key);
                for (String major : value) {
                    this.majorOfMemJCB.addItem(major);
                }
                flag = 1;
            }
        }
        this.facultyOfMemJCB.setSelectedItem(member.getKhoa());
        this.majorOfMemJCB.setSelectedItem(member.getNganh());
        this.phoneOfMemJTF.setText(member.getSdt());
    }

    // xóa người dùng đang sửa thông tin ra khỏi danh sách
    public void removeMemberByCode(long id) {
        for (Member member : this.memberList) {
            if (member.getMaTV() == id) { // Kiểm tra mã của thành viên
                this.memberList.remove(member); // Xóa thành viên có mã tương ứng
                break; // Kết thúc vòng lặp sau khi tìm thấy và xóa
            }
        }
    }

    // kiểm tra dữ liệu người dùng nhập
    public boolean checkValueInput() {
        if (this.idMemberJTF.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mã thành viên!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (checkDuplicate(Long.parseLong(this.idMemberJTF.getText())) && !this.idMemberJTF.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Mã thành viên đã tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            this.idMemberJTF.setText("");
            return false;
        } else if (this.nameOfMemJTF.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập họ tên thành viên!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (this.phoneOfMemJTF.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập số điện thoại thành viên!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (!this.phoneOfMemJTF.getText().isEmpty() && !isValidVietnamesePhoneNumber(this.phoneOfMemJTF.getText())) {
            JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            this.phoneOfMemJTF.setText("");
            return false;
        }
        return true;
    }

    // kiểm tra số điện thoại người dùng nhập có hợp lệ không 
    public static boolean isValidVietnamesePhoneNumber(String phoneNumber) {
        // Biểu thức chính quy để kiểm tra số điện thoại ở Việt Nam (10 chữ số)
        String regex = "^(0[1-9]|84[1-9]|\\+84[1-9])[0-9]{8}$"; // Định dạng: 0xxx, 84xxx, +84xxx
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    // kiểm tra trùng mã thành viên
    public boolean checkDuplicate(long id) {
        for (Member member : this.memberList) {
            System.out.println(member.getMaTV());
            if (member.getMaTV() == id) {
                return true;
            }
        }
        return false;
    }
    
    // thay đổi khoa thì đổi lựa chọn ngành
    public void changeFaculty() {
        String faculty = (String) this.facultyOfMemJCB.getSelectedItem();
        HashMap<String, ArrayList<String>> departmentMap = Department.getDepartment();
        ArrayList<String> major = departmentMap.get(faculty);
        if (major != null) {
            this.majorOfMemJCB.removeAllItems();
            for (String item : major) {
                this.majorOfMemJCB.addItem(item);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Không tìm thấy ngành của khoa này!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
}
