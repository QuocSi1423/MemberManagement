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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Thinkbook 14 G3
 */
public class PannalCheckin extends javax.swing.JPanel {

    /**
     * Creates new form PannalCheckin
     */
    UsageDAL use= new UsageDAL();
    UsageBUS usebus= new UsageBUS(use);
    MemberDAL member = new MemberDAL();
    MemberBUS memberbus= new MemberBUS();
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
    public  void addall(){
        if(jCheckBox1.isSelected()){
         List<Usage> listtemp = usebus.GetEntryList(null, null);
            adddata(listtemp);
        }
  
    }
    public void adddata(List<Usage> a) {
        // Làm rỗng JTable trước khi thêm dữ liệu mới
        DefaultTableModel model = (DefaultTableModel) jtable.getModel();
        model.setRowCount(0); 

        // Thiết lập các tiêu đề cột tùy chỉnh
        Object[] columnIdentifiers = {"Mã Thông Tin", "Mã Thành Viên", "Tên thành viên", "Thời Gian vào"};
        model.setColumnIdentifiers(columnIdentifiers);

        for (Usage usage1 : a) {
        Integer b = usage1.getMemberId();
        Long temp = Long.valueOf(b);
        Member member = memberbus.getAMemberWithID(temp);
        if (usage1.getEntryTime() != null) {
            // Lấy tên thành viên từ đối tượng Member
            String tenThanhVien = member != null ? member.getHoTen() : "";
            model.addRow(new Object[] {
                usage1.getUsageId(),
                usage1.getMemberId(),
                tenThanhVien,
                usage1.getEntryTime(),
            });
        }
}

    // Thiết lập model cho JTable "jtable"
    jtable.setModel(model);
    tableCustomizer();
}
  public void mainall(){
    List<Usage> list = usebus.GetEntryList(null, null);
     adddata(list);
    jDateChooser1.addPropertyChangeListener(new PropertyChangeListener() {
    @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("date".equals(evt.getPropertyName())) {
                    java.util.Date selectedDate = jDateChooser1.getDate();
                    java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    String formattedDate = dateFormat.format(sqlDate);

                    List<Usage> listtemp = usebus.GetEntryList(null, null);
                    System.out.println(sqlDate);
                    List<Usage> borrowingList = new ArrayList<>();
                    for (Usage usage : listtemp) {
                        
                        System.out.println(usage.getEntryTime());
                        if (String.valueOf(usage.getEntryTime()) == null ? String.valueOf(sqlDate) == null : String.valueOf(usage.getEntryTime()).equals(String.valueOf(sqlDate))) {
                            borrowingList.add(usage);
                             System.out.println(usage.getEntryTime());
                        }
                    }
                    
                    adddata(borrowingList);
                  
                    // Sử dụng list1 theo nhu cầu
                
        }   
          }
        });
        }
    public PannalCheckin() {
        initComponents();
        mainall();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jCheckBox1 = new javax.swing.JCheckBox();

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
        jScrollPane1.setViewportView(jtable);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Ghi nhận ngày vào :");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Ngày :");

        jDateChooser1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jDateChooser1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jDateChooser1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDateChooser1MouseClicked(evt);
            }
        });

        jCheckBox1.setText("All");
        jCheckBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jDateChooser1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jDateChooser1AncestorAdded
        // TODO add your handling code here:

    }//GEN-LAST:event_jDateChooser1AncestorAdded

    private void jDateChooser1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser1MouseClicked

    }//GEN-LAST:event_jDateChooser1MouseClicked

    private void jCheckBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox1MouseClicked
        // TODO add your handling code here:
        addall();
    }//GEN-LAST:event_jCheckBox1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtable;
    // End of variables declaration//GEN-END:variables
}
