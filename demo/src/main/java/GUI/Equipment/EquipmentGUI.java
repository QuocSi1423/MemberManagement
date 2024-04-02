/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Equipment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.*;


/**
 *
 * @author luong
 */
public class EquipmentGUI extends JPanel {

    Graphics g;
    Input txtGetByName;
    public EquipmentGUI() {
        initComponents();
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
        btnExcel1 = new javax.swing.JButton();
        btnCreate1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        btnCreate2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        jPanel3.setPreferredSize(new java.awt.Dimension(600, 38));
        jPanel3.setLayout(new java.awt.BorderLayout());
        jPanel1.add(jPanel3);

        btnExcel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnExcel1.setText("Thêm file từ Excel");
        btnExcel1.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel1.add(btnExcel1);

        btnCreate1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCreate1.setText("Thiết bị");
        btnCreate1.setPreferredSize(new java.awt.Dimension(150, 40));
        btnCreate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreate1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnCreate1);

        jPanel2.setPreferredSize(new java.awt.Dimension(945, 62));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("Danh sách thiết bị");

        jCheckBox1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox1.setText("All");

        jCheckBox2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox2.setText("Đang được mượn");

        jCheckBox3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox3.setText("Đang trống");

        btnCreate2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCreate2.setText("Xóa thiết bị");
        btnCreate2.setPreferredSize(new java.awt.Dimension(150, 40));
        btnCreate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreate2ActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã thiết bị", "Tên thiết bị", "Mô tả", "Trạng thái"
            }
        ));
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCheckBox1)
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBox2)
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBox3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCreate2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(btnCreate2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreate1ActionPerformed
        CreateEquipmentGUI create = new CreateEquipmentGUI();
        create.setVisible(true);
        create.setSize(775, 450);
        create.setLocationRelativeTo(null); 
    }//GEN-LAST:event_btnCreate1ActionPerformed

    private void btnCreate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreate2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCreate2ActionPerformed

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
        JFrame j = new JFrame();
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setLayout(new FlowLayout());
        j.add(new EquipmentGUI());
        j.setVisible(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate1;
    private javax.swing.JButton btnCreate2;
    private javax.swing.JButton btnExcel1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}