/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Equipment;

//import com.formdev.flatlaf.themes.FlatMacLightLaf;
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

import BUS.EquitmentBUS;
import DAL.EquipmentDAL;
import Entity.Equipment;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author luong
 */
public class EquipmentGUI extends JPanel {
    private Equipment equipment;
    private EquipmentDAL equipmentDAL;
    private EquitmentBUS equitmentBUS;
    private ArrayList<Equipment> listEquipmentBorrowed;
    private ArrayList<Equipment> listEquipmentNotBorrowed;
    Input txtGetByName;

    public EquipmentGUI() {
        initComponents();
        listEquipmentBorrowed = new ArrayList<>();
        listEquipmentNotBorrowed = new ArrayList<>();
        equipmentDAL = new EquipmentDAL();
        equitmentBUS = new EquitmentBUS(equipmentDAL);
        equipment = new Equipment();

        listEquipmentBorrowed = equitmentBUS.getAllEquipmentBorrowed();
        listEquipmentNotBorrowed = equitmentBUS.getAllEquipmentNotBorrowed();

        jPanel2.add(new MyCustomJPanel());
        txtGetByName = new Input("Tìm kiếm (Ctrl + K)");
        txtGetByName.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        txtGetByName.setBorder(createRoundedBorder(Color.GRAY, 2, 16, 0));

        int ctrlKeyK = Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx();
        txtGetByName.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_K, ctrlKeyK), "focusOnTxtGetByName");
        txtGetByName.getActionMap().put("focusOnTxtGetByName", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtGetByName.requestFocusInWindow();
            }
        });

        jPanel3.add(txtGetByName);
        showTable();
    }

    public void showTable() {
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
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setDefaultRenderer(Object.class, new CustomRowHeightRenderer());
        table.getTableHeader().setDefaultRenderer(new CustomHeaderRenderer());
        table.getColumnModel().getColumn(3).setCellRenderer(renderer);
        DefaultTableModel model = (DefaultTableModel) this.table.getModel();
        model.setRowCount(0);
//      for (StudentDTO stu : studentList) {
//      model.addRow(new Object[] {
//          stu.getID(), stu.getLastName(), stu.getFirstName(),
//          lblDelete
//      });
//    }
    }

    public Border createRoundedBorder(Color color, int thickness, int radii, int pointerSize) {
        Border lineBorder = new LineBorder(color, thickness);
        Border emptyBorder = new EmptyBorder(thickness, thickness, thickness + pointerSize, thickness);
        return new CompoundBorder(lineBorder, emptyBorder);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnExcel = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

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

        jCheckBox1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox1.setText("All");

        jCheckBox2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox2.setText("Đang được mượn");

        jCheckBox3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox3.setText("Đang trống");

        btnDelete.setBackground(new java.awt.Color(0, 102, 255));
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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox2)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox3)))
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
                            .addComponent(jCheckBox2)
                            .addComponent(jCheckBox3)
                            .addComponent(jCheckBox1))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        CreateEquipmentGUI create = new CreateEquipmentGUI();
        create.setVisible(true);
        create.setSize(775, 450);
        create.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {
        File excelFile;
        FileInputStream excelFIS = null;
        BufferedInputStream excelBIS = null;
        XSSFWorkbook excelJTableImport = null;

        DefaultTableModel model = (DefaultTableModel) this.table.getModel();
        model.setRowCount(0);

        String defaultCurrentDirectoryPath = "C:\\Users\\luong\\Downloads\\";
        JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
        System.out.println("excelFileChooser " + excelFileChooser);
        int excelChoose = excelFileChooser.showOpenDialog(null);

        if (excelChoose == JFileChooser.APPROVE_OPTION) {
            try {
                excelFile = excelFileChooser.getSelectedFile();
                excelFIS = new FileInputStream(excelFile);
                excelBIS = new BufferedInputStream(excelFIS);

                excelJTableImport = new XSSFWorkbook(excelBIS);
                XSSFSheet excelSheet = excelJTableImport.getSheetAt(0);
                System.out.println("excelsheet " + excelSheet);

                for (int row = 1; row <= excelSheet.getLastRowNum(); row++) {
                    System.out.println("row: " + row);
                    XSSFRow excelRow = excelSheet.getRow(row);
                    XSSFCell excelId = excelRow.getCell(0);
                    XSSFCell excelName = excelRow.getCell(1);
                    XSSFCell excelDes = excelRow.getCell(2);
                    model.addRow(new Object[] {
                        excelId, excelName, excelDes
                    });
                }

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException ex) {
                Logger.getLogger(EquipmentGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
