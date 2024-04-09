package GUI;

import BUS.MemberBUS;
import Entity.Member;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class review_file extends javax.swing.JFrame {
    member_layout member_layout = new member_layout();
    // các đối tượng tương tác dữ liệu 
    private MemberBUS memberBUS = new MemberBUS();
    List<Member> membersList = new ArrayList<>();

    public review_file() {
        initComponents();
        this.setLocationRelativeTo(null);
        showTable();
        readFileExcel();
    }
    
    public review_file(JPanel jPanel) {
        initComponents();
        this.member_layout = (GUI.member_layout) jPanel;
        this.setLocationRelativeTo(null);
        showTable();
        readFileExcel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        memberInfoTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Thêm dữ liệu với file excel");

        memberInfoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã thành viên", "Họ và tên", "Khoa", "Ngành", "Số điện thoại"
            }
        ));
        jScrollPane1.setViewportView(memberInfoTable);

        jButton1.setBackground(new java.awt.Color(0, 102, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addListJButton(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(201, 201, 201));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Hủy");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destroyJButton(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(197, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(197, 197, 197))
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addListJButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addListJButton
        for(Member member : this.membersList) {
            if(memberBUS.addMember(member)){
                continue;
            } else {
                JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi import file!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                this.dispose();
            }
        }
        this.member_layout.loadDataToTable();
        this.dispose();
    }//GEN-LAST:event_addListJButton

    private void destroyJButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destroyJButton
        this.dispose();
    }//GEN-LAST:event_destroyJButton

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(review_file.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(review_file.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(review_file.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(review_file.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new review_file().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable memberInfoTable;
    // End of variables declaration//GEN-END:variables

    class CustomTableHeaderRenderer implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JLabel label = new JLabel(value.toString());
            label.setOpaque(true);
            label.setBackground(new Color(0, 102, 255, 255)); // Thiết lập màu nền tùy ý cho header
            label.setForeground(Color.WHITE); // Thiết lập màu chữ là màu trắng
            label.setFont(new Font("Arial", Font.BOLD, 18)); // Thiết lập cỡ chữ là 18 và đậm
            Border border = BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK);
            label.setBorder(border);
            return label;
        }
    }

    public void showTable() {
        JTableHeader header = this.memberInfoTable.getTableHeader();
        header.setDefaultRenderer(new CustomTableHeaderRenderer());
        Dimension headerPreferredSize = header.getPreferredSize();
        headerPreferredSize.height *= 2; // Để rộng ra gấp đôi
        header.setPreferredSize(headerPreferredSize);
    }

    // Phương thức để lấy phần mở rộng của tập tin
    private static String getFileExtension(File file) {
        String fileName = file.getName();
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex > 0 && dotIndex < fileName.length() - 1) {
            return fileName.substring(dotIndex + 1).toLowerCase();
        }
        return null;
    }

    private void readFileExcel() {
        File excelFile;
        FileInputStream excelFIS = null;
        BufferedInputStream excelBIS = null;
        XSSFWorkbook excelJTableImport = null;

        DefaultTableModel model = (DefaultTableModel) this.memberInfoTable.getModel();
        model.setRowCount(0);

        String defaultCurrentDirectoryPath = "C:\\Users\\MSI\\";
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
                    XSSFCell excelFaculty = excelRow.getCell(2);
                    XSSFCell excelMajor = excelRow.getCell(3);
                    XSSFCell excelPhone = excelRow.getCell(4);

                    long id = (long) excelId.getNumericCellValue();
                    String name = excelName.getStringCellValue();
                    String faculty = excelFaculty.getStringCellValue();
                    String major = excelMajor.getStringCellValue();
                    String phone = excelPhone.getStringCellValue();
                    if(id == 0 || name.isEmpty() || faculty.isEmpty() || major.isEmpty() || phone.isEmpty()) {
                        continue;
                    }
                    Member member = new Member(id, phone, phone, name, name);
                    this.membersList.add(member);
                    
                    model.addRow(new Object[]{
                        excelId, excelName, excelFaculty, excelMajor, excelPhone
                    });
                }

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException ex) {
//                Logger.getLogger(EquipmentGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
