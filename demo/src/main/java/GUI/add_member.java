package GUI;

import BUS.MemberBUS;
import Entity.Member;
import enums.Department;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class add_member extends javax.swing.JFrame {

    Department department = new Department();
    member_layout member_layout = new member_layout();
    // các đối tượng tương tác dữ liệu 
    private MemberBUS memberBUS = new MemberBUS();
    private ArrayList<Member> memberList = new ArrayList<>();

    public add_member(JPanel jpanel) {
        initComponents();
        this.member_layout = (GUI.member_layout) jpanel;
        this.memberList = (ArrayList<Member>) this.memberBUS.getAllMembers();
        this.setupPage();
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        facultyOfMemJCB = new javax.swing.JComboBox<>();
        majorOfMemJCB = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 20)); // NOI18N
        jLabel1.setText("Thêm thành viên");

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

        jButton1.setBackground(new java.awt.Color(0, 18, 239));
        jButton1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMemberJButton(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(233, 233, 233));
        jButton2.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jButton2.setText("Làm sạch");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
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
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jLabel1)
                        .addGap(0, 140, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nameOfMemJTF)
                                    .addComponent(idMemberJTF)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(90, 90, 90)
                                .addComponent(majorOfMemJCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(31, 31, 31)
                                .addComponent(phoneOfMemJTF))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addGap(102, 102, 102)
                        .addComponent(facultyOfMemJCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
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
                    .addComponent(jButton1)
                    .addComponent(jButton2))
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

    private void addMemberJButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMemberJButton
        if (checkValueInput()) {
            long MaTV = Long.parseLong(this.idMemberJTF.getText());
            String HoTen = this.nameOfMemJTF.getText();
            String Khoa = (String) this.facultyOfMemJCB.getSelectedItem();
            String Nganh = (String) this.majorOfMemJCB.getSelectedItem();
            String SDT = this.phoneOfMemJTF.getText();
            Member member = new Member(MaTV, HoTen, Khoa, Nganh, SDT);
            if (memberBUS.addMember(member)) {
                JOptionPane.showMessageDialog(null, "Thêm thành viên thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                this.member_layout.loadDataToTable();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi thêm thành viên!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_addMemberJButton

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
//                new add_member().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> facultyOfMemJCB;
    private javax.swing.JTextField idMemberJTF;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
    // End of variables declaration//GEN-END:variables

    // set up trang 
    public void setupPage() {
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
