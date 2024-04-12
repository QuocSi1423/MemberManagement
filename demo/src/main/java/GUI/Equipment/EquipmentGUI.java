/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Equipment;

//import com.formdev.flatlaf.themes.FlatMacLightLaf;
import BUS.EquipmentBUS;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.*;

import DAL.EquipmentDAL;
import Entity.Equipment;
import GUI.Equipment.PreviewExcel.PreviewExcelListener;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author luong
 */
public class EquipmentGUI extends JPanel {

    private EquipmentDAL equipmentDAL;
    private EquipmentBUS equipmentBUS;
    private ArrayList<Equipment> list;
    private int countBorrowed;
    private ButtonGroup buttonGroup;
    Input txtGetByName;

    public EquipmentGUI() {
        initComponents();
        equipmentDAL = new EquipmentDAL();
        equipmentBUS = new EquipmentBUS(equipmentDAL);
        
        list = new ArrayList<>();
        list.addAll(equipmentBUS.getAllEquipmentBorrowed());
        list.addAll(equipmentBUS.getAllEquipmentNotBorrowed());
        
        buttonGroup = new ButtonGroup();
        buttonGroup.add(rbAll);
        buttonGroup.add(rbBorrowed);
        buttonGroup.add(rbNoBorrowed);

        countBorrowed = equipmentBUS.getAllEquipmentBorrowed().size();

        jPanel2.add(new MyCustomJPanel());
        txtGetByName = new Input("Tìm kiếm (Ctrl + K)");
        txtGetByName.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        int ctrlKeyK = Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx();
        txtGetByName.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_K, ctrlKeyK), "focusOnTxtGetByName");
        txtGetByName.getActionMap().put("focusOnTxtGetByName", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtGetByName.requestFocusInWindow();
            }
        });
        

        txtGetByName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Equipment> temp = new ArrayList<>();
                for (Equipment equipment : list) {
                    if (txtGetByName.getText().contains(equipment.getTenTB()) || txtGetByName.getText().contains(equipment.getMoTaTB()) || txtGetByName.getText().contains(equipment.getMaTB().toString())) {
                        temp.add(equipment);
                        System.out.println(equipment.getTenTB());
                    }                
                }
                System.out.println(temp.isEmpty());
                showTable(temp);
            }
        });

        jPanel3.add(txtGetByName);
        rbAll.setSelected(true);
        showTable(list);
    }

    public void showTable(ArrayList<Equipment> listEquipment) {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (value instanceof Component) {
                    return (Component) value;
                }
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
        };

        table.setShowGrid(true);
        table.setGridColor(Color.gray);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        table.setDefaultRenderer(Object.class, new CustomRowHeightRenderer());
        table.getTableHeader().setDefaultRenderer(new CustomHeaderRenderer());
        table.getColumnModel().getColumn(3).setCellRenderer(renderer);
        DefaultTableModel model = (DefaultTableModel) this.table.getModel();
        model.setRowCount(0);
        int i = 0;
        for (Equipment newEq : listEquipment) {
            i++;
            if (i <= countBorrowed) {
                model.addRow(new Object[]{
                    newEq.getMaTB(), newEq.getTenTB(), newEq.getMoTaTB(), "Đã mượn"
                });
            } else {
                model.addRow(new Object[]{
                    newEq.getMaTB(), newEq.getTenTB(), newEq.getMoTaTB(), "Đang trống"
                });
            }
        }
    }

    public Border createRoundedBorder(Color color, int thickness, int radii, int pointerSize) {
        Border lineBorder = new LineBorder(color, thickness);
        Border emptyBorder = new EmptyBorder(thickness, thickness, thickness + pointerSize, thickness);
        return new CompoundBorder(lineBorder, emptyBorder);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnExcel = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        rbAll = new javax.swing.JRadioButton();
        rbBorrowed = new javax.swing.JRadioButton();
        rbNoBorrowed = new javax.swing.JRadioButton();

        jPanel3.setPreferredSize(new java.awt.Dimension(600, 38));
        jPanel3.setLayout(new java.awt.BorderLayout());
        jPanel1.add(jPanel3);

        btnExcel.setBackground(new java.awt.Color(0, 102, 255));
        btnExcel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnExcel.setForeground(new java.awt.Color(255, 255, 255));
        btnExcel.setText("Thêm file từ Excel");
        btnExcel.setPreferredSize(new java.awt.Dimension(200, 40));
        btnExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelActionPerformed(evt);
            }
        });
        jPanel1.add(btnExcel);

        btnCreate.setBackground(new java.awt.Color(0, 102, 255));
        btnCreate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCreate.setForeground(new java.awt.Color(255, 255, 255));
        btnCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-plus-24.png"))); // NOI18N
        btnCreate.setText("Thiết bị");
        btnCreate.setPreferredSize(new java.awt.Dimension(150, 40));
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        jPanel1.add(btnCreate);

        jPanel2.setPreferredSize(new java.awt.Dimension(945, 62));
        jPanel2.setLayout(new java.awt.BorderLayout());

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã thiết bị", "Tên thiết bị", "Mô tả", "Trạng thái"
            }
        ));
        jScrollPane1.setViewportView(table);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("Danh sách thiết bị");

        btnDelete.setBackground(new java.awt.Color(153, 153, 153));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Xóa");
        btnDelete.setPreferredSize(new java.awt.Dimension(150, 40));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(0, 102, 255));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Sửa");
        btnUpdate.setPreferredSize(new java.awt.Dimension(150, 40));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        rbAll.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbAll.setText("All");
        rbAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAllActionPerformed(evt);
            }
        });

        rbBorrowed.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbBorrowed.setText("Đang mượn");
        rbBorrowed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbBorrowedActionPerformed(evt);
            }
        });

        rbNoBorrowed.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbNoBorrowed.setText("Đang trống");
        rbNoBorrowed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNoBorrowedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(rbAll)
                        .addGap(18, 18, 18)
                        .addComponent(rbBorrowed)
                        .addGap(18, 18, 18)
                        .addComponent(rbNoBorrowed)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbAll)
                            .addComponent(rbBorrowed)
                            .addComponent(rbNoBorrowed))))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
                        .addComponent(jScrollPane1)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        CreateEquipmentGUI create = new CreateEquipmentGUI();
        create.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosed(WindowEvent e) {
            refreshList();
        }
    });
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int indexRowSelected = table.getSelectedRow();
        Long equipmentId = Long.parseLong("" + table.getValueAt(indexRowSelected, 0));
        equipmentBUS.removeObject(equipmentId);
        model.removeRow(indexRowSelected);
        refreshList();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        UpdateEquipmentGUI update = new UpdateEquipmentGUI(Long.parseLong("" + table.getValueAt(table.getSelectedRow(), 0)));
        update.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                refreshList();
            }
        });
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void rbAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAllActionPerformed
        list.clear();
        list.addAll(equipmentBUS.getAllEquipmentBorrowed());
        list.addAll(equipmentBUS.getAllEquipmentNotBorrowed());
        showTable(list);
    }//GEN-LAST:event_rbAllActionPerformed

    private void rbBorrowedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbBorrowedActionPerformed
        list.clear();
        list.addAll(equipmentBUS.getAllEquipmentBorrowed());
        showTable(list);
    }//GEN-LAST:event_rbBorrowedActionPerformed

    private void rbNoBorrowedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNoBorrowedActionPerformed
        list.clear();
        list.addAll(equipmentBUS.getAllEquipmentNotBorrowed());
        showTable(list);
    }//GEN-LAST:event_rbNoBorrowedActionPerformed

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {
        PreviewExcel pe = new PreviewExcel();
        pe.setPreviewExcelListener(new PreviewExcelListener() {
            @Override
            public void onExcelPreviewClosed() {
                refreshList();
            }
        });
    }

    private class CustomRowHeightRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object object, boolean isSelected, boolean hasFocus, int row, int column) {
            Component component = super.getTableCellRendererComponent(table, object, isSelected, hasFocus, row, column);

            int desiredRowHeight = 40;
            table.setRowHeight(row, desiredRowHeight);
            return component;
        }
    }

    private class CustomHeaderRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object object, boolean isSelected, boolean hasFocus, int row, int column) {
            Component component = super.getTableCellRendererComponent(table, object, isSelected, hasFocus, row, column);
            String hexColor = "#0066FF";
            Color customColor = Color.decode(hexColor);
            component.setBackground(customColor);
            component.setForeground(Color.WHITE);
            component.setFont(new Font("Segoe UI", Font.BOLD, 16));
            component.setPreferredSize(new Dimension(row, 40));

            JTableHeader header = table.getTableHeader();
            TableColumnModel colModel = header.getColumnModel();
            TableColumn col = colModel.getColumn(column);
            return component;
        }
    }
    
    public void refreshList() {
        list.clear();
        list.addAll(equipmentBUS.getAllEquipmentBorrowed());
        list.addAll(equipmentBUS.getAllEquipmentNotBorrowed());
        rbAll.doClick();
        showTable(list);
    }

    public static void main(String[] args) {
//        FlatMacLightLaf.setup();
        JFrame j = new JFrame();
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setLayout(new FlowLayout());
        j.add(new EquipmentGUI());
        j.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbAll;
    private javax.swing.JRadioButton rbBorrowed;
    private javax.swing.JRadioButton rbNoBorrowed;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
