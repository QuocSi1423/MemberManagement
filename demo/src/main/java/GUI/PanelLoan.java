/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.MemberBUS;
import BUS.UsageBUS;
import DAL.MemberDAL;
import DAL.UsageDAL;
import Entity.Member;
import Entity.Usage;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

/**
 *
 * @author Thinkbook 14 G3
 */
public class PanelLoan extends javax.swing.JPanel {

    /**
     * Creates new form PanelLoan
     */
     UsageDAL use= new UsageDAL();
    UsageBUS usebus= new UsageBUS(use);
    MemberDAL member = new MemberDAL();
    MemberBUS memberbus= new MemberBUS();
    private int bienxoa=-1;
    private void tableCustomizer() {
        JTableHeader header = jtable.getTableHeader();
        header.setPreferredSize(new Dimension(header.getPreferredSize().width, 40));
        header.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                setBorder(BorderFactory.createLineBorder(Color.black));
                setHorizontalAlignment(JLabel.CENTER);
                return this;
            }
        };
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        jtable.setDefaultRenderer(String.class, centerRenderer);
        headerRenderer.setBackground(Color.BLUE);
        headerRenderer.setForeground(Color.WHITE);
        for (int i = 0; i < jtable.getModel().getColumnCount(); i++) {
            
           jtable.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
    }
    public void themmuon() throws IOException{
           GUIloanslip a= new GUIloanslip();
           a.setVisible(true);
    }
    public void themmuonexcel() throws IOException{
           GUIloanexcel b= new GUIloanexcel();
           b.setVisible(true);
    }
    public void all(){
        if(all.isSelected()){
            List<Usage> listtemp = usebus.GetEntryList(null, null);
            adddata(listtemp);
      
          
        }
    }
    public void tra() {
    if (tra.isSelected()) {
        List<Usage> listtemp = usebus.GetEntryList(null, null);
        
        List<Usage> borrowingList = new ArrayList<>();
        for (Usage usage : listtemp) {
            if (usage.getReturnTime()!= null) {
                borrowingList.add(usage);
                
            }
        }
         adddata(borrowingList);
         
       
    }
        }
       public void chua() {
    if (chua.isSelected()) {
        List<Usage> listtemp = usebus.GetEntryList(null, null);
        
        List<Usage> borrowingListnull = new ArrayList<>();
        for (Usage usage : listtemp) {
            if (usage.getReturnTime()== null) {
                borrowingListnull.add(usage);
            }
        }
        adddata(borrowingListnull);
 
        
    }
        }
    
    public void adddata(List<Usage> a) {
    DefaultTableModel model = (DefaultTableModel) jtable.getModel();
    model.setRowCount(0);

    Object[] columnIdentifiers = {"Mã","Tên thành viên", "Tên thiết bị", "Ngày mượn", "Ngày trả", "Trả thiết bị"};
    model.setColumnIdentifiers(columnIdentifiers);

    for (Usage usage1 : a) {
        Integer b = usage1.getMemberId();
        Long temp = Long.valueOf(b);
        Member member = memberbus.getAMemberWithID(temp);
        String tenThanhVien = member != null ? member.getHoTen() : "";

        boolean coNgayTra = usage1.getReturnTime() != null;
        System.out.println(coNgayTra);

        JCheckBox checkBox = new JCheckBox();
        checkBox.setSelected(coNgayTra); // Đặt trạng thái checkbox dựa trên coNgayTra

        TableColumn column = jtable.getColumnModel().getColumn(5);

        DefaultCellEditor cellEditor = new DefaultCellEditor(checkBox) {
            @Override
            public boolean stopCellEditing() {
                boolean selected = checkBox.isSelected();
                if (selected) {
                    int row = jtable.getSelectedRow();
                    Object value = jtable.getValueAt(row, 0);
                    System.out.println("Dữ liệu cột 0 của dòng: " + value);
                    LocalDateTime currentTime = LocalDateTime.now();
                    java.util.Date currentDate = Date.from(currentTime.atZone(ZoneId.systemDefault()).toInstant());
                    java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());
                    try {
                        usebus.AddReturnTimeOfUsage((Integer) value, sqlDate);
                        List<Usage> listtemp = usebus.GetEntryList(null, null);
                         adddata(listtemp);
                        JOptionPane.showMessageDialog(null, "Trả thành công");
                    } catch (Exception ex) {
                       
                    }
                    
                }
                return super.stopCellEditing();
            }
        };
        column.setCellEditor(cellEditor);

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JCheckBox rendererCheckBox = new JCheckBox();
                rendererCheckBox.setSelected((Boolean) value); // Đặt trạng thái checkbox dựa trên giá trị của ô
                return rendererCheckBox;
            }
        };
        column.setCellRenderer(renderer);

        model.addRow(new Object[]{
            usage1.getUsageId(),
            tenThanhVien,
            usage1.getEquipmentId(),
            usage1.getBorrowingTime(),
            usage1.getReturnTime(),
            coNgayTra
        });
        tableCustomizer();
    }
}
    public void clicktable(){
         int row = jtable.getSelectedRow();
                // Lấy dữ liệu từ cột 0 của dòng được chọn
                Object rowData = jtable.getValueAt(row, 0);
                bienxoa = (int) rowData;
    }
    public void delete(){
        if(bienxoa==-1){
            JOptionPane.showMessageDialog(null, "unselected");
        }
        else{
        System.out.println(bienxoa);
        usebus.RemoveUsage(bienxoa);
        JOptionPane.showMessageDialog(null, "success");
        List<Usage> listtemp = usebus.GetEntryList(null, null);
        adddata(listtemp);
        }
    } 
    public PanelLoan() {
        initComponents();
        List<Usage> listtemp = usebus.GetEntryList(null, null);
        adddata(listtemp);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        all = new javax.swing.JCheckBox();
        tra = new javax.swing.JCheckBox();
        chua = new javax.swing.JCheckBox();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(759, 508));

        jtable.setModel(new javax.swing.table.DefaultTableModel(
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
        jtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtable);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Danh sách phiếu mượn");

        all.setBackground(new java.awt.Color(255, 255, 255));
        all.setForeground(new java.awt.Color(0, 0, 0));
        all.setText("All");
        all.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                allMouseClicked(evt);
            }
        });

        tra.setForeground(new java.awt.Color(0, 0, 0));
        tra.setText("Đã trả");
        tra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                traMouseClicked(evt);
            }
        });

        chua.setForeground(new java.awt.Color(0, 0, 0));
        chua.setText("Chưa trả");
        chua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chuaMouseClicked(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Xóa phiếu mượn");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 102, 255));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Thêm từ excel");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 102, 255));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("+ Phiếu mượn");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });

        jButton1.setText("Làm mới bảng");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(all)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tra, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chua, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton1))
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(57, 57, 57))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(all)
                    .addComponent(tra)
                    .addComponent(chua)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableMouseClicked
        // TODO add your handling code here:
        clicktable();
    }//GEN-LAST:event_jtableMouseClicked

    private void allMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allMouseClicked
        // TODO add your handling code here:
        all();
    }//GEN-LAST:event_allMouseClicked

    private void traMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_traMouseClicked
        // TODO add your handling code here:
        tra();
    }//GEN-LAST:event_traMouseClicked

    private void chuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chuaMouseClicked
        // TODO add your handling code here:
        chua();
    }//GEN-LAST:event_chuaMouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        try {
            // TODO add your handling code here:
            themmuonexcel();
        } catch (IOException ex) {
          
        }
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        try {
            // TODO add your handling code here:
            themmuon();
        } catch (IOException ex) {
            
        }
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
         List<Usage> listtemp = usebus.GetEntryList(null, null);
        adddata(listtemp);
        
    }//GEN-LAST:event_jButton1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox all;
    private javax.swing.JCheckBox chua;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtable;
    private javax.swing.JCheckBox tra;
    // End of variables declaration//GEN-END:variables
}
