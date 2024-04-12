package GUI;

import BUS.MemberBUS;
import Entity.Member;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import static sun.jvm.hotspot.HelloWorld.e;

public class member_layout extends javax.swing.JPanel {

    // các đối tượng tương tác dữ liệu 
    private MemberBUS memberBUS = new MemberBUS();
    private ArrayList<Member> memberList = new ArrayList<>();
    // model của jtable
    private DefaultTableModel memberInfoTableModel = new DefaultTableModel();

    public member_layout() {
        initComponents();
        this.memberInfoTableModel = (DefaultTableModel) this.memberInfoTable.getModel();
        initializeTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        searchJTF = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        memberInfoTable = new javax.swing.JTable();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickOutsideJTF(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.setPreferredSize(new java.awt.Dimension(746, 74));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        searchJTF.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        searchJTF.setText("Tìm kiếm");
        searchJTF.setToolTipText("");
        searchJTF.setFocusable(false);
        searchJTF.setPreferredSize(new java.awt.Dimension(350, 38));
        searchJTF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickInsideJTF(evt);
            }
        });
        searchJTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchEnter(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 102, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Thêm file từ excel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFileExcel(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 102, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon("E:\\Xay dung phan mem theo mo hinh phan lop\\Project2\\MemberManagement\\demo\\src\\main\\java\\Icon\\plus (1).png")); // NOI18N
        jButton2.setText("Thành viên");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMember(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(searchJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 198, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(86, 86, 86));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Xóa thành viên");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMemberJButton(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(86, 86, 86));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Xóa với bộ lọc");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMemberByCondition(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Danh sách thành viên");

        jButton5.setBackground(new java.awt.Color(86, 86, 86));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Sửa");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyInfoMember(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addGap(1, 1, 1))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        memberInfoTable.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        memberInfoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã thành viên", "Họ và tên", "Khoa", "Ngành ", "Số điện thoại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        memberInfoTable.setRowMargin(15);
        jScrollPane1.setViewportView(memberInfoTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addMember(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMember
        add_member addMemberPage = new add_member(this);
        addMemberPage.setLocationRelativeTo(null);
        addMemberPage.setVisible(true);
    }//GEN-LAST:event_addMember

    private void deleteMemberByCondition(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMemberByCondition
        del_mem_condition deleteMemByConditionPage = new del_mem_condition(this);
        deleteMemByConditionPage.setLocationRelativeTo(null);
        deleteMemByConditionPage.setVisible(true);
    }//GEN-LAST:event_deleteMemberByCondition

    private void modifyInfoMember(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyInfoMember
        if (this.memberInfoTable.getSelectedRow() != -1) {
            long MaTV = (long) this.memberInfoTable.getValueAt(this.memberInfoTable.getSelectedRow(), 0);
            Member member = getMemberById(MaTV);
            modify_info_mem modifyInfoMember = new modify_info_mem(member, this);
            modifyInfoMember.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn thành viên bạn muốn xóa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_modifyInfoMember

    private void addFileExcel(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFileExcel
        review_file reviewFile = new review_file(this);
        reviewFile.setVisible(true);
    }//GEN-LAST:event_addFileExcel

    private void deleteMemberJButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMemberJButton
        if (this.memberInfoTable.getSelectedRow() != -1) {
            int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa thành viên này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) {
                long MaTV = (long) this.memberInfoTable.getValueAt(this.memberInfoTable.getSelectedRow(), 0);
                if (this.memberBUS.removeMember(MaTV)) {
                    JOptionPane.showMessageDialog(null, "Xóa thành viên thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    loadDataToTable();
                } else {
                    JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi xóa thành viên!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn thành viên bạn muốn xóa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deleteMemberJButton

    private void clickOutsideJTF(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickOutsideJTF
        Component component = evt.getComponent();
        if (!(component instanceof JTextField)) {
            if (this.searchJTF.getText().isEmpty()) {
                this.searchJTF.setText("Tìm kiếm");
                this.searchJTF.setFocusable(false);
            }
        }
    }//GEN-LAST:event_clickOutsideJTF

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        Component component = evt.getComponent();
        if (!(component instanceof JTextField)) {
            if (this.searchJTF.getText().isEmpty()) {
                this.searchJTF.setText("Tìm kiếm");
                this.searchJTF.setFocusable(false);
            }
        }
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        Component component = evt.getComponent();
        if (!(component instanceof JTextField)) {
            if (this.searchJTF.getText().isEmpty()) {
                this.searchJTF.setText("Tìm kiếm");
                this.searchJTF.setFocusable(false);
            }
        }
    }//GEN-LAST:event_jPanel2MouseClicked

    private void searchEnter(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchEnter
        Member member = null;
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!this.searchJTF.getText().isEmpty()) {
                String value = this.searchJTF.getText();
                if (isNumeric(value)) {
                    long id = Long.parseLong(value);
                    member = this.memberBUS.getAMemberWithID(id);
                    this.memberInfoTableModel.setRowCount(0);
                    if (member != null) {
                        System.out.println(member.getMaTV());
                        this.memberInfoTableModel.addRow(new Object[]{
                            member.getMaTV(),
                            member.getHoTen(),
                            member.getKhoa(),
                            member.getNganh(),
                            member.getSdt()
                        });
                    }
                } else {

                }

            } else {
                loadDataToTable();
            }
        }
    }//GEN-LAST:event_searchEnter

    private void clickInsideJTF(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickInsideJTF
        this.searchJTF.setFocusable(true);
        if(!this.searchJTF.getText().isEmpty() || !this.searchJTF.getText().equals("Tìm kiếm")) {
            this.searchJTF.setText("");
        }
    }//GEN-LAST:event_clickInsideJTF


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable memberInfoTable;
    private javax.swing.JTextField searchJTF;
    // End of variables declaration//GEN-END:variables

    // khởi tạo bảng
    public void initializeTable() {
        designTable();
        loadDataToTable();
    }

    // điều chỉnh header của bảng
    class CustomTableHeaderRenderer implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JLabel label = new JLabel(value.toString());
            label.setOpaque(true);
            label.setBackground(new Color(0, 102, 255, 255)); // Thiết lập màu nền tùy ý cho header
            label.setForeground(Color.WHITE); // Thiết lập màu chữ là màu trắng
            label.setFont(new Font("Arial", Font.BOLD, 20)); // Thiết lập cỡ chữ là 18 và đậm
            Border border = BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK);
            label.setBorder(border);
            return label;
        }
    }

    class CustomTableCellRenderer extends DefaultTableCellRenderer {

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            cellComponent.setFont(new Font("Arial", Font.PLAIN, 18)); // Đặt font và kích thước chữ cho dòng dữ liệu
            return cellComponent;
        }
    }

    public class CustomRowRenderer extends DefaultTableCellRenderer {

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (isSelected) {
                cellComponent.setBackground(new Color(102, 102, 255)); // Màu nền khi dòng được chọn
                cellComponent.setForeground(Color.WHITE); // Màu chữ khi dòng được chọn
            } else {
                cellComponent.setBackground(table.getBackground());
                cellComponent.setForeground(table.getForeground());
            }
            return cellComponent;
        }
    }

    public void designTable() {
        JTableHeader header = this.memberInfoTable.getTableHeader();
        header.setDefaultRenderer(new CustomTableHeaderRenderer());
        Dimension headerPreferredSize = header.getPreferredSize();
        headerPreferredSize.height *= 2; // Để rộng ra gấp đôi
        header.setPreferredSize(headerPreferredSize);

        this.memberInfoTable.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
        this.memberInfoTable.setRowHeight(34); // Độ cao của mỗi dòng dữ liệu
    }

    // load dữ liệu lên bảng
    public void loadDataToTable() {
        this.memberList = (ArrayList<Member>) this.memberBUS.getAllMembers();
        this.searchJTF.setText("Tìm kiếm");
        this.memberInfoTableModel.setRowCount(0);
        for (Member member : memberList) {
            this.memberInfoTableModel.addRow(new Object[]{
                member.getMaTV(),
                member.getHoTen(),
                member.getKhoa(),
                member.getNganh(),
                member.getSdt()
            });
        }
    }

    public Member getMemberById(long id) {
        Member member = null;
        for (Member member1 : this.memberList) {
            if (member1.getMaTV() == id) {
                member = member1;
            }
        }
        return member;
    }

    // kiểm tra dữ liệu nhập vào có phải là số không
    public boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

}
