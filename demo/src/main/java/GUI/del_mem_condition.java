package GUI;

import BUS.MemberBUS;
import enums.Department;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class del_mem_condition extends javax.swing.JFrame {
    Department department = new Department();
    member_layout member_layout = new member_layout();
    
    public del_mem_condition(JPanel jPanel) {
        initComponents();
        this.member_layout = (GUI.member_layout) jPanel;
        setupPage();    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        schoolYearJCB = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        facultyOfMemJCB = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        majorOfMemJCB = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 20)); // NOI18N
        jLabel1.setText("Xóa thành viên theo điều kiện");
        jLabel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel2.setText("Khóa:");

        schoolYearJCB.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel3.setText("Khoa:");

        facultyOfMemJCB.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        facultyOfMemJCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeFacultyJCB(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel4.setText("Ngành:");

        majorOfMemJCB.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Liberation Sans", 1, 20)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Xóa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAllJButton(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(majorOfMemJCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2))
                                        .addGap(29, 29, 29)
                                        .addComponent(schoolYearJCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(facultyOfMemJCB, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(56, 56, 56))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(schoolYearJCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(facultyOfMemJCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(majorOfMemJCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void changeFacultyJCB(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeFacultyJCB
        changeFaculty();
    }//GEN-LAST:event_changeFacultyJCB

    private void deleteAllJButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAllJButton
        int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa thành viên này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION) {
            String faculty = (String) this.facultyOfMemJCB.getSelectedItem();
            String major = (String) this.majorOfMemJCB.getSelectedItem();
            String subId = (String) this.schoolYearJCB.getSelectedItem();
            if(faculty.equals("Chọn tất cả")){
                faculty = null;
            } 
            if(major.equals("Chọn tất cả")) {
                major = null;
            } 
            if(subId.equals("Chọn tất cả")) {
                subId = null;
            }
            MemberBUS memberBUS = new MemberBUS();
            if(memberBUS.deleteMembersByConditions(faculty, major, subId)) {
                JOptionPane.showMessageDialog(null, "Xóa các thành viên thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                this.member_layout.loadDataToTable();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi xóa thành viên!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                this.member_layout.loadDataToTable();
            }
        } else {
            this.dispose();
        }
    }//GEN-LAST:event_deleteAllJButton

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new del_mem_condition().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> facultyOfMemJCB;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> majorOfMemJCB;
    private javax.swing.JComboBox<String> schoolYearJCB;
    // End of variables declaration//GEN-END:variables

    public void setupPage() {
        HashMap<String, ArrayList<String>> map = this.department.getDepartment();
        ArrayList<String> value = new ArrayList<>();
        this.facultyOfMemJCB.addItem("Chọn tất cả");
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            this.facultyOfMemJCB.addItem(key);
        }
        this.schoolYearJCB.addItem("Chọn tất cả");
        for(int i=11; i<=25; i++) {
            this.schoolYearJCB.addItem(i + "");
        }
        
    }
    
    // thay đổi khoa thì đổi lựa chọn ngành
    public void changeFaculty() {
        String faculty = (String) this.facultyOfMemJCB.getSelectedItem();
        if(faculty.equals("Chọn tất cả")) {
            this.majorOfMemJCB.addItem("Chọn tất cả");
            return;
        }
        HashMap<String, ArrayList<String>> departmentMap = Department.getDepartment();
        ArrayList<String> major = departmentMap.get(faculty);
        if (major != null) {
            this.majorOfMemJCB.removeAllItems();
            this.majorOfMemJCB.addItem("Chọn tất cả");
            for (String item : major) {
                this.majorOfMemJCB.addItem(item);
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Không tìm thấy ngành của khoa này!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
}

