/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.ViolationBUS;
import Entity.Violation;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nqk09
 */
public class ViolationGUI extends javax.swing.JPanel {

    /**
     * Creates new form ViolationGUI
     */
    public ViolationBUS violationBUS = new ViolationBUS();
    public ArrayList<Violation> listViolation = (ArrayList<Violation>) violationBUS.GetViolationListByFilter(null, null, null);

    public ViolationGUI() {
        initComponents();
        loadDataToTable(listViolation);
        tableCustomizer();
        jCheckBox_All.setSelected(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTextField_Search = new javax.swing.JTextField();
        jButton_Add = new javax.swing.JButton();
        jButton_Delete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Violation = new javax.swing.JTable();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jCheckBox_All = new javax.swing.JCheckBox();
        jCheckBox_processed = new javax.swing.JCheckBox();
        jCheckBox_nonprocess = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1050, 770));
        setPreferredSize(new java.awt.Dimension(1050, 770));

        jTextField_Search.setBackground(new java.awt.Color(195, 195, 195));
        jTextField_Search.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jTextField_Search.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_Search.setText("         Tìm kiếm (Ctrl + K)");
        jTextField_Search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_SearchFocusGained(evt);
            }
        });

        jButton_Add.setBackground(new java.awt.Color(255, 0, 0));
        jButton_Add.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton_Add.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-plus-18.png"))); // NOI18N
        jButton_Add.setText("Thêm vi phạm");
        jButton_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AddActionPerformed(evt);
            }
        });

        jButton_Delete.setBackground(new java.awt.Color(51, 51, 51));
        jButton_Delete.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton_Delete.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Delete.setText("Xóa vi phạm");
        jButton_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeleteActionPerformed(evt);
            }
        });

        jScrollPane1.setMinimumSize(new java.awt.Dimension(899, 532));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(899, 532));

        jTable_Violation.setAutoCreateRowSorter(true);
        jTable_Violation.setBackground(new java.awt.Color(255, 255, 255));
        jTable_Violation.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jTable_Violation.setForeground(new java.awt.Color(0, 0, 0));
        jTable_Violation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable_Violation.setMinimumSize(new java.awt.Dimension(899, 532));
        jTable_Violation.setPreferredSize(new java.awt.Dimension(899, 532));
        jTable_Violation.setRowHeight(36);
        jScrollPane1.setViewportView(jTable_Violation);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Danh sách vi phạm");

        jCheckBox_All.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jCheckBox_All);
        jCheckBox_All.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jCheckBox_All.setForeground(new java.awt.Color(0, 0, 0));
        jCheckBox_All.setText("All");
        jCheckBox_All.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_AllActionPerformed(evt);
            }
        });

        jCheckBox_processed.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jCheckBox_processed);
        jCheckBox_processed.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jCheckBox_processed.setForeground(new java.awt.Color(0, 0, 0));
        jCheckBox_processed.setText("Đã xử lý");

        jCheckBox_nonprocess.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jCheckBox_nonprocess);
        jCheckBox_nonprocess.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jCheckBox_nonprocess.setForeground(new java.awt.Color(0, 0, 0));
        jCheckBox_nonprocess.setText("Chưa xử lý");

        jButton1.setBackground(new java.awt.Color(0, 102, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Thêm từ file Excel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jCheckBox_All)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(49, 49, 49)
                                                .addComponent(jCheckBox_processed)
                                                .addGap(34, 34, 34)
                                                .addComponent(jCheckBox_nonprocess)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addGap(112, 112, 112))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTextField_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(35, 35, 35)
                                                .addComponent(jButton1)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton_Add, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton_Delete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(40, 40, 40))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 125, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox_All)
                            .addComponent(jCheckBox_processed)
                            .addComponent(jCheckBox_nonprocess))
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableCustomizer() {
        JTableHeader header = jTable_Violation.getTableHeader();
        header.setPreferredSize(new Dimension(header.getPreferredSize().width, 36));
        header.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                setBorder(BorderFactory.createLineBorder(Color.WHITE));
                setHorizontalAlignment(JLabel.CENTER);
                return this;
            }
        };
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        jTable_Violation.setDefaultRenderer(String.class, centerRenderer);
        headerRenderer.setBackground(new Color(0, 102, 255));
        headerRenderer.setForeground(Color.WHITE);
        for (int i = 0; i < jTable_Violation.getModel().getColumnCount(); i++) {
            jTable_Violation.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        jTable_Violation.getColumnModel().getColumn(5).setPreferredWidth(40);
        jTable_Violation.getColumnModel().getColumn(4).setPreferredWidth(30);
        jTable_Violation.getColumnModel().getColumn(0).setPreferredWidth(40);
    }

    private void loadDataToTable(ArrayList<Violation> list) {
        Collections.sort(list, Comparator.comparingInt(Violation::getViolationId));
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã vi phạm");
        model.addColumn("Mã thành viên");
        model.addColumn("Tên thành viên");
        model.addColumn("Hình thức xử lý");
        model.addColumn("Số tiền");
        model.addColumn("Trạng thái");
        jTable_Violation.setModel(model);
        for (Violation violation : list) {
            model.addRow(new Object[]{violation.getViolationId(), violation.getMemberId(), violation.getMember().getHoTen(), violation.getHadlingType(), violation.getFine(), violation.getStatus()});
        }
    }
    private void jButton_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AddActionPerformed
        Violation_AddGUI violation_AddGUI = new Violation_AddGUI();
        violation_AddGUI.setVisible(true);
    }//GEN-LAST:event_jButton_AddActionPerformed

    private void jCheckBox_AllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_AllActionPerformed
        loadDataToTable(listViolation);
        tableCustomizer();
    }//GEN-LAST:event_jCheckBox_AllActionPerformed

    private void jTextField_SearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_SearchFocusGained
        if (jTextField_Search.getText().equals("         Tìm kiếm (Ctrl + K)")) {
            jTextField_Search.setText("");
            jTextField_Search.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jTextField_SearchFocusGained

    private void jButton_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeleteActionPerformed
        int i = jTable_Violation.getSelectedRow();
        if (i >= 0) {
            int result = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa vi phạm đã chọn?", "Xóa vi phạm", JOptionPane.YES_NO_OPTION);
            if (result == 0) {

                DefaultTableModel model = (DefaultTableModel) jTable_Violation.getModel();
                int id = Integer.parseInt(model.getValueAt(i, 0).toString());
                violationBUS.RemoveViolation(id);
                listViolation = (ArrayList<Violation>) violationBUS.GetViolationListByFilter(null, null, null);
                loadDataToTable(listViolation);
            }
        }
    }//GEN-LAST:event_jButton_DeleteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_Add;
    private javax.swing.JButton jButton_Delete;
    private javax.swing.JCheckBox jCheckBox_All;
    private javax.swing.JCheckBox jCheckBox_nonprocess;
    private javax.swing.JCheckBox jCheckBox_processed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable_Violation;
    private javax.swing.JTextField jTextField_Search;
    // End of variables declaration//GEN-END:variables
}
